package tacos.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tacos.domain.entity.Ingredient;
import tacos.domain.repository.IngredientRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IngredientService {

    private final IngredientRepository ingredientRepository;

    public List<Ingredient> findAll() {
        return (List<Ingredient>) ingredientRepository.findAll();
    }
}
