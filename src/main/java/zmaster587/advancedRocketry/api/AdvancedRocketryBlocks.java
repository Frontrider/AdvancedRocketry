package zmaster587.advancedRocketry.api;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialLiquid;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.GameData;
import zmaster587.advancedRocketry.api.atmosphere.AtmosphereRegister;
import zmaster587.advancedRocketry.block.*;
import zmaster587.advancedRocketry.block.cable.BlockDataCable;
import zmaster587.advancedRocketry.block.cable.BlockEnergyCable;
import zmaster587.advancedRocketry.block.cable.BlockLiquidPipe;
import zmaster587.advancedRocketry.block.multiblock.BlockARHatch;
import zmaster587.advancedRocketry.block.planet.BlockDust;
import zmaster587.advancedRocketry.block.planet.BlockStone;
import zmaster587.advancedRocketry.block.plant.BlockAlienLeaves;
import zmaster587.advancedRocketry.block.plant.BlockAlienPlank;
import zmaster587.advancedRocketry.block.plant.BlockAlienSapling;
import zmaster587.advancedRocketry.block.plant.BlockAlienWood;
import zmaster587.advancedRocketry.item.ItemBlockCrystal;
import zmaster587.advancedRocketry.item.ItemBlockFluidTank;
import zmaster587.advancedRocketry.tile.*;
import zmaster587.advancedRocketry.tile.Satellite.TileEntitySatelliteControlCenter;
import zmaster587.advancedRocketry.tile.Satellite.TileSatelliteBuilder;
import zmaster587.advancedRocketry.tile.infrastructure.TileEntityFuelingStation;
import zmaster587.advancedRocketry.tile.infrastructure.TileEntityMoniteringStation;
import zmaster587.advancedRocketry.tile.multiblock.*;
import zmaster587.advancedRocketry.tile.multiblock.energy.TileMicrowaveReciever;
import zmaster587.advancedRocketry.tile.multiblock.machine.*;
import zmaster587.advancedRocketry.tile.oxygen.TileCO2Scrubber;
import zmaster587.advancedRocketry.tile.oxygen.TileOxygenCharger;
import zmaster587.advancedRocketry.tile.oxygen.TileOxygenVent;
import zmaster587.advancedRocketry.tile.station.*;
import zmaster587.advancedRocketry.util.FluidColored;
import zmaster587.libVulpes.LibVulpes;
import zmaster587.libVulpes.api.LibVulpesBlocks;
import zmaster587.libVulpes.api.material.AllowedProducts;
import zmaster587.libVulpes.block.BlockAlphaTexture;
import zmaster587.libVulpes.block.BlockMotor;
import zmaster587.libVulpes.block.BlockTile;
import net.minecraft.block.Block;
import net.minecraft.block.BlockGlass;
import zmaster587.libVulpes.block.multiblock.BlockMultiBlockComponentVisible;
import zmaster587.libVulpes.block.multiblock.BlockMultiblockMachine;
import zmaster587.libVulpes.inventory.GuiHandler;
import zmaster587.libVulpes.items.ItemBlockMeta;

import static zmaster587.advancedRocketry.AdvancedRocketry.materialRegistry;
import static zmaster587.advancedRocketry.AdvancedRocketry.proxy;
import static zmaster587.advancedRocketry.AdvancedRocketry.tabAdvRocketry;

/**
 * Stores references to Advanced Rocketry's blocks
 *
 */
