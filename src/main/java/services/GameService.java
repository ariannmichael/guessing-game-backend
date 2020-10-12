package services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.Game;
import javassist.tools.rmi.ObjectNotFoundException;
import repositories.GameRepository;

@Service
public class GameService {
	
	@Autowired
	private GameRepository gameRepository;
	
	public List<Game> findAllGames() {
		return this.gameRepository.findAll();
	}
	
	public Game insertGame(Game newGame) {
		return this.gameRepository.save(newGame);
	}
	
	public Game updateGame(Integer id, Game newGame) throws ObjectNotFoundException {
		Optional<Game> game = this.gameRepository.findById(id);
		
		if(game == null) {
			throw new ObjectNotFoundException("Partida não encontrada");
		}
		
		return this.gameRepository.save(newGame);
	}
	
	
	public void removeGame(Integer id) throws ObjectNotFoundException {
		Optional<Game> game = this.gameRepository.findById(id);
		
		if(game == null) {
			throw new ObjectNotFoundException("Partida não encontrada");
		}
		
		this.gameRepository.deleteById(id);
	}
}
