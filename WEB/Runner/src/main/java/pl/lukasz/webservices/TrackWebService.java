package pl.lukasz.webservices;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pl.lukasz.entities.LatLng;
import pl.lukasz.entities.Track;
import pl.lukasz.entities.TrackTime;
import pl.lukasz.services.TrackService;
import pl.lukasz.services.TrackTimeService;


@RestController
public class TrackWebService {

	@Autowired TrackService trackService;
	@Autowired TrackTimeService trackTimeService;
	
	//zapisuje tras� i jej czas, do serwera przychodzi lista z tras� i czasem
	@RequestMapping("/webservice/saveTrack")
	public Long saveTrack(@RequestBody Track track){
		Long id =  trackService.saveTrack(track);
		return id;
	}
	
	@RequestMapping("/webservice/saveTrackTime")
	public Boolean saveTrackTime(@RequestBody TrackTime trackTime){
		String time = trackTime.getTime();
		String[] splitted = time.split(":");
		int seconds = Integer.parseInt(splitted[1]);
		int minutes = Integer.parseInt(splitted[0]);
		Long miliseconds = new Long((seconds*1000)+(minutes*60*1000));
		trackTime.setTimeInMiliseconds(miliseconds);
		trackTimeService.saveTrackTime(trackTime);
		return true;
	}
	
	//zwraca list� z obiektami potrzebnymi do utowrzenia marker�w
	//zwraca wszystkie trasy dost�pne na widocznym fragmencie mapy
	@RequestMapping("/webservice/updateTracksMarkers")
	public List<Track> getMarkersForMapPiece(@RequestBody List<LatLng> corners){
		List<Track> trackList = trackService.getMarkersForMapPiece(corners.get(0), corners.get(1));
		return trackList;
	}
	
	
	//zwracana mapa jest wy�wietlana w dialogu z najlepszymi czasami trasy
	@RequestMapping("/webservice/getFiveBestTimesForTrack")
	public Map<Long, String> getBestFiveTimesForTrack(@RequestParam(value="trackId")Long trackId){
		List<TrackTime> trackTimes = trackTimeService.getBestFive(trackId);
		Map<Long, String> map = new LinkedHashMap<Long, String>();
		for(TrackTime t: trackTimes){
			Long id = t.getId();
			String message = t.getTime()+" - "+ t.getUser().getName();
			map.put(id, message);
		}
		return map;
	}
}
