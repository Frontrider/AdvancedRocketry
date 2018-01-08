package zmaster587.advancedRocketry.world.biome;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import net.minecraft.block.BlockStone;
import net.minecraft.init.Blocks;
import zmaster587.advancedRocketry.AdvancedRocketry;
import zmaster587.advancedRocketry.api.AdvancedRocketryBlocks;
import net.minecraft.block.Block;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;

public class BiomeGenMoon extends BiomeBase {

	public BiomeGenMoon(int biomeId, boolean register) {
		super((CustomBiomeProperties) new CustomBiomeProperties("Moon").setRainDisabled().setBaseHeight(1f).setHeightVariation(0.01f).setRainfall(0).setTemperature(0.3f));

		this.setRegistryName(new ResourceLocation("advancedrocketry:Moon"));
//		registerBiome(biomeId, "Moon", this);
		
		//cold and dry
		this.decorator.generateFalls=false;
		this.decorator.flowersPerChunk=0;
		this.decorator.grassPerChunk=0;
		this.decorator.treesPerChunk=0;
		this.decorator.mushroomsPerChunk=0;
		this.topBlock = AdvancedRocketryBlocks.blockMoonTurf.getDefaultState();
		this.fillerBlock = AdvancedRocketryBlocks.blockMoonStone.getDefaultState();
		this.desert_like = true;
		this.surfacedepth=5;
		this.fillerdepth = 10;
		stones.add(new stonegenSettings(
				Blocks.STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.ANDESITE),
				10,15,0,128,16,0
		));
	}
	
	@Override
	public List getSpawnableList(EnumCreatureType p_76747_1_) {
		return new LinkedList<>();
	}
	
	@Override
	public float getSpawningChance() {
		return 0f; //Nothing spawns
	}
}
