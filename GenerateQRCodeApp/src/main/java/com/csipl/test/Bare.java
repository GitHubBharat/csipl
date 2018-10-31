package com.csipl.test;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Reader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

public class Bare {
	public static void main(String[] args) throws IOException, NotFoundException, ChecksumException, FormatException {
		
	
	InputStream barCodeInputStream = new FileInputStream("D:\\bar.png");  
	BufferedImage barCodeBufferedImage = ImageIO.read(barCodeInputStream);  
	  
	LuminanceSource source = new BufferedImageLuminanceSource(barCodeBufferedImage);  
	BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));  
	Reader reader = new MultiFormatReader();  
	Result result = reader.decode(bitmap);  
	  
	System.out.println("Barcode text is " + result.getText());  
}
}