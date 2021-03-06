package Kaden.modules.player;

import org.lwjgl.input.Keyboard;

import Kaden.events.Event;
import Kaden.events.listeners.EventMotion;
import Kaden.events.listeners.EventUpdate;
import Kaden.modules.MyModule;
import net.minecraft.util.Rotations;

public class Derp extends MyModule {

	public Derp() {
		super("Derp", Keyboard.KEY_NONE, Category.PLAYER, null);
	}

	
public void onEvent(Event e) {
		
		if(e instanceof EventMotion) {
			if(e.isPre()) {
				
				EventMotion event = (EventMotion)e;
				
				float yaw = mc.thePlayer.rotationYaw + (float)(Math.random() * 360 - 180);
				float pitch = (float)(Math.random() * 180 - 90);

				event.setYaw(yaw);
				event.setPitch(pitch);
	}}}
	

}	
	
