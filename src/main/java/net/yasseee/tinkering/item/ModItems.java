package net.yasseee.tinkering.item;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.yasseee.tinkering.item.custom.ChiselItem;
import net.yasseee.tinkering.item.custom.MidasGloveItem;

import java.util.function.Function;

public class ModItems {

    public static Item register(ResourceKey<Item> itemKey, Function<Item.Properties,
            Item> itemFactory, Item.Properties settings) {
        // Create the item:
        Item item = itemFactory.apply(settings.setId(itemKey));
        // Register the item:
        Registry.register(BuiltInRegistries.ITEM, itemKey, item);

        return item;
    }

    public static Item registerSimple(ResourceKey<Item> itemKey) {
        return register(itemKey, Item::new, new Item.Properties());
    }

    public static final Item SUSPICIOUS_SUBSTANCE = registerSimple(
            ModItemIds.SUSPICIOUS_SUBSTANCE
    );
    public static final Item CHISEL = register(
            ModItemIds.CHISEL,
            properties -> new ChiselItem(properties.durability(32)),
            new Item.Properties()
    );
    public static final Item MIDAS_GLOVE = register(
            ModItemIds.MIDAS_GLOVE,
            properties -> new MidasGloveItem(properties.durability(32)),
            new Item.Properties()
    );

    public static void onInitialize() {

    }

}
