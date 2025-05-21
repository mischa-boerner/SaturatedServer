package com.mischaboerner.saturatedserver.ingredient;

import java.math.BigDecimal;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Embeddable
public class Ingredient {

	@NotBlank
	private String name;

	@DecimalMin(value = "0.0", inclusive = false, message = "Must be > 0")
	private BigDecimal amount;

	@NotNull
	@Enumerated(EnumType.STRING)
	private Unit unit;

	public Ingredient() {
	}

	public Ingredient(final String name, final BigDecimal amount, final Unit unit) {
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

	public Unit getUnit() {
		return unit;
	}

	public void setUnit(final Unit unit) {
		this.unit = unit;
	}
}