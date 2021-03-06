package Kaden.command.impl;

import Kaden.Client;
import Kaden.command.Command;
import Kaden.command.CommandManager;
import Kaden.modules.MyModule;
import net.minecraft.client.Minecraft;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

public class KillPot extends Command {

	public KillPot() {
		super("KillPot", "Makes a kill pot that can kill everbody, (Credit: WURST Client).", "killpot", "kp");
	}
	


	@Override
	public void onCommand(String[] args, String command) {	

		// check gamemode
		if(!Minecraft.getMinecraft().thePlayer.capabilities.isCreativeMode)
		{
			Client.addChatMessage("Creative mode only.");
			return;
		}
		
		// generate potion
		ItemStack stack = new ItemStack(Items.potionitem);
		stack.setItemDamage(16384);
		NBTTagCompound effect = new NBTTagCompound();
		effect.setInteger("Amplifier", 125);
		effect.setInteger("Duration", 2000);
		effect.setInteger("Id", 6);
		NBTTagList effects = new NBTTagList();
		effects.appendTag(effect);
		stack.setTagInfo("CustomPotionEffects", effects);
		stack.setStackDisplayName("§rSplash Potion of §4§lDEATH");
		
		// give potion
		if(Minecraft.getMinecraft().thePlayer.inventory.addItemStackToInventory(stack))
			Client.addChatMessage("Potion created.");
		else
			Client.addChatMessage("Please clear a slot in your hotbar.");
		
		
}
		
	
	
}

