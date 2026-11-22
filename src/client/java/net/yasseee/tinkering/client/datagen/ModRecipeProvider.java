package net.yasseee.tinkering.client.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.advancements.Advancement;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Recipe;
import net.yasseee.tinkering.block.ModBlocks;
import org.jspecify.annotations.NonNull;

import java.util.concurrent.CompletableFuture;

import static net.yasseee.tinkering.item.ModItems.*;
import static net.yasseee.tinkering.block.ModBlockItems.*;
import static net.minecraft.world.item.Items.*;


public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected @NonNull RecipeProvider createRecipeProvider(
            HolderLookup.@NonNull Provider registries, @NonNull BootstrapContext<Recipe<?>> recipes,
            @NonNull BootstrapContext<Advancement> advancements) {
        return new RecipeProvider(recipes, advancements) {
            @Override
            public void buildRecipes() {
                HolderLookup.RegistryLookup<Item> itemLookup =
                        registries.lookupOrThrow(Registries.ITEM);

                twoByTwoPacker(RecipeCategory.BUILDING_BLOCKS, CONDENSED_DIRT, DIRT);
            }
        };
    }

    @Override
    public @NonNull String getName() {
        return "TinkeringFabricRecipeProvider";
    }
}
