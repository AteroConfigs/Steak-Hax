package Kaden;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;

import Kaden.command.CommandManager;
import Kaden.events.Event;
import Kaden.events.listeners.EventChat;
import Kaden.events.listeners.EventKey;
import Kaden.events.listeners.EventUpdate;
import Kaden.modules.MyModule;
import Kaden.modules.MyModule.Category;
import Kaden.modules.combat.*;
import Kaden.modules.movement.*;
import Kaden.modules.player.*;
import Kaden.modules.render.*;
import Kaden.modules.settings.BooleanSetting;
import Kaden.modules.settings.KeybindSetting;
import Kaden.modules.settings.ModeSetting;
import Kaden.modules.settings.NumberSetting;
import Kaden.modules.settings.Settings;
import Kaden.ui.HUD;
import Kaden.util.SaveLoad.Load;
import Kaden.util.SaveLoad.Save;
import Kaden.util.XrayUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;

public class Client {

	public static String name = "Steak Hax", version = "1.0.10TEST";
	public static CopyOnWriteArrayList<MyModule> modules = new CopyOnWriteArrayList<MyModule>();
	public static HUD hud = new HUD();
	public static CommandManager commandManager = new CommandManager();
	public static boolean Load_ = true;
	

	public static void startup() {

		Rainbow.color = 0x8fffffff;

		System.out.println("Starting " + name + "- version " + version);
		Display.setTitle(name + " v" + version);

		modules.add(new Fly());
		modules.add(new Sprint());
		modules.add(new FullBright());
		modules.add(new NoFall());
		modules.add(new TabGUI());
		modules.add(new KillAura());
		//modules.add(new QuickCharge());
		modules.add(new NoFire());
		modules.add(new AutoRespawn());
		modules.add(new Bhop());
		modules.add(new Sanic());
		modules.add(new AutoCrits());
		modules.add(new Rainbow());
		modules.add(new FastPlace());
		modules.add(new FastLadder());
		modules.add(new PingSpoof());
		modules.add(new ArrowCount());
		modules.add(new BowTicks());
		modules.add(new ArmorDur());
		modules.add(new ItemDur());
		modules.add(new Fish());
		modules.add(new KeyStrokes());
		modules.add(new InstaPortal());
		modules.add(new Derp());
		modules.add(new AutoSword());
		modules.add(new Xray());
		XrayUtils.initXRayBlocks();
		modules.add(new AirJump());
		modules.add(new Spider());
		modules.add(new BetterFont());
		
		//modules.add(new FakeLagSpike());
		
		modules.add(new Tracers());
		modules.add(new ESP());

		
		for (MyModule m : modules) { 
			if (m.name.equals("Arrow Count") == true || m.name.equals("Armor Dur") || m.name.equals("Item Dur")) {
				m.setToggleTrue();
			}
			if(m.name.equals("TabGUI")) {
				for(Settings s : m.settings) {
					
					if(s instanceof KeybindSetting) {
						KeybindSetting keybind = (KeybindSetting) s;
						keybind.setKeyCode(Keyboard.KEY_TAB);
					}}
				m.setToggleTrue();
			}
		}

	}
	
	
	public static void onFirstTick() {
		System.out.println("LOAD");
		Load.main();
	}
	
	public static void onQuit() {
		System.out.println("SAVE");
		Save.main();
	}
	

	public static void onEvent(Event e) {
		if(e instanceof EventUpdate) 
			if(MinecraftServer.getServer() != null && Load_ == true) {
				Client.onFirstTick();
				Load_ = false;
			}
		
		
		if (e instanceof EventChat) {
			commandManager.handleChat((EventChat) e);
		}

		for (MyModule m : modules) {
			if (!m.toggled)
				continue;
			
			m.onRender();
			m.onEvent(e);
		}
	}
	

	
	public static void keyPress(int key) {
		
		Client.onEvent(new EventKey(key));
		for (MyModule m : modules) {

			if (m.getKey() == key) {
				if (!m.isEnabled()) {
					if (m.toTurnOff != null) {
						turnOff(m.toTurnOff);
					}
				}
				m.toggle();
			}

		}
	}

	public static void turnOff(String[] toTurn) {
		for (String strTemp : toTurn) {
			for (MyModule m : modules) {
				if (m.name.equals(strTemp) && m.isEnabled()) {
					m.setToggleFalse();
				}
			}
		}
	}

	public static List<MyModule> getModulesByCategory(Category c) {
		List<MyModule> modules = new ArrayList<MyModule>();

		for (MyModule m : Client.modules) {
			if (m.category == c) {
				modules.add(m);
			}

		}
		return modules;
	}

	public static void addChatMessage(String message) {
		message = "§4[" + "§6" + name + "§4]" + "§f " + message;
		Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(message));
	}

}
