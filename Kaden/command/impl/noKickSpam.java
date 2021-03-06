package Kaden.command.impl;

import Kaden.Client;
import Kaden.command.Command;
import Kaden.modules.MyModule;
import Kaden.util.Timer;
import net.minecraft.client.Minecraft;
import net.minecraft.network.play.client.C01PacketChatMessage;

public class noKickSpam extends Command {
	
	public noKickSpam() {
		super("IntSpam", "IntSpam <message> for as long you chose", "IntSpam <number of spam messages> <Interval> <message>", "is");
	}
	Timer timer = new Timer();
	

	@Override
	public void onCommand(String[] args, String command) {	
		
		if(args[1] == null) {
			Client.addChatMessage("Incorrect format, Proper format is: " + syntax);
			return;
		}
		
		if(args[1].matches("[0-9]+") && args[0].matches("[0-9]+") && !args[2].isEmpty()) {
			
			int i = Integer.parseInt(args[0]);
			int savei = i;
		      StringBuffer sb = new StringBuffer();
		      for(int i1 = 0; i1 < args.length; i1++) {
		         sb.append(args[i1] + " ");
		      }
		      String str = sb.toString().substring(args[0].length() + args[1].length());
			while(i > 0) {

			if(timer.hasTimeElapsed(100, true)) {
			Minecraft.getMinecraft().thePlayer.sendQueue.addToSendQueue(new C01PacketChatMessage(str));
			i--;
			}}
			Client.addChatMessage("Sent " + savei + " messages!");

	} else {
		Client.addChatMessage("Incorrect format, Proper format is: " + syntax);
	}}
}
	

