package com.iloader.bo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.springframework.web.multipart.MultipartFile;
public class CopyToD {

		public void copyImage(MultipartFile file){
			
			try{
				
			 byte[] bytes = file.getBytes();
             String fileLocation = "c://Development//"+file.getOriginalFilename();
   
         	
         		OutputStream out = new FileOutputStream(new File(fileLocation));
         		int read = 0;
         		byte[] bytess = new byte[1024];
         		
         		InputStream iStream = file.getInputStream();
         		out = new FileOutputStream(new File(fileLocation));
         		
         		while((read = iStream.read(bytess))!= -1){
         			out.write(bytess, 0 , read);            		
         		}
         		
         		out.flush();
         		out.close();
         		iStream.close();
         	}catch(IOException e){
         		e.printStackTrace();
         	}
		}
}
