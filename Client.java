package lesson12;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	
	public static void main(String[] args) throws Exception {
		 
		Socket client = new Socket("localhost", 1074);
	 
		DataInputStream input =
				new DataInputStream(client.getInputStream());

		DataOutputStream output =
				new DataOutputStream(client.getOutputStream());
			
		Scanner in = new Scanner(System.in);
				
		System.out.print(input.readUTF());
		
		String text = nextLine(in);
		
		output.writeUTF(text);
		output.flush();

		System.out.print(input.readUTF());
		
		text = nextLine(in);
		
		output.writeUTF(text);
		output.flush();
		
		System.out.print(input.readUTF());
		System.out.print(input.readUTF());
		
		text = nextLine(in);
		
		output.writeUTF(text);
		output.flush();
		
		input.close();
		output.close();
		client.close();
		
	}

	private static String nextLine(Scanner input) {
		String line = input.nextLine().trim();
		while(line.isEmpty()) {
			line = input.nextLine().trim();
		}
		return line;
	}

}
