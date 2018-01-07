package zmaster587.advancedRocketry.block.planet;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSandStone;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import zmaster587.advancedRocketry.AdvancedRocketry;

public class BlockStone extends Block {

    MapColor extraMapColor;

    public BlockStone() {
        super(Material.ROCK);
        setHarvestLevel("pickaxe", 0);

    }

    public Block setMapColor(MapColor color) {
        extraMapColor = color;
        this.setSoundType(SoundType.STONE);
        return this;
    }

    @Override
    public MapColor getMapColor(IBlockState state, IBlockAccess access, BlockPos pos) {
        return extraMapColor == null ? super.getMapColor(state,access,pos) : extraMapColor;
    }

}
