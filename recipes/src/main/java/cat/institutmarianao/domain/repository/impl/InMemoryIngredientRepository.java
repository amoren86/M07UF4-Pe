package cat.institutmarianao.domain.repository.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cat.institutmarianao.domain.repository.IngredientRepository;

public class InMemoryIngredientRepository implements IngredientRepository {
	private final Map<String, List<String>> ingredients = new HashMap<>();

	public InMemoryIngredientRepository() {

		List<String> ingredients1 = new ArrayList<>();

		ingredients1.add("1 zanahoria");
		ingredients1.add("100 g de mantequilla");
		ingredients1.add("¼ de cebolla grande");
		ingredients1.add("120 g de maíz en grano");
		ingredients1.add("½ diente de ajo");
		ingredients1.add("50 g de harina de trigo de todo uso");
		ingredients1.add("600 ml de caldo de verduras");
		ingredients1.add("1 patata grande");
		ingredients1.add("60 g de panceta curada");
		ingredients1.add("50 ml de nata líquida para cocinar");
		ingredients1.add("Sal y pimienta negra recién molida (al gusto de cada casa)");
		ingredients1.add("60 g de panceta curada");
		ingredients1.add("Para decorar un poco: Cebollino fresco");

		ingredients.put("1", ingredients1);

		List<String> ingredients2 = new ArrayList<>();

		ingredients2.add("1,5 kg. de aguja de ternera sin hueso");
		ingredients2.add("2 cebollas");
		ingredients2.add("4 dientes de ajos");
		ingredients2.add("2 zanahorias grandes");
		ingredients2.add("6 patatas medianas (a ser posible gallegas)");
		ingredients2.add("6 cucharadas de aceite de oliva virgen extra");
		ingredients2.add("1 vaso de vino tinto (220 ml.)");
		ingredients2.add("Sal y pimienta negra recién molida (al gusto)");
		ingredients2.add("750 ml. de caldo de carne");
		ingredients2.add("2 tomates grandes maduros");
		ingredients2.add("1 hoja de laurel, orégano, perejil fresco, tomillo y romero");

		ingredients.put("2", ingredients2);

		List<String> ingredients3 = new ArrayList<>();

		ingredients3.add("4 peras grandes (os recomiendo la variedad Abate Fetel)");
		ingredients3.add("1/2 l. de vino tinto, hemos utilizado un mencía de la DO Ribeira Sacra.");
		ingredients3.add("150 g. de azúcar");
		ingredients3.add("1 rama de canela");
		ingredients3.add("Cáscara de naranja");
		ingredients3.add("Cáscara de limón");
		ingredients3.add(
				"Para aromatizar el almíbar de vino puede usarse también vainilla, cardamomo, incluso anís o un licor dulce.");

		ingredients.put("3", ingredients3);
	}

	@Override
	public List<String> getIngredients(String recipeId) {
		return ingredients.get(recipeId);
	}
}
