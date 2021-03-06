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

public class ItemDur extends MyModule {

	public ItemDur() {
		super("Item Dur", Keyboard.KEY_NONE, Category.RENDER, null);
	}
	
	public FontRenderer fr = mc.fontRendererObj;
	ScaledResolution sr = new ScaledResolution(mc, mc.displayWidth, mc.displayHeight);
	
	public static boolean draw = false;
	
	public void onDisable() {
		draw = false;
	}
	
	public void onRender() {
					
					if(mc.thePlayer.isDead) {
						draw = false;
					return;
					}
					
					if(mc.thePlayer.getCurrentEquippedItem() == null) {
						return;
					}
					
					if(mc.thePlayer.getCurrentEquippedItem() != null && mc.thePlayer.getCurrentEquippedItem().isItemDamaged()) {
					draw = true;
					} else { 
					draw = false;
					}


				//mc.thePlayer.getCurrentEquippedItem().getItemDamage() - mc.thePlayer.getCurrentEquippedItem().getMaxDamage()
}
	



}
	