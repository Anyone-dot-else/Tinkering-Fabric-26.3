package net.yasseee.tinkering.block;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Function;

public class ModBlocks {

    public static Block register(ResourceKey<Block> id, Function<BlockBehaviour.Properties,
            Block> blockFactory, BlockBehaviour.Properties properties) {
        // Create the Block instance:
        Block block = blockFactory.apply(properties.setId(id));
        return Registry.register(BuiltInRegistries.BLOCK, id, block);
    }
}