@Mod.EventBusSubscriber
public class AdvancedRocketryBlocks {
	public static Block blockMissionComp;
	public static Block blockSpaceLaser;
	public static Block blockPrecisionAssembler;
	public static Block blockArcFurnace;
	public static Block blockBlastBrick;
	public static Block blockQuartzCrucible;
	public static Block blockCrystallizer;
	public static Block blockLathe;
	public static Block blockCuttingMachine;
	public static Block blockObservatory;
	public static Block blockPlanetAnalyser;
	public static Block blockLaunchpad;
	public static Block blockStructureTower;
	public static Block blockRocketBuilder;
	public static Block blockGenericSeat;
	public static Block blockEngine;
	public static Block blockFuelTank;
	public static Block blockFuelingStation;
	public static Block blockMonitoringStation, blockSatelliteBuilder, blockSatelliteControlCenter;
	public static Block blockChipStorage;
	public static Block blockMoonTurf, blockHotTurf;
	public static Block blockMultiMineOre;
	public static Block blockLightSource;
	public static Block blockAlienWood, blockAlienLeaves, blockAlienSapling;
	public static Block blockGuidanceComputer;
	public static Block blockLunarAnalyser;
	public static Block blockPlanetSelector;
	public static Block blockSawBlade;
	public static Block blockConcrete;
	public static Block blockRollingMachine;
	public static Block blockPlatePress;
	public static Block blockStationBuilder;
	public static Block blockElectrolyser;
	public static Block blockOxygenFluid;
	public static Block blockHydrogenFluid;
	public static Block blockChemicalReactor;
	public static Block blockFuelFluid;
	public static Block test;
	public static Block blockOxygenVent;
	public static Block blockOxygenScrubber;
	public static Block blockOxygenCharger;
	public static Block blockAirLock;
	public static Block blockLandingPad;
	public static Block blockWarpCore;
	public static Block blockWarpShipMonitor;
	public static Block blockOxygenDetection;
	public static Block blockUnlitTorch;
	public static Block blocksGeode;
	public static Block blockVitrifiedSand;
	public static Block blockCharcoalLog;
	public static Block blockElectricMushroom;
	public static Block blockCrystal;
	public static Block blockOrientationController;
	public static Block blockGravityController;
	public static Block blockDrill;
	public static Block blockFluidPipe;
	public static Block blockDataPipe;
	public static Block blockMicrowaveReciever;
	public static Block blockSolarPanel;
	public static Block blockSuitWorkStation;
	public static Block blockLoader;
	public static Block blockBiomeScanner;
	public static Block blockAtmosphereTerraformer;
	public static Block blockDeployableRocketBuilder;
	public static Block blockPressureTank;
	public static Block blockIntake;
	public static Block blockNitrogenFluid;
	public static Block blockCircleLight;
	public static Block blockEnergyPipe;
	public static Block blockSolarGenerator;
	public static Block blockDockingPort;
	public static Block blockAltitudeController;
	public static Block blockRailgun;
	public static Block blockAstroBed;
	public static Block blockAdvEngine;
	public static Block blockPlanetHoloSelector;
	public static Block blockLens;
	public static Block blockForceField;
	public static Block blockForceFieldProjector;
	public static Block blockGravityMachine;
	public static Block blockPipeSealer;
	public static Block blockSpaceElevatorController;
	public static Block blockBeacon;
	public static Block blockAlienPlanks;
	public static Block blockThermiteTorch;
    public static Block blockMoonStone;
	public static Block blockChiseledMoonStone;
	public static Block blockSmoothMoonStone;

