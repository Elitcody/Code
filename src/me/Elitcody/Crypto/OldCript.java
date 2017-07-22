package me.Elitcody.Crypto;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OldCript {
///*
// * 	
// 	String test = "Ciao";
//			byte[] pos = test.getBytes();
//			int position = pos[0];
//			
//			for(int i = 0; i < test.length(); i++){
//				System.out.println(" Lettera convertita: "+getLetter(position));
//				position = pos[i];
//			}
////			// Decript
//			
//			String myString = new String(pos, Charset.forName("UTF-8"));
//			System.out.println(myString);
//			
//			Startingalphabet = generateAutoAlphabet(Startingalphabet, 10000);
//			
////			for(int x = 0; x < 1;x++)
////			{
////				System.out.println(convertLetterFromStartToMiddle(getLetter(x)));
////			}
// 
//  
// * 
// * 	
// */
//	
//	
//	// Using this variable It changes the way that it picks from alphabet
//		// In base a queste variabili cambia il modo cui prende dall'alfabeto
//		public static int originalST = 0;
//		public static int MiddleST = 17;
//		public static int FinishedSt = 50;
//		
//		// I've copied these variables, coz I'm lazy D:
//		// Queste tre variabili copiate spudoratamente perchè mi scocciavo di farle a mano :(
//		public static char[] Startingalphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
//		public static char[] Middlealphabet = {'Z','y','X','w','V','u','T','s','R','q','P','o','n','M','l','K','j','i','H','g','F','e','D','c','B','a'};
//		public static char[] EndAlphabet = {};
//		
//		public static void decompile(String end){
//			
//			
//		}
//		
//		// Algorithm
//		/* Initial string = Convert a string into normal alphabet after Its done add Its original statement  
//		 * Middle string = Convert initial string (using bytes unique codes) into another alphabet and add MiddleSt 
//		 * EndAlphabet string = Convert middle string into another alphabet using bytes 
//		 * Create an image that pixel rgb colors are colored by its letter 
//		 * Image hight/wide are both originalSt and MiddleSt
//		 * FinishedSt are how much pixel It has been coloured
//		 */
//		
//		// Algoritmo
//		/*  Giro = Alfabeto con qualcosa
//		 * 
//		 * 	Giro	a = 1 + una variabile 
//		 * 	Giro 	b = quanti byte a è + una variabile 	
//		 * 	Giro 	c = quanti byte è b è + una variabile
//		 * 		
//		 * String a = "Blablabla"
//		 * 
//		 *  
//		 * giro a	B diventa A
//		 * giro b   A diventa C
//		 * giro c   C diventa X
//		 * 
//		 * 
//		 * Converti in un immagine tutte le parole
//		 * 
//		 */
//		
//		public static String convertLetterFromStartToMiddle(String letter){
////			System.out.println(letter);
//			byte[] test = letter.getBytes();
//			
//			int position = test[0];
////			System.out.println(position);
//			
//			position = position+MiddleST;
////			System.out.println(temporal);
//			while(position > Middlealphabet.length-1){
//				position = (position % 26);
////				System.out.println(temporal);
//			}
//			// If u pick greater than its lenght it's divided by 26
////			System.out.println(temporal);
//			
//			// Decoding 
//			
//			String myString = new String(test, Charset.forName("UTF-8"));
//			System.out.println("Stringa iniziale: "+letter+" stringa finale: "+myString);
//			
//			// Printing 
//			
//			letter = ""+Middlealphabet[position];
//			
//			
//			
//			return letter;
//		}
//		// From the original letter position 
//		public static String getLetter(int position){
//			String letter = "";
//			
//			
//			while(position > Startingalphabet.length-1){
////				position = (position + originalST ) % 26;
//				int posz = (Startingalphabet.length-1) / position ;
//				posz = posz+originalST;
//				System.out.println(posz);
//			} // If u pick greater than its lenght it loops it self every 26 
//			int actt = position; 
//			
//			
//			// Decoding
//			int actual = actt;
////			while(actual > Startingalphabet.length-1){
////				actual = (actual + originalST ) % 26;
////			} 
//
////			while (actual < Startingalphabet.length-1){
////				actual = ( actual % 26 );
////				
////			}
//			System.out.println("L1: "+actual+" "+position);
//				
////			System.out.println("LX: "+ actual);
////			System.out.println("L1: "+ Startingalphabet[position] == Startingalphabet[actual]+" Dec: "+actual);
//			
//			// Print
//			letter = ""+Startingalphabet[position];
//			
//			
//			return letter;
//			
//		}
//		public static char[] generateAutoAlphabet(char[] st, int size){
//			List<char[]> initialLetters = Arrays.asList(st);
//			char[] results = new ArrayList<>();
//			int indexOfLetterToAdd = 0;
//			for (int i=1;i<size;i++){
//			    results.add(initialLetters.get(indexOfLetterToAdd++));
//			    if(indexOfLetterToAdd==initialLetters.size()){ //reset counter when necessary
//			        indexOfLetterToAdd=0;
//			    }
//			}
//			return results;
//		}
}
