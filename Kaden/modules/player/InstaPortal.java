package Kaden.modules.player;

import org.lwjgl.input.Keyboard;

import Kaden.events.Event;
import Kaden.events.listeners.EventUpdate;
import Kaden.modules.MyModule;

public class InstaPortal extends MyModule {

	public InstaPortal() {
		super("Insta Portal(WIP)", Keyboard.KEY_NONE, Category.PLAYER, null);
	}


	public void onEnable() {
		mc.thePlayer.timeUntilPortal = 0;
	}
	
	public void onDisable() {
		mc.thePlayer.timeInPortal = 1;
	}
	
	

}	
	
