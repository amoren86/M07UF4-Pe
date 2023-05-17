package cat.institutmarianao.domain.repository;

import java.util.List;

public interface IngredientRepository {

	List<String> getIngredients(String recipeId);

}
