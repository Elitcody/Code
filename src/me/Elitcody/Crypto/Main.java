package me.Elitcody.Crypto;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.naming.StringRefAddr;

public class Main {
	
	static int height = 600; // Height of the image
	static int width = 600; // Width of the image 
	// Remember to put the extension 
	public static String path = ""; // Path where are located the file
	public static String pathPick = "Secret code.txt"; // How is called the file where you take the original non encrypted code
	public static String pathImg = "NewCode.png"; // How is called the image where you encrypt the code
	public static String pathDecripted = "Unlocked Code.txt"; // How is called the file where you decrypt the code
	public static int delay = 1; // How many letter per second will be delayed in order to not crash
	
//  Original String message used as a test now unused
//	public static String loremlipsus =
//			"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus tristique sagittis libero, vitae bibendum magna rutrum bibendum. Cras vel risus placerat, tincidunt risus id, porttitor enim. Sed et sem quis tortor blandit fermentum. Mauris vel sagittis ante. Mauris ultrices urna cursus metus interdum auctor. Proin sit amet erat vel lorem molestie iaculis. Proin sit amet rhoncus dui, eget sodales nisi. Vestibulum malesuada nisl et accumsan maximus. Morbi quis viverra nisl, ac dapibus lectus. Nulla tempor sapien sollicitudin sapien fringilla malesuada."+
//			"Nunc vel sodales sapien, vel feugiat sem. Proin laoreet dolor ut posuere tempus. Sed feugiat sapien magna. Suspendisse rhoncus dapibus nisl, ut rhoncus orci finibus quis. Suspendisse ac sem nec risus ornare tincidunt et ac risus. In euismod egestas pulvinar. Nunc at elit sem. Phasellus at lorem sit amet odio efficitur egestas semper ac turpis."
//			+"Integer mollis placerat nibh, a ultricies lectus imperdiet ut. Ut ullamcorper finibus eros, nec euismod dui tincidunt et. Proin placerat lacinia justo vel laoreet. Nulla ac varius nisl. Pellentesque in ligula neque. Ut suscipit erat in sapien auctor laoreet sed elementum augue. Nunc finibus nisl id pharetra tincidunt. Phasellus pellentesque nec ligula sed mollis. Donec sagittis sapien interdum, hendrerit mi in, scelerisque nisi. Integer id ipsum mi. Etiam nec eleifend massa, a vulputate arcu. Sed vitae ultrices mauris."
//			+"Vivamus sit amet nunc nisi. Duis varius magna vitae odio rutrum vulputate. Donec maximus tempor ipsum. Donec pulvinar augue metus, id varius tortor egestas non. Nam vehicula, mi at ornare porta, odio sapien semper nunc, ac volutpat sapien nulla in ipsum. Pellentesque eget odio sed enim mollis suscipit porta id est. Vestibulum scelerisque odio a ipsum consectetur rhoncus. Suspendisse ultrices erat leo, at consequat metus volutpat eget. Etiam eu ligula in lacus iaculis consectetur. Morbi lorem diam, finibus eget convallis non, elementum at felis. Phasellus vel nibh et nunc suscipit finibus."
//			+"Praesent dignissim varius dui in venenatis. Donec dolor odio, sollicitudin ac dolor in, euismod aliquet justo. Phasellus tincidunt mi vel suscipit blandit. Donec vitae consequat dolor, ac mollis felis. Nam ac convallis diam. Ut ultricies id mi quis euismod. Nam id ullamcorper augue. Suspendisse sit amet malesuada orci. Maecenas maximus id mauris quis eleifend. Cras tempus pulvinar nisi, ut gravida nisl gravida luctus. Nunc a fermentum ex, non dictum orci. Integer maximus viverra purus sit amet eleifend. Maecenas nec orci nibh. Pellentesque sodales, turpis non ullamcorper malesuada, erat ante maximus nisl, congue volutpat tellus enim at lorem. Vivamus eleifend pellentesque nulla et facilisis."
//			+"Donec metus dui, malesuada eget congue in, vestibulum a ante. Quisque luctus nulla dictum pretium laoreet. Suspendisse ac ipsum velit. Morbi id orci ac ligula scelerisque congue sed non libero. Cras fermentum lorem ac massa tempus, in interdum tellus suscipit. Donec ultricies tincidunt volutpat. Praesent erat enim, faucibus vel erat in, malesuada rutrum velit. Etiam iaculis massa vel tristique bibendum."
//			+"Donec eget ornare est, id sodales augue. Integer eleifend sagittis mi. Sed semper pulvinar porttitor. Nam ornare, lectus nec efficitur sagittis, metus quam consequat mi, at iaculis lectus eros eget justo. Nunc pretium.";		

