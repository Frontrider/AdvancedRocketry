package zmaster587.advancedRocketry.block.planet;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.BlockSand;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockDust extends BlockFalling {

    MapColor extraMapColor;

    public Block setMapColor(MapColor color) {
        extraMapColor = color;
        this.setSoundType(SoundType.SAND);
        return this;
    }

    @Override
    public MapColor getMapColor(IBlockState state, IBlockAccess access, BlockPos pos) {
        	return extraMapColor == null ? super.getMapColor(state,access,pos) : extraMapColor;
    }
}
