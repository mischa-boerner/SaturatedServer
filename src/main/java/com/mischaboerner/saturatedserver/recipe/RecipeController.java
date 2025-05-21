package com.mischaboerner.saturatedserver.recipe;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.mischaboerner.saturatedserver.ingredient.Ingredient;
import com.mischaboerner.saturatedserver.ingredient.Unit;
import com.mischaboerner.saturatedserver.mapper.RecipeMapper;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/recipes")
public class RecipeController {

	private final RecipeRepository repository;
	private final RecipeMapper mapper;

	public RecipeController(RecipeRepository repository, final RecipeMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	@PostMapping
	public RecipeDto create(@Valid @RequestBody RecipeDto dto) {
		Recipe saved = repository.save(mapper.toEntity(dto));
		return mapper.toDto(saved);
	}

	@GetMapping
	public List<RecipeDto> getAll() {
		return mapper.toDtoList(repository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<RecipeDto> getById(@PathVariable Long id) {
		return repository.findById(id)
						 .map(mapper::toDto)
						 .map(ResponseEntity::ok)
						 .orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		if (repository.existsById(id)) {
			repository.deleteById(id);
			return ResponseEntity.noContent().build(); // 204 No Content
		} else {
			return ResponseEntity.notFound().build(); // 404 Not Found
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<RecipeDto> update(@PathVariable Long id, @Valid @RequestBody RecipeDto dto) {
		return repository.findById(id)
						 .map(existing -> {
							 Recipe updated = mapper.toEntity(dto);
							 updated.setId(existing.getId()); // wichtig: ID beibehalten
							 Recipe saved = repository.save(updated);
							 return ResponseEntity.ok(mapper.toDto(saved));
						 })
						 .orElse(ResponseEntity.notFound().build());
	}

	@PatchMapping("/{id}")
	public ResponseEntity<RecipeDto> partialUpdate(@PathVariable Long id, @Valid @RequestBody RecipeDto dto) {
		return repository.findById(id)
						 .map(existing -> {
							 if (dto.getTitle() != null) existing.setTitle(dto.getTitle());
							 if (dto.getDescription() != null) existing.setDescription(dto.getDescription());
							 if (dto.getIngredients() != null) existing.setIngredients(
									 dto.getIngredients().stream()
										.map(i -> new Ingredient(i.getName(), i.getAmount(), Unit.valueOf(i.getUnit())))
										.collect(Collectors.toCollection(ArrayList::new))
							 );
							 if (dto.getInstructionSteps() != null) existing.setInstructionSteps(dto.getInstructionSteps());
							 Recipe saved = repository.save(existing);
							 return ResponseEntity.ok(mapper.toDto(saved));
						 })
						 .orElse(ResponseEntity.notFound().build());
	}

}