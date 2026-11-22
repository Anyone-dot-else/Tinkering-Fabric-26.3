package net.yasseee.tinkering.client.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TexturedModel;
import org.jspecify.annotations.NonNull;

import static net.yasseee.tinkering.item.ModItems.*;
import static net.yasseee.tinkering.block.ModBlockItems.*;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricPackOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockModelGenerators) {
        blockModelGenerators.createTrivialCube(CONDENSED_DIRT);
        blockModelGenerators.createTrivialBlock(BOMB_BLOCK, TexturedModel.COLUMN_ALT);
        blockModelGenerators.createTrivialCube(HEALING_PAD);
        blockModelGenerators.createTrivialCube(MAGIC_BLOCK);
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerators) {
        itemModelGenerators.generateFlatItem(SUSPICIOUS_SUBSTANCE, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(CHISEL, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(MIDAS_GLOVE, ModelTemplates.FLAT_ITEM);
    }

    @Override
    public @NonNull String getName() {
        return "TinkeringFabricModelProvider";
    }
}
