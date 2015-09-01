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
	public int read() throws IOException {
		int c;
		// TODO Auto-generated method stub
		while((c=in.read())!=-1)
		{
			System.out.println(c+ ",");
		}
		return 0;
	}
}
 