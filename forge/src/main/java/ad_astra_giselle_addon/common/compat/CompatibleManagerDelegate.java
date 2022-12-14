package ad_astra_giselle_addon.common.compat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ad_astra_giselle_addon.common.compat.curios.CuriosCompat;
import ad_astra_giselle_addon.common.compat.mekanism.MekanismCompat;
import ad_astra_giselle_addon.common.compat.pneumaticcraft.PneumaticCraftCompat;
import ad_astra_giselle_addon.common.compat.redstonearsenal.RedstoneArsenalCompat;

public class CompatibleManagerDelegate implements CompatibleManager.Delegate
{
	public static final List<CompatibleMod> MODS;
	public static final CuriosCompat CURIOS;
	public static final MekanismCompat MEKANISM;
	public static final PneumaticCraftCompat PNEUMATICCRAFT;
	public static final RedstoneArsenalCompat REDSTONE_ARSENAL;

	static
	{
		List<CompatibleMod> mods = new ArrayList<>();
		mods.add(CURIOS = new CuriosCompat());
		mods.add(MEKANISM = new MekanismCompat());
		mods.add(PNEUMATICCRAFT = new PneumaticCraftCompat());
		mods.add(REDSTONE_ARSENAL = new RedstoneArsenalCompat());

		MODS = Collections.unmodifiableList(mods);
	}

	@Override
	public List<CompatibleMod> getMods()
	{
		return MODS;
	}

}
