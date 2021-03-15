package com.stormrunner.supramod.items;

import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;

public class CustomItemTier implements IItemTier {

	private int maxUses;
	private float efficiency;
	private float attackDamage;
	private int harvestLevel;
	private int enchantability;
	private Ingredient repairIngredient;
	
	public CustomItemTier(int maxUses, float efficiency, float attackDamage, int harvestLevel, int enchantability, Ingredient repairIngredient) {
		this.maxUses = maxUses;
		this.efficiency = efficiency;
		this.attackDamage = attackDamage;
		this.harvestLevel = harvestLevel;
		this.enchantability = enchantability;
		this.repairIngredient = repairIngredient;
	}
	
	@Override
	public int getMaxUses() {
		// TODO Auto-generated method stub
		return maxUses;
	}

	@Override
	public float getEfficiency() {
		// TODO Auto-generated method stub
		return efficiency;
	}

	@Override
	public float getAttackDamage() {
		// TODO Auto-generated method stub
		return attackDamage;
	}

	@Override
	public int getHarvestLevel() {
		// TODO Auto-generated method stub
		return harvestLevel;
	}

	@Override
	public int getEnchantability() {
		// TODO Auto-generated method stub
		return enchantability;
	}

	@Override
	public Ingredient getRepairMaterial() {
		// TODO Auto-generated method stub
		return repairIngredient;
	}

}
