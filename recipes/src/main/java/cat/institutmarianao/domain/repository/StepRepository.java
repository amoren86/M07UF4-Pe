package cat.institutmarianao.domain.repository;

import java.util.List;

public interface StepRepository {

	List<String> getSteps(String recipeId);

}
