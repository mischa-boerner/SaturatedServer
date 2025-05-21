package com.mischaboerner.saturatedserver.recipe;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recipes")
public class RecipeController {

	private final RecipeRepository repository;

	public RecipeController(RecipeRepository repository) {
		this.repository = repository;
	}

	@GetMapping
	public List<Recipe> getAll() {
		return repository.findAll();
	}

	@PostMapping
	public Recipe create(@RequestBody Recipe recipe) {
		return repository.save(recipe);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Recipe> getById(@PathVariable Long id) {
		return repository.findById(id)
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
	public ResponseEntity<Recipe> update(@PathVariable Long id, @RequestBody Recipe newRecipe) {
		return repository.findById(id)
						 .map(recipe -> {
							 recipe.setTitle(newRecipe.getTitle());
							 recipe.setDescription(newRecipe.getDescription());
							 return ResponseEntity.ok(repository.save(recipe));
						 })
						 .orElse(ResponseEntity.notFound().build());
	}
}