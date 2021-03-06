package Kaden.command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Kaden.Client;
import Kaden.command.impl.*;
import Kaden.events.listeners.EventChat;

public class CommandManager {

	public static List<Command> commands = new ArrayList<Command>();
	public String prefix = "$";
	
	public CommandManager() {
		setup();
	}
	
	public void setup() {
		commands.add(new Help());
		commands.add(new Info());
		commands.add(new Spam());
		commands.add(new SpeedyGonzalez());
		commands.add(new Combat());
		commands.add(new AllOff());
		commands.add(new Spawn());
		commands.add(new KillPot());
		//commands.add(new Phasex());
		//commands.add(new Phasez());
		//commands.add(new noKickSpam());
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
			if(!foundCommand) {
				Client.addChatMessage("Invalid command. \n Use $Help for all commands!");
			}
		}
	}
	
}
