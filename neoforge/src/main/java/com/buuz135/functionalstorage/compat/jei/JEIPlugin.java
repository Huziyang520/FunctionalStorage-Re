// Functional Storage JEI Plugin

package com.buuz135.functionalstorage.compat.jei;

import com.buuz135.functionalstorage.FunctionalStorage;
import com.buuz135.functionalstorage.recipe.CustomCompactingRecipe;
import com.buuz135.functionalstorage.util.Utils;
import com.hrznstudio.titanium.util.RecipeUtil;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.registration.ISubtypeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.crafting.RecipeType;

import java.util.Collection;
import java.util.List;

@JeiPlugin
public class JEIPlugin implements IModPlugin {

    public static final Identifier PLUGIN_ID = Utils.resourceLocation(FunctionalStorage.MOD_ID, "main");

    private CompactingRecipeCategory compactingRecipeCategory;

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(compactingRecipeCategory = new CompactingRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    @SuppressWarnings("unchecked")
    public void registerRecipes(IRecipeRegistration registration) {
        var level = Minecraft.getInstance().level;
        if (level == null) return;
        RecipeType<CustomCompactingRecipe> type = (RecipeType<CustomCompactingRecipe>) (RecipeType<?>) FunctionalStorage.CUSTOM_COMPACTING_RECIPE_TYPE.value();
        List<CustomCompactingRecipe> recipes = RecipeUtil.getRecipes(level, type);
        registration.addRecipes(CompactingRecipeCategory.TYPE, recipes);
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addCraftingStation(CompactingRecipeCategory.TYPE,
                FunctionalStorage.COMPACTING_DRAWER,
                FunctionalStorage.FRAMED_COMPACTING_DRAWER,
                FunctionalStorage.SIMPLE_COMPACTING_DRAWER,
                FunctionalStorage.FRAMED_SIMPLE_COMPACTING_DRAWER);
    }

    @Override
    public void registerItemSubtypes(ISubtypeRegistration registration) {
        FunctionalStorage.DRAWER_TYPES.values().stream().flatMap(Collection::stream).forEach(blockWithTile -> registration.registerSubtypeInterpreter(blockWithTile.asItem(), new InventorySubtypeInterpreter()));
    }

    @Override
    public Identifier getPluginUid() {
        return PLUGIN_ID;
    }
}
