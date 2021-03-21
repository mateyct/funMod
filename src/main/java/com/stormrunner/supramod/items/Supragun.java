package com.stormrunner.supramod.items;

import java.util.List;
import java.util.function.Predicate;

import org.lwjgl.glfw.GLFW;

import com.stormrunner.supramod.ItemInit;
import com.stormrunner.supramod.entities.GunBlast;

import net.minecraft.client.Minecraft;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.client.util.InputMappings;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BowItem;
import net.minecraft.item.Item;
import net.minecraft.item.Item.Properties;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.ShootableItem;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class Supragun extends Item {

	public Supragun(Properties properties) {
		super(properties);
		// TODO Auto-generated constructor stub
		properties.maxStackSize(1);
	}

	@Override
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		// TODO Auto-generated method stub
		super.addInformation(stack, worldIn, tooltip, flagIn);
		
		if(InputMappings.isKeyDown(Minecraft.getInstance().getMainWindow().getHandle(), GLFW.GLFW_KEY_LEFT_SHIFT)) {
			tooltip.add(new StringTextComponent("A gun that hurts enemies and activates certain buttons."));
		}
		else {
			// Hold " + "\u00A71" + "Shift " + "\u00A77" + "for info.
			tooltip.add(new TranslationTextComponent("tooltip.supramod.special_item.hold_shift"));
		}
	}
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		ItemStack stack = playerIn.getHeldItem(handIn);
		if(!worldIn.isRemote) {
			if(!playerIn.getCooldownTracker().hasCooldown(this)) {
				GunBlast blast = new GunBlast(playerIn, worldIn);
				blast.setItem(new ItemStack(ItemInit.GUN_BLAST.get()));
				blast.shoot(playerIn.getForward().x, playerIn.getForward().y, playerIn.getForward().z, .75f, 0f);
				//blast.setPosition(playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ());
				worldIn.addEntity(blast);
				playerIn.getCooldownTracker().setCooldown(this, 5);
				return ActionResult.resultSuccess(stack);
			}
			else {
				return ActionResult.resultFail(stack);
			}
		}
		return ActionResult.resultSuccess(stack);
	}
}
