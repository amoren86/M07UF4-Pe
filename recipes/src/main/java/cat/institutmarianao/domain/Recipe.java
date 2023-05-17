package cat.institutmarianao.domain;

public class Recipe {

	private Integer id;
	private String name;
	private Category category;
	private Difficulty difficulty;
	private Integer time;
	private Integer diners;
	private Integer positiveVotes;
	private Integer negativeVotes;

	public Recipe(Integer id, String name, Category category, Difficulty difficulty, int time, int diners) {
		this.id = id;
		this.name = name;
		this.category = category;
		this.difficulty = difficulty;
		this.time = time;
		this.diners = diners;
		positiveVotes = 0;
		negativeVotes = 0;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Difficulty getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(Difficulty difficulty) {
		this.difficulty = difficulty;
	}

	public Integer getTime() {
		return time;
	}

	public void setTime(Integer time) {
		this.time = time;
	}

	public Integer getDiners() {
		return diners;
	}

	public void setDiners(Integer diners) {
		this.diners = diners;
	}

	public Integer getPositiveVotes() {
		return positiveVotes;
	}

	public void setPositiveVotes(Integer rating) {
		positiveVotes = rating;
	}

	public Integer getNegativeVotes() {
		return negativeVotes;
	}

	public void setNegativeVotes(Integer totalVotes) {
		negativeVotes = totalVotes;
	}
}
