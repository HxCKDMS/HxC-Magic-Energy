package HxCKDMS.HxCMagicEnergy.TileEntities;

import HxCKDMS.HxCMagicEnergy.Registry.Registry;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.ChunkPosition;

public class TileEntityMagicRune extends TileEntity {
    public boolean isMaster = false;
    public boolean isSlave = false;
    private ChunkPosition masterPosition = null;

    @Override
    public void readFromNBT(NBTTagCompound tagCompound) {
        isMaster = tagCompound.getBoolean("isMaster");
        isSlave = tagCompound.getBoolean("isSlave");
        if(isSlave) masterPosition = new ChunkPosition(tagCompound.getInteger("masterX"), tagCompound.getInteger("masterY"), tagCompound.getInteger("masterZ"));

        super.readFromNBT(tagCompound);
    }

    @Override
    public void writeToNBT(NBTTagCompound tagCompound) {
        tagCompound.setBoolean("isMaster", isMaster);
        tagCompound.setBoolean("isSlave", isSlave);

        if(isSlave && masterPosition != null) {
            tagCompound.setInteger("masterX", masterPosition.chunkPosX);
            tagCompound.setInteger("masterY", masterPosition.chunkPosY);
            tagCompound.setInteger("masterZ", masterPosition.chunkPosZ);
        }

        super.writeToNBT(tagCompound);
    }

    @Override
    public void updateEntity() {
        makeMultiBlock();

        if (isSlave) {
            if(masterPosition == null || worldObj.getTileEntity(masterPosition.chunkPosX, masterPosition.chunkPosY, masterPosition.chunkPosZ) == null || !((TileEntityMagicRune) worldObj.getTileEntity(masterPosition.chunkPosX, masterPosition.chunkPosY, masterPosition.chunkPosZ)).isMaster) isSlave = false;
        }
    }

    private void makeMultiBlock() {
        boolean hasFailed = false;

        XLoop:
        for (int x = xCoord - 1; x <= xCoord + 1; ++x) {
            for (int z = zCoord - 1; z <= zCoord + 1; ++z) {
                if (worldObj.getBlock(x, yCoord, z) != Registry.blockMagicRune) {
                    hasFailed = true;
                    isMaster = false;
                    break XLoop;
                }
            }
        }

        if (!hasFailed) {
            isMaster = true;

            for (int x = xCoord - 1; x <= xCoord + 1; ++x) {
                for (int z = zCoord - 1; z <= zCoord + 1; ++z) {
                    if (!(x == xCoord && z == zCoord)) {
                        ((TileEntityMagicRune) worldObj.getTileEntity(x, yCoord, z)).isSlave = true;
                        ((TileEntityMagicRune) worldObj.getTileEntity(x, yCoord, z)).isMaster = false;
                        ((TileEntityMagicRune) worldObj.getTileEntity(x, yCoord, z)).masterPosition = new ChunkPosition(xCoord, yCoord, zCoord);
                    }
                }
            }
        }
    }

    @Override
    public AxisAlignedBB getRenderBoundingBox() {
        return AxisAlignedBB.getBoundingBox(xCoord - 5, yCoord, zCoord - 5, xCoord + 5, yCoord + 5, zCoord + 5);
    }
}
