package Kaden.modules.render;

import org.lwjgl.input.Keyboard;

import Kaden.events.Event;
import Kaden.events.listeners.EventUpdate;
import Kaden.modules.MyModule;

public class FullBright extends MyModule {

	public FullBright() {
		super("FullBright", Keyboard.KEY_O, Category.RENDER, null);
	}

	public void onEnable() {
		mc.gameSettings.gammaSetting = 100;
	}
	
	
	public void onDisable() {
		mc.gameSettings.gammaSetting = 1;
	}
	}	
	
