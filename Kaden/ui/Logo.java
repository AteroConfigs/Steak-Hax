package Kaden.ui;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

import org.lwjgl.opengl.GL11;

import Kaden.Client;
import Kaden.events.listeners.EventRenderGUI;
import Kaden.modules.MyModule;
import Kaden.modules.render.ArrowCount;
import Kaden.modules.render.Rainbow;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.util.ResourceLocation;

public class Logo {

	private final Minecraft mc = Minecraft.getMinecraft();
	
	private static final ResourceLocation Logo =
			new ResourceLocation("Steak-MCLOGO.png");	
	
	public static void LogoDraw() {		
		OpenGlHelper.glBlendFunc(770, 771, 1, 0);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		Minecraft.getMinecraft().getTextureManager().bindTexture(Logo);
		int x = -8;
		int y = -12;
		int w = 72;
		int h = 50;
		float fw = 72;
		float fh = 50;
		float u = 0;
		float v = 0;
		Gui.drawModalRectWithCustomSizedTexture(x, y, u, v, w, h, fw, fh);
	}
	
}
 