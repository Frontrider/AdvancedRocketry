package zmaster587.advancedRocketry.world.biome;

import net.minecraft.block.BlockStone;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.util.ResourceLocation;
import zmaster587.advancedRocketry.api.AdvancedRocketryBlocks;

import java.util.LinkedList;
import java.util.List;

public class BiomeGenMoonMountain extends BiomeBase {

	//Gives extra height variation to the moon.
	//Its surprising how mutch better the world looks like, just because its not completly flat.
	public BiomeGenMoonMountain(int biomeId, boolean register) {
		super((CustomBiomeProperties) new CustomBiomeProperties("Moon Mountain").setRainDisabled().setBaseHeight(1.5f).setHeightVariation(.7f).setRainfall(0).setTemperature
				(0.3f));

		this.setRegistryName(new ResourceLocation("advancedrocketry:moon mountain"));
//		registerBiome(biomeId, "Moon", this);
		
		//cold and dry
		this.decorator.generateFalls=false;
		this.decorator.flowersPerChunk=0;
		this.decorator.grassPerChunk=0;
		this.decorator.treesPerChunk=0;
		this.decorator.mushroomsPerChunk=0;
		this.fillerBlock = AdvancedRocketryBlocks.blockMoonStone.getDefaultState();
		this.topBlock = AdvancedRocketryBlocks.blockMoonTurf.getDefaultState();
		//tell our generator, to generate it as if it was a desert
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
