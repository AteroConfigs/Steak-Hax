package Kaden.modules.player;

import org.lwjgl.input.Keyboard;

import Kaden.events.Event;
import Kaden.events.listeners.EventUpdate;
import Kaden.modules.MyModule;
import net.minecraft.network.play.client.C03PacketPlayer;

public class NoFall extends MyModule {

	public NoFall() {
		super("NoFall", Keyboard.KEY_M, Category.PLAYER, null);
	}

	
	public void onEvent(Event e) {
		
		if(e instanceof EventUpdate) {
			if(e.isPre()) {
				if(mc.thePlayer.fallDistance > 2)
					mc.thePlayer.sendQueue.addToSendQueue(new C03PacketPlayer(true));
			}
		}
	}
}
