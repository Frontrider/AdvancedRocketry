package zmaster587.advancedRocketry.api;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import net.minecraft.init.Biomes;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;
import zmaster587.advancedRocketry.world.biome.*;

import static zmaster587.advancedRocketry.api.Configuration.config;


/**
 * Stores information relating to the biomes and biome registry of AdvancedRocketry
 */
@Mod.EventBusSubscriber
public class AdvancedRocketryBiomes {

	private static final String BIOMECATETORY = "Biomes";


	public static final AdvancedRocketryBiomes instance = new AdvancedRocketryBiomes();
	private List<Biome> registeredBiomes;
	private List<Biome> registeredHighPressureBiomes;
	private List<Biome> registeredSingleBiome;
	private static List<Integer> blackListedBiomeIds;

	public static Biome moonBiome;
	public static BiomeBase moonHills;
	public static BiomeBase moonHillsM;
	public static Biome hotDryBiome;
	public static Biome alienForest;
	public static Biome spaceBiome;
	public static Biome stormLandsBiome;
	public static Biome crystalChasms;
	public static Biome swampDeepBiome;
	public static Biome marsh;
	public static Biome oceanSpires;

	public static Biome frozenOcean;

	private AdvancedRocketryBiomes() {
		registeredBiomes = new ArrayList<Biome>();
		registeredHighPressureBiomes = new LinkedList<Biome>();
		blackListedBiomeIds = new ArrayList<Integer>();
		registeredSingleBiome = new ArrayList<Biome>();
	}

	/**
	 * TODO: support id's higher than 255.  
	 * Any biome registered through vanilla forge does not need to be registered here
	 * @param biome Biome to register with AdvancedRocketry's Biome registry
	 * @param iForgeRegistry 
	 */
	public void registerBiome(Biome biome, IForgeRegistry<Biome> iForgeRegistry) {
		registeredBiomes.add(biome);
		iForgeRegistry.register(biome);
	}


	/**
	 * Registers biomes you don't want to spawn on any planet unless registered with highpressure or similar feature
	 */
	public void registerBlackListBiome(Biome biome) {
		blackListedBiomeIds.add(Biome.getIdForBiome(biome));
	}

	/**
	 * Gets a list of the blacklisted Biome Ids
	 */
	public List<Integer> getBlackListedBiomes() {
		return blackListedBiomeIds;
	}

	/**
	 * Registers a biome as high pressure for use with the planet generators (It will only spawn on planets with high pressure)
	 * @param biome
	 */
	public void registerHighPressureBiome(Biome biome) {
		registeredHighPressureBiomes.add(biome);
		registerBlackListBiome(biome);
	}

	public List<Biome> getHighPressureBiomes() {
		return registeredHighPressureBiomes;	
	}

	/**
	 * Registers a biome to have a chance to spawn as the only biome on a planet, will not register the biome if it is in the blacklist already
	 * @param biome
	 */
	public void registerSingleBiome(Biome biome) {
		if(!blackListedBiomeIds.contains(Biome.getIdForBiome(biome)))
			registeredSingleBiome.add(biome);
	}
	
	public void blackListVanillaBiomes() {
		//Good grief... this is long, better than making users do it though..
		for(int i = 0; i < 40; i++)
			blackListedBiomeIds.add(i);
		
		blackListedBiomeIds.add(127);
		blackListedBiomeIds.add(129);
		blackListedBiomeIds.add(130);
		blackListedBiomeIds.add(131);
		blackListedBiomeIds.add(132);
		blackListedBiomeIds.add(133);
		blackListedBiomeIds.add(134);
		blackListedBiomeIds.add(140);
		blackListedBiomeIds.add(149);
		blackListedBiomeIds.add(151);
		blackListedBiomeIds.add(155);
		blackListedBiomeIds.add(156);
		blackListedBiomeIds.add(157);
		blackListedBiomeIds.add(158);
		blackListedBiomeIds.add(160);
		blackListedBiomeIds.add(161);
		blackListedBiomeIds.add(162);
		blackListedBiomeIds.add(163);
		blackListedBiomeIds.add(164);
		blackListedBiomeIds.add(165);
		blackListedBiomeIds.add(166);
		blackListedBiomeIds.add(167);
	}

	public List<Biome> getSingleBiome() {
		return registeredSingleBiome;	
	}

	/**
	 * Gets Biomes from Advanced Rocketry's biomes registry.  If it does not exist attepts to retrieve from vanilla forge
	 * @param id biome id
	 * @return Biome retrieved from the biome ID
	 */
	public Biome getBiomeById(int id) {

		for(Biome biome : registeredBiomes) {
			if( Biome.getIdForBiome(biome) == id)
				return biome;
		}

		return Biome.getBiome(id);
	}


	//Biome registry.
	@SubscribeEvent
	public static void register(RegistryEvent.Register<Biome> evt)
	{
		System.out.println("REGISTERING BIOMES");
		moonBiome = new BiomeGenMoon(config.get(BIOMECATETORY, "moonBiomeId", 110).getInt(), true);
		//TODO: Sanitize biome classes
		moonHills = new BiomeGenMoonMountain(config.get(BIOMECATETORY, "moonHillBiomeId", 119).getInt(), true);
		moonHillsM = new BiomeGenMoonMountainM(config.get(BIOMECATETORY, "moonHillMBiomeId", 119).getInt(), true);
		alienForest = new BiomeGenAlienForest(config.get(BIOMECATETORY, "alienForestBiomeId", 111).getInt(), true);
		hotDryBiome = new BiomeGenHotDryRock(config.get(BIOMECATETORY, "hotDryBiome", 112).getInt(), true);
		spaceBiome = new BiomeGenSpace(config.get(BIOMECATETORY, "spaceBiomeId", 113).getInt(), true);
		stormLandsBiome = new BiomeGenStormland(config.get(BIOMECATETORY, "stormLandsBiomeId", 114).getInt(), true);
		crystalChasms = new BiomeGenCrystal(config.get(BIOMECATETORY, "crystalChasmsBiomeId", 115).getInt(), true);
		swampDeepBiome = new BiomeGenDeepSwamp(config.get(BIOMECATETORY, "deepSwampBiomeId", 116).getInt(), true);
		marsh = new BiomeGenMarsh(config.get(BIOMECATETORY, "marsh", 117).getInt(), true);
		oceanSpires = new BiomeGenOceanSpires(config.get(BIOMECATETORY, "oceanSpires", 118).getInt(), true);
		frozenOcean = new BiomeGenFrozenOcean(config.get(BIOMECATETORY, "frozenOceanBiomeId", 120).getInt(), true);

		instance.registerBiome(moonBiome, evt.getRegistry());
		instance.registerBiome(alienForest, evt.getRegistry());
		instance.registerBiome(hotDryBiome, evt.getRegistry());
		instance.registerBiome(spaceBiome, evt.getRegistry());
		instance.registerBiome(stormLandsBiome, evt.getRegistry());
		instance.registerBiome(crystalChasms, evt.getRegistry());
		instance.registerBiome(swampDeepBiome, evt.getRegistry());
		instance.registerBiome(marsh, evt.getRegistry());
		instance.registerBiome(oceanSpires, evt.getRegistry());
		instance.registerBiome(frozenOcean,evt.getRegistry());
		instance.registerBiome(moonHills,evt.getRegistry());
		instance.registerBiome(moonHillsM,evt.getRegistry());
	}
}
