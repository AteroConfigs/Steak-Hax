package Kaden.modules.render;

import org.lwjgl.input.Keyboard;

import Kaden.events.Event;
import Kaden.events.listeners.EventMotion;
import Kaden.events.listeners.EventUpdate;
import Kaden.modules.MyModule;
import net.minecraft.init.Items;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;

public class BowTicks extends MyModule {

	public BowTicks() {
		super("Bow Ticks(WIP)", Keyboard.KEY_NONE, Category.RENDER, null);
	}
	

	
	public void onRender() {
			
		if(mc.thePlayer.getCurrentEquippedItem() != null) {	
			if(mc.thePlayer.getCurrentEquippedItem().getItem() == Items.bow) {
					mc.fontRendererObj.drawString("-                               50", 215, 132, Rainbow.color);
					mc.fontRendererObj.drawString("-                               25", 215, 124, Rainbow.color);
		
			}}
		
	}}




	