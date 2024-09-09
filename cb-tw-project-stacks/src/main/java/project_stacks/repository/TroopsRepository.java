package project_stacks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project_stacks.model.Troops;

@Repository
public interface TroopsRepository extends JpaRepository<Troops, Long>{

}
