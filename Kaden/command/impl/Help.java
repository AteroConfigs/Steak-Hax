package Kaden.command.impl;

import java.util.List;

import Kaden.Client;
import Kaden.command.Command;
import Kaden.command.CommandManager;
import Kaden.modules.MyModule;

public class Help extends Command {

	public Help() {
		super("Help", "All Commands", "help | help <command name>", "h");
	}
	
private String str = "";
private boolean b = false;

	@Override
	public void onCommand(String[] args, String command) {	
		str = "\n";
		b = false;
		

			for(Command c : CommandManager.commands) {
				
					str += c.name + ",\n";
				}
				
			
	/*if(!args[0].isEmpty()) {
		for(Command c : CommandManager.commands) {
			if(args[0].toLowerCase() == c.name.toLowerCase()) {
			str = str + c.name + ", ";
			break;
			b = true;
		} }
		if(b == false)
		str = str + "\n Type $help <command name> for details on a command!";
			
	} */
	Client.addChatMessage(str);
		}
			
		
}
		
	
	


