package net.yasseee.tinkering.block;

import net.minecraft.references.BlockItemId;
import net.minecraft.resources.Identifier;
import net.yasseee.tinkering.TinkeringFabric;

public class ModBlockIds {

    private static BlockItemId create(String name) {
        Identifier id = TinkeringFabric.id(name);
        return BlockItemId.create(id, id);
    }

    public static final BlockItemId CONDENSED_DIRT =  create("condensed_dirt");
    public static final BlockItemId HEALING_PAD = create("healing_pad");
    public static final BlockItemId MAGIC_BLOCK = create("magic_block");
    public static final BlockItemId BOMB_BLOCK = create("bomb_block");
}
