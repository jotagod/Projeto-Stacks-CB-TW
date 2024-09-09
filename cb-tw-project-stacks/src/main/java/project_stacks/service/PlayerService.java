package project_stacks.service;

import project_stacks.model.Player;

public interface PlayerService {
    Player findById(Long id);

    Player create(Player playerToCreate);
}
