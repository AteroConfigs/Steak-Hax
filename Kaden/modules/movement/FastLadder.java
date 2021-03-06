package Kaden.modules.movement;

import org.lwjgl.input.Keyboard;

import Kaden.Client;
import Kaden.events.Event;
import Kaden.events.listeners.EventKey;
import Kaden.events.listeners.EventUpdate;
import Kaden.modules.MyModule;
import Kaden.modules.settings.NumberSetting;
import net.minecraft.network.play.client.C03PacketPlayer;

public class FastLadder extends MyModule {

	
	public FastLadder() {
		super("Fast Ladder", Keyboard.KEY_NONE, Category.MOVEMENT, null);
	}
	
	public void onDisable() {

	}

	public void onEvent(Event e) {
		
		if(e instanceof EventUpdate) {
	
			if(!mc.thePlayer.isDead) {
			if(mc.thePlayer.isOnLadder() && mc.thePlayer.isCollidedHorizontally)
				mc.thePlayer.motionY = 0.2872;

			}}
		}
	}


	
