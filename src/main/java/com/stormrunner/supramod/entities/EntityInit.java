package com.stormrunner.supramod.entities;

import com.stormrunner.supramod.SupraMod;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class EntityInit {
	
	public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, SupraMod.MODID);

	public static final RegistryObject<EntityType<GunBlast>> GUN_BLAST = ENTITIES.register("gun_blast", 
			() -> EntityType.Builder.<GunBlast>create(GunBlast::new, EntityClassification.MISC)
			.size(.025f, .25f).build("gun_blast"));
}
