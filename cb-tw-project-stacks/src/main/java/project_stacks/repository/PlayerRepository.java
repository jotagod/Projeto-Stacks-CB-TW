package project_stacks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project_stacks.model.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long>{

}
