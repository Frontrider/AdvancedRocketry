package zmaster587.advancedRocketry.block.planet;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockPlanetSoil extends Block {

	MapColor extraMapColor;
	
	public BlockPlanetSoil() {
		super(Material.GROUND);
		setHarvestLevel("shovel", 0);
	}
	
	public Block setMapColor(MapColor color) {
		extraMapColor = color;
		return this;
	}

	@Override//TODO colour for soil?
	// yes, override.
	public MapColor getMapColor(IBlockState state, IBlockAccess access, BlockPos pos) {
		return extraMapColor == null ? super.getMapColor(state,access,pos) : extraMapColor;
	}
}
