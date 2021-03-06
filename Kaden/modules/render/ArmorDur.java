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

public class ArmorDur extends MyModule {

	public ArmorDur() {
		super("Armor Dur", Keyboard.KEY_NONE, Category.RENDER, null);
	}
	
	public FontRenderer fr = mc.fontRendererObj;
	ScaledResolution sr = new ScaledResolution(mc, mc.displayWidth, mc.displayHeight);
	
	public static boolean draw0 = false;
	public static boolean draw1 = false;
	public static boolean draw2 = false;
	public static boolean draw3 = false;
	
	public void onDisable() {
		draw0 = false;
		draw1 = false;
		draw2 = false;
		draw3 = false;
	}
	
	public void onRender() {
		
					
					
					if(mc.thePlayer.isDead) {
						draw0 = false;
						draw1 = false;
						draw2 = false;
						draw3 = false;
						return;
					}
					
					if(mc.thePlayer.getCurrentArmor(0) != null) {
					draw0 = true;
					} else { 
					draw0 = false;
					}
					
					if(mc.thePlayer.getCurrentArmor(1) != null) {
					draw1 = true;
					} else { 
					draw1 = false;
					}
					
					if(mc.thePlayer.getCurrentArmor(2) != null) {
					draw2 = true;
					} else { 
					draw2 = false;
					}
				
					if(mc.thePlayer.getCurrentArmor(3) != null) {
					draw3 = true;
					} else { 
					draw3 = false;
					}

				
}
	



}
	