	@SubscribeEvent(priority= EventPriority.HIGH)
	public static void registerBlocks(RegistryEvent.Register<Block> evt)
	{
		//Blocks -------------------------------------------------------------------------------------
		blocksGeode = new Block(MaterialGeode.geode).setUnlocalizedName("geode").setCreativeTab(LibVulpes.tabLibVulpesOres).setHardness(6f).setResistance(2000F);
		blocksGeode.setHarvestLevel("jackhammer", 2);
		blockLaunchpad = new BlockLinkedHorizontalTexture(Material.ROCK).setUnlocalizedName("pad").setCreativeTab(tabAdvRocketry).setHardness(2f).setResistance(10f);
		blockStructureTower = new BlockAlphaTexture(Material.ROCK).setUnlocalizedName("structuretower").setCreativeTab(tabAdvRocketry).setHardness(2f);
		blockGenericSeat = new BlockSeat(Material.CLOTH).setUnlocalizedName("seat").setCreativeTab(tabAdvRocketry).setHardness(0.5f);
		blockEngine = new BlockRocketMotor(Material.ROCK).setUnlocalizedName("rocket").setCreativeTab(tabAdvRocketry).setHardness(2f);
		blockAdvEngine = new BlockAdvancedRocketMotor(Material.ROCK).setUnlocalizedName("advRocket").setCreativeTab(tabAdvRocketry).setHardness(2f);
		blockFuelTank = new BlockFuelTank(Material.ROCK).setUnlocalizedName("fuelTank").setCreativeTab(tabAdvRocketry).setHardness(2f);
		blockSawBlade = new BlockMotor(Material.ROCK,1f).setCreativeTab(tabAdvRocketry).setUnlocalizedName("sawBlade").setHardness(2f);

		blockConcrete = new Block(Material.ROCK).setUnlocalizedName("concrete").setCreativeTab(tabAdvRocketry).setHardness(3f).setResistance(16f);
		blockPlatePress = new BlockPress().setUnlocalizedName("blockHandPress").setCreativeTab(tabAdvRocketry).setHardness(2f);
		blockAirLock = new BlockDoor2(Material.ROCK).setUnlocalizedName("smallAirlockDoor").setHardness(3f).setResistance(8f);
		blockLandingPad = new BlockLandingPad(Material.ROCK).setUnlocalizedName("dockingPad").setHardness(3f).setCreativeTab(tabAdvRocketry);
		blockOxygenDetection = new BlockRedstoneEmitter(Material.ROCK,"advancedrocketry:atmosphereDetector_active").setUnlocalizedName("atmosphereDetector").setHardness(3f).setCreativeTab(tabAdvRocketry);
		blockOxygenScrubber = new BlockTile(TileCO2Scrubber.class, GuiHandler.guiId.MODULAR.ordinal()).setCreativeTab(tabAdvRocketry).setUnlocalizedName("scrubber").setHardness(3f);
		blockUnlitTorch = new BlockTorchUnlit().setHardness(0.0F).setUnlocalizedName("unlittorch");
		blockVitrifiedSand = new Block(Material.SAND).setUnlocalizedName("vitrifiedSand").setCreativeTab(CreativeTabs.BUILDING_BLOCKS).setHardness(0.5F);
		blockCharcoalLog = new BlockCharcoalLog().setUnlocalizedName("charcoallog").setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		blockElectricMushroom = new BlockElectricMushroom().setUnlocalizedName("electricMushroom").setCreativeTab(tabAdvRocketry).setHardness(0.0F);
		blockCrystal = new BlockCrystal().setUnlocalizedName("crystal").setCreativeTab(LibVulpes.tabLibVulpesOres).setHardness(2f);
		blockOrientationController = new BlockTile(TileStationOrientationControl.class,  GuiHandler.guiId.MODULAR.ordinal()).setCreativeTab(tabAdvRocketry).setUnlocalizedName("orientationControl").setHardness(3f);
		blockGravityController = new BlockTile(TileStationGravityController.class,  GuiHandler.guiId.MODULAR.ordinal()).setCreativeTab(tabAdvRocketry).setUnlocalizedName("gravityControl").setHardness(3f);
		blockAltitudeController = new BlockTile(TileStationAltitudeController.class,  GuiHandler.guiId.MODULAR.ordinal()).setCreativeTab(tabAdvRocketry).setUnlocalizedName("altitudeController").setHardness(3f);
		blockOxygenCharger = new BlockHalfTile(TileOxygenCharger.class, GuiHandler.guiId.MODULAR.ordinal()).setUnlocalizedName("oxygenCharger").setCreativeTab(tabAdvRocketry).setHardness(3f);
		blockOxygenVent = new BlockTile(TileOxygenVent.class, GuiHandler.guiId.MODULAR.ordinal()).setUnlocalizedName("oxygenVent").setCreativeTab(tabAdvRocketry).setHardness(3f);
		blockCircleLight = new Block(Material.IRON).setUnlocalizedName("circleLight").setCreativeTab(tabAdvRocketry).setHardness(2f).setLightLevel(1f);
		blockLens = new BlockLens().setUnlocalizedName("lens").setCreativeTab(tabAdvRocketry).setHardness(0.3f);
		blockRocketBuilder = new BlockTile(TileRocketBuilder.class, GuiHandler.guiId.MODULARNOINV.ordinal()).setUnlocalizedName("rocketAssembler").setCreativeTab(tabAdvRocketry).setHardness(3f);
		blockForceField = new BlockForceField(Material.ROCK).setBlockUnbreakable().setResistance(6000000.0F).setUnlocalizedName("forceField");
		blockForceFieldProjector = new BlockForceFieldProjector(Material.ROCK).setUnlocalizedName("forceFieldProjector").setCreativeTab(tabAdvRocketry).setHardness(3f);

		blockDeployableRocketBuilder = new BlockTile(TileStationDeployedAssembler.class, GuiHandler.guiId.MODULARNOINV.ordinal()).setUnlocalizedName("deployableRocketAssembler").setCreativeTab(tabAdvRocketry).setHardness(3f);

		blockStationBuilder = new BlockTile(TileStationBuilder.class, GuiHandler.guiId.MODULAR.ordinal()).setUnlocalizedName("stationAssembler").setCreativeTab(tabAdvRocketry).setHardness(3f);

		blockFuelingStation = new BlockTileRedstoneEmitter(TileEntityFuelingStation.class, GuiHandler.guiId.MODULAR.ordinal()).setUnlocalizedName("fuelStation").setCreativeTab(tabAdvRocketry).setHardness(3f);

		blockMonitoringStation = new BlockTileNeighborUpdate(TileEntityMoniteringStation.class, GuiHandler.guiId.MODULARNOINV.ordinal()).setCreativeTab(tabAdvRocketry).setHardness(3f);
		blockMonitoringStation.setUnlocalizedName("monitoringstation");

		blockWarpShipMonitor = new BlockWarpShipMonitor(TileWarpShipMonitor.class, GuiHandler.guiId.MODULARNOINV.ordinal()).setCreativeTab(tabAdvRocketry).setHardness(3f);
		blockWarpShipMonitor.setUnlocalizedName("stationmonitor");

		blockSatelliteBuilder = new BlockMultiblockMachine(TileSatelliteBuilder.class, GuiHandler.guiId.MODULAR.ordinal()).setCreativeTab(tabAdvRocketry).setHardness(3f);
		blockSatelliteBuilder.setUnlocalizedName("satelliteBuilder");

		blockSatelliteControlCenter = new BlockTile(TileEntitySatelliteControlCenter.class, GuiHandler.guiId.MODULAR.ordinal()).setCreativeTab(tabAdvRocketry).setHardness(3f);
		blockSatelliteControlCenter.setUnlocalizedName("satelliteMonitor");

		blockMicrowaveReciever = new BlockMultiblockMachine(TileMicrowaveReciever.class, GuiHandler.guiId.MODULAR.ordinal()).setCreativeTab(tabAdvRocketry).setHardness(3f);
		blockMicrowaveReciever.setUnlocalizedName("microwaveReciever");

		//Arcfurnace
		blockArcFurnace = new BlockMultiblockMachine(TileElectricArcFurnace.class, GuiHandler.guiId.MODULAR.ordinal()).setUnlocalizedName("electricArcFurnace").setCreativeTab(tabAdvRocketry).setHardness(3f);

		blockMoonTurf = new BlockDust().setMapColor(MapColor.SNOW).setHardness(0.5F).setUnlocalizedName("turf").setCreativeTab(tabAdvRocketry);
		blockMoonStone = new BlockStone().setMapColor(MapColor.SNOW).setHardness(0.5F).setUnlocalizedName("moonStone").setCreativeTab(tabAdvRocketry);
		blockChiseledMoonStone = new BlockStone().setMapColor(MapColor.SNOW).setHardness(0.5F).setUnlocalizedName("chiseledMoonStone").setCreativeTab
				(tabAdvRocketry);
		blockSmoothMoonStone = new BlockStone().setMapColor(MapColor.SNOW).setHardness(0.5F).setUnlocalizedName("smoothMoonStone").setCreativeTab
				(tabAdvRocketry);

		blockHotTurf = new BlockPlanetSoil().setMapColor(MapColor.NETHERRACK).setHardness(0.5F).setUnlocalizedName("hotDryturf").setCreativeTab(tabAdvRocketry);

		blockLoader = new BlockARHatch(Material.ROCK).setUnlocalizedName("loader").setCreativeTab(tabAdvRocketry).setHardness(3f);

		blockAlienWood = new BlockAlienWood().setUnlocalizedName("log").setCreativeTab(tabAdvRocketry).setHardness(3f);
		blockAlienLeaves = new BlockAlienLeaves().setUnlocalizedName("leaves2").setCreativeTab(tabAdvRocketry).setHardness(3f);
		blockAlienSapling = new BlockAlienSapling().setUnlocalizedName("sapling").setCreativeTab(tabAdvRocketry).setHardness(3f);
		blockAlienPlanks = new BlockAlienPlank().setUnlocalizedName("planks").setCreativeTab(tabAdvRocketry).setHardness(3f);

		blockLightSource = new BlockLightSource();

		blockBlastBrick = new BlockMultiBlockComponentVisible(Material.ROCK).setCreativeTab(tabAdvRocketry).setUnlocalizedName("blastBrick").setHardness(3F).setResistance(15F);
		blockQuartzCrucible = new BlockQuartzCrucible().setUnlocalizedName("qcrucible").setCreativeTab(tabAdvRocketry);
		blockAstroBed = new BlockAstroBed().setHardness(0.2F).setUnlocalizedName("astroBed");

		blockPrecisionAssembler = new BlockMultiblockMachine(TilePrecisionAssembler.class, GuiHandler.guiId.MODULAR.ordinal()).setUnlocalizedName("precisionAssemblingMachine").setCreativeTab(tabAdvRocketry).setHardness(3f);

		blockCuttingMachine = new BlockMultiblockMachine(TileCuttingMachine.class, GuiHandler.guiId.MODULAR.ordinal()).setUnlocalizedName("cuttingMachine").setCreativeTab(tabAdvRocketry).setHardness(3f);

		blockCrystallizer = new BlockMultiblockMachine(TileCrystallizer.class, GuiHandler.guiId.MODULAR.ordinal()).setUnlocalizedName("Crystallizer").setCreativeTab(tabAdvRocketry).setHardness(3f);

		blockWarpCore = new BlockWarpCore(TileWarpCore.class, GuiHandler.guiId.MODULAR.ordinal()).setUnlocalizedName("warpCore").setCreativeTab(tabAdvRocketry).setHardness(3f);

		blockChemicalReactor = new BlockMultiblockMachine(TileChemicalReactor.class, GuiHandler.guiId.MODULAR.ordinal()).setUnlocalizedName("chemreactor").setCreativeTab(tabAdvRocketry).setHardness(3f);

		blockLathe = new BlockMultiblockMachine(TileLathe.class, GuiHandler.guiId.MODULAR.ordinal()).setUnlocalizedName("lathe").setCreativeTab(tabAdvRocketry).setHardness(3f);

		blockRollingMachine = new BlockMultiblockMachine(TileRollingMachine.class, GuiHandler.guiId.MODULAR.ordinal()).setUnlocalizedName("rollingMachine").setCreativeTab(tabAdvRocketry).setHardness(3f);

		blockElectrolyser = new BlockMultiblockMachine(TileElectrolyser.class, GuiHandler.guiId.MODULAR.ordinal()).setUnlocalizedName("electrolyser").setCreativeTab(tabAdvRocketry).setHardness(3f);

		blockAtmosphereTerraformer = new BlockMultiblockMachine(TileAtmosphereTerraformer.class, GuiHandler.guiId.MODULARNOINV.ordinal()).setUnlocalizedName("atmosphereTerraformer").setCreativeTab(tabAdvRocketry).setHardness(3f);

		blockPlanetAnalyser = new BlockMultiblockMachine(TileAstrobodyDataProcessor.class, GuiHandler.guiId.MODULARNOINV.ordinal()).setUnlocalizedName("planetanalyser").setCreativeTab(tabAdvRocketry).setHardness(3f);

		blockObservatory = (BlockMultiblockMachine) new BlockMultiblockMachine(TileObservatory.class, GuiHandler.guiId.MODULARNOINV.ordinal()).setUnlocalizedName("observatory").setCreativeTab(tabAdvRocketry).setHardness(3f);

		blockGuidanceComputer = new BlockTile(TileGuidanceComputer.class,GuiHandler.guiId.MODULAR.ordinal()).setUnlocalizedName("guidanceComputer").setCreativeTab(tabAdvRocketry).setHardness(3f);

		blockPlanetSelector = new BlockTile(TilePlanetSelector.class,GuiHandler.guiId.MODULARFULLSCREEN.ordinal()).setUnlocalizedName("planetSelector").setCreativeTab(tabAdvRocketry).setHardness(3f);

		blockPlanetHoloSelector = new BlockHalfTile(TilePlanetaryHologram.class,GuiHandler.guiId.MODULAR.ordinal()).setUnlocalizedName("planetHoloSelector").setCreativeTab(tabAdvRocketry).setHardness(3f);

		blockBiomeScanner = new BlockMultiblockMachine(TileBiomeScanner.class,GuiHandler.guiId.MODULARNOINV.ordinal()).setUnlocalizedName("biomeScanner").setCreativeTab(tabAdvRocketry).setHardness(3f);

		blockDrill = new BlockMiningDrill().setUnlocalizedName("drill").setCreativeTab(tabAdvRocketry).setHardness(3f);

		blockSuitWorkStation = new BlockSuitWorkstation(TileSuitWorkStation.class, GuiHandler.guiId.MODULAR.ordinal()).setUnlocalizedName("suitWorkStation").setCreativeTab(tabAdvRocketry).setHardness(3f);

		blockRailgun = new BlockMultiblockMachine(TileRailgun.class, GuiHandler.guiId.MODULAR.ordinal()).setUnlocalizedName("railgun").setCreativeTab(tabAdvRocketry).setHardness(3f);

		blockSpaceElevatorController = new BlockMultiblockMachine(TileSpaceElevator.class,  GuiHandler.guiId.MODULAR.ordinal()).setCreativeTab(tabAdvRocketry).setUnlocalizedName("spaceElevatorController").setHardness(3f);
		blockBeacon = new BlockBeacon(TileBeacon.class,  GuiHandler.guiId.MODULAR.ordinal()).setCreativeTab(tabAdvRocketry).setUnlocalizedName("beacon").setHardness(3f);

		blockIntake = new BlockIntake(Material.IRON).setUnlocalizedName("gasIntake").setCreativeTab(tabAdvRocketry).setHardness(3f);
		blockPressureTank = new BlockPressurizedFluidTank(Material.IRON).setUnlocalizedName("pressurizedTank").setCreativeTab(tabAdvRocketry).setHardness(3f);
		blockSolarPanel = new Block(Material.IRON).setUnlocalizedName("solarPanel").setCreativeTab(tabAdvRocketry).setHardness(3f);
		blockSolarGenerator = new BlockSolarGenerator(TileSolarPanel.class, GuiHandler.guiId.MODULAR.ordinal()).setCreativeTab(tabAdvRocketry).setHardness(3f).setUnlocalizedName("solarGenerator");
		blockDockingPort = new BlockStationModuleDockingPort(Material.IRON).setUnlocalizedName("stationMarker").setCreativeTab(tabAdvRocketry).setHardness(3f);
		blockPipeSealer = new BlockSeal(Material.IRON).setUnlocalizedName("pipeSeal").setCreativeTab(tabAdvRocketry).setHardness(0.5f);
		blockThermiteTorch = new BlockThermiteTorch().setUnlocalizedName("thermiteTorch").setCreativeTab(tabAdvRocketry).setHardness(0.1f).setLightLevel(1f);

		//Configurable stuff
		if(zmaster587.advancedRocketry.api.Configuration.enableGravityController)
			blockGravityMachine = new BlockMultiblockMachine(TileGravityController.class,GuiHandler.guiId.MODULARNOINV.ordinal()).setUnlocalizedName("gravityMachine").setCreativeTab(tabAdvRocketry).setHardness(3f);


		if(zmaster587.advancedRocketry.api.Configuration.enableLaserDrill) {
			blockSpaceLaser = new BlockLaser().setHardness(2f);
			blockSpaceLaser.setCreativeTab(tabAdvRocketry);
		}


		//Fluid Registration
		AdvancedRocketryFluids.fluidOxygen = new FluidColored("oxygen",0x8f94b9).setUnlocalizedName("oxygen").setGaseous(true);
		if(!FluidRegistry.registerFluid(AdvancedRocketryFluids.fluidOxygen))
		{
			AdvancedRocketryFluids.fluidOxygen = FluidRegistry.getFluid("oxygen");
		}

		AdvancedRocketryFluids.fluidHydrogen = new FluidColored("hydrogen",0xdbc1c1).setUnlocalizedName("hydrogen").setGaseous(true);
		if(!FluidRegistry.registerFluid(AdvancedRocketryFluids.fluidHydrogen))
		{
			AdvancedRocketryFluids.fluidHydrogen = FluidRegistry.getFluid("hydrogen");
		}

		AdvancedRocketryFluids.fluidRocketFuel = new FluidColored("rocketFuel", 0xe5d884).setUnlocalizedName("rocketFuel").setGaseous(false);
		if(!FluidRegistry.registerFluid(AdvancedRocketryFluids.fluidRocketFuel))
		{
			AdvancedRocketryFluids.fluidRocketFuel = FluidRegistry.getFluid("rocketFuel");
		}

		AdvancedRocketryFluids.fluidNitrogen = new FluidColored("nitrogen", 0x97a7e7);
		if(!FluidRegistry.registerFluid(AdvancedRocketryFluids.fluidNitrogen))
		{
			AdvancedRocketryFluids.fluidNitrogen = FluidRegistry.getFluid("nitrogen");
		}

		AtmosphereRegister.getInstance().registerHarvestableFluid(AdvancedRocketryFluids.fluidNitrogen);
		AtmosphereRegister.getInstance().registerHarvestableFluid(AdvancedRocketryFluids.fluidHydrogen);
		AtmosphereRegister.getInstance().registerHarvestableFluid(AdvancedRocketryFluids.fluidOxygen);

		blockOxygenFluid = new BlockFluid(AdvancedRocketryFluids.fluidOxygen, Material.WATER).setUnlocalizedName("oxygenFluidBlock").setCreativeTab(CreativeTabs.MISC);
		blockHydrogenFluid = new BlockFluid(AdvancedRocketryFluids.fluidHydrogen, Material.WATER).setUnlocalizedName("hydrogenFluidBlock").setCreativeTab(CreativeTabs.MISC);
		blockFuelFluid = new BlockFluid(AdvancedRocketryFluids.fluidRocketFuel, new MaterialLiquid(MapColor.YELLOW)).setUnlocalizedName("rocketFuelBlock").setCreativeTab(CreativeTabs.MISC);
		blockNitrogenFluid = new BlockFluid(AdvancedRocketryFluids.fluidNitrogen, Material.WATER).setUnlocalizedName("nitrogenFluidBlock").setCreativeTab(CreativeTabs.MISC);

		//Cables
		blockFluidPipe = new BlockLiquidPipe(Material.IRON).setUnlocalizedName("liquidPipe").setCreativeTab(tabAdvRocketry).setHardness(1f);
		blockDataPipe = new BlockDataCable(Material.IRON).setUnlocalizedName("dataPipe").setCreativeTab(tabAdvRocketry).setHardness(1f);
		blockEnergyPipe = new BlockEnergyCable(Material.IRON).setUnlocalizedName("energyPipe").setCreativeTab(tabAdvRocketry).setHardness(1f);

		LibVulpesBlocks.registerBlock(blockDataPipe.setRegistryName("dataPipe"));
		LibVulpesBlocks.registerBlock(blockEnergyPipe.setRegistryName("energyPipe"));
		LibVulpesBlocks.registerBlock(blockFluidPipe.setRegistryName("liquidPipe"));
		LibVulpesBlocks.registerBlock(blockLaunchpad.setRegistryName("launchpad"));
		LibVulpesBlocks.registerBlock(blockRocketBuilder.setRegistryName("rocketBuilder"));
		LibVulpesBlocks.registerBlock(blockStructureTower.setRegistryName("structureTower"));
		LibVulpesBlocks.registerBlock(blockGenericSeat.setRegistryName("seat"));
		LibVulpesBlocks.registerBlock(blockEngine.setRegistryName("rocketmotor"));
		LibVulpesBlocks.registerBlock(blockAdvEngine.setRegistryName("advRocketmotor"));
		LibVulpesBlocks.registerBlock(blockFuelTank.setRegistryName("fuelTank"));
		LibVulpesBlocks.registerBlock(blockFuelingStation.setRegistryName("fuelingStation"));
		LibVulpesBlocks.registerBlock(blockMonitoringStation.setRegistryName("monitoringStation"));
		LibVulpesBlocks.registerBlock(blockSatelliteBuilder.setRegistryName("satelliteBuilder"));
		LibVulpesBlocks.registerBlock(blockMoonTurf.setRegistryName("moonTurf"));
		LibVulpesBlocks.registerBlock(blockMoonStone.setRegistryName("moonStone"));
		LibVulpesBlocks.registerBlock(blockChiseledMoonStone.setRegistryName("chiseled_moonstone"));
		LibVulpesBlocks.registerBlock(blockSmoothMoonStone.setRegistryName("smooth_moonstone"));


		LibVulpesBlocks.registerBlock(blockHotTurf.setRegistryName("hotTurf"));
		LibVulpesBlocks.registerBlock(blockLoader.setRegistryName("loader"), ItemBlockMeta.class, false);
		LibVulpesBlocks.registerBlock(blockPrecisionAssembler.setRegistryName("precisionassemblingmachine"));
		LibVulpesBlocks.registerBlock(blockBlastBrick.setRegistryName("blastBrick"));
		LibVulpesBlocks.registerBlock(blockQuartzCrucible.setRegistryName("quartzcrucible"));
		LibVulpesBlocks.registerBlock(blockCrystallizer.setRegistryName("crystallizer"));
		LibVulpesBlocks.registerBlock(blockCuttingMachine.setRegistryName("cuttingMachine"));
		LibVulpesBlocks.registerBlock(blockAlienWood.setRegistryName("alienWood"));
		LibVulpesBlocks.registerBlock(blockAlienLeaves.setRegistryName("alienLeaves"));
		LibVulpesBlocks.registerBlock(blockAlienSapling.setRegistryName("alienSapling"));
		LibVulpesBlocks.registerBlock(blockObservatory.setRegistryName("observatory"));
		LibVulpesBlocks.registerBlock(blockConcrete.setRegistryName("concrete"));
		LibVulpesBlocks.registerBlock(blockPlanetSelector.setRegistryName("planetSelector"));
		LibVulpesBlocks.registerBlock(blockSatelliteControlCenter.setRegistryName("satelliteControlCenter"));
		LibVulpesBlocks.registerBlock(blockPlanetAnalyser.setRegistryName("planetAnalyser"));
		LibVulpesBlocks.registerBlock(blockGuidanceComputer.setRegistryName("guidanceComputer"));
		LibVulpesBlocks.registerBlock(blockArcFurnace.setRegistryName("arcFurnace"));
		LibVulpesBlocks.registerBlock(blockSawBlade.setRegistryName("sawBlade"));
		LibVulpesBlocks.registerBlock(blockLathe.setRegistryName("lathe"));
		LibVulpesBlocks.registerBlock(blockRollingMachine.setRegistryName("rollingMachine"));
		LibVulpesBlocks.registerBlock(blockPlatePress.setRegistryName("platePress"));
		LibVulpesBlocks.registerBlock(blockStationBuilder.setRegistryName("stationBuilder"));
		LibVulpesBlocks.registerBlock(blockElectrolyser.setRegistryName("electrolyser"));
		LibVulpesBlocks.registerBlock(blockChemicalReactor.setRegistryName("chemicalReactor"));
		LibVulpesBlocks.registerBlock(blockOxygenScrubber.setRegistryName("oxygenScrubber"));
		LibVulpesBlocks.registerBlock(blockOxygenVent.setRegistryName("oxygenVent"));
		LibVulpesBlocks.registerBlock(blockOxygenCharger.setRegistryName("oxygenCharger"));
		LibVulpesBlocks.registerBlock(blockAirLock.setRegistryName("airlock_door"));
		LibVulpesBlocks.registerBlock(blockLandingPad.setRegistryName("landingPad"));
		LibVulpesBlocks.registerBlock(blockWarpCore.setRegistryName("warpCore"));
		LibVulpesBlocks.registerBlock(blockWarpShipMonitor.setRegistryName("warpMonitor"));
		LibVulpesBlocks.registerBlock(blockOxygenDetection.setRegistryName("oxygenDetection"));
		LibVulpesBlocks.registerBlock(blockUnlitTorch.setRegistryName("unlitTorch"));
		LibVulpesBlocks.registerBlock(blocksGeode.setRegistryName("geode"));
		LibVulpesBlocks.registerBlock(blockOxygenFluid.setRegistryName("oxygenFluid"));
		LibVulpesBlocks.registerBlock(blockHydrogenFluid.setRegistryName("hydrogenFluid"));
		LibVulpesBlocks.registerBlock(blockFuelFluid.setRegistryName("rocketFuel"));
		LibVulpesBlocks.registerBlock(blockNitrogenFluid.setRegistryName("nitrogenFluid"));
		LibVulpesBlocks.registerBlock(blockVitrifiedSand.setRegistryName("vitrifiedSand"));
		LibVulpesBlocks.registerBlock(blockCharcoalLog.setRegistryName("charcoalLog"));
		LibVulpesBlocks.registerBlock(blockElectricMushroom.setRegistryName("electricMushroom"));
		LibVulpesBlocks.registerBlock(blockCrystal.setRegistryName("crystal"), ItemBlockCrystal.class, true );
		LibVulpesBlocks.registerBlock(blockOrientationController.setRegistryName("orientationController"));
		LibVulpesBlocks.registerBlock(blockGravityController.setRegistryName("gravityController"));
		LibVulpesBlocks.registerBlock(blockDrill.setRegistryName("drill"));
		LibVulpesBlocks.registerBlock(blockMicrowaveReciever.setRegistryName("microwaveReciever"));
		LibVulpesBlocks.registerBlock(blockLightSource.setRegistryName("lightSource"));
		LibVulpesBlocks.registerBlock(blockSolarPanel.setRegistryName("solarPanel"));
		LibVulpesBlocks.registerBlock(blockSuitWorkStation.setRegistryName("suitWorkStation"));
		LibVulpesBlocks.registerBlock(blockBiomeScanner.setRegistryName("biomeScanner"));
		LibVulpesBlocks.registerBlock(blockAtmosphereTerraformer.setRegistryName("terraformer"));
		LibVulpesBlocks.registerBlock(blockDeployableRocketBuilder.setRegistryName("deployableRocketBuilder"));
		LibVulpesBlocks.registerBlock(blockPressureTank.setRegistryName("liquidTank"), ItemBlockFluidTank.class, true);
		LibVulpesBlocks.registerBlock(blockIntake.setRegistryName("intake"));
		LibVulpesBlocks.registerBlock(blockCircleLight.setRegistryName("circleLight"));
		LibVulpesBlocks.registerBlock(blockSolarGenerator.setRegistryName("solarGenerator"));
		LibVulpesBlocks.registerBlock(blockDockingPort.setRegistryName("stationMarker"));
		LibVulpesBlocks.registerBlock(blockAltitudeController.setRegistryName("altitudeController"));
		LibVulpesBlocks.registerBlock(blockRailgun .setRegistryName("railgun"));
		LibVulpesBlocks.registerBlock(blockAstroBed .setRegistryName("astroBed"));
		LibVulpesBlocks.registerBlock(blockPlanetHoloSelector.setRegistryName("planetHoloSelector"));
		LibVulpesBlocks.registerBlock(blockLens.setRegistryName("blockLens"));
		LibVulpesBlocks.registerBlock(blockForceField.setRegistryName("forceField"));
		LibVulpesBlocks.registerBlock(blockForceFieldProjector.setRegistryName("forceFieldProjector"));
		LibVulpesBlocks.registerBlock(blockPipeSealer.setRegistryName("pipeSealer"));
		LibVulpesBlocks.registerBlock(blockSpaceElevatorController.setRegistryName("spaceElevatorController"));
		LibVulpesBlocks.registerBlock(blockBeacon.setRegistryName("beacon"));
		LibVulpesBlocks.registerBlock(blockAlienPlanks.setRegistryName("planks"));
		LibVulpesBlocks.registerBlock(blockThermiteTorch.setRegistryName("thermiteTorch"));

		if(zmaster587.advancedRocketry.api.Configuration.enableGravityController)
			LibVulpesBlocks.registerBlock(blockGravityMachine.setRegistryName("gravityMachine"));

		//TODO, use different mechanism to enable/disable drill
		if(zmaster587.advancedRocketry.api.Configuration.enableLaserDrill)
			LibVulpesBlocks.registerBlock(blockSpaceLaser.setRegistryName("spaceLaser"));


		//Register Allowed Products
		materialRegistry.registerMaterial(new zmaster587.libVulpes.api.material.Material("TitaniumAluminide", "pickaxe", 1, 0xaec2de, AllowedProducts.getProductByName("PLATE").getFlagValue() | AllowedProducts.getProductByName("INGOT").getFlagValue() | AllowedProducts.getProductByName("NUGGET").getFlagValue() | AllowedProducts.getProductByName("DUST").getFlagValue() | AllowedProducts.getProductByName("STICK").getFlagValue() | AllowedProducts.getProductByName("BLOCK").getFlagValue() | AllowedProducts.getProductByName("GEAR").getFlagValue() | AllowedProducts.getProductByName("SHEET").getFlagValue(), false));
		materialRegistry.registerMaterial(new zmaster587.libVulpes.api.material.Material("TitaniumIridium", "pickaxe", 1, 0xd7dfe4, AllowedProducts.getProductByName("PLATE").getFlagValue() | AllowedProducts.getProductByName("INGOT").getFlagValue() | AllowedProducts.getProductByName("NUGGET").getFlagValue() | AllowedProducts.getProductByName("DUST").getFlagValue() | AllowedProducts.getProductByName("STICK").getFlagValue() | AllowedProducts.getProductByName("BLOCK").getFlagValue() | AllowedProducts.getProductByName("GEAR").getFlagValue() | AllowedProducts.getProductByName("SHEET").getFlagValue(), false));

		materialRegistry.registerOres(LibVulpes.tabLibVulpesOres);

		proxy.preInitBlocks();
	}
}
