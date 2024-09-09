package project_stacks.service;

import project_stacks.model.Troops;

public interface TroopsService {
    Troops findById(Long id);

    Troops create(Troops troopToCreate);
}
