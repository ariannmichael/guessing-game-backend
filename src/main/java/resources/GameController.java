package resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import domain.Game;
import javassist.tools.rmi.ObjectNotFoundException;
import services.GameService;

@RestController
@RequestMapping("/game")
public class GameController {
	
	@Autowired
	private GameService gameService;

	@GetMapping
	public ResponseEntity<List<Game>> findAllGames() {
		List<Game> games = this.gameService.findAllGames();
		return ResponseEntity.ok(games);
	}
	
	@PostMapping
	public ResponseEntity<Game> insertGame(@RequestBody Game game) {
		Game newGame = this.gameService.insertGame(game);
		return ResponseEntity.ok(newGame);
	}
	
	@PutMapping
	public ResponseEntity<?> updateGame(@PathVariable Integer id ,@RequestBody Game game) {
		try {
			this.gameService.updateGame(id, game);
			return ResponseEntity.ok(game);
		} catch (Exception e) {
			return (ResponseEntity<?>) ResponseEntity.badRequest();
		}
	}
	
	@DeleteMapping
	public ResponseEntity<?> removeGame(@PathVariable Integer id) {
		try {
			this.gameService.removeGame(id);
			return (ResponseEntity<?>) ResponseEntity.ok();
		} catch (ObjectNotFoundException e) {
			return (ResponseEntity<?>) ResponseEntity.badRequest();
		}
	}
}
