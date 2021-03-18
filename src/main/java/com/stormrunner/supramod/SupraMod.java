package com.stormrunner.supramod;

import com.stormrunner.supramod.blocks.BlockInit;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(SupraMod.MODID)
public class SupraMod {

	public static final String MODID = "supramod";
	
	public SupraMod() {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		
		bus.addListener(this::setup);
		
		ItemInit.ITEMS.register(bus);
		
		BlockInit.BLOCKS.register(bus);
		
		MinecraftForge.EVENT_BUS.register(this);
	}
	
	private void setup(final FMLCommonSetupEvent event) {
		
	}
}
