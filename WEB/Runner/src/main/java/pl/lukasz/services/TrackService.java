package pl.lukasz.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.lukasz.dao.TrackDao;
import pl.lukasz.entities.Track;

@Service
public class TrackService {

	@Autowired TrackDao trackDao;
	
	
	public void saveTrack(Track track){
		trackDao.saveTrack(track);
	}
}
