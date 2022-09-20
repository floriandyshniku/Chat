package lesson12;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer extends ServerSocket {
	
	private List<ChatClient> clients;
	private static int nextId = 1;
	
	public ChatServer(int port) throws IOException {
		super(port); 
		clients = new ArrayList<ChatClient>();
	}

	public ChatClient addClient(String fullName) {
		ChatClient client = new ChatClient(nextId, fullName);
		clients.add(client);
		return client;
	}
	
	public ChatClient getClient(int id) {
		for(ChatClient c : clients) {
			if(c.getId() == id) {
				return c;
			}
		}
		return null;
	}

	public ChatClient getClient(String fullName) {
		for(ChatClient c : clients) {
			if(c.getFullName().equals(fullName)) {
				return c;
			}
		}
		return null;
	}
	
	public boolean exists(ChatClient client) {
		for(ChatClient c : clients) {
			if(c.getFullName().equals(client.getFullName()) &&
			   c.getId() == client.getId()) {
				return true;
			}
		}
		return false;
	}

	public int getNumberOfClients() { 
		return clients.size();
	}

}
