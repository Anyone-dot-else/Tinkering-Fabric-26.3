package net.yasseee.tinkering.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.yasseee.tinkering.TinkeringFabric;

public class ModItemIds {

    public static ResourceKey<Item> create(String name) {
        // Creating the item key:
        return ResourceKey.create(Registries.ITEM, TinkeringFabric.id(name));
    }

    public static final ResourceKey<Item> SUSPICIOUS_SUBSTANCE = create("suspicious_substance");
    public static final ResourceKey<Item> CHISEL = create("chisel");
    public static final ResourceKey<Item> MIDAS_GLOVE= create("midas_glove");

}
