package minefantasy.mf2.api.crafting.carpenter;

import java.util.Comparator;

import net.minecraft.src.*;

/**
 * 
 * @author AnonymousProductions
 *
 */
class RecipeSorterCarpenter implements Comparator
{
    final CraftingManagerCarpenter craftingManager;

    RecipeSorterCarpenter(CraftingManagerCarpenter manager)
    {
        this.craftingManager = manager;
    }

    public int compareRecipes(ICarpenterRecipe recipe1, ICarpenterRecipe recipe2)
    {
        return recipe1 instanceof ShapelessCarpenterRecipes && recipe2 instanceof ShapedCarpenterRecipes ? 1 : (recipe2 instanceof ShapelessCarpenterRecipes && recipe1 instanceof ShapedCarpenterRecipes ? -1 : (recipe2.getRecipeSize() < recipe1.getRecipeSize() ? -1 : (recipe2.getRecipeSize() > recipe1.getRecipeSize() ? 1 : 0)));
    }

    public int compare(Object input1, Object input2)
    {
        return this.compareRecipes((ICarpenterRecipe)input1, (ICarpenterRecipe)input2);
    }
}
