package ad_astra_giselle_addon.common.content.proof;

import ad_astra_giselle_addon.common.config.EnchantmentsConfig;
import ad_astra_giselle_addon.common.enchantment.EnchantmentEnergyStorageOrDamageable;
import ad_astra_giselle_addon.common.item.ItemUsableResource;
import net.minecraft.world.entity.LivingEntity;

public class AcidRainProofEnchantmentSession extends ProofEnchantmentSession
{
	public AcidRainProofEnchantmentSession(LivingEntity entity, EnchantmentEnergyStorageOrDamageable enchantment)
	{
		super(entity, enchantment);
	}

	@Override
	public long getResourceUsingAmount(ItemUsableResource resource)
	{
		if (resource == ItemUsableResource.Energy)
		{
			return EnchantmentsConfig.ACID_RAIN_PROOF_ENERGY_USING;
		}
		else if (resource == ItemUsableResource.Durability)
		{
			return EnchantmentsConfig.ACID_RAIN_PROOF_DURABILITY_USING;
		}
		else
		{
			return 0;
		}

	}

	@Override
	public int getProofDuration(ItemUsableResource resource)
	{
		if (resource == ItemUsableResource.Energy)
		{
			return ProofAbstractUtils.GENERAL_PROOF_INTERVAL;
		}
		else if (resource == ItemUsableResource.Durability)
		{
			return EnchantmentsConfig.ACID_RAIN_PROOF_DURABILITY_DURATION;
		}
		else
		{
			return 0;
		}

	}

}
