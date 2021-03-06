package Kaden.modules.player;

import org.lwjgl.input.Keyboard;

import Kaden.Client;
import Kaden.events.Event;
import Kaden.events.listeners.EventKey;
import Kaden.events.listeners.EventUpdate;
import Kaden.modules.MyModule;
import Kaden.modules.settings.NumberSetting;

public class FastPlace extends MyModule {

	
	public FastPlace() {
		super("Fast Place", Keyboard.KEY_NONE, Category.PLAYER, null);
	}
	
	public void onDisable() {
		mc.rightClickDelayTimer = 4;
	}

	public void onEvent(Event e) {
		
		if(e instanceof EventUpdate) {
	
			mc.rightClickDelayTimer = 0;

			}
		}
	}


	
