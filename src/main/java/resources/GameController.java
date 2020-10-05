package resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import domain.Game;

@RestController
@RequestMapping("/game")
public class GameController {

	@GetMapping
	public Game gaming() {
		return new Game();
	}
}
