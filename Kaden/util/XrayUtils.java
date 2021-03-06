package Kaden.util;

import Kaden.modules.render.Xray;
import net.minecraft.block.Block;

public class XrayUtils {

	public static void initXRayBlocks() {
		Xray.XrayBlocks.add(Block.getBlockFromName("coal_ore"));
		Xray.XrayBlocks.add(Block.getBlockFromName("iron_ore"));
		Xray.XrayBlocks.add(Block.getBlockFromName("gold_ore"));
		Xray.XrayBlocks.add(Block.getBlockFromName("redstone_ore"));
		Xray.XrayBlocks.add(Block.getBlockById(74));
		Xray.XrayBlocks.add(Block.getBlockFromName("lapis_ore"));
		Xray.XrayBlocks.add(Block.getBlockFromName("diamond_ore"));
		Xray.XrayBlocks.add(Block.getBlockFromName("emerald_ore"));
		Xray.XrayBlocks.add(Block.getBlockFromName("quartz_ore"));
		Xray.XrayBlocks.add(Block.getBlockFromName("clay"));
		Xray.XrayBlocks.add(Block.getBlockFromName("glowstone"));
		Xray.XrayBlocks.add(Block.getBlockById(8));
		Xray.XrayBlocks.add(Block.getBlockById(9));
		Xray.XrayBlocks.add(Block.getBlockById(10));
		Xray.XrayBlocks.add(Block.getBlockById(11));
		Xray.XrayBlocks.add(Block.getBlockFromName("crafting_table"));
		Xray.XrayBlocks.add(Block.getBlockById(61));
		Xray.XrayBlocks.add(Block.getBlockById(62));
		Xray.XrayBlocks.add(Block.getBlockFromName("torch"));
		Xray.XrayBlocks.add(Block.getBlockFromName("ladder"));
		Xray.XrayBlocks.add(Block.getBlockFromName("tnt"));
		Xray.XrayBlocks.add(Block.getBlockFromName("coal_block"));
		Xray.XrayBlocks.add(Block.getBlockFromName("iron_block"));
		Xray.XrayBlocks.add(Block.getBlockFromName("gold_block"));
		Xray.XrayBlocks.add(Block.getBlockFromName("diamond_block"));
		Xray.XrayBlocks.add(Block.getBlockFromName("emerald_block"));
		Xray.XrayBlocks.add(Block.getBlockFromName("redstone_block"));
		Xray.XrayBlocks.add(Block.getBlockFromName("lapis_block"));
		Xray.XrayBlocks.add(Block.getBlockFromName("fire"));
		Xray.XrayBlocks.add(Block.getBlockFromName("mossy_cobblestone"));
		Xray.XrayBlocks.add(Block.getBlockFromName("mob_spawner"));
		Xray.XrayBlocks.add(Block.getBlockFromName("end_portal_frame"));
		Xray.XrayBlocks.add(Block.getBlockFromName("enchanting_table"));
		Xray.XrayBlocks.add(Block.getBlockFromName("bookshelf"));
		Xray.XrayBlocks.add(Block.getBlockFromName("command_block"));
	}
	
	public static boolean isXrayBlock(Block b) {
		if(Xray.XrayBlocks.contains(b))
			return true;

			return false;
	}
}
