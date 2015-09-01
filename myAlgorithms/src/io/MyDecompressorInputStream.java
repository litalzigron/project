package io;

import java.io.IOException;
import java.io.InputStream;

public class MyDecompressorInputStream extends InputStream {

	InputStream in;

	public MyDecompressorInputStream(InputStream in) {
		super();
		this.in = in;
	}

	@Override
	public int read(){
		int c;
		try {
			while((c=in.read())!=-1)
			{
				System.out.print(c+ ",");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return 0;
	}
	protected void finalize() throws Throwable {
	     try {
	         in.close();        // close open files
	     } finally {
	         super.finalize();
	     }
	 }
}
 