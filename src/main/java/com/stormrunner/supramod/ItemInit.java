package com.stormrunner.supramod;

import com.stormrunner.supramod.blocks.BlockInit;
import com.stormrunner.supramod.items.CustomItemTier;
import com.stormrunner.supramod.items.Supragun;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.BowItem;
import net.minecraft.item.Item;
import net.minecraft.item.Item.Properties;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SwordItem;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {
	
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SupraMod.MODID);
	
	public static final RegistryObject<Item> woodenSword = ITEMS.register("wooden_sword", 
			() -> new SwordItem(new CustomItemTier(1000000, 10, 5, 1, 30, null), 5, 1.25f, 
			new SwordItem.Properties().group(ItemGroup.COMBAT)));
	
	public static final RegistryObject<Item> RED_MOON = ITEMS.register("red_moon", 
			() -> new Item(new Item.Properties().group(ItemGroup.MATERIALS)));
	
	public static final RegistryObject<Supragun> SUPRAGUN = ITEMS.register("supragun", 
			() -> new Supragun(new Item.Properties().group(ItemGroup.COMBAT)));
	
	public static final RegistryObject<Item> GUN_BLAST = ITEMS.register("gun_blast", 
			() -> new Item(new Item.Properties()));
	
	//////////BlockItems//////////////////////

	public static final RegistryObject<BlockItem> RED_MOON_BLOCK = ITEMS.register("red_moon_ore",
			() -> new BlockItem(BlockInit.RED_MOON_BLOCK.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));
	
	
}