	// Function that decrypt the image which path is path plus the name of the image therefore remember to put the image (that you want decrypt) in the path you used before.  
	public static void decriptImage(){
		// Load the image 
		File f = new File(path+pathImg); 
        BufferedImage img = null;
		try {
			img = ImageIO.read(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
		// Determinate its pixels and put in an array
		StringBuffer s = new StringBuffer(); // Creare a StringBuffer
        byte[] pixels = ((DataBufferByte) img.getRaster().getDataBuffer()).getData(); // get pixels
        // Check every pixel
        for(int x = 0; x < pixels.length; x++){
        	x=x+2; // +2 means that red & green are unused
        	if(pixels[x] != 0){ // Remove the pixels with value = 0
            	Color c = new Color(pixels[x]); // Convert pixel to color
            	int red = c.getRed(); // Unused in the real code, It is used in debug
            	int green = c.getGreen(); // Unused in the real code,It is used in debug
            	int blue = c.getBlue();  // Where you're going to pick values
            	char car = (char) blue;	// Convert to char
            	s.append(car); // Put in the string buffer
        	}
        }
        
        
        System.out.println("Image decripted correctly"); // Debug
        
        File converted = new File(path+pathDecripted); // Create the file where its going to decrypt everything
            if(!converted.exists()){ // If it doesn't exist create a new one
            	try {
					converted.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
            }
            // Writer of the code decripted
            BufferedWriter writer = null; 
            try
            {
                writer = new BufferedWriter( new FileWriter(converted));
                writer.write(s.toString());
            }
            catch ( IOException e)
            {
            	e.printStackTrace();
            }
            finally
            {
                try
                {
                    if ( writer != null)
                    writer.close( );
                }
                catch ( IOException e)
                {
                	e.printStackTrace();
                }
            }
	}
	// Function that encrypts data 
	public static void encriptImage(byte[] data){
		BufferedImage img = new BufferedImage(height, width, BufferedImage.TYPE_INT_RGB ); // Create an image

    	int x = 0; // Coordinates x
    	int y = 0; // Coordinates y
    	
        File f = new File(path+pathImg); // Determinate where it will be saved the image

		boolean loaded = data != null; // Check if data are loaded correctly
        System.out.println("Is data loaded? "+loaded);
        try {
	        	// Check if the file exists in case not create a new one
	    		if(!f.exists())
	    		{
	            	f.createNewFile();
	            }
        	    // Check every data
        		for (int i = 0; i < data.length; i++) {
        			
        				if(delay != 0){
        					Thread.sleep(delay); // Delay in order to not crash the program
        				}
            		
            		
            			//Debug of working
            			if(x == (width-10)){
            				System.out.println("Coord: "+x+" "+y);
            			}
            			// Algorithm of coordinates 
            			if(x < (width-10)){ // Untill x is minor the width of the image minus 10 x add 1
            				x++;
            			}else if(x == (width-10)){ // if x is equal the width of the image minus 10 x add 1 to the y and set x = 0
            				x=0;
            				y++;
            			}else if(y < (height-10) && x < (width-10)){ //If the page is full write out of rage
            				System.out.println("Out of rage! x: "+x+" y: "+y);
            				break;
            			}
            			// Create a random function 
            			Random r = new Random();
            			// Put data in color blue and randomize red and green
            			if(data[i] > 0){ // Check that data > 0
                            Color color = new Color(data[i],r.nextInt(254), r.nextInt(254)); 
                            // Set the pixel with this color
                            img.setRGB(x, y, color.getRGB());
            			}
            			
                }
        		System.out.println("Finished encoding");
        		// Write the image
        		ImageIO.write(img, "PNG", f);
                
        }catch (Exception e) {
        	e.printStackTrace();
		}
		
	}
	// A function that read file and convert it in a String
	public static String readFile(String pathname) throws IOException {

	    File file = new File(pathname);
	    StringBuilder fileContents = new StringBuilder((int)file.length());
	    Scanner scanner = new Scanner(file);
	    String lineSeparator = System.getProperty("line.separator");

	    try {
	        while(scanner.hasNextLine()) {
	            fileContents.append(scanner.nextLine() + lineSeparator);
	        }
	        return fileContents.toString();
	    } finally {
	        scanner.close();
	    }
	}
	
	public static void main(String[] args) {
			String scr = "";
			try {
				scr = readFile(path+pathPick);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			byte[] pos = scr.getBytes();
			int highernumber = 0;
			for(int x = 0;  x < pos.length; x++){
				if(pos[x] >= highernumber){
					highernumber = pos[x];
				}
			}
			encriptImage(pos);
//			decriptImage();
			
			System.out.println("High byte value: "+highernumber);
	}
}
