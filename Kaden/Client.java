package Kaden;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.lwjgl.opengl.Display;

import Kaden.command.CommandManager;
import Kaden.events.Event;
import Kaden.events.listeners.EventChat;
import Kaden.events.listeners.EventKey;
import Kaden.modules.MyModule;
import Kaden.modules.MyModule.Category;
import Kaden.modules.combat.*;
import Kaden.modules.movement.*;
import Kaden.modules.player.*;
import Kaden.modules.render.*;
import Kaden.ui.HUD;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;

public class Client {

	public static String name = "Catch-21", version = "1";
	public static CopyOnWriteArrayList<MyModule> modules = new CopyOnWriteArrayList<MyModule>();
	public static HUD hud = new HUD();
	public static CommandManager commandManager = new CommandManager();
	
	public static void startup() {

		System.out.println("Starting " + name + "- version " + version);
		Display.setTitle(name + " v" + version);
		
		modules.add(new Fly());
		modules.add(new Sprint());
		modules.add(new FullBright());
		modules.add(new NoFall());
		modules.add(new TabGUI());
		modules.add(new KillAura());
		modules.add(new LegitAura());
		modules.add(new DelayFire());
		modules.add(new AutoRespawn());
		modules.add(new Bhop());
		modules.add(new Sanic());
	}
	
	public static void onEvent(Event e) {
		if(e instanceof EventChat) {
			commandManager.handleChat((EventChat)e);
		}
		
		for (MyModule m : modules) {
			if(!m.toggled)
				continue;
				
			m.onEvent(e);
		}
	}

	public static void keyPress(int key) {
		Client.onEvent(new EventKey(key));
	
		for(MyModule m : modules){
			
			if(m.getKey() == key) {
				if(!m.isEnabled()) {
					if(m.toTurnOff != null) {
						turnOff(m.toTurnOff);
						}
					}
				m.toggle();
				}
				
			}
		}
	
	
	public static void turnOff(String[] toTurn) {
		for(String strTemp : toTurn) {
			for(MyModule m : modules){
				if(m.name.equals(strTemp) && m.isEnabled()) {
					m.untoggle();
				}
			}
		}
	}
	
	
	public static List<MyModule> getModulesByCategory(Category c){
		List<MyModule> modules = new ArrayList<MyModule>();
		
		for(MyModule m : Client.modules) {
			if(m.category == c) {
				modules.add(m);
			}
		
		}
		return modules;
	}
	
	public static void addChatMessage(String message) {
		message = "\2472" + name + "\2477: " + message;
		Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(message));
	}
	
}
