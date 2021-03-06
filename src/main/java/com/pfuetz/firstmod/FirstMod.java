package com.pfuetz.firstmod;

import com.pfuetz.firstmod.handler.ConfigurationHandler;
import com.pfuetz.firstmod.init.ModBlocks;
import com.pfuetz.firstmod.init.ModItems;
import com.pfuetz.firstmod.proxy.IProxy;
import com.pfuetz.firstmod.reference.Reference;
import com.pfuetz.firstmod.utility.LogHelper;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID ,name = Reference.MOD_NAME, version=Reference.VERSION, guiFactory = Reference.GUI_FACTORY_CLASS)
public class FirstMod {
    @Mod.Instance(Reference.MOD_ID)
    public static FirstMod instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS,serverSide = Reference.Server_PROXY_CLASS)
    public static IProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){
        ConfigurationHandler.init(event.getSuggestedConfigurationFile());
        FMLCommonHandler.instance().bus().register(new ConfigurationHandler());

        ModItems.init();

        ModBlocks.init();
        LogHelper.info("Pre Initialization Complete!");
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event){
        LogHelper.info("Initialization Complete!");
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event){
        LogHelper.info("Post Initialization Complete!");
    }
}
