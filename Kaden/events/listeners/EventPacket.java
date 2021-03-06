package Kaden.events.listeners;

import Kaden.events.Event;
import net.minecraft.network.Packet;

public class EventPacket extends Event<EventPacket>{


	public Packet packet;
	
	public EventPacket(Packet packet) {
		super();
		this.packet = packet;

	}

	public Packet getPacket() {
		return packet;
	}

	public void setPacket(Packet packet) {
		this.packet = packet;
	}

	
	
}
