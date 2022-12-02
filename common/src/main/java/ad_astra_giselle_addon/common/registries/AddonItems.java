package ad_astra_giselle_addon.common.registries;

import ad_astra_giselle_addon.common.AdAstraGiselleAddon;
import ad_astra_giselle_addon.common.item.OxygenCanItem;
import net.minecraft.world.item.Item;

public class AddonItems
{
	public static final DelegateItemCollection ITEMS = new DelegateItemCollection(AdAstraGiselleAddon.MOD_ID);
	public static final DelegateObjectHolder<OxygenCanItem> OXYGEN_CAN = ITEMS.register("oxygen_can", () -> new OxygenCanItem(new Item.Properties().tab(AddonTabs.tab_main)));

	public static Item.Properties getMainItemProperties()
	{
		return new Item.Properties().tab(AddonTabs.tab_main);
	}

	private AddonItems()
	{

	}

}