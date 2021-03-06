package Kaden.ui;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

import Kaden.Client;
import Kaden.events.listeners.EventRenderGUI;
import Kaden.modules.MyModule;
import Kaden.modules.render.*;
import Kaden.util.RenderUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;

public class HUD {

	private final Minecraft mc = Minecraft.getMinecraft();

	
	public void draw() {
		
		
		Logo.LogoDraw();
		
		ScaledResolution sr = new ScaledResolution(mc, mc.displayWidth, mc.displayHeight);
		FontRenderer fr = mc.fontRendererObj;
			
		Client.modules.sort(Comparator.comparingInt(m -> 
		fr.getStringWidth(((MyModule)m).name)
		).reversed()
	);
		
		
		GlStateManager.pushMatrix();
		GlStateManager.translate(4, 4, 0);
		GlStateManager.scale(2, 2, 1);
		GlStateManager.translate(-4, -4, 0);
		fr.drawStringWithShadow(Client.name + " V" + Client.version, 4.0, 4.0, Rainbow.color);
		GlStateManager.popMatrix();
		GlStateManager.pushMatrix();
		GlStateManager.translate(4, 4, 0);
		GlStateManager.scale(1.05, 1.05, 1.05);
		GlStateManager.translate(-4, -4, 0);
		if(mc.inGameHasFocus) {
		fr.drawString(String.valueOf(Math.round(mc.thePlayer.lastTickPosX)) + " / " + String.valueOf(Math.round(mc.thePlayer.lastTickPosY)) + " / " + String.valueOf(Math.round(mc.thePlayer.lastTickPosZ)), 15.0, 218.0, Rainbow.color);
		//fr.drawString(String.valueOf(mc.thePlayer.getLook(1.0f)), 15.0, 200.0, Rainbow.color);
		if(ArrowCount.draw == true)
		fr.drawString(Integer.toString(ArrowCount.arrow), sr.getScaledWidth()/2 * 0.93, sr.getScaledHeight()/2 * 1.5, Rainbow.color);
		
		if(mc.thePlayer.getCurrentEquippedItem() != null && mc.thePlayer.getCurrentEquippedItem().getItemDamage() != 0 && mc.thePlayer.getCurrentEquippedItem().getMaxDamage() != 0) {
			if(ItemDur.draw == true) {
				double percent = (mc.thePlayer.getCurrentEquippedItem().getItemDamage() * 100) / mc.thePlayer.getCurrentEquippedItem().getMaxDamage();
				fr.drawString("Tool: " + Double.toString(Math.abs(percent - 100)) + "%", 1, 155, Rainbow.color);
			}}
			
			if(ArmorDur.draw0 == true) {
				if(mc.thePlayer.getCurrentArmor(0) != null)
				if(mc.thePlayer.getCurrentArmor(0).getItemDamage() != 0 && mc.thePlayer.getCurrentArmor(0).getMaxDamage() != 0) {
				double percent = (mc.thePlayer.getCurrentArmor(0).getItemDamage() * 100) / mc.thePlayer.getCurrentArmor(0).getMaxDamage();
				fr.drawString("H: " + Double.toString(Math.abs(percent - 100)) + "%", 1, 170, Rainbow.color);
			}}
			
			if(ArmorDur.draw1 == true) {
				if(mc.thePlayer.getCurrentArmor(1) != null)
				if(mc.thePlayer.getCurrentArmor(1).getItemDamage() != 0 && mc.thePlayer.getCurrentArmor(1).getMaxDamage() != 0) {
				double percent = (mc.thePlayer.getCurrentArmor(1).getItemDamage() * 100) / mc.thePlayer.getCurrentArmor(1).getMaxDamage();
				fr.drawString("C: " + Double.toString(Math.abs(percent - 100)) + "%", 1, 180, Rainbow.color);
			}}
			
			if(ArmorDur.draw2 == true) {
				if(mc.thePlayer.getCurrentArmor(2) != null)
				if(mc.thePlayer.getCurrentArmor(2).getItemDamage() != 0 && mc.thePlayer.getCurrentArmor(2).getMaxDamage() != 0) {
				double percent = (mc.thePlayer.getCurrentArmor(2).getItemDamage() * 100) / mc.thePlayer.getCurrentArmor(2).getMaxDamage();
				fr.drawString("L: " + Double.toString(Math.abs(percent - 100)) + "%", 1, 190, Rainbow.color);
			}}
			
			if(ArmorDur.draw3 == true) {
				if(mc.thePlayer.getCurrentArmor(3) != null)
				if(mc.thePlayer.getCurrentArmor(3).getItemDamage() != 0 && mc.thePlayer.getCurrentArmor(3).getMaxDamage() != 0) {
				double percent = (mc.thePlayer.getCurrentArmor(3).getItemDamage() * 100) / mc.thePlayer.getCurrentArmor(3).getMaxDamage();
				fr.drawString("B: " + Double.toString(Math.abs(percent - 100)) + "%", 1, 200, Rainbow.color);
			}}
			
			GlStateManager.scale(1.5, 1.5, 1.5);
			
			if(KeyStrokes.WDown) {
				fr.drawString("W", 25, 100, Rainbow.color);
			}
			
			if(KeyStrokes.ADown) {
				fr.drawString("A", 15, 115, Rainbow.color);
			}
			
			if(KeyStrokes.SDown) {
				fr.drawString("S", 25, 115, Rainbow.color);
			}
			
			if(KeyStrokes.DDown) {
				fr.drawString("D", 35, 115, Rainbow.color);
			}
			
			if(KeyStrokes.SpaceDown) {
				fr.drawString("----", 15, 125, Rainbow.color);
			}
			
			if(KeyStrokes.ShiftDown) {
				fr.drawString("LS", 3, 125, Rainbow.color);
			}
			
			if(KeyStrokes.CTRLDown) {
				fr.drawString("CTRL", 3, 135, Rainbow.color);
			}
			
		}
		
		GlStateManager.popMatrix();
		
		
		
		int count = 0;
		
		for(MyModule m : Client.modules) {
			if(!m.toggled || m.name.equals("TabGUI"))
				continue;
			
			double offset = count*(fr.FONT_HEIGHT + 6);
			
			Gui.drawRect(sr.getScaledWidth() - fr.getStringWidth(m.name) - 8, offset, sr.getScaledWidth(), 6 + fr.FONT_HEIGHT + offset, 0x90000000);
			//Make cool green block on the side of commands
			//Gui.drawRect(count, offset, count, offset, count);
			fr.drawString(m.name, sr.getScaledWidth() - fr.getStringWidth(m.name) -4, 4 + offset, Rainbow.color);
		
			count++;
	
		}
	
		Client.onEvent(new EventRenderGUI());
	
	}
	

}
 