package zmaster587.advancedRocketry.api;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import net.minecraftforge.common.config.Config;
import zmaster587.advancedRocketry.util.AsteroidSmall;
import net.minecraft.block.Block;
import net.minecraftforge.common.config.Property;

import static net.minecraftforge.common.config.Configuration.CATEGORY_GENERAL;

/**
 * Stores config variables
 *
 */
public class Configuration {
	public static final String configFolder = "advRocketry";

	public static final String oreGen = "Ore Generation";
	public static final String ROCKET = "Rockets";
	public static final String MOD_INTERACTION = "Mod Interaction";
	public static final String PLANET = "Planet";
	public static final String ASTEROID = "Asteroid";
	public static final String GAS_MINING = "GasMining";
	public static final String PERFORMANCE = "Performance";

	public static net.minecraftforge.common.config.Configuration config;
	public static int orbit = 1000;
	public static int MoonId = -1;
	public static int spaceDimId = -2;
	public static int fuelPointsPer10Mb = 10;
	public static int stationSize = 1024;
	
	public static double rocketThrustMultiplier;
	public static double fuelCapacityMultiplier;
	
	public static int maxBiomes = 512;
	public static boolean rocketRequireFuel = true;
	public static boolean enableOxygen = true;
	public static float buildSpeedMultiplier = 1f;
	
	public static boolean generateCopper;
	public static int copperPerChunk; 
	public static int copperClumpSize;
	
	public static boolean generateTin;
	public static int tinPerChunk;
	public static int tinClumpSize;
	
	public static boolean generateDilithium;
	public static int dilithiumClumpSize;
	public static int dilithiumPerChunk;
	public static int dilithiumPerChunkMoon;
	
	public static int aluminumPerChunk;
	public static int aluminumClumpSize;
	public static boolean generateAluminum;
	
	public static boolean generateIridium;
	public static int IridiumClumpSize;
	public static int IridiumPerChunk;
	
	public static boolean generateRutile;
	public static int rutilePerChunk;
	public static int rutileClumpSize;
	public static boolean allowMakingItemsForOtherMods;
	public static boolean scrubberRequiresCartrige;
	public static float EUMult;
	public static float RFMult;
	public static boolean overrideGCAir;
	public static int fuelPointsPerDilithium;
	public static boolean electricPlantsSpawnLightning;

	public static boolean allowSawmillVanillaWood;

	public static int atmosphereHandleBitMask;

	public static boolean automaticRetroRockets;

	public static boolean advancedVFX;

	public static boolean enableLaserDrill;

	public static int spaceSuitOxygenTime;

	public static float travelTimeMultiplier;

	public static int maxBiomesPerPlanet;

	public static boolean enableTerraforming;

	public static double gasCollectionMult;
	public static boolean allowTerraforming;

	public static int terraformingBlockSpeed;
	public static double terraformSpeed;
	public static boolean terraformRequiresFluid;
	public static float microwaveRecieverMulitplier;
	public static boolean blackListAllVanillaBiomes;
	public static double asteroidMiningTimeMult;
	public static boolean canPlayerRespawnInSpace;
	public static float spaceLaserPowerMult;
	public static List<Integer> laserBlackListDims = new LinkedList<Integer>();

	public static List<String> standardLaserDrillOres = new LinkedList<String>();

	public static boolean laserDrillPlanet;

	/** list of entities of which atmospheric effects should not be applied **/
	public static List<Class> bypassEntity = new LinkedList<Class>();
	
	public static List<Block> torchBlocks = new LinkedList<Block>();
	public static List<String> standardGeodeOres = new LinkedList<String>();
	public static Set<Integer> initiallyKnownPlanets = new HashSet<Integer>();

	public static boolean geodeOresBlackList;
	public static boolean laserDrillOresBlackList;

	public static boolean lockUI;

	public static HashMap<String, AsteroidSmall> asteroidTypes = new HashMap<String, AsteroidSmall>();
	public static HashMap<String, AsteroidSmall> prevAsteroidTypes = new HashMap<String, AsteroidSmall>();
	
