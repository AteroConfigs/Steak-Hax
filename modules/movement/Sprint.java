package Kaden.modules.movement;

import org.lwjgl.input.Keyboard;

import Kaden.Client;
import Kaden.events.Event;
import Kaden.events.listeners.EventUpdate;
import Kaden.modules.MyModule;

public class Sprint extends MyModule {

	public Sprint() {
		super("Sprint", Keyboard.KEY_N, Category.MOVEMENT, null);
	}

	public void onEnable() {
		
	}
	
	
	public void onDisable() {
		mc.thePlayer.setSprinting(mc.gameSettings.keyBindSprint.getIsKeyPressed());
	}
	
public void onEvent(Event e) {
		
		if(e instanceof EventUpdate) {
			if(e.isPre()) {

				if(mc.thePlayer.moveForward > 0 && !mc.thePlayer.isUsingItem() && !mc.thePlayer.isCollidedHorizontally)
					mc.thePlayer.setSprinting(true);
			}
		}
	}


}	
	
