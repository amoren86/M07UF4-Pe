package cat.institutmarianao.domain.repository.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import cat.institutmarianao.domain.Category;
import cat.institutmarianao.domain.Difficulty;
import cat.institutmarianao.domain.Recipe;
import cat.institutmarianao.domain.repository.RecipeRepository;

public class InMemoryRecipeRepository implements RecipeRepository {

	private final Map<String, Recipe> recipes = new HashMap<>();

	public InMemoryRecipeRepository() {
		Recipe recipe1 = new Recipe(1, "Sopa de maíz o Corn chowder", Category.FIRSTS, Difficulty.SUPEREASY, 30, 2);

		Recipe recipe2 = new Recipe(2, "Guiso de ternera con patatas", Category.SECONDS, Difficulty.MEDIUM, 190, 6);

		Recipe recipe3 = new Recipe(3, "Peras al vino tinto con canela. Receta tradicional", Category.DESSERTS,
				Difficulty.EASY, 45, 4);

		recipes.put("1", recipe1);
		recipes.put("2", recipe2);
		recipes.put("3", recipe3);
	}

	@Override
	public Collection<Recipe> getAllRecipes() {
		return recipes.values();
	}

	@Override
	public Recipe votePositive(String recipeId) {
		Recipe recipe = recipes.get(recipeId);

		int positiveVotes = recipe.getPositiveVotes();
		recipe.setPositiveVotes(positiveVotes + 1);

		return recipe;
	}

	@Override
	public Recipe voteNegative(String recipeId) {
		Recipe recipe = recipes.get(recipeId);

		int negativeVotes = recipe.getNegativeVotes();
		recipe.setNegativeVotes(negativeVotes + 1);

		return recipe;
	}

	@Override
	public Recipe getRecipe(String recipeId) {
		return recipes.get(recipeId);
	}
}
