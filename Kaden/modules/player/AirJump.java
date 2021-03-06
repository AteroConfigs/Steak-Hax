package Kaden.modules.player;

import org.lwjgl.input.Keyboard;

import Kaden.events.Event;
import Kaden.events.listeners.EventMotion;
import Kaden.events.listeners.EventUpdate;
import Kaden.modules.MyModule;

public class AirJump extends MyModule {

	public AirJump() {
		super("AirJump", Keyboard.KEY_NONE, Category.PLAYER, null);
	}

	
	public void onEvent(Event e) {
		
		if(e instanceof EventUpdate) {
				mc.thePlayer.fallDistance = 0;
				mc.thePlayer.onGround = true;
			}}
	
	public void onDisable() {

	}
	
	

}	
	
