package ad_astra_giselle_addon.client.screens;

import java.awt.Rectangle;

import com.mojang.blaze3d.vertex.PoseStack;

import ad_astra_giselle_addon.common.AdAstraGiselleAddon;
import ad_astra_giselle_addon.common.block.entity.FuelLoaderBlockEntity;
import ad_astra_giselle_addon.common.compat.CompatibleManager;
import ad_astra_giselle_addon.common.menu.FuelLoaderMenu;
import ad_astra_giselle_addon.common.network.AddonNetwork;
import ad_astra_giselle_addon.common.network.FuelLoaderMessageWorkingAreaVisible;
import earth.terrarium.ad_astra.client.screens.GuiUtil;
import earth.terrarium.botarium.api.fluid.FluidHolder;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.phys.AABB;

public class FuelLoaderScreen extends AddonMachineScreen<FuelLoaderBlockEntity, FuelLoaderMenu>
{
	public static final ResourceLocation TEXTURE = AdAstraGiselleAddon.rl("textures/gui/container/fuel_loader.png");

	public static final int TANK_LEFT = 68;
	public static final int TANK_TOP = 28;

	public FuelLoaderScreen(FuelLoaderMenu menu, Inventory inventory, Component title)
	{
		super(menu, inventory, title, TEXTURE);
		this.imageWidth = 176;
		this.imageHeight = 182;
		this.inventoryLabelY = this.imageHeight - 94;
	}

	@Override
	public boolean hasWorkingArea()
	{
		return true;
	}

	@Override
	public boolean isWorkingAreaVisible()
	{
		return this.getMenu().getMachine().isWorkingAreaVisible();
	}

	@Override
	public AABB getWorkingArea()
	{
		return this.getMenu().getMachine().getWorkingArea();
	}

	@Override
	public void setWorkingAreaVisible(boolean visible)
	{
		super.setWorkingAreaVisible(visible);
		AddonNetwork.sendToServer(new FuelLoaderMessageWorkingAreaVisible(this.getMenu().getMachine(), visible));
	}

	@Override
	protected void renderBg(PoseStack stack, float partialTicks, int mouseX, int mouseY)
	{
		super.renderBg(stack, partialTicks, mouseX, mouseY);
		int tank = 0;
		FluidHolder fluid = this.getMenu().getFluids().get(tank);
		long capacity = this.getMenu().getMachine().getFluidContainer().getTankCapacity(tank);
		Rectangle bounds = this.getFluidTankBounds();
		GuiUtil.drawFluidTank(stack, this.leftPos + bounds.x, this.topPos + bounds.y, capacity, fluid);
	}

	@Override
	public void render(PoseStack stack, int mouseX, int mouseY, float delta)
	{
		super.render(stack, mouseX, mouseY, delta);

		if (GuiUtil.isHovering(this.getFluidTankBounds(), mouseX - this.leftPos, mouseY - this.topPos))
		{
			if (!CompatibleManager.JEI.isLoaded())
			{
				int tank = 0;
				FluidHolder fluid = this.getMenu().getFluids().get(tank);
				long capacity = this.getMenu().getMachine().getFluidContainer().getTankCapacity(tank);
				GuiUtil.drawTankTooltip(this, stack, fluid, capacity, mouseX, mouseY);
			}

		}

	}

	public Rectangle getFluidTankBounds()
	{
		return GuiUtil.getFluidTankBounds(TANK_LEFT, TANK_TOP);
	}

}