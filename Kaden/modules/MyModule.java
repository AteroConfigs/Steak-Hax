package Kaden.modules;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Kaden.events.Event;
import Kaden.modules.MyModule.Category;
import Kaden.modules.settings.KeybindSetting;
import Kaden.modules.settings.Settings;
import net.java.games.input.Keyboard;
import net.minecraft.client.Minecraft;

public class MyModule {

	public String name;
	public boolean toggled;
	public KeybindSetting keyCode = new KeybindSetting(0);
	public Category category;
	public String[] toTurnOff;
	public Minecraft mc = Minecraft.getMinecraft();
	
	public boolean expanded;
	public int Index;
	public List<Settings> settings =  new ArrayList <Settings>();
	
	public MyModule(String name, int key, Category c, String[] toTurnOff) {
		this.name = name;
		keyCode.code = key;
		this.category = c;
		this.addSettings(keyCode);
		this.toTurnOff = toTurnOff;
	}
	
	public void addSettings(Settings...settings) {
		this.settings.addAll(Arrays.asList(settings));
	}
	
	public boolean isEnabled() {
		return toggled;
	}
	

	public int getKey() {
		return keyCode.code;
	}
	
	public void onEvent(Event e) {
		
	}
	
	
	public void toggle() {
		toggled = !toggled;
		if(toggled) {
			onEnable();
		} else {
			onDisable();
		}
		}
	
	public void setToggleFalse() {
		if(toggled == true)
		onDisable();
		
		toggled = false;
	}
	
	public void setToggleTrue() {
		if(toggled == false)
		onEnable();
		
		toggled = true;
	}
	
	public void onEnable() {
		
	}
	
	public void onDisable() {
		
	}	
	
	public void onRender() {
		
	}
	
	public enum Category {
		COMBAT("Combat"),
		MOVEMENT("Movement"),
		PLAYER("Player"),
		RENDER("Render");
		
		public String name;
		public int moduleIndex;
		
		Category(String name){
			this.name = name;
		}
	}

	//public void onRender() {
		// TODO Auto-generated method stub
		
	//}
	
}