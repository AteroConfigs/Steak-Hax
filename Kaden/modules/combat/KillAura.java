package Kaden.modules.combat;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.lwjgl.input.Keyboard;

import Kaden.Client;
import Kaden.events.Event;
import Kaden.events.listeners.EventMotion;
import Kaden.modules.MyModule;
import Kaden.modules.settings.BooleanSetting;
import Kaden.modules.settings.ModeSetting;
import Kaden.modules.settings.NumberSetting;
import Kaden.util.Timer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.network.play.client.C01PacketChatMessage;
import net.minecraft.network.play.client.C02PacketUseEntity;
import net.minecraft.network.play.client.C02PacketUseEntity.Action;
import net.minecraft.network.play.client.C0APacketAnimation;
import net.minecraft.network.play.client.C0BPacketEntityAction;

public class KillAura extends MyModule {
	
	public Timer timer = new Timer();
	public NumberSetting range = new NumberSetting("Range", 4.8, 1, 6, 0.1);
	public NumberSetting aps = new NumberSetting("APS", 30, 1, 100, 1);
	public NumberSetting startblocking = new NumberSetting("Start Block", 1, 0, 2.5, 0.1);
	public BooleanSetting noSwing = new BooleanSetting("No Swing", false);
	public BooleanSetting autoBlock = new BooleanSetting("Auto Block", true);
	public BooleanSetting moveHead = new BooleanSetting("Head Fake", true);
	
	public KillAura() {
		super("KillAura", Keyboard.KEY_X, Category.COMBAT, new String[]{"LegitAura"});
		this.addSettings(range, aps, noSwing, autoBlock, moveHead, startblocking);
	}

	public void onEnable() {

	}
	
	
	public void onDisable() {

	}
	
	public void onEvent(Event e) {
		
		if(e instanceof EventMotion) {
			if(e.isPre()) {
				
				EventMotion event = (EventMotion)e;
				
				List<EntityLivingBase> targets = (List<EntityLivingBase>) mc.theWorld.loadedEntityList.stream().filter(EntityLivingBase.class::isInstance).collect(Collectors.toList());
				List<EntityLivingBase> Blocktargets;
				
				targets = targets.stream().filter(entity -> entity.getDistanceToEntity(mc.thePlayer) < range.getValue() && entity != mc.thePlayer && !entity.isDead && entity.getHealth() > 0).collect((Collectors.toList()));
				Blocktargets = targets.stream().filter(entity -> entity.getDistanceToEntity(mc.thePlayer) < (range.getValue() + startblocking.getValue()) && entity != mc.thePlayer && !entity.isDead && entity.getHealth() > 0).collect((Collectors.toList()));
				
				float[] EntityRot;
				
				
				
				targets.sort(Comparator.comparingDouble(entity -> ((EntityLivingBase)entity).getDistanceToEntity(mc.thePlayer)));
				
				
				
				if(!targets.isEmpty()) {
					EntityLivingBase target = targets.get(0);
					

				if(moveHead.isEnabled()) {
					event.setYaw(getRotations(target)[0]);
					event.setPitch(getRotations(target)[1]);
				}
				
				
					
				//targets = targets.stream().filter(EntityPlayer.class::isInstance).collect(Collectors.toList());	

				
				if(mc.thePlayer.getCurrentEquippedItem() != null) {
				if(mc.thePlayer.getCurrentEquippedItem().getItemUseAction() == EnumAction.BLOCK && autoBlock.isEnabled()) {
				ItemStack item = mc.thePlayer.getCurrentEquippedItem();
				mc.thePlayer.setItemInUse(item, item.getMaxItemUseDuration());
				}}
				
				if(timer.hasTimeElapsed((long) (1000 / aps.getValue()), true)) {	
					boolean AutoCrit_ = false;
					boolean AutoSword_ = false;
					for(MyModule m : Client.modules) {
						if(m.name.equals("AutoSword")) {
							if(m.toggled) {
								AutoSword_ = true;
							}
						}
						if(m.name.equals("AutoCrits")) {
							if(m.toggled) {
								AutoCrit_ = true;
							}
						}
						}
					
					if(AutoCrit_ == true) {
						AutoCrits.isReady = true;
					}
					if(AutoSword_ == true) {
						AutoSword.setSlot();
					}
					
					if(noSwing.isEnabled()) {
						mc.thePlayer.sendQueue.addToSendQueue(new C0APacketAnimation());
					} else {
					mc.thePlayer.swingItem();
					}
				
					mc.thePlayer.sendQueue.addToSendQueue(new C02PacketUseEntity(target, Action.ATTACK));

					
					}
				}
				}
			}}

	//}


	public float[] getRotations(Entity e) {
		double deltaX = e.posX + (e.posX - e.lastTickPosX) - mc.thePlayer.posX,
		deltaY = e.posY - 3.5 + e.getEyeHeight() - mc.thePlayer.posY + mc.thePlayer.getEyeHeight(),
		deltaZ = e.posZ + (e.posZ - e.lastTickPosZ) - mc.thePlayer.posZ,
		distance = Math.sqrt(Math.pow(deltaX, 2)) + Math.pow(deltaZ, 2);
		
		float yaw = (float) Math.toDegrees(-Math.atan(deltaX - deltaZ)),
				pitch = (float) -Math.toDegrees(Math.atan(deltaY / distance));
		
		if(deltaX < 0 && deltaZ < 0) {
			yaw = (float) (90 + Math.toDegrees(Math.atan(deltaZ / deltaX)));
		}
		else if(deltaX > 0 && deltaZ < 0) {
			yaw = (float) (-90 + Math.toDegrees(Math.atan(deltaZ / deltaX)));
		}
	
		return new float[] {yaw, pitch};
	
	}
	



}	
	
