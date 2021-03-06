package Kaden.modules.render;

import org.lwjgl.input.Keyboard;

import Kaden.events.Event;
import Kaden.events.listeners.EventMotion;
import Kaden.events.listeners.EventUpdate;
import Kaden.modules.MyModule;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class ArrowCount extends MyModule {

	public ArrowCount() {
		super("Arrow Count", Keyboard.KEY_NONE, Category.RENDER, null);
	}
	
	public static int arrow = 0;
	public static boolean draw = false;
	private boolean isArrowInInv;
	private ScaledResolution sr = new ScaledResolution(mc, mc.displayWidth, mc.displayHeight);

    private boolean isArrow(ItemStack stack) {
    	if(stack != null) {
    	return stack.stackSize != 0 && stack.getItem() == Items.Arrow;
    	}
		return false;
    }
	
	public void onRender() {
		
			draw = false;
			isArrowInInv = false;
			int arrows = 0;
	        for (ItemStack stack : mc.thePlayer.inventory.mainInventory) {
	            if (isArrow(stack)) {
	            	isArrowInInv = true;
	                arrows += stack.stackSize;
	                arrow = arrows;
	            }
	        }
	        if(isArrowInInv == false) {
	        	arrow = 0;
	        }
	
		if(mc.thePlayer.getCurrentEquippedItem() != null) {	
			if(mc.thePlayer.getCurrentEquippedItem().getItem() == Items.bow) {
				draw = true;
		}

}}

}
	