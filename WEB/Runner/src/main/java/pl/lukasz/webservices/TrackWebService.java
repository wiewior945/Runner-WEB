package pl.lukasz.webservices;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pl.lukasz.entities.LatLng;
import pl.lukasz.entities.MarkerInfo;
import pl.lukasz.entities.Track;
import pl.lukasz.services.TrackService;

@RestController
public class TrackWebService {

	@Autowired TrackService trackService;
	
	@RequestMapping("/webservice/saveTrack")
	public Boolean saveTrack(@RequestBody Track track){
		trackService.saveTrack(track);
		return true;
	}
	
	//zwraca list� z obiektami potrzebnymi do utowrzenia marker�w
	//zwraca wszystkie trasy dost�pne na widocznym fragmencie mapy
	@RequestMapping("/webservice/updateTracksMarkers")
	public List<MarkerInfo> getMarkersForMapPiece(@RequestBody List<LatLng> corners){
		List<Track> trackList = trackService.getMarkersForMapPiece(corners.get(0), corners.get(1));
		List<MarkerInfo> markers = new ArrayList<MarkerInfo>();
		for(Track track:trackList){
			MarkerInfo mi = new MarkerInfo();
			mi.setTrackName(track.getName());
			mi.setTrackId(track.getId());
			mi.setPosition(track.getStartLatitude(), track.getStartLongitude());
			markers.add(mi);
		}
		return markers;
	}
}
