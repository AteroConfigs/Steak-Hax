package Kaden.modules.player;

import org.lwjgl.input.Keyboard;

import Kaden.events.Event;
import Kaden.events.listeners.EventUpdate;
import Kaden.modules.MyModule;

public class NoFire extends MyModule {

	public NoFire() {
		super("NoFire", Keyboard.KEY_NONE, Category.PLAYER, null);
	}

	
	public void onEnable() {
		mc.thePlayer.fireResistance = 1000000000;
	}
	
	public void onDisable() {
		mc.thePlayer.fireResistance = 20;
	}
	

}	
	
