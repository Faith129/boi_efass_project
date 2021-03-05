package com.efass;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.FileChannel;
import java.nio.file.Path;

import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.efass.payload.Response;

public class Test {

	
	public static void main(String [] args) throws Exception {
		
		String FILE_URL = "file://datafiles/archives/2019-04-25~1614699839315";
		String FILE_NAME = "cbn_MFB_rpt_12345m052087.xlsx";
			
		
		FileOutputStream fileOutputStream = new FileOutputStream(FILE_NAME);
		FileChannel fileChannel = fileOutputStream.getChannel();
		
		System.out.println(fileChannel);
		
	}
	
	

		 
		 
}