	public static int oxygenVentSize;

	public static int solarGeneratorMult;

	public static boolean gravityAffectsFuel;
	public static boolean lowGravityBoots;
	public static float jetPackThrust;
	public static boolean enableGravityController;
	public static boolean planetsMustBeDiscovered;

	public static boolean generateGeodes;
	public static int geodeBaseSize;
	public static int geodeVariation;
	public static int terraformliquidRate;
	public static boolean dropExTorches;

	public static double oxygenVentConsumptionMult;

	public static int terraformPlanetSpeed;

	public static int planetDiscoveryChance;

	public static double oxygenVentPowerMultiplier;

	public static void loadConfig()
	{
		zmaster587.advancedRocketry.api.Configuration.buildSpeedMultiplier = (float) config.get(CATEGORY_GENERAL, "buildSpeedMultiplier", 1f, "Multiplier for the build speed of the Rocket Builder (0.5 is twice as fast 2 is half as fast").getDouble();
		zmaster587.advancedRocketry.api.Configuration.spaceDimId = config.get(CATEGORY_GENERAL,"spaceStationId" , -2,"Dimension ID to use for space stations").getInt();
		zmaster587.advancedRocketry.api.Configuration.enableOxygen = config.get(CATEGORY_GENERAL, "EnableAtmosphericEffects", true, "If true, allows players being hurt due to lack of oxygen and allows effects from non-standard atmosphere types").getBoolean();
		zmaster587.advancedRocketry.api.Configuration.allowMakingItemsForOtherMods = config.get(CATEGORY_GENERAL, "makeMaterialsForOtherMods", true, "If true the machines from AdvancedRocketry will produce things like plates/rods for other mods even if Advanced Rocketry itself does not use the material (This can increase load time)").getBoolean();
		zmaster587.advancedRocketry.api.Configuration.scrubberRequiresCartrige = config.get(CATEGORY_GENERAL, "scrubberRequiresCartrige", true, "If true the Oxygen scrubbers require a consumable carbon collection cartridge").getBoolean();
		zmaster587.advancedRocketry.api.Configuration.enableLaserDrill = config.get(CATEGORY_GENERAL, "EnableLaserDrill", true, "Enables the laser drill machine").getBoolean();
		zmaster587.advancedRocketry.api.Configuration.spaceLaserPowerMult = (float)config.get(CATEGORY_GENERAL, "LaserDrillPowerMultiplier", 1d, "Power multiplier for the laser drill machine").getDouble();
		zmaster587.advancedRocketry.api.Configuration.lowGravityBoots = config.get(CATEGORY_GENERAL, "lowGravityBoots", false, "If true the boots only protect the player on planets with low gravity").getBoolean();
		zmaster587.advancedRocketry.api.Configuration.jetPackThrust = (float)config.get(CATEGORY_GENERAL, "jetPackForce", 1.3, "Amount of force the jetpack provides with respect to gravity, 1 is the same acceleration as caused by Earth's gravity, 2 is 2x the acceleration caused by Earth's gravity, etc.  To make jetpack only work on low gravity planets, simply set it to a value less than 1").getDouble();
		zmaster587.advancedRocketry.api.Configuration.enableTerraforming = config.get(CATEGORY_GENERAL, "EnableTerraforming", true,"Enables terraforming items and blocks").getBoolean();
		zmaster587.advancedRocketry.api.Configuration.oxygenVentPowerMultiplier = config.get(CATEGORY_GENERAL, "OxygenVentPowerMultiplier", 1.0f, "Power consumption multiplier for the oxygen vent", 0, Float.MAX_VALUE).getDouble();
		zmaster587.advancedRocketry.api.Configuration.spaceSuitOxygenTime = config.get(CATEGORY_GENERAL, "spaceSuitO2Buffer", 30, "Maximum time in minutes that the spacesuit's internal buffer can store O2 for").getInt();
		zmaster587.advancedRocketry.api.Configuration.travelTimeMultiplier = (float)config.get(CATEGORY_GENERAL, "warpTravelTime", 1f, "Multiplier for warp travel time").getDouble();
		zmaster587.advancedRocketry.api.Configuration.maxBiomesPerPlanet = config.get(CATEGORY_GENERAL, "maxBiomesPerPlanet", 5, "Maximum unique biomes per planet, -1 to disable").getInt();
		zmaster587.advancedRocketry.api.Configuration.allowTerraforming = config.get(CATEGORY_GENERAL, "allowTerraforming", false, "EXPERIMENTAL: If set to true allows contruction and usage of the terraformer.  This is known to cause strange world generation after successful terraform").getBoolean();
		zmaster587.advancedRocketry.api.Configuration.terraformingBlockSpeed = config.get(CATEGORY_GENERAL, "biomeUpdateSpeed", 1, "How many blocks have the biome changed per tick.  Large numbers can slow the server down", Integer.MAX_VALUE, 1).getInt();
		zmaster587.advancedRocketry.api.Configuration.terraformSpeed = config.get(CATEGORY_GENERAL, "terraformMult", 1f, "Multplier for atmosphere change speed").getDouble();
		zmaster587.advancedRocketry.api.Configuration.terraformPlanetSpeed = config.get(CATEGORY_GENERAL, "terraformBlockPerTick", 1, "Max number of blocks allowed to be changed per tick").getInt();
		zmaster587.advancedRocketry.api.Configuration.terraformRequiresFluid = config.get(CATEGORY_GENERAL, "TerraformerRequiresFluids", true).getBoolean();
		zmaster587.advancedRocketry.api.Configuration.terraformliquidRate = config.get(CATEGORY_GENERAL, "TerraformerFluidConsumeRate", 40, "how many millibuckets/t are required to keep the terraformer running").getInt();
		zmaster587.advancedRocketry.api.Configuration.stationSize = config.get(net.minecraftforge.common.config.Configuration.CATEGORY_GENERAL, "SpaceStationBuildRadius", 1024, "The largest size a space station can be.  Should also be a power of 2 (512, 1024, 2048, 4096, ...).  CAUTION: CHANGING THIS OPTION WILL DAMAGE EXISTING STATIONS!!!").getInt();
		zmaster587.advancedRocketry.api.Configuration.canPlayerRespawnInSpace = config.get(net.minecraftforge.common.config.Configuration.CATEGORY_GENERAL, "allowPlanetRespawn", false, "If true players will respawn near beds on planets IF the spawn location is in a breathable atmosphere").getBoolean();
		zmaster587.advancedRocketry.api.Configuration.solarGeneratorMult = config.get(net.minecraftforge.common.config.Configuration.CATEGORY_GENERAL, "solarGeneratorMultiplier", 1, "Amount of power per tick the solar generator should produce").getInt();
		zmaster587.advancedRocketry.api.Configuration.enableGravityController = config.get(net.minecraftforge.common.config.Configuration.CATEGORY_GENERAL, "enableGravityMachine", true, "If false the gravity controller cannot be built or used").getBoolean();
		zmaster587.advancedRocketry.api.Configuration.planetsMustBeDiscovered = config.get(net.minecraftforge.common.config.Configuration.CATEGORY_GENERAL, "planetsMustBeDiscovered", false, "If true planets must be discovered in the warp controller before being visible").getBoolean();
		zmaster587.advancedRocketry.api.Configuration.dropExTorches = config.get(net.minecraftforge.common.config.Configuration.CATEGORY_GENERAL, "dropExtinguishedTorches", false, "If true, breaking an extinguished torch will drop an extinguished torch instead of a vanilla torch").getBoolean();
		zmaster587.advancedRocketry.api.Configuration.blackListAllVanillaBiomes = config.getBoolean("blackListVanillaBiomes", PLANET, false, "Prevents any vanilla biomes from spawning on planets");
		zmaster587.advancedRocketry.api.Configuration.overrideGCAir = config.get(MOD_INTERACTION, "OverrideGCAir", true, "If true Galaciticcraft's air will be disabled entirely requiring use of Advanced Rocketry's Oxygen system on GC planets").getBoolean();
		zmaster587.advancedRocketry.api.Configuration.fuelPointsPerDilithium = config.get(net.minecraftforge.common.config.Configuration.CATEGORY_GENERAL, "pointsPerDilithium", 500, "How many units of fuel should each Dilithium Crystal give to warp ships", 1, 1000).getInt();
		zmaster587.advancedRocketry.api.Configuration.electricPlantsSpawnLightning = config.get(net.minecraftforge.common.config.Configuration.CATEGORY_GENERAL, "electricPlantsSpawnLightning", true, "Should Electric Mushrooms be able to spawn lightning").getBoolean();
		zmaster587.advancedRocketry.api.Configuration.allowSawmillVanillaWood = config.get(net.minecraftforge.common.config.Configuration.CATEGORY_GENERAL, "sawMillCutVanillaWood", true, "Should the cutting machine be able to cut vanilla wood into planks").getBoolean();
		zmaster587.advancedRocketry.api.Configuration.automaticRetroRockets = config.get(ROCKET, "autoRetroRockets", true, "Setting to false will disable the retrorockets that fire automatically on reentry on both player and automated rockets").getBoolean();
		zmaster587.advancedRocketry.api.Configuration.atmosphereHandleBitMask = config.get(PERFORMANCE, "atmosphereCalculationMethod", 0, "BitMask: 0: no threading, radius based; 1: threading, radius based (EXP); 2: no threading volume based; 3: threading volume based (EXP)").getInt();
		zmaster587.advancedRocketry.api.Configuration.oxygenVentSize = config.get(PERFORMANCE, "oxygenVentSize", 32, "Radius of the O2 vent.  if atmosphereCalculationMethod is 2 or 3 then max volume is calculated from this radius.  WARNING: larger numbers can lead to lag").getInt();
		zmaster587.advancedRocketry.api.Configuration.oxygenVentConsumptionMult = config.get(net.minecraftforge.common.config.Configuration.CATEGORY_GENERAL, "oxygenVentConsumptionMultiplier", 1f, "Multiplier on how much O2 an oxygen vent consumes per tick").getDouble();
		zmaster587.advancedRocketry.api.Configuration.gravityAffectsFuel = config.get(net.minecraftforge.common.config.Configuration.CATEGORY_GENERAL, "gravityAffectsFuels", true, "If true planets with higher gravity require more fuel and lower gravity would require less").getBoolean();
		zmaster587.advancedRocketry.api.Configuration.advancedVFX = config.get(PERFORMANCE, "advancedVFX", true, "Advanced visual effects").getBoolean();
		zmaster587.advancedRocketry.api.Configuration.gasCollectionMult = config.get(GAS_MINING, "gasMissionMultiplier", 1.0, "Multiplier for the amount of time gas collection missions take").getDouble();
		zmaster587.advancedRocketry.api.Configuration.asteroidMiningTimeMult = config.get(ASTEROID, "miningMissionTmeMultiplier", 1.0, "Multiplier changing how long a mining mission takes").getDouble();
		zmaster587.advancedRocketry.api.Configuration.geodeOresBlackList = config.get(oreGen, "geodeOres_blacklist", false, "True if the ores in geodeOres should be a blacklist, false for whitelist").getBoolean();
		zmaster587.advancedRocketry.api.Configuration.generateGeodes = config.get(oreGen, "generateGeodes", true, "If true then ore-containing geodes are generated on high pressure planets").getBoolean();
		zmaster587.advancedRocketry.api.Configuration.geodeBaseSize = config.get(oreGen, "geodeBaseSize", 36, "average size of the geodes").getInt();
		zmaster587.advancedRocketry.api.Configuration.geodeVariation = config.get(oreGen, "geodeVariation", 24, "variation in geode size").getInt();
		zmaster587.advancedRocketry.api.Configuration.laserDrillOresBlackList = config.get(net.minecraftforge.common.config.Configuration.CATEGORY_GENERAL, "laserDrillOres_blacklist", false, "True if the ores in laserDrillOres should be a blacklist, false for whitelist").getBoolean();
		zmaster587.advancedRocketry.api.Configuration.laserDrillPlanet = config.get(net.minecraftforge.common.config.Configuration.CATEGORY_GENERAL, "laserDrillPlanet", false, "If true the orbital laser will actually mine blocks on the planet below").getBoolean();
		//fuel
		zmaster587.advancedRocketry.api.Configuration.rocketRequireFuel = config.get(ROCKET, "rocketsRequireFuel", true, "Set to false if rockets should not require fuel to fly").getBoolean();
		zmaster587.advancedRocketry.api.Configuration.rocketThrustMultiplier = config.get(ROCKET, "thrustMultiplier", 1f, "Multiplier for per-engine thrust").getDouble();
		zmaster587.advancedRocketry.api.Configuration.fuelCapacityMultiplier = config.get(ROCKET, "fuelCapacityMultiplier", 1f, "Multiplier for per-tank capacity").getDouble();


		//Copper Config
		zmaster587.advancedRocketry.api.Configuration.generateCopper = config.get(oreGen, "GenerateCopper", true).getBoolean();
		zmaster587.advancedRocketry.api.Configuration.copperClumpSize = config.get(oreGen, "CopperPerClump", 6).getInt();
		zmaster587.advancedRocketry.api.Configuration.copperPerChunk = config.get(oreGen, "CopperPerChunk", 10).getInt();

		//Tin Config
		zmaster587.advancedRocketry.api.Configuration.generateTin = config.get(oreGen, "GenerateTin", true).getBoolean();
		zmaster587.advancedRocketry.api.Configuration.tinClumpSize = config.get(oreGen, "TinPerClump", 6).getInt();
		zmaster587.advancedRocketry.api.Configuration.tinPerChunk = config.get(oreGen, "TinPerChunk", 10).getInt();

		//Dilithium config
		zmaster587.advancedRocketry.api.Configuration.generateDilithium = config.get(oreGen, "generateDilithium", true).getBoolean();
		zmaster587.advancedRocketry.api.Configuration.dilithiumClumpSize = config.get(oreGen, "DilithiumPerClump", 16).getInt();
		zmaster587.advancedRocketry.api.Configuration.dilithiumPerChunk = config.get(oreGen, "DilithiumPerChunk", 1).getInt();
		zmaster587.advancedRocketry.api.Configuration.dilithiumPerChunkMoon = config.get(oreGen, "DilithiumPerChunkLuna", 10).getInt();

		//Aluminium Config
		zmaster587.advancedRocketry.api.Configuration.generateAluminum = config.get(oreGen, "generateAluminum", true).getBoolean();
		zmaster587.advancedRocketry.api.Configuration.aluminumClumpSize = config.get(oreGen, "AluminumPerClump", 16).getInt();
		zmaster587.advancedRocketry.api.Configuration.aluminumPerChunk = config.get(oreGen, "AluminumPerChunk", 1).getInt();

		//Iridium Config
		zmaster587.advancedRocketry.api.Configuration.generateIridium = config.get(oreGen, "generateIridium", false).getBoolean();
		zmaster587.advancedRocketry.api.Configuration.IridiumClumpSize = config.get(oreGen, "IridiumPerClump", 16).getInt();
		zmaster587.advancedRocketry.api.Configuration.IridiumPerChunk = config.get(oreGen, "IridiumPerChunk", 1).getInt();

		//Titanium Config
		zmaster587.advancedRocketry.api.Configuration.generateRutile = config.get(oreGen, "GenerateRutile", true).getBoolean();
		zmaster587.advancedRocketry.api.Configuration.rutileClumpSize = config.get(oreGen, "RutilePerClump", 6).getInt();
		zmaster587.advancedRocketry.api.Configuration.rutilePerChunk = config.get(oreGen, "RutilePerChunk", 6).getInt();
	}
}
