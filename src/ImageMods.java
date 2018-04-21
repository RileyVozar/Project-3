import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.util.Random;

public class ImageMods {
	public static void main(String[] args) {

		//Create New Image Utility.		
		ImageUtils utils = new ImageUtils();
		
		//Load Image
		Color[][] orig = utils.loadImage("src/LennaCV.png");
		
		//Add Original Image
		utils.addImage(orig,  "Original Image");
		
		//Image Modifications
		
		Color[][] redact=redact(orig);
		utils.addImage(redact, "[REDACTED]");
		
		Color[][] inv=inv(orig);
		utils.addImage(inv, "Inverse");
		
		Color[][] missingno=missingno(orig);
		utils.addImage(missingno, "MissingNo");
		
		Color[][] dank=dank(orig);
		utils.addImage(dank, "DaNk ZoNe");
		
		Color[][] picass=picasso(orig);
		utils.addImage(picass, "Picasso");
		
		Color[][] toasty=toasty(orig);
		utils.addImage(toasty, "Toasty");
		
		Color[][] swap=swap(orig);
		utils.addImage(swap, "color swap");
	
		
		//Display images
		utils.display();
		
	}

	
	public static Color[][] redact(Color[][] img)
	{
		Color[][] tmp= ImageUtils.cloneArray(img);
		for( int i=0; i < tmp.length; i++) 
		{
			for( int j=0; j < tmp[i].length; j++) {
				
					Random rng = new Random();
					int n = rng.nextInt(100) + 1;
					if(n == 1)
					{
						tmp[i][j] = new Color(102,255,255);
					}
					else if (n == 2)
					{
						tmp[i][j] = new Color(255,0,127);
					}
					
					if(j < (285) && j > (235) && i < (365) && i > (225))
					{
						tmp[i][j] = new Color(0,0,0);
					}	
					
			}
		}
		
		return tmp;
	}
	
	
	public static Color[][] inv(Color[][] img){
		Color[][] tmp= ImageUtils.cloneArray(img);
		for( int i=0; i < tmp.length; i++) {
			for( int j=0; j < tmp[i].length; j++) {
				Color pixel = img[i][j];
				int r = pixel.getRed();
				int g = pixel.getGreen();
				int b = pixel.getBlue();
				
				r = (255-r);
				g = (255-g);
				b = (255-b);
				
				tmp[i][j] = new Color(r,g,b);
				
				//tmp[i][j] = new Color(b,g,r);
				
				
			}
		}
		
		return tmp;
	}
	
	public static Color[][] swap(Color[][] img){
		Color[][] tmp= ImageUtils.cloneArray(img);
		for( int i=0; i < tmp.length; i++) {
			for( int j=0; j < tmp[i].length; j++) {
				Color pixel = img[i][j];
				int r = pixel.getRed();
				int g = pixel.getGreen();
				int b = pixel.getBlue();
				
				tmp[i][j] = new Color(b,g,r);
				
				
			}
		}
		
		return tmp;
	}
	
	public static Color[][] missingno(Color[][] img)
	{
		Color[][] tmp= ImageUtils.cloneArray(img);
		for( int i=0; i < tmp.length; i++) 
		{
			Random rng = new Random();
			int n = rng.nextInt(10) + 1;
			
			for( int j=0; j < tmp[i].length; j++) {
				
				Color pixel = img[i][j];
				
				int r = pixel.getRed();
				int g = pixel.getGreen();
				int b = pixel.getBlue();
				
				if( i > 225 && i < 365 && j > 235 && j < 285)
				{
					
				}
				
				if (n == 1)
				{
					Random randyButternubs = new Random();
					
					int red = randyButternubs.nextInt(256);
					int green = randyButternubs.nextInt(256);
					int blue = randyButternubs.nextInt(256);
					
					if(j%n <=2)
					{
						tmp[i][j] = new Color(red,green, blue);
					}
				}
					
			}
		}
		return tmp;
	}
	
	public static Color[][] dank(Color[][] img){
		Color[][] tmp= ImageUtils.cloneArray(img);
		for( int i=0; i < tmp.length; i++) {
			for( int j=0; j < tmp[i].length; j++) {
				Color pixel = img[i][j];
				int r = pixel.getRed();
				int g = pixel.getGreen();
				int b = pixel.getBlue();

				tmp[i][j]= new Color(r,200,b);
			}
		}
		return tmp;
	}

	
	public static Color[][] picasso(Color[][] img)
	{
		Color[][] tmp= ImageUtils.cloneArray(img);
		for( int i=0; i < tmp.length; i++) {
			for( int j=0; j < tmp[i].length; j++) {
				Color wack = img[i][j];
				int r = wack.getRed();
				int g = wack.getGreen();
				int b = wack.getBlue();
				
				if(j < (i) && i < (365))
				{
					tmp[i][j]= new Color(100,g,255);
				}	
				
				if(i < (.5*j) )
				{
					tmp[i][j] = new Color(200,r,200);
				}	
				
				if(i > (-1*j + 700) )
				{
						tmp[i][j]= new Color(255,g,50);
				}	
				
				if((Math.pow(i-420,2) + Math.pow(j-100,2)< 2000) )
				{
						tmp[i][j]= new Color(0,255,b);
				}
				
				if(i > (-1*j + 700) )
				{
						if(j < (i) && i < (365))
						{
							tmp[i][j]= new Color(255,255,b);
						}	
				}	
				
			}
		}
		return tmp;
	}
	
	public static Color[][] toasty(Color[][] img){
		Color[][] tmp= ImageUtils.cloneArray(img);
		for( int i=0; i < tmp.length; i++) {
			for( int j=0; j < tmp[i].length; j++) {
				Color pixel = img[i][j];
				int r = pixel.getRed();
				int g = pixel.getGreen();
				int b = pixel.getBlue();
				
				if (r > 150)
					tmp[i][j] = new Color(200,g,20);

			}
		}
		return tmp;
	}
		
}
