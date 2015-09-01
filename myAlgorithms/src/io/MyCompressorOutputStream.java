package io;

import java.io.IOException;
import java.io.OutputStream;

public class MyCompressorOutputStream extends OutputStream {
	OutputStream out;
	static int before=-1;
	static int count=1;
	
	public MyCompressorOutputStream(OutputStream out) {
		super();
		this.out = out;
	}
	@Override
	public void write(int b) throws IOException {
		if(b!=before)
		{
			if(before!=-1)
			{
				out.write(count);
				out.write(before);
			    count =1;
			}
			before=b;
		}	
		count++;
	}
}
	