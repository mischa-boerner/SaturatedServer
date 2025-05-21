package com.mischaboerner.saturatedserver.recipe;

import java.util.List;
import com.mischaboerner.saturatedserver.ingredient.IngredientDto;

public class RecipeDto {
	private String title;
	private String description;
	private List<IngredientDto> ingredients;
	private List<String> instructionSteps;

	public RecipeDto() {
	}

	public RecipeDto(final String title, final String description, final List<IngredientDto> ingredients, final List<String> instructionSteps) {
		this.title = title;
		this.description = description;
		this.ingredients = ingredients;
		this.instructionSteps = instructionSteps;
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

	public List<IngredientDto> getIngredients() {
		return ingredients;
	}

	public void setIngredients(final List<IngredientDto> ingredients) {
		this.ingredients = ingredients;
	}

	public List<String> getInstructionSteps() {
		return instructionSteps;
	}

	public void setInstructionSteps(final List<String> instructionSteps) {
		this.instructionSteps = instructionSteps;
	}
}
