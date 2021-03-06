package Kaden.modules.render;

import java.awt.Color;
import java.util.List;

import org.lwjgl.input.Keyboard;

import Kaden.Client;
import Kaden.events.Event;
import Kaden.events.listeners.EventKey;
import Kaden.events.listeners.EventRenderGUI;
import Kaden.events.listeners.EventUpdate;
import Kaden.modules.MyModule;
import Kaden.modules.settings.BooleanSetting;
import Kaden.modules.settings.KeybindSetting;
import Kaden.modules.settings.ModeSetting;
import Kaden.modules.settings.NumberSetting;
import Kaden.modules.settings.Settings;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;

public class TabGUI extends MyModule {

	public int currentTab;
	public boolean expanded;
	public static int Color_;
	
	public TabGUI() {
		super("TabGUI", Keyboard.KEY_TAB, Category.RENDER, null);
	}


	public void onEvent(Event e) {
		if(e instanceof EventRenderGUI) {
			FontRenderer fr = mc.fontRendererObj;
			int count = 0;
			

			int color = Rainbow.color;
			
			int primaryColor = color, secondaryColor = 0x3fffffff;
			//0x8fffffff
			
			Gui.drawRect(5, 31, 70, 30 + MyModule.Category.values().length * 16 + 1.5, 0x90000000);
			Gui.drawRect(7, 33 + currentTab * 16, 9, 33 + currentTab * 16 + 12, -1);
		
		for(Category c : MyModule.Category.values()) {
			fr.drawString(c.name, 11, 36 + count*16 , primaryColor);
			
			count ++;
		}
		
		
		
		
	if(expanded) {	
		Category category = MyModule.Category.values()[currentTab]; 
		List<MyModule> modules = Client.getModulesByCategory(category);
		
		if(modules.size() == 0)
			return;
		
		Gui.drawRect(70, 31, 68 + 70, 30 + modules.size() * 16 + 1.5, 0x90000000);
		Gui.drawRect(70, 33 + category.moduleIndex * 16, 7 + 61 + 68, 33 + category.moduleIndex * 16  + 12,  primaryColor);
	
	count = 0;
	for(MyModule m : modules) {
		fr.drawString(m.name, 73, 36 + count*16 , -1);
		
		if(count == category.moduleIndex && m.expanded) {
			
			int Index = 0, maxLength = 0;
			for(Settings s : m.settings) {
				if(s instanceof BooleanSetting) {
					BooleanSetting bool = (BooleanSetting) s;
					if(maxLength < fr.getStringWidth(s.name + ": " + (bool.enabled ? "Enabled" : "Disabled"))) {
						maxLength = fr.getStringWidth(s.name + ": " + (bool.enabled ? "Enabled" : "Disabled"));
					}
				}
				
				if(s instanceof NumberSetting) {
					NumberSetting number = (NumberSetting) s;
					if(maxLength < fr.getStringWidth(s.name + ": " + number.getValue())) {
						maxLength = fr.getStringWidth(s.name + ": " + number.getValue());
					}
					
				}
				
				if(s instanceof ModeSetting) {
					ModeSetting mode = (ModeSetting) s;
					if(maxLength < fr.getStringWidth(s.name + ": " + mode.getMode())) {
						maxLength = fr.getStringWidth(s.name + ": " + mode.getMode());
					}
				}
				
				if(s instanceof KeybindSetting) {
					KeybindSetting keybind = (KeybindSetting) s;
					if(maxLength < fr.getStringWidth(s.name + ": " + Keyboard.getKeyName(keybind.code))) {
					maxLength = fr.getStringWidth(s.name + ": " + Keyboard.getKeyName(keybind.code));
					}
				}
				
				Index++;
		}
			
			if(!m.settings.isEmpty()) {
			Gui.drawRect(68 + 70, 31, maxLength + 68 + 70 + 8, 30 + m.settings.size() * 16 + 1.5, 0x90000000);
			Gui.drawRect(68 + 70, 33 + m.Index * 16, 7 + 61 + maxLength + 68 + 8, 33 + m.Index * 16  + 12, m.settings.get(m.Index).focused ? secondaryColor : primaryColor);
			
			Index = 0;
			for(Settings s : m.settings) {
				if(s instanceof BooleanSetting) {
					BooleanSetting bool = (BooleanSetting) s;
					fr.drawString(s.name + ": " + (bool.enabled ? "Enabled" : "Disabled"), 68 + 73, 36 + Index*16 , -1);
				}
				
				if(s instanceof NumberSetting) {
					NumberSetting number = (NumberSetting) s;
					fr.drawString(s.name + ": " + number.getValue(), 68 + 73, 36 + Index*16 , -1);
				}
				
				if(s instanceof ModeSetting) {
					ModeSetting mode = (ModeSetting) s;
					fr.drawString(s.name + ": " + mode.getMode(), 68 + 73, 36 + Index*16 , -1);
				}
				
				if(s instanceof KeybindSetting) {
					KeybindSetting keybind = (KeybindSetting) s;
					fr.drawString(s.name + ": " + Keyboard.getKeyName(keybind.code), 68 + 73, 36 + Index*16 , -1);
				}
				
				Index++;
			}	
		}
				
	}
		count ++;
		
		}
	}}
	
		if(e instanceof EventKey) {
			int code = ((EventKey)e).code;
			
			Category category = MyModule.Category.values()[currentTab]; 
			List<MyModule> modules = Client.getModulesByCategory(category);
			
			if(expanded & !modules.isEmpty() && modules.get(category.moduleIndex).expanded) {
				MyModule module = modules.get(category.moduleIndex);
				
				if(!module.settings.isEmpty() &&  module.settings.get(module.Index).focused && module.settings.get(module.Index) instanceof KeybindSetting) {
					if(code != Keyboard.KEY_RETURN && code != Keyboard.KEY_UP && code != Keyboard.KEY_DOWN && code != Keyboard.KEY_LEFT && code != Keyboard.KEY_RIGHT && code != Keyboard.KEY_ESCAPE) {
						
						KeybindSetting keyBind = (KeybindSetting)module.settings.get(module.Index);
						
						if(code == Keyboard.KEY_GRAVE)
							code = Keyboard.KEY_NONE;

								
						keyBind.code = code;
						keyBind.focused = false;
						
						return;
					}
					
					
				}
			}
			
			if(code == Keyboard.KEY_UP) {
				
				if(expanded) {
					if(expanded && !modules.isEmpty() && modules.get(category.moduleIndex).expanded) {
						MyModule module = modules.get(category.moduleIndex);
						
						if(!module.settings.isEmpty()) {
						if(module.settings.get(module.Index).focused) {
								Settings s = module.settings.get(module.Index);
								
								if(s instanceof NumberSetting) {
									((NumberSetting)s).increment(true);
								}
						} else {
						if(module.Index <= 0) {			
							module.Index = module.settings.size() - 1;
						} else 
							module.Index--;
						}
						}
						} else {
					if(category.moduleIndex <= 0) {			
						category.moduleIndex = modules.size() - 1;
					} else
						category.moduleIndex--;
						}
					} else {
				if(currentTab <= 0) {			
				currentTab = MyModule.Category.values().length - 1;
			} else 
				currentTab--;
			}}
				
			
			if(code == Keyboard.KEY_DOWN) {
				if(expanded) {
					if(expanded && !modules.isEmpty() && modules.get(category.moduleIndex).expanded) {
						MyModule module = modules.get(category.moduleIndex);
					
						if(!module.settings.isEmpty()) {
						if(module.settings.get(module.Index).focused) {
							Settings s = module.settings.get(module.Index);
							
							if(s instanceof NumberSetting) {
								((NumberSetting)s).increment(false);
							}
						} else {
						
						if(module.Index >= module.settings.size() - 1) {
						module.Index = 0;
					} else 
						module.Index++;
					}
					}
					} else {
					if(category.moduleIndex >= modules.size() - 1) {
						category.moduleIndex = 0;
					} else {
						category.moduleIndex++;
					}}
					
				} else {
				
				if(currentTab >= MyModule.Category.values().length - 1) {
					currentTab = 0;
				} else {
					currentTab++;
				}}}
			
			
			if(code == Keyboard.KEY_RETURN) {
				if(expanded && modules.size() != 0) {
					MyModule module = modules.get(category.moduleIndex);
					
					if(!module.expanded && !module.settings.isEmpty())
					module.expanded = true;
					else if(module.expanded && !module.settings.isEmpty()) {
						module.settings.get(module.Index).focused = !module.settings.get(module.Index).focused;
					}
				}
			}
			
			
			if(code == Keyboard.KEY_RIGHT) {
				if(expanded && modules.size() != 0) {
					MyModule module = modules.get(category.moduleIndex);
					
					if(expanded && !modules.isEmpty() && module.expanded) {
						if(!module.settings.isEmpty()) {
						Settings s = module.settings.get(module.Index);
						
						if(s instanceof BooleanSetting) {
							((BooleanSetting)s).toggle();
						}
						
						if(s instanceof ModeSetting) {
							((ModeSetting)s).cycle();
						}
						}
					} else {
					
					if(!module.name.equals("TabGUI"))
					module.toggle();
					if(module.toTurnOff != null) {
					Client.turnOff(module.toTurnOff);
					}}
				} else {
					expanded = true;
			}}
			
			if(code == Keyboard.KEY_LEFT) {
				
				if(expanded && !modules.isEmpty() && modules.get(category.moduleIndex).expanded) {
					MyModule module = modules.get(category.moduleIndex);
					if(!module.settings.isEmpty()) {
					if(module.settings.get(module.Index).focused) {
						
					} else {
					modules.get(category.moduleIndex).expanded = false;
					}}
				} else {
				expanded = false;
			}}
			
		
		}
		
		
		}}
	
		
	