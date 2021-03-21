package com.stormrunner.supramod.entities;

import com.stormrunner.supramod.ItemInit;
import com.stormrunner.supramod.items.Supragun;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ProjectileItemEntity;
import net.minecraft.item.Item;
import net.minecraft.network.IPacket;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.Explosion.Mode;
import net.minecraft.world.World;
import net.minecraftforge.common.extensions.IForgeBlock;
import net.minecraftforge.fml.network.NetworkHooks;

public class GunBlast extends ProjectileItemEntity {

	public GunBlast(EntityType<GunBlast> type, World world) {
		super(type, world);
		super.setNoGravity(true);
	}
	
	public GunBlast(LivingEntity entity, World world) {
		super(EntityInit.GUN_BLAST.get(), entity, world);
		super.setNoGravity(true);
	}
	
	public GunBlast(double x, double y, double z, World world) {
		super(EntityInit.GUN_BLAST.get(), x, y, x, world);
		super.setNoGravity(true);
	}

	@Override
	protected Item getDefaultItem() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public IPacket<?> createSpawnPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}
	
	@Override
	protected void onImpact(RayTraceResult result) {
		if(result.getType() == RayTraceResult.Type.ENTITY) {
			Entity entity = ((EntityRayTraceResult)result).getEntity();
			int damage = 0;
			if(entity instanceof LivingEntity) {
				damage = 5;
			}
			else {
				damage = 0;
			}
			entity.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getControllingPassenger()), (float)damage);
		}
		world.createExplosion(this, this.getPosX(), this.getPosY(), this.getPosZ(), 20, Mode.DESTROY);
		
		
		if(!world.isRemote) {
			this.remove();
		}
	}
	
}
