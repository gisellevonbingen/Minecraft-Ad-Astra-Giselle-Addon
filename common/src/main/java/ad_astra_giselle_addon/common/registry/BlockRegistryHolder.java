package ad_astra_giselle_addon.common.registry;

import java.util.function.Supplier;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;

public class BlockRegistryHolder<B extends Block, I extends BlockItem> extends DoubleRegistryHolder<B, I> implements Supplier<B>, ItemLike
{
	public BlockRegistryHolder(ObjectRegistryHolder<? extends B> b, ObjectRegistryHolder<? extends I> i)
	{
		super(b, i);
	}

	public B asBlock()
	{
		return this.getPrimary();
	}

	@Override
	public B get()
	{
		return this.asBlock();
	}

	@Override
	public I asItem()
	{
		return this.getSecondary();
	}

}
