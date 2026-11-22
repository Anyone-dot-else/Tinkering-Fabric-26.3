package net.yasseee.tinkering.item.custom;

import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class MidasGloveItem extends Item {

    public MidasGloveItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        Block block = level.getBlockState(context.getClickedPos()).getBlock();

        if(!level.isClientSide()) {
            level.setBlockAndUpdate(context.getClickedPos(),
                    Blocks.GOLD_BLOCK.defaultBlockState());
            context.getItemInHand().hurtAndBreak(1, context.getPlayer(),
                    context.getHand());
        }
        return InteractionResult.SUCCESS;
    }
}

