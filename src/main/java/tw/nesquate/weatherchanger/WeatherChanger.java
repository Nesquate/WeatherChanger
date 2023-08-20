package tw.nesquate.weatherchanger;

import eu.pb4.polymer.resourcepack.api.PolymerResourcePackUtils;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tw.nesquate.weatherchanger.item.CallClearItem;
import tw.nesquate.weatherchanger.item.CallRainItem;
import tw.nesquate.weatherchanger.item.CallThunderItem;

public class WeatherChanger implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger("WeatherChanger");
	public static final CallRainItem CALL_RAIN_ITEM  = new CallRainItem(new FabricItemSettings(), Items.PAPER);
	public static final CallThunderItem CALL_THUNDER_ITEM = new CallThunderItem(new FabricItemSettings(), Items.PAPER);
	public static final CallClearItem CALL_CLEAR_ITEM = new CallClearItem(new FabricItemSettings(), Items.PAPER);
	public static final String MOD_ID = "weatherchanger";

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Starting...");

		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "call_rain_item"), CALL_RAIN_ITEM);
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "call_thunder_item"), CALL_THUNDER_ITEM);
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "call_clear_item"), CALL_CLEAR_ITEM);

		if(FabricLoader.getInstance().getEnvironmentType() == EnvType.SERVER){
			PolymerResourcePackUtils.addModAssets(MOD_ID);
		}

	}
}