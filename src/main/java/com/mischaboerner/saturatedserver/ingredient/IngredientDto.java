package com.mischaboerner.saturatedserver.ingredient;

import java.math.BigDecimal;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class IngredientDto {

	@NotNull(message = "Ingredient name can't be null.")
	@NotBlank(message = "Ingredient name can't be empty.")
	@Size(max = 100, message = "Title can't be longer than 100 characters.")
	private String name;

	@NotNull(message = "Amount can't be null")
	@DecimalMin(value = "0.0", inclusive = false, message = "Amount has to be greater than 0")
	private BigDecimal amount;

	@NotNull(message = "Unit can't be null")
	@NotBlank(message = "Unit can't be empty")
	private String unit;

	public IngredientDto() {
	}

	public IngredientDto(final String name, final BigDecimal amount, final String unit) {
		this.name = name;
		this.amount = amount;
		this.unit = unit;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(final BigDecimal amount) {
		this.amount = amount;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(final String unit) {
		this.unit = unit;
	}
}