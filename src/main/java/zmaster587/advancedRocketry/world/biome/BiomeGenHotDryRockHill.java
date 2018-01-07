package zmaster587.advancedRocketry.world.biome;

import net.minecraft.block.BlockSand;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;

public class BiomeGenHotDryRockHill extends Biome {

	private static final IBlockState RED_SAND = Blocks.SAND.getDefaultState().withProperty(BlockSand.VARIANT, BlockSand.EnumType.RED_SAND);


	public BiomeGenHotDryRockHill(int biomeId, boolean register) {
		super(new BiomeProperties("Hot Dry Rock Hill").setRainDisabled().setBaseHeight(1.5f).setHeightVariation(0.1f).setRainfall(0).setTemperature
				(0.9f));
		
        this.setRegistryName(new ResourceLocation("advancedrocketry:Hot Dry Rock Hill"));
		
		//hot and stinks
		this.decorator.generateFalls=false;
		this.decorator.flowersPerChunk=0;
		this.decorator.grassPerChunk=0;
		this.decorator.treesPerChunk=0;
		this.decorator.mushroomsPerChunk=0;
		this.fillerBlock = Blocks.RED_SANDSTONE.getDefaultState();
		this.topBlock = RED_SAND;
	}
	
	@Override
	public float getSpawningChance() {
		return 0f; //Nothing spawns
	}
	
	@Override
	public int getSkyColorByTemp(float p_76731_1_) {
		return 0x664444;
	}
}
