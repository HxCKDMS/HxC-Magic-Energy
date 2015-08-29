package HxCKDMS.HxCMagicEnergy.Proxy;

import HxCKDMS.HxCMagicEnergy.Client.Renderer.TileEntitySpecialRenderer.TESRMagicRune;
import HxCKDMS.HxCMagicEnergy.TileEntities.TileEntityMagicRune;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy implements IProxy {
    @Override
    public void preInit(FMLPreInitializationEvent event) {
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMagicRune.class, new TESRMagicRune());
    }

    @Override
    public void init(FMLInitializationEvent event) {

    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {

    }
}
