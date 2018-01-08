package zmaster587.advancedRocketry.world.biome;


import com.sun.istack.internal.NotNull;
import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.feature.WorldGenMinable;
import javax.annotation.Nullable;
import java.util.*;

/***
 * Base Biome class, containing all the planet specific generation code
 * Created to allow for deeper customization options.
 *
 */

public class BiomeBase extends Biome {
    //tell our generator, to generate it as if it was a desert. AKA, the filler block goes inside the rock layer, instead of just sitting on top.
    //Same effect as seen in overworld deserts.
    boolean desert_like = false;
    protected int fillerdepth =2;
    protected int surfacedepth = 1;
    private  boolean decorating = false;
    protected ArrayList<stonegenSettings> stones = new ArrayList<>();
    private String biomeName;
    public CustomBiomeProperties properties;
    public BiomeBase(CustomBiomeProperties customBiomeProperties) {

        super(customBiomeProperties);
        this.properties = customBiomeProperties;
        this.biomeName = customBiomeProperties.biomeName;
    }

    @Override
    public void genTerrainBlocks(World world, Random random, ChunkPrimer primer, int x, int z, double p_genTerrainBlocks_6_) {
        generateCustomBiomeTerrain(world, random, primer, x, z, p_genTerrainBlocks_6_);
    }

    @Override
    public void decorate(World world, Random random, BlockPos pos) {
        if (this.decorating) {
            throw new RuntimeException("Already decorating");
        } else {

                this.decorating = true;
                {
                    for(stonegenSettings data :stones){
                            WorldGenMinable gen = new WorldGenMinable(data.getStone(), data.getASize(random));
                            BlockPos genpos = pos.add(random.nextInt(16),
                                    random.nextInt(data.getHeightRange())+data.getMinheight(),
                                    random.nextInt(16));
                            gen.generate(world, random, genpos);
                }
                    this.decorating = false;
            }
        }
    }

    @Override
    public String getBiomeName()
    {
        return biomeName+" customized name";
    }

    public  void generateCustomBiomeTerrain(World world, Random random, ChunkPrimer primer,
                                            int x, int z, double p_generateBiomeTerrain_6_) {
        int i = world.getSeaLevel();
        IBlockState iblockstate = this.topBlock;
        IBlockState iblockstate1 = this.fillerBlock;
        int j = -1;
        int k = (int)(p_generateBiomeTerrain_6_ / 3.0D + 3.0D + random.nextDouble() * 0.25D);
        int l = x & 15;
        int i1 = z & 15;
        BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();

        for(int j1 = 255; j1 >= 0; --j1) {
            if (j1 <= random.nextInt(5)) {
                primer.setBlockState(i1, j1, l, BEDROCK);
            } else {
                IBlockState iblockstate2 = primer.getBlockState(i1, j1, l);
                if (iblockstate2.getMaterial() == Material.AIR) {
                    j = -1;
                } else if (iblockstate2.getBlock() == Blocks.STONE) {
                    if (j == -1) {
                        if (k <= 0) {
                            iblockstate = AIR;
                            iblockstate1 = STONE;
                        } else if (j1 >= i - 4 && j1 <= i + 1) {
                            iblockstate = this.topBlock;
                            iblockstate1 = this.fillerBlock;
                        }

                        if (j1 < i && (iblockstate == null || iblockstate.getMaterial() == Material.AIR)) {
                            if (this.getFloatTemperature(blockpos$mutableblockpos.setPos(x, j1, z)) < 0.15F) {
                                iblockstate = ICE;
                            } else {
                                iblockstate = WATER;
                            }
                        }

                        j = k;
                        if (j1 >= i - 1) {
                            primer.setBlockState(i1, j1, l, iblockstate);
                        } else if (j1 < i - 7 - k) {
                            iblockstate = AIR;
                            iblockstate1 = STONE;
                            primer.setBlockState(i1, j1, l, GRAVEL);
                        } else {
                            primer.setBlockState(i1, j1, l, iblockstate1);
                        }
                    } else if (j > 0) {
                        --j;
                        primer.setBlockState(i1, j1, l, iblockstate1);
                        if (j == 0 && desert_like && k > 1 && j1 >i-fillerdepth) {
                            j = random.nextInt(4) + Math.max(0, j1 - 63);
                            iblockstate1 = fillerBlock;
                            primer.setBlockState(i1, j1, l, iblockstate1);
                        }
                    }
                }
            }
        }

    }


    class stonegenSettings
    {
        private IBlockState stone;
        private int minsize;
        private int maxsize;
        private int minheight;
        private int maxheight;
        private int spawnchance_value;
        private int spawnchance_range;

