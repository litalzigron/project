package io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class MyCompressorOutputStream extends OutputStream {
	FileOutputStream out;
	static int before= -1;
	static int count= 0;
	
	public MyCompressorOutputStream(FileOutputStream out) {
		super();
		this.out = out;
	}
	@Override
	public void write(int b){
		System.out.println("b: "+ b);
	try {
		if(b!=before)
		{
			if(before!=-1)
			{
				out.write(before);
				System.out.println("before: "+before);
				out.write(count);
				System.out.println("count "+count);

			}
			before=b;
		    count=0;
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
	