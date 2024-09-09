package project_stacks.service.impl;

import org.springframework.stereotype.Service;
import project_stacks.model.Troops;
import project_stacks.repository.TroopsRepository;
import project_stacks.service.TroopsService;

import java.util.NoSuchElementException;

@Service
public class TroopsServiceImpl implements TroopsService {

    private final TroopsRepository troopsRepository;

    public TroopsServiceImpl(TroopsRepository troopsRepository) {
        this.troopsRepository = troopsRepository;
    }

    @Override
    public Troops findById(Long id) {
        return troopsRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Troops create(Troops troopToCreate) {
        if (troopToCreate.getId() != null && troopsRepository.existsById(troopToCreate.getId())) {
            throw new IllegalArgumentException("This troop ID already exists.");
        }
        return troopsRepository.save(troopToCreate);
    }
}
