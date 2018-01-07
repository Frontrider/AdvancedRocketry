package zmaster587.advancedRocketry.world.biome;

import net.minecraft.init.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;

public class BiomeGenDusty extends BiomeBase {

    // Its quite unimpressive, and looks like a desert world,
    // but its intended to have no atmosphere,
    // (no cacti) or have a custom world gen.
    public BiomeGenDusty(int biomeId, boolean register) {
        super(new Biome.BiomeProperties("Dusty Rock").setRainDisabled().setBaseHeight(1f).setHeightVariation(0.01f).setRainfall(0).setTemperature
                (0.9f));

        this.setRegistryName(new ResourceLocation("advancedrocketry:Dusty Rock"));

        //hot and stinks
        this.decorator.generateFalls=false;
        this.decorator.flowersPerChunk=0;
        this.decorator.grassPerChunk=0;
        this.decorator.treesPerChunk=0;
        this.decorator.mushroomsPerChunk=0;
        this.fillerBlock = Blocks.SANDSTONE.getDefaultState();
        this.topBlock = Blocks.SAND.getDefaultState();
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
