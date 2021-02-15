package Kaden.modules.combat;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.lwjgl.input.Keyboard;

import Kaden.events.Event;
import Kaden.events.listeners.EventMotion;
import Kaden.modules.MyModule;
import Kaden.modules.MyModule.Category;
import Kaden.modules.settings.BooleanSetting;
import Kaden.modules.settings.NumberSetting;
import Kaden.util.Timer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.network.play.client.C02PacketUseEntity;
import net.minecraft.network.play.client.C02PacketUseEntity.Action;

public class LegitAura extends MyModule {
	
	public Timer timer = new Timer();
	public NumberSetting aps = new NumberSetting("APS", 10, 1, 20, 1);
	
	public LegitAura() {
		super("LegitAura", Keyboard.KEY_NONE, Category.COMBAT, new String[]{"KillAura"});
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
				
				targets = targets.stream().filter(entity -> entity.getDistanceToEntity(mc.thePlayer) < 4 && entity != mc.thePlayer && !entity.isDead && entity.getHealth() > 0).collect((Collectors.toList()));
			
				targets.sort(Comparator.comparingDouble(entity -> ((EntityLivingBase)entity).getDistanceToEntity(mc.thePlayer)));
				
				if(!targets.isEmpty()) {
					EntityLivingBase target = targets.get(0);
				
				mc.thePlayer.rotationYaw = (getRotations(target)[0]);
				mc.thePlayer.rotationPitch = (getRotations(target)[1]);
					
				//filter targets = targets.stream().filter(EntityAnimal.class::isInstance).collect(Collectors.toList());	
					
				if(timer.hasTimeElapsed(1000 / 10, true))	
					mc.thePlayer.swingItem();
					mc.thePlayer.sendQueue.addToSendQueue(new C02PacketUseEntity(target, Action.ATTACK));
				}
				
			}
		}
	}


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