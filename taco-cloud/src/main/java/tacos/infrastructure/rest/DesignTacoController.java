package tacos.infrastructure.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import tacos.application.service.IngredientService;
import tacos.domain.entity.Ingredient;
import tacos.domain.entity.Taco;
import tacos.domain.entity.TacoOrder;
import tacos.domain.udt.TacoUDRUtils;

import javax.validation.Valid;

import static tacos.domain.entity.Ingredient.Type;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("tacoOrder")
@RequiredArgsConstructor
public class DesignTacoController {

    private final IngredientService ingredientService;

    @ModelAttribute
    public void addIngredientToModel(Model model) {
        List<Ingredient> ingredients = ingredientService.findAll();
        Type[] types = Type.values();
        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(ingredients, type));
        }
    }

    @ModelAttribute(name = "tacoOrder")
    public TacoOrder order() {
        return new TacoOrder();
    }

    @ModelAttribute(name = "taco")
    public Taco taco() {
        return new Taco();
    }

    @GetMapping
    public String showDesignForm() {
        return "design";
    }

    @PostMapping
    public String processTaco(@Valid Taco taco,
                              Errors errors,
                              @ModelAttribute TacoOrder tacoOrder) {
        if (errors.hasErrors()) {
            return "design";
        }

        tacoOrder.addTaco(taco); //(TacoUDRUtils.toTacoUDT(taco));
        log.info("Processing taco: {}", taco);

        return "redirect:/orders/current";
    }

    private Iterable<Ingredient> filterByType(List<Ingredient> ingredients,
                                              Type type) {
        return ingredients.stream()
                .filter(ingredient -> ingredient.getType().equals(type))
                .collect(Collectors.toList());
    }
}
