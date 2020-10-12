package services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import domain.Rank;
import javassist.tools.rmi.ObjectNotFoundException;
import repositories.RankRepository;

@Service
public class RankService {
	
	private RankRepository rankRepository;
	
	public List<Rank> findAllRank() {
		return this.rankRepository.findAll();
	}

	public Rank insertRank(Rank newRank) {
		return this.rankRepository.save(newRank);
	}
	
	public Rank updateRank(Integer id, Rank newRank ) throws ObjectNotFoundException {
		Optional<Rank> rank = this.rankRepository.findById(newRank.getId());
		
		if(rank == null) {
			throw new ObjectNotFoundException("Rank não encontrada");
		}
		
		return this.rankRepository.save(newRank);
	}
	
	public void removeRank(Integer id) throws ObjectNotFoundException {
		Optional<Rank> rank = this.rankRepository.findById(id);
		
		if(rank == null) {
			throw new ObjectNotFoundException("Partida não encontrada");
		}
		
		this.rankRepository.deleteById(id);
	}
	
}
