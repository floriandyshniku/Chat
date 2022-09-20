package lesson12;

import java.util.GregorianCalendar;

public class ChatHistory {

	private ChatClient sender;
	private GregorianCalendar dateAndTime;
	private String msg;
	 
	public ChatHistory(ChatClient sender, 
					  GregorianCalendar dateAndTime, 
					  String msg) { 
		this.sender = sender;
		this.dateAndTime = dateAndTime;
		this.msg = msg;
	}

	public ChatClient getSender() {
		return sender;
	}

	public void setSender(ChatClient sender) {
		this.sender = sender;
	}

	public GregorianCalendar getDateAndTime() {
		return dateAndTime;
	}

	public void setDateAndTime(GregorianCalendar dateAndTime) {
		this.dateAndTime = dateAndTime;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateAndTime == null) ? 0 : dateAndTime.hashCode());
		result = prime * result + ((msg == null) ? 0 : msg.hashCode());
		result = prime * result + ((sender == null) ? 0 : sender.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof ChatHistory)) {
			return false;
		}
		ChatHistory other = (ChatHistory) obj;
		if (dateAndTime == null) {
			if (other.dateAndTime != null) {
				return false;
			}
		} else if (!dateAndTime.equals(other.dateAndTime)) {
			return false;
		}
		if (msg == null) {
			if (other.msg != null) {
				return false;
			}
		} else if (!msg.equals(other.msg)) {
			return false;
		}
		if (sender == null) {
			if (other.sender != null) {
				return false;
			}
		} else if (!sender.equals(other.sender)) {
			return false;
		}
		return true;
	}

}
