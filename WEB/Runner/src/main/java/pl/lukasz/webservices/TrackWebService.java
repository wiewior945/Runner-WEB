package pl.lukasz.webservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
