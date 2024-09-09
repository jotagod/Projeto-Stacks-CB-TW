package project_stacks.service.impl;

import org.springframework.stereotype.Service;
import project_stacks.model.Player;
import project_stacks.repository.PlayerRepository;
import project_stacks.service.PlayerService;

import java.util.NoSuchElementException;

@Service
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;

    public PlayerServiceImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }


    @Override
    public Player findById(Long id) {
        return playerRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Player create(Player playerToCreate) {
        if (playerToCreate.getId() != null && playerRepository.existsById(playerToCreate.getId())) {
            throw new IllegalArgumentException("This player ID already exists");
        }
        return playerRepository.save(playerToCreate);
    }
}
