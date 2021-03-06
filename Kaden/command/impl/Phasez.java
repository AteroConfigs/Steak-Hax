package Kaden.command.impl;

import Kaden.Client;
import Kaden.command.Command;
import Kaden.command.CommandManager;
import Kaden.modules.MyModule;
import net.minecraft.client.Minecraft;

public class Phasez extends Command {

	public Phasez() {
		super("PhaseZ", "Phase though blocks.", " phasey <numb>", "pz");
	}
	


	@Override
	public void onCommand(String[] args, String command) {	
		
		if(Integer.parseInt(args[0]) < 1 || args[0] == null)
			Client.addChatMessage("Proper way to use command is " + this.syntax);
			
		Minecraft.getMinecraft().thePlayer.posZ += Integer.parseInt(args[0]);
		Minecraft.getMinecraft().thePlayer.serverPosZ += Integer.parseInt(args[0]);
		Client.addChatMessage("Tp'ed " + Integer.parseInt(args[0]) + " blocks!");
		
}
		
	
	
}

