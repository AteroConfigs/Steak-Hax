package Kaden.modules.movement;

import org.lwjgl.input.Keyboard;

import Kaden.events.Event;
import Kaden.events.listeners.EventUpdate;
import Kaden.modules.MyModule;
import Kaden.modules.settings.NumberSetting;

public class Sanic extends MyModule {

	public NumberSetting Speed = new NumberSetting("Speed Mutiplyer", 1.3, 1, 1.6, 0.1);
	public NumberSetting SpeedMax = new NumberSetting("Max Speed", 5, 1, 15, 1);
	
	public Sanic() {
		super("Sanic", Keyboard.KEY_NONE, Category.MOVEMENT, null);
		this.addSettings(Speed, SpeedMax);
	}

	
	public void onEnable() {
		
	}
	
	public void onDisable() {

	}
	
	
	public void onEvent(Event e) {
		
		if(e instanceof EventUpdate) {
			if(e.isPre()) {
				 if((mc.thePlayer.moveForward != 0 || mc.thePlayer.moveStrafing != 0)
				     && !mc.thePlayer.isSneaking() && mc.thePlayer.onGround) {
					 if(mc.thePlayer.motionX > SpeedMax.getValue()) {
						 mc.thePlayer.motionX = SpeedMax.getMax();
					 } else {
						 mc.thePlayer.motionX *= Speed.getValue(); 
					 }
					 
					 if(mc.thePlayer.motionZ > SpeedMax.getValue()) {
						 mc.thePlayer.motionZ = SpeedMax.getValue();
					 } else {
						 mc.thePlayer.motionZ *= Speed.getValue(); 
					 }
			}}
		}
	}

}	
	
