package Kaden.modules.player;

import org.lwjgl.input.Keyboard;

import Kaden.events.Event;
import Kaden.events.listeners.EventUpdate;
import Kaden.modules.MyModule;

public class Fish extends MyModule {

	public Fish() {
		super("Fish", Keyboard.KEY_NONE, Category.PLAYER, null);
	}

	public static boolean FishMode = false;
	
	
	public void onDisable() {
		FishMode = false;
	}
	
	public void onEvent(Event e) {
		
		if(e instanceof EventUpdate) {

			if(mc.thePlayer.isInWater() && !mc.thePlayer.isDead && mc.thePlayer.getAir() < 10) {
				FishMode = true;//				mc.thePlayer.timeUntilPortal = 0;
			} else {
				FishMode = false;
			}
		}
	}
	

}	
	
