package com.mischaboerner.saturatedserver.recipe;

import java.util.List;
import com.mischaboerner.saturatedserver.ingredient.IngredientDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class RecipeDto {
	@NotNull(message = "Title can't be null")
	@NotBlank(message = "Title can't be empty")
	@Size(max = 100, message = "Title isn't allowed to be longer than 100 characters.")
	private String title;

	@NotNull(message = "Description can't be null.")
	@NotBlank(message = "Description can't be empty")
	@Size(max = 1000, message = "Description isn't allowed to be longer than 1000 characters.")
	private String description;

	@NotNull(message = "Ingredient List can't be null")
	@Size(min = 1, message = "There has to be at least one ingredient.")
	@Valid
	private List<IngredientDto> ingredients;

	@NotNull(message = "Instruction Steps can't be null.")
	@Size(min = 1, message = "There has to be at least one instruction step.")
	private List<@NotBlank(message = "Instruction step can't be empty.") String> instructionSteps;

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
