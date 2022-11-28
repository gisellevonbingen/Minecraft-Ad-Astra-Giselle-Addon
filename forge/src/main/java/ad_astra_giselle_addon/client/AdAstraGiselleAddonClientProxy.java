package ad_astra_giselle_addon.client;

import ad_astra_giselle_addon.client.overlay.OxygenCanOverlay;
import ad_astra_giselle_addon.client.renderer.blockentity.FuelLoaderRenderer;
import ad_astra_giselle_addon.client.screens.FuelLoaderScreen;
import ad_astra_giselle_addon.client.util.RenderHelper;
import ad_astra_giselle_addon.common.registries.AddonBlockEntityTypes;
import ad_astra_giselle_addon.common.registries.AddonMenuTypes;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterGuiOverlaysEvent;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class AdAstraGiselleAddonClientProxy
{
	public AdAstraGiselleAddonClientProxy()
	{
		this.registerFML();
		this.registerForge();
	}

	public void registerFML()
	{
		IEventBus fml_bus = FMLJavaModLoadingContext.get().getModEventBus();
		fml_bus.addListener(this::onAtlasPreStitch);
		fml_bus.addListener(this::onRegisterRenderers);
		fml_bus.addListener(this::registerMenuType);
		fml_bus.addListener(this::onRegisterGuiOverlay);
	}

	public void registerForge()
	{
		IEventBus forge_bus = MinecraftForge.EVENT_BUS;
		forge_bus.register(EventListenerEnchantmentTooltip.class);
	}

	public void onRegisterRenderers(EntityRenderersEvent.RegisterRenderers event)
	{
		event.registerBlockEntityRenderer(AddonBlockEntityTypes.FUEL_LOADER.get(), FuelLoaderRenderer::new);
	}

	public void registerMenuType(FMLClientSetupEvent event)
	{
		MenuScreens.register(AddonMenuTypes.FUEL_LOADER.get(), FuelLoaderScreen::new);
	}

	public void onRegisterGuiOverlay(RegisterGuiOverlaysEvent event)
	{
		event.registerBelowAll("oxygen_can", new OxygenCanOverlay());
	}

	public void onAtlasPreStitch(TextureStitchEvent.Pre event)
	{
		event.addSprite(RenderHelper.TILE_SURFACE);
	}

}