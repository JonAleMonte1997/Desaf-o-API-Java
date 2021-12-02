package com.desafios.club.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.desafios.club.model.Club;

@Service
public class ClubService {

	private List<Club> clubs;
	
	public ClubService(List<Club> clubs) {
		this.clubs = clubs;
	}
	
	public List<Club> getClubs() {
		return clubs;
	}
	
	public Club createClub(Club club) {
		clubs.add(club);
		return club;
	}
	
	public Optional<Club> updateClub(Club club, Integer id) {
		for (Club c : clubs) {
			if (c.getId().equals(id)) {
				clubs.remove(c);
				clubs.add(club);
				return Optional.ofNullable(club);
			}
		}
		return null;
	}
	
	public boolean deleteClub(Integer id) {
		for (Club c : clubs) {
			if (c.getId().equals(id)) {
				clubs.remove(c);
				return true;
			}
		}
		return false;
	}
}
