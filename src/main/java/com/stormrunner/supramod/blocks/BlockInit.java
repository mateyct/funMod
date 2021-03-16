package com.stormrunner.supramod.blocks;

import com.stormrunner.supramod.SupraMod;

import net.minecraft.block.Block;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit {
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, SupraMod.MODID);
	
	//public static final RegistryObject<Block> RED_MOON_BLOCK = BLOCKS.register("red_moon_block", () -> new Block(new Block.Properties()));
}
