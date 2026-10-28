// Functional Storage Compacting Recipe Category

package com.buuz135.functionalstorage.compat.jei;

import com.buuz135.functionalstorage.FunctionalStorage;
import com.buuz135.functionalstorage.recipe.CustomCompactingRecipe;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.category.IRecipeCategory;
import mezz.jei.api.recipe.types.IRecipeType;
import net.minecraft.network.chat.Component;

public class CompactingRecipeCategory implements IRecipeCategory<CustomCompactingRecipe> {

    public static final IRecipeType<CustomCompactingRecipe> TYPE = IRecipeType.create(FunctionalStorage.MOD_ID, "custom_compacting", CustomCompactingRecipe.class);

    private final IDrawable icon;

    public CompactingRecipeCategory(IGuiHelper guiHelper) {
        this.icon = guiHelper.createDrawableItemLike(FunctionalStorage.COMPACTING_DRAWER);
    }

    @Override
    public IRecipeType<CustomCompactingRecipe> getRecipeType() {
        return TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.literal("Custom Compacting");
    }

    @Override
    public int getWidth() {
        return 64;
    }

    @Override
    public int getHeight() {
        return 64;
    }

    @Override
    public IDrawable getIcon() {
        return icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, CustomCompactingRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 8, 40).add(recipe.lowerStack());
        builder.addSlot(RecipeIngredientRole.OUTPUT, 24, 8).add(recipe.higherStack());
    }
}
