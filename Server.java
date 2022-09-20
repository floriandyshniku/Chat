package lesson12;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Server {
	
	public static void main(String[] args) throws Exception {
		
		ChatServer server = new ChatServer(1074);
		
		while(true) {
			
			Socket client = server.accept();

			new Thread(()->{
				
				try {
					
					DataInputStream input =
							new DataInputStream(client.getInputStream());

					DataOutputStream output =
							new DataOutputStream(client.getOutputStream());
					
					output.writeUTF("Mire se erdhe! Vendos emrin e plote: ");
					output.flush();
					
					String fullName = input.readUTF();
					
					ChatClient client1 = server.getClient(fullName);
					
					if(client1 == null) {
						client1 = server.addClient(fullName); 
					}
					
					output.writeUTF("Vendos emrin e plote te personit me te cilin do komunikosh: ");
					output.flush();

					fullName = input.readUTF();
					
					ChatClient client2 = server.getClient(fullName);
					
					if(client2 == null) {
						client2 = server.addClient(fullName); 
					}
					
					StringBuilder chatHistoryContent = new StringBuilder();
					
					if(client1.getChat().get(client2) == null) {
						client1.getChat().put(client2, new ArrayList<ChatHistory>());
						client2.getChat().put(client1, new ArrayList<ChatHistory>());
					}
					
					for(ChatHistory c : client1.getChat().get(client2)) {
						chatHistoryContent.append("Derguesi: " + c.getSender().getFullName());
						chatHistoryContent.append("\nData dhe ora: " + c.getDateAndTime().getTime());
						chatHistoryContent.append("\nMesazhi: " + c.getMsg());
						chatHistoryContent.append("\n-------------------------------------------\n");
					}
					
					output.writeUTF(chatHistoryContent.toString());
					output.flush();
					
					output.writeUTF("\nVendos mesazhin e ri: ");
					output.flush();
					
					String msg = input.readUTF();
					
					ChatHistory chatHistory = new ChatHistory(client1, 
															  new GregorianCalendar(), 
															  msg);
					
					client1.getChat().get(client2).add(chatHistory);
					
					client2.getChat().get(client1).add(chatHistory);

					input.close();
					output.close();
					client.close();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}).start();

		}
		
	}

}
