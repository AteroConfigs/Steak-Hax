package Kaden.ui;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

import Kaden.Client;
import Kaden.events.listeners.EventRenderGUI;
import Kaden.modules.MyModule;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;

public class HUD {

	public Minecraft mc = Minecraft.getMinecraft();
	
		
		

	
	public void draw() {
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
		fr.drawStringWithShadow(Client.name + " V" + Client.version, 4.0, 4.0, -1);
		GlStateManager.popMatrix();
		GlStateManager.pushMatrix();
		GlStateManager.translate(4, 4, 0);
		GlStateManager.scale(1.05, 1.05, 1.05);
		GlStateManager.translate(-4, -4, 0);
		if(mc.inGameHasFocus) {
		fr.drawString(String.valueOf(Math.round(mc.thePlayer.lastTickPosX)) + " / " + String.valueOf(Math.round(mc.thePlayer.lastTickPosY)) + " / " + String.valueOf(Math.round(mc.thePlayer.lastTickPosZ)), 15.0, 218.0, 1);
		}
		//add speed use vel relative to look
		GlStateManager.popMatrix();
		
		
		
		int count = 0;
		
		for(MyModule m : Client.modules) {
			if(!m.toggled || m.name.equals("TabGUI"))
				continue;
			
			double offset = count*(fr.FONT_HEIGHT + 6);
			
			Gui.drawRect(sr.getScaledWidth() - fr.getStringWidth(m.name) - 8, offset, sr.getScaledWidth(), 6 + fr.FONT_HEIGHT + offset, 0x90000000);
			//Make cool green block on the side of commands
			//Gui.drawRect(count, offset, count, offset, count);
			fr.drawString(m.name, sr.getScaledWidth() - fr.getStringWidth(m.name) -4, 4 + offset, -1);
		
			count++;
		}
	
		Client.onEvent(new EventRenderGUI());
	
	}

}
 