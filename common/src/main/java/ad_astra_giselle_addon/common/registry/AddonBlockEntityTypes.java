package ad_astra_giselle_addon.common.registry;

import ad_astra_giselle_addon.common.AdAstraGiselleAddon;
import ad_astra_giselle_addon.common.block.entity.AutomationNasaWorkbenchBlockEntity;
import ad_astra_giselle_addon.common.block.entity.FuelLoaderBlockEntity;

public class AddonBlockEntityTypes
{
	public static final BlockEntityTypeRegistryCollection BLOCK_ENTITY_TYPES = new BlockEntityTypeRegistryCollection(AdAstraGiselleAddon.MOD_ID);
	public static final BlockEntityTypeRegistryHolder<FuelLoaderBlockEntity> FUEL_LOADER = BLOCK_ENTITY_TYPES.add("fuel_loader", AddonBlocks.FUEL_LOADER, FuelLoaderBlockEntity::new);
	public static final BlockEntityTypeRegistryHolder<AutomationNasaWorkbenchBlockEntity> AUTOMATION_NASA_WORKBENCH = BLOCK_ENTITY_TYPES.add("automation_nasa_workbench", AddonBlocks.AUTOMATION_NASA_WORKBENCH, AutomationNasaWorkbenchBlockEntity::new);

	private AddonBlockEntityTypes()
	{

	}

}
