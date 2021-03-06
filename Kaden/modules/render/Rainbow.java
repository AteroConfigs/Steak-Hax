package Kaden.modules.render;

import java.awt.Color;

import org.lwjgl.input.Keyboard;

import Kaden.events.Event;
import Kaden.events.listeners.EventRenderGUI;
import Kaden.events.listeners.EventUpdate;
import Kaden.modules.MyModule;
import Kaden.modules.settings.BooleanSetting;
import Kaden.modules.settings.ModeSetting;
import Kaden.modules.settings.NumberSetting;

public class Rainbow extends MyModule {

	public NumberSetting speed = new NumberSetting("Speed of Rainbow", 3, 1, 10, 1);
	public NumberSetting saturation = new NumberSetting("Saturation", 10, 1, 10, 1);
	public NumberSetting brightness = new NumberSetting("Brightness", 10, 1, 10, 1);
	
	public Rainbow() {
		super("Rainbow", Keyboard.KEY_R, Category.RENDER, null);
		settings.add(speed);
		settings.add(saturation);
		settings.add(brightness);
	}
	
	public static int color;
	
	public void onEvent(Event e) {
		if(e instanceof EventRenderGUI) {
		if(mc.inGameHasFocus) {
			float hue = (System.currentTimeMillis() % (int)(speed.getValue() * 1000)) / (float)(speed.getValue() * 1000f);
			color = Color.HSBtoRGB(hue, (float)(saturation.getValue() * 0.1), (float)(brightness.getValue() * 0.1));
			
		}}}
	
	public void onDisable() {
		color = 0x8fffffff;
	}
		
}


	
