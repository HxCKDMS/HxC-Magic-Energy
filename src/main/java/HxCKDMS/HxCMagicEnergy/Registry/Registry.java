package HxCKDMS.HxCMagicEnergy.Registry;

import HxCKDMS.HxCMagicEnergy.Blocks.BlockMagicRune;
import HxCKDMS.HxCMagicEnergy.Lib.References;
import HxCKDMS.HxCMagicEnergy.TileEntities.TileEntityMagicRune;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.material.Material;

public class Registry {
    public static final CreativeTabHxCMagicEnergy creativeTabHxCMagicEnergy = new CreativeTabHxCMagicEnergy("HxCMagicEnergy");

    //BLOCKS
    public static BlockMagicRune blockMagicRune = new BlockMagicRune(Material.rock, creativeTabHxCMagicEnergy);

    //ITEMS




    public static void preInit() {
        registerBlocks();
        registerItems();
        registerTileEntities();
    }

    private static void registerBlocks() {
        GameRegistry.registerBlock(blockMagicRune, "BlockMagicRune");
    }

    private static void registerItems() {

    }

    private static void registerTileEntities() {
        GameRegistry.registerTileEntity(TileEntityMagicRune.class, References.MOD_ID + ":TileEntityMagicRune");
    }
}
