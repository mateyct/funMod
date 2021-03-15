package com.stormrunner.supramod;

import com.stormrunner.supramod.items.CustomItemTier;

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
	
	
}
