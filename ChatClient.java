package lesson12;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChatClient {
	
	private int id;
	private String fullName;

	private Map<ChatClient, List<ChatHistory>> chat;

	public ChatClient(int id, String fullName) {
		this.id = id;
		this.fullName = fullName;
		chat = new HashMap<>();
	}
	
	public int getId() {
		return id;
	}
	
	public String getFullName() {
		return fullName;
	}
	
	public Map<ChatClient, List<ChatHistory>> getChat() {
		return chat;
	}

	@Override
	public int hashCode() { 
		return id;
	} 
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof ChatClient)) {
			return false;
		}
		ChatClient other = (ChatClient) obj;
		if (chat == null) {
			if (other.chat != null) {
				return false;
			}
		} else if (!chat.equals(other.chat)) {
			return false;
		}
		if (fullName == null) {
			if (other.fullName != null) {
				return false;
			}
		} else if (!fullName.equals(other.fullName)) {
			return false;
		}
		if (id != other.id) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "ChatClient [id=" + id + ", fullName=" + fullName + ", chat=" + chat + "]";
	}
	
}

