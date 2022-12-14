package ad_astra_giselle_addon.common.block;

import ad_astra_giselle_addon.common.block.entity.FuelLoaderBlockEntity;
import earth.terrarium.ad_astra.common.block.machine.AbstractMachineBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class FuelLoaderBlock extends AbstractMachineBlock
{
	public FuelLoaderBlock(BlockBehaviour.Properties properties)
	{
		super(properties.strength(3.0F));
	}

	@Override
	public FuelLoaderBlockEntity newBlockEntity(BlockPos pos, BlockState state)
	{
		return new FuelLoaderBlockEntity(pos, state);
	}

}
