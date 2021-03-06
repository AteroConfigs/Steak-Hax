package Kaden.command.impl;

import Kaden.Client;
import Kaden.command.Command;
import Kaden.command.CommandManager;
import Kaden.modules.MyModule;

public class SpeedyGonzalez extends Command {

	public SpeedyGonzalez() {
		super("SpeedyGonzalez", "Put fast boi Hax on ( ;", " SpeedyGonzalez", "speed");
	}
	


	@Override
	public void onCommand(String[] args, String command) {	

		for(MyModule m : Client.modules) {
			if(m.name.equals("Sanic") || m.name.equals("Sprint") || m.name.equals("NoFall") || m.name.equals("Fast Ladder")) {
				m.setToggleTrue();
			}}
		Client.addChatMessage("SpeedyGonzalez activated!");
		
}
		
	
	
}

