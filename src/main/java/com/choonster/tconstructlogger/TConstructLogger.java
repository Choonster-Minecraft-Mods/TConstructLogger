package com.choonster.tconstructlogger;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;


@Mod(modid = Constants.MODID, name = Constants.MODNAME, dependencies = "required-after:TConstruct;after:ExtraTiC")
public class TConstructLogger {

	@Instance(Constants.MODID)
	public static TConstructLogger instance;

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		MaterialsLogger.log();
	}
}
