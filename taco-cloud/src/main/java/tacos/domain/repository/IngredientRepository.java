package tacos.domain.repository;

//import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tacos.domain.entity.Ingredient;

@Repository
public interface IngredientRepository extends CrudRepository<Ingredient, String> {//JpaRepository<Ingredient, String> {
}
