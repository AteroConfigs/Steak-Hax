package Kaden.modules.movement;

import org.lwjgl.input.Keyboard;

import Kaden.events.Event;
import Kaden.events.listeners.EventUpdate;
import Kaden.modules.MyModule;

public class Bhop extends MyModule {

	public Bhop() {
		super("Bhop", Keyboard.KEY_B, Category.MOVEMENT, null);
	}
	
	
	public void onEvent(Event e) {
		
		if(e instanceof EventUpdate) {
			if(e.isPre()) {
			if(mc.thePlayer.onGround)
				mc.thePlayer.jump();
			}
		}
	}

}	
	
