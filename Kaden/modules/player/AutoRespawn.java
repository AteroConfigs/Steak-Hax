package Kaden.modules.player;

import org.lwjgl.input.Keyboard;

import Kaden.events.Event;
import Kaden.events.listeners.EventUpdate;
import Kaden.modules.MyModule;

public class AutoRespawn extends MyModule {

	public AutoRespawn() {
		super("AutoRespawn", Keyboard.KEY_NONE, Category.PLAYER, null);
	}

	
	public void onEnable() {
		mc.thePlayer.deathTime = 0;

	}
	
	public void onDisable() {
		
	}
	
	public void onEvent(Event e) {
		
		if(e instanceof EventUpdate) {
			if(e.isPre()) {
			if(mc.thePlayer.isDead) {
				mc.thePlayer.respawnPlayer();
			}
			}
		}
	}
	

}	
	
