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
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPotion;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.network.play.client.C01PacketChatMessage;
import net.minecraft.network.play.client.C02PacketUseEntity;
import net.minecraft.network.play.client.C02PacketUseEntity.Action;
import net.minecraft.network.play.client.C0APacketAnimation;
import net.minecraft.network.play.client.C0BPacketEntityAction;

public class AutoSword extends MyModule {
	
	
	public AutoSword() {
		super("AutoSword", Keyboard.KEY_NONE, Category.COMBAT, null);

	}
	


/*
	public void onEvent(Event e) {
		
		if(e instanceof EventUpdate) {
			if(e.isPre()) {
				
				if(mc.thePlayer.isDead)
					return;
				
				if(mc.objectMouseOver != null && mc.objectMouseOver.entityHit instanceof EntityLivingBase)
						setSlot();
				}
				
	}}
*/

	
	public static void setSlot()
	{

		float bestSpeed = 1F;
		int bestSlot = -1;
		for(int i = 0; i < 9; i++)
		{
			ItemStack item = Minecraft.getMinecraft().thePlayer.inventory.getStackInSlot(i);
			if(item == null)
				continue;
			float speed = 0;
			if(item.getItem() instanceof ItemSword)
				speed = ((ItemSword)item.getItem()).func_150931_i();
			else if(item.getItem() instanceof ItemTool)
				speed = ((ItemTool)item.getItem()).getToolMaterial()
					.getDamageVsEntity();
			if(speed > bestSpeed)
			{
				bestSpeed = speed;
				bestSlot = i;
			}
		}
		if(bestSlot != -1 && bestSlot != Minecraft.getMinecraft().thePlayer.inventory.currentItem)
		{
			Minecraft.getMinecraft().thePlayer.inventory.currentItem = bestSlot;
		}
	}

		

}
	