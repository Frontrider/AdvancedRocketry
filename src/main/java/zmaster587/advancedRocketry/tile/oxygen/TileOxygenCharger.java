package zmaster587.advancedRocketry.tile.oxygen;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.IFluidContainerItem;
import zmaster587.advancedRocketry.api.AdvancedRocketryFluids;
import zmaster587.advancedRocketry.api.armor.IModularArmor;
import zmaster587.advancedRocketry.armor.ItemSpaceArmor;
import zmaster587.advancedRocketry.inventory.modules.IModularInventory;
import zmaster587.advancedRocketry.inventory.modules.ModuleBase;
import zmaster587.advancedRocketry.inventory.modules.ModuleLiquidIndicator;
import zmaster587.advancedRocketry.inventory.modules.ModulePower;
import zmaster587.libVulpes.tile.TileInventoriedRFConsumerTank;

public class TileOxygenCharger extends TileInventoriedRFConsumerTank implements IModularInventory {
	public TileOxygenCharger() {
		super(1000, 2, 16000);
	}

	@Override
	public int[] getAccessibleSlotsFromSide(int slots) {
		return new int[] {};
	}

	@Override
	public boolean isItemValidForSlot(int slot, ItemStack stack) {
		return false;
	}

	@Override
	public int fill(ForgeDirection from, FluidStack resource, boolean doFill) {

		if(resource.getFluidID() == AdvancedRocketryFluids.fluidOxygen.getID() ||
				resource.getFluidID() == AdvancedRocketryFluids.fluidHydrogen.getID())
			return super.fill(from, resource, doFill);
		return 0;
	}

	@Override
	public boolean canFill(ForgeDirection from, Fluid fluid) {
		return fluid.getID() == FluidRegistry.getFluidID(AdvancedRocketryFluids.fluidOxygen) || fluid.getID() == FluidRegistry.getFluidID(AdvancedRocketryFluids.fluidHydrogen);
	}	

	@Override
	public int getPowerPerOperation() {
		return 1;
	}

	@Override
	public boolean canPerformFunction() {
		if(!worldObj.isRemote) {
			for( Object player : this.worldObj.getEntitiesWithinAABB(EntityPlayer.class, AxisAlignedBB.getBoundingBox(this.xCoord, this.yCoord, this.zCoord, this.xCoord + 1, this.yCoord + 2, this.zCoord + 1))) {
				ItemStack stack = ((EntityPlayer)player).getEquipmentInSlot(3);

				//Check for O2 fill
				if(stack != null && stack.getItem() instanceof ItemSpaceArmor) {
					FluidStack fluidStack = this.drain(ForgeDirection.UNKNOWN, 1, false);

					if(((ItemSpaceArmor)stack.getItem()).getAirRemaining(stack) < ((ItemSpaceArmor)stack.getItem()).getMaxAir() &&
							fluidStack != null && fluidStack.getFluid().getID() == AdvancedRocketryFluids.fluidOxygen.getID() && fluidStack.amount > 0)  {
						this.drain(ForgeDirection.UNKNOWN, 1, true);
						((ItemSpaceArmor)stack.getItem()).increment(stack, 100);
						
						return true;
					}
				}

				//Check for H2 fill (possibly merge with O2 fill
				if(stack != null && stack.getItem() instanceof IModularArmor) {
					IInventory inv = ((IModularArmor)stack.getItem()).loadModuleInventory(stack);

					FluidStack fluidStack = this.drain(ForgeDirection.UNKNOWN, 100, false);
					if(fluidStack != null) {
						for(int i = 0; i < inv.getSizeInventory(); i++) {
							ItemStack module = inv.getStackInSlot(i);
							if(module != null && module.getItem() instanceof IFluidContainerItem) {
								int amtFilled = ((IFluidContainerItem)module.getItem()).fill(module, fluidStack, true);
								if(amtFilled == 100) {
									this.drain(ForgeDirection.UNKNOWN, 100, true);
									
									((IModularArmor)stack.getItem()).saveModuleInventory(stack, inv);
									
									return true;
								}
							}
						}
					}
				}
				
				return false;
			}
		}
		return false;
	}

	@Override
	public void performFunction() {

	}

	@Override
	public List<ModuleBase> getModules(int ID, EntityPlayer player) {
		ArrayList<ModuleBase> modules = new ArrayList<ModuleBase>();

		modules.add(new ModulePower(18, 20, this));
		modules.add(new ModuleLiquidIndicator(32, 20, this));
		//modules.add(toggleSwitch = new ModuleToggleSwitch(160, 5, 0, "", this, TextureResources.buttonToggleImage, 11, 26, getMachineEnabled()));
		//TODO add itemStack slots for liqiuid
		return modules;
	}

	@Override
	public String getModularInventoryName() {
		return "tile.oxygenCharger.name";
	}

	@Override
	public boolean canInteractWithContainer(EntityPlayer entity) {
		return true;
	}
}
