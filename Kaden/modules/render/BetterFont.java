package Kaden.modules.render;

import org.lwjgl.input.Keyboard;

import Kaden.events.Event;
import Kaden.events.listeners.EventMotion;
import Kaden.events.listeners.EventUpdate;
import Kaden.modules.MyModule;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class BetterFont extends MyModule {

	public BetterFont() {
		super("BetterFont", Keyboard.KEY_NONE, Category.RENDER, null);
	}
	
	public void onEnable() {
		mc.gameSettings.forceUnicodeFont = true;
	}

	public void onDisable() {
		mc.gameSettings.forceUnicodeFont = false;
	}
}
	