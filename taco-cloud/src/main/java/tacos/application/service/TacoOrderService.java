package tacos.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tacos.domain.entity.TacoOrder;
import tacos.domain.repository.TacoOrderRepository;

@Service
@RequiredArgsConstructor
public class TacoOrderService {

    private final TacoOrderRepository tacoOrderRepository;

    public void save(TacoOrder tacoOrder) {
        tacoOrderRepository.save(tacoOrder);
    }
}
