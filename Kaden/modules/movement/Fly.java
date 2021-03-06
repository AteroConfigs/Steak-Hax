package Kaden.modules.movement;

import org.lwjgl.input.Keyboard;

import Kaden.Client;
import Kaden.events.Event;
import Kaden.events.listeners.EventKey;
import Kaden.events.listeners.EventUpdate;
import Kaden.modules.MyModule;
import Kaden.modules.settings.NumberSetting;

public class Fly extends MyModule {

	public NumberSetting Speed = new NumberSetting("Speed", 3, 1, 10, 1);
	
	public Fly() {
		super("Fly", Keyboard.KEY_G, Category.MOVEMENT, null);
		this.addSettings(Speed);
	}

	public void onEnable() {

	}
	
	public void onDisable() {
		mc.thePlayer.capabilities.isFlying = false;
		mc.thePlayer.capabilities.allowFlying = false;
		}
	
	public void onEvent(Event e) {
		
		if(e instanceof EventUpdate) {
	
				if(e.isPre()) {
				mc.thePlayer.capabilities.isFlying = true;
				//int key = 0;
				//Client.onEvent(new EventKey(key));
				//if(key != mc.gameSettings.keyBindForward.getKeyCode() || key != mc.gameSettings.keyBindRight.getKeyCode() || key != mc.gameSettings.keyBindLeft.getKeyCode() || key != mc.gameSettings.keyBindBack.getKeyCode()) { 
				//	mc.thePlayer.capabilities.setFlySpeed(0);
				//} else {
				if(mc.thePlayer.capabilities.getFlySpeed() < Speed.getValue()/100 )
					mc.thePlayer.capabilities.setFlySpeed((float)Speed.getValue()/100);

			}//}
		}
	}

}	
	
