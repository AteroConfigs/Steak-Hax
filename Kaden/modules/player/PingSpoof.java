package Kaden.modules.player;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.lwjgl.input.Keyboard;

import Kaden.events.Event;
import Kaden.events.listeners.EventMotion;
import Kaden.events.listeners.EventPacket;
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
import net.minecraft.network.play.client.C00PacketKeepAlive;
import net.minecraft.network.play.client.C01PacketChatMessage;
import net.minecraft.network.play.client.C02PacketUseEntity;
import net.minecraft.network.play.client.C02PacketUseEntity.Action;
import net.minecraft.network.play.client.C0APacketAnimation;
import net.minecraft.network.play.client.C0BPacketEntityAction;

public class PingSpoof extends MyModule {

	
	public PingSpoof() {
		super("PingSpoof", Keyboard.KEY_P, Category.PLAYER, null);
	}
	
public static void Start() {

}

public void onEvent(Event e) {
	
	if(e instanceof EventPacket) {
		if(((EventPacket) e).getPacket() instanceof C00PacketKeepAlive) {
			e.setCancelled(true);
			//mc.theWorld.pi
			
}}}



}
