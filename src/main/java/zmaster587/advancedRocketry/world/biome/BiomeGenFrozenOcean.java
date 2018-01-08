package zmaster587.advancedRocketry.world.biome;

import net.minecraft.block.BlockStone;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.monster.EntityGuardian;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.init.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.ChunkPrimer;
import zmaster587.advancedRocketry.api.AdvancedRocketryBlocks;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class BiomeGenFrozenOcean extends BiomeBase {


    public BiomeGenFrozenOcean(int id, boolean b)
    {
        super((CustomBiomeProperties) new CustomBiomeProperties("Frozen Ocean").setRainDisabled().setBaseHeight(1.5f).setHeightVariation(.7f)
                .setRainfall(0).setTemperature
                (0.3f));

        this.setRegistryName(new ResourceLocation("advancedrocketry:frozen ocean"));
//		registerBiome(biomeId, "Moon", this);

        //cold and dry
        this.decorator.generateFalls=false;
        this.decorator.flowersPerChunk=0;
        this.decorator.grassPerChunk=0;
        this.decorator.treesPerChunk=0;
        this.decorator.mushroomsPerChunk=0;
        this.fillerBlock = Blocks.PACKED_ICE.getDefaultState();
        this.topBlock =Blocks.PACKED_ICE.getDefaultState();
        //tell our generator, to generate it as if it was a desert
        this.desert_like = true;
        this.surfacedepth=5;
        this.fillerdepth = 10;
        stones.add(new stonegenSettings(
                Blocks.STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.ANDESITE),
                10,15,0,128,16,0
        ));
        this.spawnableWaterCreatureList.add(new Biome.SpawnListEntry(EntitySquid.class, 10, 4, 4));
        this.spawnableWaterCreatureList.add(new Biome.SpawnListEntry(EntityGuardian.class, 1, 1, 2));
    }

    @Override
    public void generateCustomBiomeTerrain(World world, Random random, ChunkPrimer primer, int x, int z, double p_generateBiomeTerrain_6_) {
        int i = world.getSeaLevel();
        IBlockState iblockstate = GRAVEL;
        IBlockState iblockstate1 = STONE;
        int j = -1;
        int k = (int)(p_generateBiomeTerrain_6_ / 3.0D + 3.0D + random.nextDouble() * 0.25D);
        int l = x & 15;
        int i1 = z & 15;
        BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();
        int ice_sheet_height = 200;
        for(int iter = 200; iter >=160;iter--) {
            IBlockState topstate = primer.getBlockState(i1, iter, l);
            if (topstate != STONE && topstate != GRAVEL) {

                { if(random.nextBoolean()){
                        primer.setBlockState(i1, iter, l, Blocks.PACKED_ICE.getDefaultState());
                }else
                if(iter >=165 && iter <=190) {
                    primer.setBlockState(i1, iter, l, Blocks.ICE.getDefaultState());
                }
            }
            }
        }
        for(int j1 = 255; j1 >= 0; --j1) {

                IBlockState iblockstate0 = primer.getBlockState(i1, j1, l);

                if(iblockstate0 == Blocks.AIR.getDefaultState() && j1<ice_sheet_height)
                {
                    primer.setBlockState(i1, j1, l,Blocks.WATER.getDefaultState());
                }

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
                            iblockstate = GRAVEL;
                            iblockstate1 = STONE;
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
                    }
                    }
                }
            }
        }


    @Override
    public List getSpawnableList(EnumCreatureType type) {

        if(type == EnumCreatureType.CREATURE)
        {
            return spawnableWaterCreatureList;
        }
        return new LinkedList<>();
    }

    @Override
    public float getSpawningChance() {
        return 0.5f; //Nothing spawns
    }

}
