package Kaden.modules.movement;

import org.lwjgl.input.Keyboard;

import Kaden.events.Event;
import Kaden.events.listeners.EventUpdate;
import Kaden.modules.MyModule;
import Kaden.modules.settings.NumberSetting;

public class Fly extends MyModule {

	//public NumberSetting Speed = new NumberSetting("Speed", 0.05, 0.05, 0.5, 0.05);
	
	public Fly() {
		super("Fly", Keyboard.KEY_G, Category.MOVEMENT, null);
		//this.addSettings(Speed);
	}

	
	
	public void onDisable() {
		mc.thePlayer.capabilities.isFlying = false;
		mc.thePlayer.capabilities.allowFlying = false;
	}
	
	
	public void onEvent(Event e) {
		
		if(e instanceof EventUpdate) {
			if(e.isPre()) {
			mc.thePlayer.capabilities.isFlying = true;
			//mc.thePlayer.capabilities.setFlySpeed((float)Speed.getValue());
			}
		}
	}

}	
	
