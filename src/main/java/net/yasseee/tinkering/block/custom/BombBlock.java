package net.yasseee.tinkering.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jspecify.annotations.NonNull;

import java.util.function.BiConsumer;

public class BombBlock extends Block {
    public BombBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected void onProjectileHit(Level level, BlockState state, BlockHitResult blockHit, Projectile projectile) {
        explode(level, blockHit.getBlockPos());
    }

    @Override
    public void stepOn(Level level, BlockPos pos, BlockState onState, Entity entity) {
        // Optional: ignore sneaking players if you want a way to walk safely
        if (!entity.isSteppingCarefully()) {
            explode(level, pos);
        }
        super.stepOn(level, pos, onState, entity);
    }

    @Override
    protected void onExplosionHit(BlockState state, ServerLevel level, BlockPos pos, Explosion explosion, BiConsumer<ItemStack, BlockPos> onHit) {
        // Handles chain reactions cleanly without dropping the BombBlock item
        explode(level, pos);
    }

    @Override
    public @NonNull BlockState playerWillDestroy(Level level, BlockPos pos, BlockState state, Player player) {
        if (!player.isCreative()) {
            explode(level, pos);
        }
        return super.playerWillDestroy(level, pos, state, player);
    }

    private void explode(Level level, BlockPos pos) {
        // Guard ensures the block only detonates once even if multiple triggers fire on the same tick
        if (!level.isClientSide() && level.getBlockState(pos).is(this)) {
            level.removeBlock(pos, false);
            level.explode(
                    null,
                    pos.getX() + 0.5,
                    pos.getY() + 0.5,
                    pos.getZ() + 0.5,
                    4.0F,
                    Level.ExplosionInteraction.TNT
            );
        }
    }
}
