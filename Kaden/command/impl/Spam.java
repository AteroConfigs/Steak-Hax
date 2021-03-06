package Kaden.command.impl;

import Kaden.Client;
import Kaden.command.Command;
import Kaden.modules.MyModule;
import Kaden.util.Timer;
import net.minecraft.client.Minecraft;
import net.minecraft.network.play.client.C01PacketChatMessage;

public class Spam extends Command {
	
	public Spam() {
		super("Spam", "Spam <message> for as long you chose", "spam <number of spam messages> <message>", "s");
	}

	@Override
	public void onCommand(String[] args, String command) {	

		
		if(!args[1].isEmpty() && args[0].matches("[0-9]+")) {
			
			int i = Integer.parseInt(args[0]);
			int savei = i;
		      StringBuffer sb = new StringBuffer();
		      for(int i1 = 0; i1 < args.length; i1++) {
		         sb.append(args[i1] + " ");
		      }
		      String str = sb.toString().substring(args[0].length());
			while(i > 0) {
			Minecraft.getMinecraft().thePlayer.sendQueue.addToSendQueue(new C01PacketChatMessage(str));
			i--;
			}
			Client.addChatMessage("Sent " + savei + " messages!");

	} else {
		Client.addChatMessage("Incorrect format, Proper format is: " + syntax);
	}}
}
	

