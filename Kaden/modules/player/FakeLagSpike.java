package Kaden.modules.player;

import java.util.ArrayList;

import org.lwjgl.input.Keyboard;

import Kaden.events.Event;
import Kaden.events.listeners.EventMotion;
import Kaden.events.listeners.EventUpdate;
import Kaden.modules.MyModule;
import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.network.Packet;

public class FakeLagSpike extends MyModule {

	private static ArrayList<Packet> packets = new ArrayList<Packet>();
	private EntityOtherPlayerMP fakethePlayer = null;
	private double oldX;
	private double oldY;
	private double oldZ;
	private static long blinkTime;
	private static long lastTime;
	
	public FakeLagSpike() {
		super("LagSpike", Keyboard.KEY_NONE, Category.PLAYER, null);
	}

	
	public void onEvent(Event e) {
		
		if(e instanceof EventUpdate) {
				mc.thePlayer.fallDistance = 0;
				mc.thePlayer.onGround = true;
			}}
	
	public void onEnable() {
		lastTime = System.currentTimeMillis();
		
		oldX = mc.thePlayer.posX;
		oldY = mc.thePlayer.posY;
		oldZ = mc.thePlayer.posZ;
		fakethePlayer =
			new EntityOtherPlayerMP(mc.theWorld, mc.thePlayer.getGameProfile());
		fakethePlayer.clonePlayer(mc.thePlayer, true);
		fakethePlayer.copyLocationAndAnglesFrom(mc.thePlayer);
		fakethePlayer.rotationYawHead = mc.thePlayer.rotationYawHead;
		mc.theWorld.addEntityToWorld(-69, fakethePlayer);
	}
	
	public void onDisable() {
		for(Packet packet : packets)
			//mc.thePlayer.sendPacket(packet);
		packets.clear();
		mc.theWorld.removeEntityFromWorld(-69);
		fakethePlayer = null;
		blinkTime = 0;
	}
	
	public void addToBlinkQueue(Packet packet)
	{
		if(mc.thePlayer.posX != mc.thePlayer.prevPosX
			|| mc.thePlayer.posZ != mc.thePlayer.prevPosZ
			|| mc.thePlayer.posY != mc.thePlayer.prevPosY)
		{
			blinkTime += System.currentTimeMillis() - lastTime;
			packets.add(packet);
		}
		lastTime = System.currentTimeMillis();
	}
	
	public void cancel()
	{
		packets.clear();
		mc.thePlayer.setPositionAndRotation(oldX, oldY, oldZ,
			mc.thePlayer.rotationYaw, mc.thePlayer.rotationPitch);
		this.setToggleFalse();
	}
	
	
}	
	
