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

import domain.Rank;
import javassist.tools.rmi.ObjectNotFoundException;
import services.RankService;

@RestController
@RequestMapping("/rank")
public class RankController {
	
	@Autowired
	private RankService rankService;

	@GetMapping
	public ResponseEntity<List<Rank>> findAllGames() {
		List<Rank> ranks = this.rankService.findAllRank();
		return ResponseEntity.ok(ranks);
	}
	
	@PostMapping
	public ResponseEntity<Rank> insertRank(@RequestBody Rank newRank) {
		Rank rank = this.rankService.insertRank(newRank);
		return ResponseEntity.ok(rank);
	}
	
	@PutMapping
	public ResponseEntity<?> updateRank(@PathVariable Integer id ,@RequestBody Rank rank) {
		try {
			this.rankService.updateRank(id, rank);
			return ResponseEntity.ok(rank);
		} catch (Exception e) {
			return (ResponseEntity<?>) ResponseEntity.badRequest();
		}
	}
	
	@DeleteMapping
	public ResponseEntity<?> removeRank(@PathVariable Integer id) {
		try {
			this.rankService.removeRank(id);
			return (ResponseEntity<?>) ResponseEntity.ok();
		} catch (ObjectNotFoundException e) {
			return (ResponseEntity<?>) ResponseEntity.badRequest();
		}
	}
}
