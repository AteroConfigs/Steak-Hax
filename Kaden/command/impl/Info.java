package Kaden.command.impl;

import Kaden.Client;
import Kaden.command.Command;
import Kaden.modules.MyModule;

public class Info extends Command {

	public Info() {
		super("Info", "Client Info", "info", "i");
	}

	@Override
	public void onCommand(String[] args, String command) {	
		Client.addChatMessage("V" + Client.version + " by TDC0471");
	}
	
}
