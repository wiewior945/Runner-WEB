package pl.lukasz.entities;

//klasa pomocnicza przy tworzeniu markrów w aplikacji mobilnej
//zamiast wysy³aæ ca³y obiekt klasy Track wysy³am tylko niezbêdne informacje do stworzenia makrera
//póŸniej po klikniêciu markera pobierany jest pe³ny obiekt klasy po ID
public class MarkerInfo {

	private long trackId;
	private String trackName;
	private LatLng position;

	
	public void setPosition(double latitude, double longtitude){
		position = new LatLng(latitude, longtitude);
	}
	
	public long getTrackId() {return trackId;}
	public void setTrackId(long trackId) {this.trackId = trackId;}
	public String getTrackName() {return trackName;}
	public void setTrackName(String trackName) {this.trackName = trackName;}
	public LatLng getPosition() {return position;}
	public void setPosition(LatLng position) {this.position = position;}
}
