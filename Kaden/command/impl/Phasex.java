package Kaden.command.impl;

import Kaden.Client;
import Kaden.command.Command;
import Kaden.command.CommandManager;
import Kaden.modules.MyModule;
import net.minecraft.client.Minecraft;

public class Phasex extends Command {

	public Phasex() {
		super("PhaseX", "Phase though blocks.", " phasex <numb>", "px");
	}
	


	@Override
	public void onCommand(String[] args, String command) {	
		
		if(Integer.parseInt(args[0]) < 1 || args[0] == null)
			Client.addChatMessage("Proper way to use command is " + this.syntax);
			
		Minecraft.getMinecraft().thePlayer.posX += Integer.parseInt(args[0]);
		Minecraft.getMinecraft().thePlayer.serverPosX += Integer.parseInt(args[0]);
		Client.addChatMessage("Tp'ed " + Integer.parseInt(args[0]) + " blocks!");
		
}
		
	
	
}

