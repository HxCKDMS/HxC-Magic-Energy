package HxCKDMS.HxCMagicEnergy.Blocks;

import HxCKDMS.HxCMagicEnergy.TileEntities.TileEntityMagicRune;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockMagicRune extends BlockContainer {
    public BlockMagicRune(Material material, CreativeTabs creativeTabs) {
        super(material);
        setUnlocalizedName("BlockMagicRune");
        setCreativeTab(creativeTabs);
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileEntityMagicRune();
    }

    @Override
    public int getRenderType() {
        return -1;
    }

    @Override
    public boolean isFullBlock() {
        return false;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public boolean shouldSideBeRendered(IBlockAccess worldIn, int x, int y, int z, int side) {
        return true;
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }
}
