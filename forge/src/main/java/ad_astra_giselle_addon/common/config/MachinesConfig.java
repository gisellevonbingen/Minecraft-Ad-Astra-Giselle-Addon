package ad_astra_giselle_addon.common.config;

import com.teamresourceful.resourcefulconfig.common.annotations.Category;
import com.teamresourceful.resourcefulconfig.common.annotations.Comment;
import com.teamresourceful.resourcefulconfig.common.annotations.ConfigEntry;
import com.teamresourceful.resourcefulconfig.common.annotations.IntRange;
import com.teamresourceful.resourcefulconfig.common.annotations.LongRange;
import com.teamresourceful.resourcefulconfig.common.config.EntryType;

import earth.terrarium.botarium.api.fluid.FluidHooks;

@Category(id = MachinesConfig.ID, translation = MachinesConfig.PREFIX)
public final class MachinesConfig
{
	public static final String ID = "machines";
	public static final String PREFIX = AddonConfigs.PREFIX + "." + ID;

	public static final String FUEL_LOADER_ID = "fuel_loader";
	public static final String FUEL_LOADER_PREFIX = PREFIX + "." + FUEL_LOADER_ID;
	@ConfigEntry(id = FUEL_LOADER_ID + ".fluid_capacity", type = EntryType.LONG, translation = FUEL_LOADER_PREFIX + ".fluid_capacity")
	@LongRange(min = 0, max = Long.MAX_VALUE)
	public static long FUEL_LOADER_FLUID_CAPACITY = FluidHooks.buckets(8);
	@ConfigEntry(id = FUEL_LOADER_ID + ".fluid_transfer", type = EntryType.LONG, translation = FUEL_LOADER_PREFIX + ".fluid_transfer")
	@LongRange(min = 0, max = Long.MAX_VALUE)
	public static long FUEL_LOADER_FLUID_TRANSFER = FluidHooks.toMillibuckets(256);
	@ConfigEntry(id = FUEL_LOADER_ID + ".working_range", type = EntryType.INTEGER, translation = FUEL_LOADER_PREFIX + ".working_range")
	@IntRange(min = 0, max = Integer.MAX_VALUE)
	@Comment("Blocks from FuelLoader to each direction")
	public static int FUEL_LOADER_WORKING_RANGE = 2;
}
