package cat.institutmarianao.domain.repository;

import java.util.Collection;

import cat.institutmarianao.domain.Recipe;

public interface RecipeRepository {
	Collection<Recipe> getAllRecipes();

	Recipe getRecipe(String recipeId);

	Recipe votePositive(String recipeId);

	Recipe voteNegative(String recipeId);

}
