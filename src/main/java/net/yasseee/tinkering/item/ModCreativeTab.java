package net.yasseee.tinkering.item;

import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.yasseee.tinkering.TinkeringFabric;

import static net.yasseee.tinkering.item.ModItems.*;
import static net.yasseee.tinkering.block.ModBlockItems.*;

public class ModCreativeTab {

    public static final ResourceKey<CreativeModeTab> MOD_TAB_KEY = ResourceKey.create(
            BuiltInRegistries.CREATIVE_MODE_TAB.key(), TinkeringFabric.id("creative_tab")
    );

    public static final CreativeModeTab MOD_TAB = Registry.register(
            BuiltInRegistries.CREATIVE_MODE_TAB,
            MOD_TAB_KEY,
            FabricCreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.SUSPICIOUS_SUBSTANCE))
                    .title(Component.translatable("creativeTab.tinkering-fabric"))
                    .displayItems((params, out) -> {

                        out.accept(SUSPICIOUS_SUBSTANCE);
                        out.accept(CHISEL);
                        out.accept(MIDAS_GLOVE);
                        out.accept(CONDENSED_DIRT.asItem());

                    }).build()
            );

    public static void onInitialize() {

    }
}
