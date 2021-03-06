package Kaden.modules.render;

import java.util.ArrayList;

import org.lwjgl.input.Keyboard;

import Kaden.events.Event;
import Kaden.events.listeners.EventMotion;
import Kaden.events.listeners.EventUpdate;
import Kaden.modules.MyModule;
import Kaden.util.RenderUtils;
import net.minecraft.block.Block;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class Xray extends MyModule {

	public static ArrayList<Block> XrayBlocks = new ArrayList<Block>();
	
	public static boolean XrayEnabled = false;
	
	private int defaultRender;
	
	public Xray() {
		super("Xray", Keyboard.KEY_Z, Category.RENDER, null);
	}
	
	public void onEnable() {
		defaultRender = mc.gameSettings.renderDistanceChunks;
		mc.gameSettings.renderDistanceChunks = 32;
		XrayEnabled = true;
		mc.renderGlobal.loadRenderers();
	}
	
	public void onDisable() {
		mc.gameSettings.renderDistanceChunks = defaultRender;
		XrayEnabled = false;
		mc.renderGlobal.loadRenderers();
	}
	

}
	