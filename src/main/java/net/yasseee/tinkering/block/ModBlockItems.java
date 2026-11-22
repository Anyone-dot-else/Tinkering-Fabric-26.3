package net.yasseee.tinkering.block;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.references.BlockItemId;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Function;

public class ModBlockItems {

    public static Block register(BlockItemId id, Function<BlockBehaviour.Properties, Block>
            blockFactory, BlockBehaviour.Properties properties) {
        // Create the Block instance:
        Block block = ModBlocks.register(id.block(), blockFactory, properties);

        // Create the BlockItem instance:
        BlockItem blockItem = new BlockItem(block, new Item.Properties()
                .useBlockDescriptionPrefix().setId(id.item()));
        Registry.register(BuiltInRegistries.ITEM, id.item(), blockItem);

        return block;
    }

    public static final Block CONDENSED_DIRT = register(
        ModBlockIds.CONDENSED_DIRT,
            Block::new,
            BlockBehaviour.Properties.of()
                    .sound(SoundType.GRASS)
    );

    public static void onInitialize() {

    }
}
