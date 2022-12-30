package tacos.domain.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//import org.springframework.data.cassandra.core.mapping.PrimaryKey;
//import org.springframework.data.cassandra.core.mapping.Table;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//import javax.persistence.Entity;
//import javax.persistence.EnumType;
//import javax.persistence.Enumerated;
//import javax.persistence.Id;

@Data
//@Entity
//@Table("ingredients")
@Document
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class Ingredient {

    @Id
    //@PrimaryKey
    private String id;

    private String name;

    //@Enumerated(EnumType.STRING)
    private Type type;

    public enum Type {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }
}
