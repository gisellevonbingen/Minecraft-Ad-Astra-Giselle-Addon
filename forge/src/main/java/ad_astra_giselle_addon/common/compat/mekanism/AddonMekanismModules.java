package ad_astra_giselle_addon.common.compat.mekanism;

import ad_astra_giselle_addon.common.AdAstraGiselleAddon;
import ad_astra_giselle_addon.common.compat.mekanism.gear.ModuleSpaceBreathingUnit;
import ad_astra_giselle_addon.common.compat.mekanism.gear.ModuleSpaceFireProofUnit;
import ad_astra_giselle_addon.common.compat.mekanism.gear.ModuleVenusAcidProofUnit;
import mekanism.common.registration.impl.ModuleDeferredRegister;
import mekanism.common.registration.impl.ModuleRegistryObject;
import net.minecraft.world.item.Rarity;

public class AddonMekanismModules
{
	public static final ModuleDeferredRegister MODULES = new ModuleDeferredRegister(AdAstraGiselleAddon.MOD_ID);

	public static final ModuleRegistryObject<ModuleSpaceBreathingUnit> SPACE_BREATHING_UNIT = MODULES.register("space_breathing_unit", ModuleSpaceBreathingUnit::new, () -> AddonMekanismItems.SPACE_BREATHING_UNIT.get(), m -> m.rarity(Rarity.UNCOMMON).maxStackSize(4).rendersHUD());
	public static final ModuleRegistryObject<ModuleSpaceFireProofUnit> SPACE_FIRE_PROOF_UNIT = MODULES.register("space_fire_proof_unit", ModuleSpaceFireProofUnit::new, () -> AddonMekanismItems.SPACE_FIRE_PROOF_UNIT.get(), m -> m.rarity(Rarity.RARE));
	public static final ModuleRegistryObject<ModuleVenusAcidProofUnit> ACID_RAIN_PROOF_UNIT = MODULES.register("acid_rain_proof_unit", ModuleVenusAcidProofUnit::new, () -> AddonMekanismItems.ACID_RAIN_PROOF_UNIT.get(), m -> m.rarity(Rarity.RARE));

	private AddonMekanismModules()
	{

	}

}
