package pl.lukasz.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.lukasz.dao.TrackTimeDao;
import pl.lukasz.entities.TrackTime;

@Service
public class TrackTimeService {

	@Autowired TrackTimeDao trackTimeDao;
	
	
	public void saveTrackTime(TrackTime trackTime){
		trackTimeDao.saveTrackTime(trackTime);
	}
}
