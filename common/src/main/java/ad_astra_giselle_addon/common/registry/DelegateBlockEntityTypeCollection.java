package ad_astra_giselle_addon.common.registry;

import net.minecraft.core.Registry;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class DelegateBlockEntityTypeCollection extends ObjectRegistryCollection<BlockEntityType<?>>
{
	public DelegateBlockEntityTypeCollection(String modid)
	{
		super(modid, Registry.BLOCK_ENTITY_TYPE_REGISTRY);
	}

	public <T extends BlockEntity> ObjectRegistryHolder<BlockEntityType<T>> add(String name, DelegateBlockHolder<?, ?> block, BlockEntityType.BlockEntitySupplier<T> blockEntitySupplier)
	{
		return this.add(name, () -> BlockEntityType.Builder.of(blockEntitySupplier, block.get()).build(null));
	}

}