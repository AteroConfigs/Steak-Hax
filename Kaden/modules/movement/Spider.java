package Kaden.modules.movement;

import org.lwjgl.input.Keyboard;

import Kaden.Client;
import Kaden.events.Event;
import Kaden.events.listeners.EventKey;
import Kaden.events.listeners.EventUpdate;
import Kaden.modules.MyModule;
import Kaden.modules.settings.NumberSetting;
import net.minecraft.network.play.client.C03PacketPlayer;

public class Spider extends MyModule {

	public NumberSetting Speed = new NumberSetting("Speed", 2, 1, 10, 1);
	
	public Spider() {
		super("Spider", Keyboard.KEY_NONE, Category.MOVEMENT, null);
		this.addSettings(Speed);
	}
	
	public void onDisable() {

	}

	public void onEvent(Event e) {
		
		if(e instanceof EventUpdate) {
	
			if(!mc.thePlayer.isDead) {
				if(mc.thePlayer.isCollidedHorizontally)
					mc.thePlayer.motionY = Speed.getValue()/10;

			}}
		}
	}


	
