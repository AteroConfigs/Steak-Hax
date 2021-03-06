package Kaden.command.impl;

import Kaden.Client;
import Kaden.command.Command;
import Kaden.command.CommandManager;
import Kaden.modules.MyModule;

public class Combat extends Command {

	public Combat() {
		super("Combat", "Put combat commands on!", " combat", "c");
	}
	


	@Override
	public void onCommand(String[] args, String command) {	

		for(MyModule m : Client.modules) {
			if(m.name.equals("KillAura") || m.name.equals("Quick Bow") || m.name.equals("Auto Respawn") || m.name.equals("AutoCrits") || m.name.equals("NoFall")) {
				m.setToggleTrue();
			}}
		Client.addChatMessage("Combat commands activated!");
		
}
		
	
	
}

