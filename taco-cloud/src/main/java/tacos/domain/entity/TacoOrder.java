package tacos.domain.entity;

//import com.datastax.oss.driver.api.core.uuid.Uuids;
import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.springframework.data.annotation.Id;
//import org.springframework.data.cassandra.core.mapping.Column;
//import org.springframework.data.cassandra.core.mapping.PrimaryKey;
//import org.springframework.data.cassandra.core.mapping.Table;
import org.springframework.data.mongodb.core.mapping.Document;
import tacos.domain.udt.TacoUDT;

//import javax.persistence.CascadeType;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.OneToMany;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
//import java.util.UUID;

@Data
//@Entity
//@Table("orders")
@Document
public class TacoOrder implements Serializable {

    private static final long serialVersionUID = 1L;

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;

//    @PrimaryKey
//    private UUID id = Uuids.timeBased();

    @Id
    private String id;

    private Date placedAt = new Date();

    @NotBlank(message = "Delivery name is required")
    private String deliveryName;

    @NotBlank(message = "Delivery street is required")
    private String deliveryStreet;

    @NotBlank(message = "Delivery city is required")
    private String deliveryCity;

    @NotBlank(message = "Delivery state is required")
    private String deliveryState;

    @NotBlank(message = "Delivery zip is required")
    private String deliveryZip;

    @CreditCardNumber(message = "Not a valid credit card number")
    private String ccNumber;

    @Pattern(regexp = "^(0[1-9]|1[0-2])(/)([2-9][0-9])$",
            message = "Must be formatted MM/YY")
    private String ccExpiration;

    @Digits(integer = 3, fraction = 0, message = "Invalid CVV")
    private String ccCVV;

    private User user;

    //@OneToMany(cascade = CascadeType.ALL)
    private List<Taco> tacos = new ArrayList<>();

//    @Column("tacos")
//    private List<TacoUDT> tacos = new ArrayList<>();

    public void addTaco(Taco taco) {
    //public void addTaco(TacoUDT taco) {
        tacos.add(taco);
    }
}
