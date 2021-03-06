package Kaden.modules.player;

import org.lwjgl.input.Keyboard;

import Kaden.events.Event;
import Kaden.events.listeners.EventUpdate;
import Kaden.modules.MyModule;

public class NoClip extends MyModule {

	public NoClip() {
		super("NoClip", Keyboard.KEY_NONE, Category.PLAYER, null);
	}

	
	public void onEnable() {
		mc.thePlayer.noClip = true;
	}
	
	public void onDisable() {
		mc.thePlayer.noClip = false;
	}
	
	

}	
	
