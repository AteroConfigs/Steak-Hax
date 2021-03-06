package Kaden.modules.combat;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.lwjgl.input.Keyboard;

import Kaden.events.Event;
import Kaden.events.listeners.EventMotion;
import Kaden.events.listeners.EventUpdate;
import Kaden.modules.MyModule;
import Kaden.modules.settings.BooleanSetting;
import Kaden.modules.settings.ModeSetting;
import Kaden.modules.settings.NumberSetting;
import Kaden.util.Timer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.network.play.client.C01PacketChatMessage;
import net.minecraft.network.play.client.C02PacketUseEntity;
import net.minecraft.network.play.client.C02PacketUseEntity.Action;
import net.minecraft.network.play.client.C0APacketAnimation;
import net.minecraft.network.play.client.C0BPacketEntityAction;

public class AutoCrits extends MyModule {
	
	public ModeSetting Mode = new ModeSetting("Type of Jump", "MiniJump", "Jump", "MiniJump");
	
	public AutoCrits() {
		super("AutoCrits", Keyboard.KEY_NONE, Category.COMBAT, null);
		this.addSettings(Mode);

	}
public static boolean isReady;

public static void Start() {
	isReady = true;
}

public void onEvent(Event e) {
	
	if(e instanceof EventUpdate) {
		if(e.isPre()) {
			
			if(mc.thePlayer.isDead) {
				return;
			}
			
			if(Mode.getMode() == "Jump") {
				if(isReady == true) {
					Crit();
					isReady = false;
				}
			}
			
			if(Mode.getMode() == "MiniJump") {
				if(isReady == true) {
					MiniJump();
					isReady = false;
				}
			}
		
}}}

public void Crit() {
	if(Mode.getMode().toString() == "Jump") {
		Jump();
	}
	
	if(Mode.getMode().toString() == "MiniJump") {
		MiniJump();
	}
}

private void MiniJump() {
	if(mc.thePlayer.onGround) {
		mc.thePlayer.motionY += 0.1;
		mc.thePlayer.fallDistance = 0.2F;
		mc.thePlayer.onGround = false;
	}
}

private void Jump() {
	if(mc.thePlayer.onGround) {
	mc.thePlayer.jump();
}}
		



}
