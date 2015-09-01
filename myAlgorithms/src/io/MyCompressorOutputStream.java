package io;

import java.io.IOException;
import java.io.OutputStream;

public class MyCompressorOutputStream extends OutputStream {
	OutputStream out;
	static int before=-1;
	static int count=0;
	
	public MyCompressorOutputStream(OutputStream out) {
		super();
		this.out = out;
	}
	@Override
	public void write(int b){
	try {
		if(b!=before)
		{
			if(before!=-1)
			{
				out.write(before);
				out.write(count);
			}
			before=b;
		    count =1;
		}	
		count++;
	} catch (IOException e) {
		e.printStackTrace();}
	}
protected void finalize() throws Throwable {
     try {
         out.close();        // close open files
     } finally {
         super.finalize();
     }
 }

}
	