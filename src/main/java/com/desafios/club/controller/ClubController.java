package com.desafios.club.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafios.club.model.Club;
import com.desafios.club.service.ClubService;

@RestController
@RequestMapping("apiClub/v1")
public class ClubController {
	
	private final ClubService clubService;
	
	@Autowired
	public ClubController(ClubService clubService) {
		this.clubService = clubService;
	}

	@GetMapping("/clubs")
	public List<Club> getClubs() {
		return clubService.getClubs();
	}
	
	@PostMapping("/createClub")
	public Club createClub(@RequestBody Club club) {
		return clubService.createClub(club);
	}
	
	@PutMapping("/updateClub/{id}")
	public Club updateClub(@RequestBody Club club, @PathVariable Integer id) {
		return clubService.updateClub(club, id).orElseThrow(() -> new RuntimeException("Club not found"));
	}
	
	@DeleteMapping("deleteClub/{id}")
	public boolean depeteClub(@PathVariable Integer id) {
		return clubService.deleteClub(id);
	}
}
