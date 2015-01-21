package com.choonster.tconstructlogger;

import au.com.bytecode.opencsv.CSVWriter;
import tconstruct.library.TConstructRegistry;
import tconstruct.library.tools.ToolMaterial;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

public class MaterialsLogger {

	public static void log() {
		try {
			Logger.info("Logging ToolMaterials...");
			CSVWriter writer = new CSVWriter(new FileWriter(Constants.MATERIALS_FILE));
			writer.writeNext(new String[]{
					"materialID",
					"materialName",
					"harvestLevel",
					"durability",
					"miningspeed",
					"attack",
					"handleModifier",
					"reinforced",
					"stonebound",
					"tipStyle",
					"primaryColor"
			});

			int numLogged = 0;

			HashMap<Integer, ToolMaterial> materials = TConstructRegistry.toolMaterials;
			for (Entry<Integer, ToolMaterial> entry : materials.entrySet()) {
				ToolMaterial material = entry.getValue();
				writer.writeNext(new String[]{
						entry.getKey().toString(),
						material.name(),
						String.valueOf(material.harvestLevel()),
						String.valueOf(material.durability()),
						String.valueOf(material.toolSpeed()),
						String.valueOf(material.attack()),
						String.valueOf(material.handleDurability()),
						String.valueOf(material.reinforced()),
						String.valueOf(material.shoddy()),
						material.style(),
						String.format("%x", material.primaryColor()),
				});
				numLogged++;
			}

			writer.close();
			Logger.info("Logged %d materials to %s.", numLogged, Constants.MATERIALS_FILE);
		} catch (IOException exception) {
			Logger.error(exception, "Exception while logging materials");
		}
	}
}
