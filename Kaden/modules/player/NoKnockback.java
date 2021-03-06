package Kaden.modules.player;

import org.lwjgl.input.Keyboard;

import Kaden.events.Event;
import Kaden.events.listeners.EventUpdate;
import Kaden.modules.MyModule;
import net.minecraft.network.play.client.C03PacketPlayer;

public class NoKnockback extends MyModule {

	public NoKnockback() {
		super("NoFall", Keyboard.KEY_M, Category.PLAYER, null);
	}

	
	public void onEvent(Event e) {
		
		if(e instanceof EventUpdate) {
			if(e.isPre()) {
				//if(mc.thePlayer.hitByEntity(true)) {

				}
			}
		}
	}
//}
