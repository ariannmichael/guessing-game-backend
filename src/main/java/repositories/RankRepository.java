package repositories;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import domain.Rank;

@Repository
public interface RankRepository extends JpaRepository<Rank, Integer>{

	Optional<Rank> findByName(String name);
}
