import java.util.*;


public class CaesarCipher 
{

	public static String caesarCipher(char shift, String message)
	{
		int ascii = (int) shift;
		ascii -= 65;
		
		for(int i = 0; i < message.length(); i++)
		{
			char tempChar = message.charAt(i);
			int tempInt = (int) tempChar;
			
			if(tempInt >= 65 && tempInt <= 90)
			{
				tempInt += ascii;
			}
			
			tempChar = (char) tempInt;
			
			message = message.substring(0, i) + tempChar + message.substring(i + 1, message.length());
		}
		
		return message;
	}
	
	public static void main(String[] args) 
	{
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Enter a letter to shift by: ");
		char caesarShift = keyboard.next().charAt(0);
		
		keyboard.nextLine();
		
		System.out.println("Enter the message to encrypt:");
		
		String plainText = keyboard.nextLine();
		
		keyboard.close();
		
		System.out.println("Encrypted message:");
		
		System.out.println(caesarCipher(caesarShift, plainText));
		
	}

}


