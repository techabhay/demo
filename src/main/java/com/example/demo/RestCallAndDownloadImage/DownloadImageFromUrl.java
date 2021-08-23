package com.example.demo.RestCallAndDownloadImage;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

import com.example.demo.utils.DemoUtil;

/**
 *@Nielsen
 *@author Abhay Mishra
 */

public class DownloadImageFromUrl {

	public static void main(String[] args) {
		String imageUrl = "https://cdarlhhtblobnonprod001.blob.core.windows.net/data-dct/UAT3/SurveyResponses/356/15513/100073036/100073036_STOREPICTURE_1580386508.jpg";
		String url = imageUrl+"?sig=Kwq%2F0brj2l70Ty8NLGIW%2B2JgY%2BFW%2FYyyY0eGiSzZOv8%3D&st=2020-05-27T10%3A43%3A51Z&se=2020-05-27T15%3A43%3A51Z&sv=2017-04-17&spr=https%2Chttp&sp=rl&sr=c";
		 try {
	           // downloadUsingNIO(url, "C:\\Users\\akamishra\\OneDrive - HARMAN\\Nielsen\\Eclipse19Ws\\demo\\country_356\\country_356_img.jpg");	         
	           // downloadUsingStream(url, "C:\\Users\\akamishra\\OneDrive - HARMAN\\Nielsen\\Eclipse19Ws\\demo\\country_356\\country_356_img.jpg");
			 System.out.println("Extension :: " + DemoUtil.getExtension(imageUrl));
		 } catch (Exception e) {
	            e.printStackTrace();
	        }
	}

	private static void downloadUsingNIO(String urlStr, String file) throws IOException {
		URL url = new URL(urlStr);
		ReadableByteChannel rbc = Channels.newChannel(url.openStream());
		FileOutputStream fos = new FileOutputStream(file);
		fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
		fos.close();
		rbc.close();
	}
	
	private static void downloadUsingStream(String urlStr, String file) throws IOException{
        URL url = new URL(urlStr);
        BufferedInputStream bis = new BufferedInputStream(url.openStream());
        FileOutputStream fis = new FileOutputStream(file);
        byte[] buffer = new byte[1024];
        int count=0;
        while((count = bis.read(buffer,0,1024)) != -1)
        {
            fis.write(buffer, 0, count);
        }
        fis.close();
        bis.close();
    }
}