        stonegenSettings(IBlockState stone,int minsize,int maxsize,int minheight,int maxheight,int spawnchance_range,int spawnchance_value)
        {
            this.stone = stone;
            if(maxsize > minsize) {
                this.minsize = minsize;
                this.maxsize = maxsize;
            }else
            {
                this.maxsize = minsize;
                this.minsize = maxsize;
            }
            if(maxheight > minheight) {
                this.minheight = minheight;
                this.maxheight = maxheight;
            }else{
                this.maxheight = minheight;
                this.minheight = maxheight;
            }
            if(spawnchance_range >spawnchance_value) {
                this.spawnchance_value = spawnchance_value;
                this.spawnchance_range = spawnchance_range;
            }
            else {
                this.spawnchance_range = spawnchance_value;
                this.spawnchance_value = spawnchance_range;
            }
        }

        public IBlockState getStone() {
            return stone;
        }

        public int getMinheight() {
            return minheight;
        }

        public int getMinsize() {
            return minsize;
        }

        public int getMaxsize() {
            return maxsize;
        }

        public int getSpawnchance_range() {
            return spawnchance_range;
        }

        public int getSpawnchance_value() {
            return spawnchance_value;
        }

        public int getMaxheight() {
            return maxheight;
        }

        public int getHeightRange()
        {
            return maxheight-minheight;
        }

        public int getSizeRange()
        {
            return maxsize-minsize;
        }

        public int getASize(Random random)
        {
            return  random.nextInt(getSizeRange())+minsize;
        }
    }


    public static class CustomBiomeProperties extends Biome.BiomeProperties {
        private final String biomeName;
        private float baseHeight = 0.1F;
        private float heightVariation = 0.2F;
        private float temperature = 0.5F;
        private float rainfall = 0.5F;
        private int waterColor = 16777215;
        private boolean enableSnow;
        private boolean enableRain = true;
        @Nullable
        private String baseBiomeRegName;
        private IBlockState material;
        private int sealevel=60;
        private boolean generateSnow;

        public CustomBiomeProperties(String name) {
            super(name);
            this.biomeName = name;
        }

        @Override
        @MethodsReturnNonnullByDefault
        @NotNull
        public Biome.BiomeProperties setTemperature(float tempature) {
            if (tempature > 0.1F && tempature < 0.2F) {
                throw new IllegalArgumentException("Please avoid temperatures in the range 0.1 - 0.2 because of snow");
            } else {
                this.temperature = tempature;
                return this;
            }
        }
        @Override
        @MethodsReturnNonnullByDefault
        @NotNull        public Biome.BiomeProperties setRainfall(float rainfall) {
            this.rainfall = rainfall;
            return this;
        }
        @Override
        @MethodsReturnNonnullByDefault
        @NotNull
        public Biome.BiomeProperties setBaseHeight(float baseheight) {
            this.baseHeight = baseheight;
            return this;
        }
        @Override
        @MethodsReturnNonnullByDefault
        @NotNull
        public Biome.BiomeProperties setHeightVariation(float heightvariation) {
            this.heightVariation = heightvariation;
            return this;
        }
        @Override
        @MethodsReturnNonnullByDefault
        @NotNull
        public Biome.BiomeProperties setRainDisabled() {
            this.enableRain = false;
            return this;
        }
        @Override
        @MethodsReturnNonnullByDefault
        @NotNull
        public Biome.BiomeProperties setSnowEnabled() {
            this.enableSnow = true;
            return this;
        }
        @Override
        @MethodsReturnNonnullByDefault
        @NotNull
        public Biome.BiomeProperties setWaterColor(int watercolor) {
            this.waterColor = watercolor;
            return this;
        }
        @Override
        @MethodsReturnNonnullByDefault
        @NotNull
        public Biome.BiomeProperties setBaseBiome(String baseBiome) {
            this.baseBiomeRegName = baseBiome;
            return this;
        }
        public String getBiomeName() {
            return biomeName;
        }

        public IBlockState getMaterial() {
            return material;
        }

        public void setMaterial(IBlockState material) {
            this.material = material;
        }

        public int getSealevel() {
            return sealevel;
        }

        public void setSealevel(int sealevel) {
            this.sealevel = sealevel;
        }

        public boolean isGenerateSnow() {
            return generateSnow;
        }

        public void setGenerateSnow(boolean generateSnow) {
            this.generateSnow = generateSnow;
        }

        public boolean isEnableSnow() {
            return enableSnow;
        }

        public void setEnableSnow(boolean enableSnow) {
            this.enableSnow = enableSnow;
        }

        public boolean isEnableRain() {
            return enableRain;
        }

        public void setEnableRain(boolean enableRain) {
            this.enableRain = enableRain;
        }

        public int getWaterColor() {
            return waterColor;
        }


        public float getRainfall() {
            return rainfall;
        }

        public float getTemperature() {
            return temperature;
        }


        public float getHeightVariation() {
            return heightVariation;
        }


        public float getBaseHeight() {
            return baseHeight;
        }

    }




}
