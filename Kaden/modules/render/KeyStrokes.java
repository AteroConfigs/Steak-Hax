package Kaden.modules.render;

import org.lwjgl.input.Keyboard;

import Kaden.Client;
import Kaden.events.Event;
import Kaden.events.listeners.EventKey;
import Kaden.events.listeners.EventMotion;
import Kaden.events.listeners.EventUpdate;
import Kaden.modules.MyModule;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class KeyStrokes extends MyModule {

	public KeyStrokes() {
		super("Key Strokes", Keyboard.KEY_NONE, Category.RENDER, null);
	}
	
	public static boolean WDown;
	public static boolean ADown;
	public static boolean SDown;
	public static boolean DDown;
	public static boolean SpaceDown;
	public static boolean ShiftDown;
	public static boolean CTRLDown;

	public void onDisable() {
		WDown = false;
		ADown = false;
		SDown = false;
		DDown = false;
		SpaceDown = false;
		ShiftDown = false;
		CTRLDown = false;
	}
	
	public void onRender() {
				
					if(Keyboard.isKeyDown(Keyboard.KEY_W)) {
						WDown = true;
					} else {
						WDown = false;
					}
					if(Keyboard.isKeyDown(Keyboard.KEY_A)) {
						ADown = true;
					} else {
						ADown = false;
					}
					if(Keyboard.isKeyDown(Keyboard.KEY_S)) {
						SDown = true;
					} else {
						SDown = false;
					}
					if(Keyboard.isKeyDown(Keyboard.KEY_D)) {
						DDown = true;
					} else {
						DDown = false;
					}
					if(Keyboard.isKeyDown(Keyboard.KEY_SPACE)) {
						SpaceDown = true;
					} else {
						SpaceDown = false;
					}
					if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) {
						ShiftDown = true;
					} else {
						ShiftDown = false;
					}
					if(Keyboard.isKeyDown(Keyboard.KEY_LCONTROL)) {
						CTRLDown = true;
					} else {
						CTRLDown = false;
					}
					
}
	


}
	