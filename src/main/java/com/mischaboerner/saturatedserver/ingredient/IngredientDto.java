package com.mischaboerner.saturatedserver.ingredient;

import java.math.BigDecimal;

public class IngredientDto {
	private String name;
	private BigDecimal amount;
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