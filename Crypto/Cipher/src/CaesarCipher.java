/**
 * 
 * @author Alexander Ottewell
 *
 *Purpose: Write a program to encrypt a message using a Caesar's Cipher encryption technique.
 *         
 *Description: Caesar's Cipher is a substitution cipher in which each letter in the plaintext (message) 
 * 			   is replaced by a letter some fixed number of positions down the alphabet.
 *           
 *Algorithm:   The user will be prompted for capital letter to shift the message by and then the actual message in capital letters.
 *			   The program will output the encrypted message to the user. Note: in Cryptography, letter A is at index 0 and does not 
 *			   shift the message text in any way. The letter B is at index 1 and shifts letters by +1 in the English alphabet.
 *           
 */

import java.util.Scanner;

public class CaesarCipher 
{

	/**
	 * @param char shift
	 * @param String message
	 * @return encrypted String message
	 */
	public static String caesarCipher(char shift, String message)
	{
		//convert char to unicode
		int ascii = (int) shift; 
		ascii -= 65;
		
		for(int i = 0; i < message.length(); i++)
		{
			//obtain a single char from message 
			char tempChar = message.charAt(i);
			int tempInt = (int) tempChar;
			
			//if the letter is upper case
			if(tempInt >= 65 && tempInt <= 90)
			{
				//update unicode value
				tempInt += ascii;
			}
			
			//if tempInt aka unicode value is out of capital
			//letters value
			if(tempInt > 90)
			{
				//wrap around the alphabet
				tempInt -= 26;
				
				//assign char with new unicode
				tempChar = (char) tempInt;
			}
			else
			{		
				//assign char with new unicode
				tempChar = (char) tempInt;
			}
			
			//rebuild message by adding encrypted char
			message = message.substring(0, i) + tempChar + message.substring(i + 1, message.length());
		}
		
		return message;
		
	}//end of caesarCipher()--------------------------------------------------------------------------------------------
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) 
	{
		char tryAgain = 'n';
		
		//scanner for user input
		Scanner keyboard = new Scanner(System.in);
		
		/**
		 * do-while allows to use program
		 * until user enter 'n'
		 * loop repeats if user enters 'y'
		 */
		do
		{
			System.out.println("********");
			
			//accept character shift for Caesar Cipher (CC)
			System.out.print("Enter a letter to shift by (capitals only): ");
			char caesarShift = keyboard.next().charAt(0);
			
			keyboard.nextLine();//eat up a new line
			
			//accept message to encrypt 
			System.out.println("Enter the message to encrypt (capitals only):");
			String plainText = keyboard.nextLine();
			
			//print encrypted message
			System.out.println("Encrypted message:");
			System.out.println(caesarCipher(caesarShift, plainText));
			
			//accept user's choice to repeat encryption
			System.out.println("Try again? (y/n):");
			tryAgain = keyboard.next().charAt(0);
			
		}while(tryAgain == 'y' || tryAgain == 'Y');
		
		keyboard.close();
		
	}//end of main

}//end of class CaesarCipher


