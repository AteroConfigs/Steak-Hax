package Kaden.command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Kaden.command.impl.Info;
import Kaden.command.impl.Spam;
import Kaden.events.listeners.EventChat;

public class CommandManager {

	public List<Command> commands = new ArrayList<Command>();
	public String prefix = "$";
	
	public CommandManager() {
		setup();
	}
	
	public void setup() {
		commands.add(new Info());
		commands.add(new Spam());
	}
	
	public void handleChat(EventChat event) {
		String message = event.getMessage();
		
		if(!message.startsWith(prefix))
			return;
		
		event.setCancelled(true);
		
		message = message.substring(prefix.length());
		
		boolean foundCommand = false;
		
		if(message.split(" ").length > 0) {
			String commandName = message.split(" ")[0];
		
			for(Command c : commands) {
				if(c.aliases.contains(commandName) || c.name.equalsIgnoreCase(commandName)) {
					c.onCommand(Arrays.copyOfRange(message.split(" "), 1, message.split(" ").length), message);
					foundCommand = true;
					break;
				}
			}
		}
	}
	
}
