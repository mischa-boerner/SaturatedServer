package com.mischaboerner.saturatedserver.recipe;

import java.util.ArrayList;
import java.util.List;
import com.mischaboerner.saturatedserver.ingredient.Ingredient;
import jakarta.persistence.*;
import jakarta.validation.*;
import jakarta.validation.constraints.*;

@Entity
public class Recipe {
	@Id
	@GeneratedValue
	private Long id;

	private String title;
	private String description;

	@ElementCollection
	@CollectionTable(
			name = "recipe_ingredients",
			joinColumns = @JoinColumn(name = "recipe_id")
	)
	private List<Ingredient> ingredients;

	@ElementCollection
	@CollectionTable(
			name = "recipe_steps",
			joinColumns = @JoinColumn(name = "recipe_id")
	)
	@Column(name = "step")
	private List<String> instructionSteps;

	public Recipe() {

	}

	public Recipe(final String title, final String description, final List<Ingredient> ingredients, final List<String> instructionSteps) {
		this.title = title;
		this.description = description;
		this.ingredients = ingredients;
		this.instructionSteps = instructionSteps;
	}

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(final String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(final String description) {
		this.description = description;
	}

	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(final List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	public List<String> getInstructionSteps() {
		return instructionSteps;
	}

	public void setInstructionSteps(final List<String> instructionSteps) {
		this.instructionSteps = instructionSteps;
	}
}
