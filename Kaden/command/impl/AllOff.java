package Kaden.command.impl;

import Kaden.Client;
import Kaden.command.Command;
import Kaden.command.CommandManager;
import Kaden.modules.MyModule;

public class AllOff extends Command {

	public AllOff() {
		super("Panic", "Turn all Haxs off.", "panic", "p");
	}
	


	@Override
	public void onCommand(String[] args, String command) {	

		for(MyModule m : Client.modules) {
			if(m.toggled == true) {
				m.setToggleFalse();
				m.onDisable();
			}}
		Client.addChatMessage("All Hacks are off!");
		
}
		
	
	
}

