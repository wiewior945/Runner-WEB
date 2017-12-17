package pl.lukasz.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.lukasz.dao.TrackDao;
import pl.lukasz.entities.LatLng;
import pl.lukasz.entities.Track;

@Service
public class TrackService {

	@Autowired TrackDao trackDao;
	
	
	public Long saveTrack(Track track){
		return trackDao.saveTrack(track);
	}
	
	public List<Track> getMarkersForMapPiece(LatLng leftTop, LatLng rightBottom){
		return trackDao.getMarkersForMapPiece(leftTop, rightBottom);
	}
}
