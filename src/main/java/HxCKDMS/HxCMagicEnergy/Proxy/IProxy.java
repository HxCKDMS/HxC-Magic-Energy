package HxCKDMS.HxCMagicEnergy.Proxy;

import cpw.mods.fml.common.event.*;

public interface IProxy {
    void preInit(FMLPreInitializationEvent event);
    void init(FMLInitializationEvent event);
    void postInit(FMLPostInitializationEvent event);
}
