package Kaden.command.impl;

import Kaden.Client;
import Kaden.command.Command;
import Kaden.modules.MyModule;
import net.minecraft.client.Minecraft;

public class Spawn extends Command {

	public Spawn() {
		super("WorldSpawn", "Tells you the World Spawn!", "WorldSpawn", "w");
	}

	@Override
	public void onCommand(String[] args, String command) {	
		Client.addChatMessage(Minecraft.getMinecraft().theWorld.getSpawnPoint().toString());
	}
	
}
