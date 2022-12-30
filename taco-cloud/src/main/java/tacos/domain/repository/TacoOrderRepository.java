package tacos.domain.repository;

//import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tacos.domain.entity.TacoOrder;

//import java.util.UUID;

@Repository
public interface TacoOrderRepository extends CrudRepository<TacoOrder, String> {//UUID> {//JpaRepository<TacoOrder, Long> {
}
