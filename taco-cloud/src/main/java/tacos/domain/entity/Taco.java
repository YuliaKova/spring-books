package tacos.domain.entity;

//import com.datastax.oss.driver.api.core.uuid.Uuids;
import lombok.Data;
//import org.springframework.data.cassandra.core.cql.Ordering;
//import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
//import org.springframework.data.cassandra.core.mapping.Column;
//import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
//import org.springframework.data.cassandra.core.mapping.Table;
import tacos.domain.udt.IngredientUDT;
import tacos.domain.udt.TacoUDRUtils;

//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
//import java.util.UUID;

@Data
//@Entity
//@Table("tacos")
public class Taco {

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;

//    @PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED)
//    private UUID id = Uuids.timeBased();

//    @PrimaryKeyColumn(type = PrimaryKeyType.CLUSTERED,
//            ordering = Ordering.DESCENDING)
    private Date createdAt = new Date();

    @NotNull
    @Size(min = 5, message = "Name must be at least 5 characters long")
    private String name;

    @Size(min = 1, message = "You must choose at least 1 ingredient")
    //@ManyToMany
    private List<Ingredient> ingredients = new ArrayList<>();
//    @Column("ingredients")
//    private List<IngredientUDT> ingredients = new ArrayList<>();

    public void addIngredient(Ingredient ingredient) {
        //ingredients.add(TacoUDRUtils.toIngredientUDT(ingredient));
        ingredients.add(ingredient);
    }
}
