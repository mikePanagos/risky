package mojo;
import java.util.List;
import java.util.ArrayList;
import mojo.risk.*;
import mojo.notification.*;

public class NotificationCenter {
	private List<Player> observers;
	private Notification notification;
	
	/**
	 * Constructor used to initiate the notification center.
	 */
	NotificationCenter() {
		observers = new ArrayList<Player>();
	}
	
	/**
	 * This method will add a player to the list of observers kept.
	 * @param player
	 */
	public String add(Player player) {
		try {
			observers.add(player);
			return "Success!";
		} catch (Exception e) {
			return e.toString();
		}
	}
	
	/**
	 * This method will set the notification to be sent.
	 * @param notification The notification that was created by the game
	 */
	public boolean setNotification(Notification notification) {
		if ((this.notification = notification) != null) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * This method will update the player who is supposed to receive the notification.
	 */
	public boolean updatePlayer() {
		Player playerToNotify = null;
		for (int i = 0; i < observers.size(); i++) {
			if (observers.get(i).getId() == notification.getReceiver()) {
				playerToNotify = observers.get(i);
				break;
			}
		}
		playerToNotify.sendNotification(notification);
		return true;
	}
}