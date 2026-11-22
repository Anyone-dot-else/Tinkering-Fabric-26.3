package net.yasseee.tinkering.item.custom;

import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

import static net.minecraft.world.level.block.Blocks.*;

import java.util.Map;

public class ChiselItem extends Item {

    private static final Map<Block, Block> CHISEL_MAP = Map.of(
            STONE, STONE_BRICKS,
            DEEPSLATE, DEEPSLATE_BRICKS,
            POLISHED_BLACKSTONE, POLISHED_BLACKSTONE_BRICKS,
            MUD, MUD_BRICKS,
            QUARTZ_BLOCK, QUARTZ_BRICKS,
            SULFUR, SULFUR_BRICKS,
            PRISMARINE, PRISMARINE_BRICKS,
            CINNABAR, CINNABAR_BRICKS,
            RESIN_BLOCK, RESIN_BRICKS,
            END_STONE, END_STONE_BRICKS
            );

    public ChiselItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        Block block = level.getBlockState(context.getClickedPos()).getBlock();

        if(CHISEL_MAP.containsKey(block) && !level.isClientSide()) {
            level.setBlockAndUpdate(context.getClickedPos(), CHISEL_MAP
                    .get(block).defaultBlockState());

            context.getItemInHand().hurtAndBreak(1, context.getPlayer(),
                    context.getHand());
        }

        return InteractionResult.SUCCESS;
    }
}
