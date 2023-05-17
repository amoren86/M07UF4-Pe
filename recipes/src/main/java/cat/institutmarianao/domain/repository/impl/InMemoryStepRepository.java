package cat.institutmarianao.domain.repository.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cat.institutmarianao.domain.repository.StepRepository;

public class InMemoryStepRepository implements StepRepository {
	private final Map<String, List<String>> steps = new HashMap<>();

	public InMemoryStepRepository() {
		List<String> steps1 = new ArrayList<>();

		steps1.add(
				"Primero cortamos la panceta en pequeños cuadraditos y la doramos en la olla donde haremos la sopa. Una vez esté listo, dejamos los cuadrados de panceta sobre un plato con papel de cocina para que absorba el exceso de grasa.");
		steps1.add(
				"Sin retirar la grasa de la olla, añadimos la mantequilla e introducimos la cebolla bien picada para sofreírla, hasta que quede tierna y translúcida. Una vez esté lista la cebolla, añadimos el ajo muy picado y, un minuto después, echamos la harina. Removemos bien la harina para que se tueste ligeramente, durante 2 o 3 minutos.");
		steps1.add(
				"Pelamos la patata y la zanahoria. Picamos la zanahoria en cuadraditos pequeños y la patata en cuadraditos de 1 cm. más o menos.");
		steps1.add(
				"Añadimos el caldo y subimos el fuego hasta que eche a hervir. Entonces añadimos la patata y la zanahoria pelada y cortada en cuadraditos, el tomillo seco, la pimienta negra y la sal. Después bajamos el fuego y lo dejamos cocer a fuego lento durante 15 minutos.");
		steps1.add(
				"Una vez pasado este tiempo, añadimos los granos de maíz y los dejamos cocinar durante 5 minutos más, asegurándonos que las patatas están tiernas.");
		steps1.add(
				"Retiramos un cucharón de sopa, lo trituramos bien y lo volvemos a añadir para espesar nuestra sopa de forma natural. Añadimos el toque de la nata, aunque es opcional, le da un toque cremoso inconfundible.");
		steps1.add(
				"Una vez lista, servimos en platos o cuencos y le añadimos encima la panceta cocinada al principio y bien de pimienta molida. Un poco de cebollino fresco finamente cortado. Listo para disfrutar.");

		steps.put("1", steps1);

		List<String> steps2 = new ArrayList<>();

		steps2.add(
				"Limpiamos la carne de grasa y la troceamos en pedazos grandes. Calentamos un chorrito de aceite de oliva en una cazuela. Doramos la carne para que quede bien sellada por todos sus lados. Retiramos la carne de la cazuela y reservamos.");
		steps2.add(
				"En la misma cazuela y con el aceite de haber dorado la carne. Sofreímos las cebollas con los dientes de ajo, todo ello cortado en daditos. Cocinamos la cebolla a fuego lento durante 10 minutos, removiendo de vez en cuando.");
		steps2.add("Incorporamos las zanahorias cortadas en rodajitas y seguimos cocinando 10 minutos más.");
		steps2.add(
				"Agregamos los tomates lavados y cortados en dados y continuamos la cocción durante 8-10 minutos desde el momento en que vuelva a tomar calor la cazuela.");
		steps2.add(
				"Añadimos el vino tinto. Dejamos que se evapore el alcohol durante unos minutos antes de incorporar las hierbas aromáticas, el orégano, perejil, tomillo y romero.");
		steps2.add(
				"Podemos hacer un ramillete con las hierbas de rama para que nos resulte más sencillo retirarlas de la cazuela al final de la cocción.");
		steps2.add("Salpimentamos y añadimos la carne que tenemos reservada a la cazuela.");
		steps2.add(
				"Cubrimos con el caldo de carne y dejamos que comience a hervir antes de tapar la cazuela. Cocinamos la carne durante 2 horas a fuego medio con la cazuela tapada.");
		steps2.add(
				"Una vez que comprobamos que la carne está tierna y en su punto, la retiramos de la cazuela y la reservamos. Retiramos también las hierbas aromáticas de la salsa y las desechamos.");
		steps2.add(
				"Trituramos la salsa restante con una batidora. Posteriormente la pasamos por un pasapuré si queremos conseguir un resultado más fino. Volvemos a incorporar la carne en la salsa y reservamos.");
		steps2.add(
				"Pelamos las patatas y las cortamos en pedazos grandes. Cocemos las patatas cubriéndolas de agua, durante 10 minutos.  Una vez cocidas las patatas y aun duras, las escurrimos bien antes de proceder a freír las en abundante aceite. La idea es que adquieran una costra exterior.");
		steps2.add(
				"Escurrimos las patatas del aceite sobrante y las añadimos a la cazuela de la carne con su salsa. Continuamos la cocción de las patatas en la cazuela con la carne durante 15 minutos y la cazuela destapada.");
		steps2.add(
				"Servimos este guiso bien caliente, acompañando la carne con las patatas asadas y regada con parte de su salsa. Se trata de un lujo sencillo y sabroso que os dejará seguro, con ganas de más.");

		steps.put("2", steps2);

		List<String> steps3 = new ArrayList<>();
		steps3.add(
				"Pelamos las peras, dejándoles el rabito de la parte superior para poder luego manipularlas con facilidad. Si disponemos de un utensilio para extraerles el corazón lo hacemos, en caso contrario ya lo quitaremos  en el momento de degustarlas. Realizamos un corte horizontal en la base de las peras para que se asienten bien en la cazuela.");
		steps3.add(
				"Elegimos una olla/cazuela de base ancha para que nos entren perfectamente las 4 peras. Debe sobrar espacio, lo suficiente entre ellas para luego regarlas con el vino.");
		steps3.add(
				"Vertemos el vino y ponemos a calentar a fuego medio, cuando coja temperatura añadimos el azúcar y removemos para que se vaya integrando. Añadimos ahora la canela en rama, la cáscara de naranja y la de limón. Recordad que debemos quitarles la parte blanca para que no nos aporten amargor.");
		steps3.add(
				"Colocamos las peras en la cazuela, tapamos  y cocinamos 25-30 minutos a fuego medio. Es importante de vez en cuando, por lo menos cada 5 minutos, ir regando las peras varias veces con el almíbar de vino que se va cocinando. Según vayamos bañando la fruta, comprobaremos como va adquiriendo el color del vino tinto.");
		steps3.add(
				"Pasado el tiempo de cocción comprobamos con una brocheta o pincho el punto óptimo. Debe introducirse fácilmente hasta el corazón de la pera, cuya carne debe de estar tierna.");
		steps3.add(
				"Retiramos las peras a un plato cogiéndolas por el rabito. Seguimos reduciendo el líquido de la cazuela, esta vez a fuego alto durante unos 10-15 min. Debemos buscar que nos quede un almíbar de vino pero sin que llegue a caramelizar.");
		steps3.add(
				"Pueden consumirse templadas o frías según gustos. Aunque la manera más típica es consumirlas una vez hayan enfriando en el frigorífico. Podemos calentar ligeramente el almíbar para que haga contraste con la fruta. Emplatamos en un cuenco una pera por persona con un poco de almíbar.");

		steps.put("3", steps3);
	}

	@Override
	public List<String> getSteps(String recipeId) {
		return steps.get(recipeId);
	}
}
