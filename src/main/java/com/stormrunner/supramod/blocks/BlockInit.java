package com.stormrunner.supramod.blocks;

import com.stormrunner.supramod.SupraMod;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit {
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, SupraMod.MODID);
	
	public static final RegistryObject<Block> RED_MOON_BLOCK = BLOCKS.register("red_moon_ore",
			() -> new Block(AbstractBlock.Properties.create(Material.IRON, MaterialColor.BLUE)
					.hardnessAndResistance(10, 20).harvestTool(ToolType.PICKAXE).harvestLevel(2).sound(SoundType.METAL)));
}
