package com.stormrunner.supramod;

import java.util.function.Supplier;

import com.stormrunner.supramod.blocks.BlockInit;
import com.stormrunner.supramod.entities.EntityInit;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.entity.SpriteRenderer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(SupraMod.MODID)
public class SupraMod {

	public static final String MODID = "supramod";
	
	public SupraMod() {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		
		bus.addListener(this::setup);
		bus.addListener(this::clientSetup);
		// register inits
		ItemInit.ITEMS.register(bus);
		BlockInit.BLOCKS.register(bus);
		EntityInit.ENTITIES.register(bus);
		
		MinecraftForge.EVENT_BUS.register(this);
	}
	
	private void setup(final FMLCommonSetupEvent event) {
		
	}
	
	private void clientSetup(final FMLClientSetupEvent event) {
		registerEntityModels(event.getMinecraftSupplier());
	}
	
	private void registerEntityModels(Supplier<Minecraft> minecraft) {
		ItemRenderer renderer = minecraft.get().getItemRenderer();
		
		RenderingRegistry.registerEntityRenderingHandler(EntityInit.GUN_BLAST.get(), (renderManager) -> new SpriteRenderer<>(renderManager, renderer));
	}
}
