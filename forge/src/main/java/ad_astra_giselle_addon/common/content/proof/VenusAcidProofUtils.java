package ad_astra_giselle_addon.common.content.proof;

import ad_astra_giselle_addon.common.AdAstraGiselleAddon;
import ad_astra_giselle_addon.common.registries.AddonEnchantments;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class VenusAcidProofUtils extends ProofAbstractUtils
{
	public static final String NBT_KEY = AdAstraGiselleAddon.rl("venus_acid_proof").toString();
	public static final VenusAcidProofUtils INSTANCE = new VenusAcidProofUtils();

	private VenusAcidProofUtils()
	{

	}

	@Override
	public String getNBTKey()
	{
		return NBT_KEY;
	}

	@Override
	public LivingProofEvent createEvent(LivingEntity entity)
	{
		return new LivingVenusAcidProofEvent(entity);
	}

	@SubscribeEvent
	public void onProofEnchantment(LivingVenusAcidProofEvent e)
	{
		LivingEntity entity = e.getEntity();
		ProofSession session = new VenusAcidProofEnchantmentSession(entity, AddonEnchantments.VENUS_ACID_PROOF.get());
		e.setProofDuration(session.provide());
	}

}