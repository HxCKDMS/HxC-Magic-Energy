package HxCKDMS.HxCMagicEnergy;

import HxCKDMS.HxCMagicEnergy.Proxy.IProxy;
import HxCKDMS.HxCMagicEnergy.Registry.Registry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

import static HxCKDMS.HxCMagicEnergy.Lib.References.*;

@Mod(modid = MOD_ID, name = MOD_NAME, version = VERSION, dependencies = "before:*")
public class HxCMagicEnergy {

    @SidedProxy(serverSide = SERVER_PROXY_LOCATION, clientSide = CLIENT_PROXY_LOCATION)
    public static IProxy proxy;

    @Mod.Instance(MOD_ID)
    public static HxCMagicEnergy instance;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) throws Throwable {
        Registry.preInit();
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {

    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }
}
