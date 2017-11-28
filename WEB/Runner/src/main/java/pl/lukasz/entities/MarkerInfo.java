package pl.lukasz.entities;

//klasa pomocnicza przy tworzeniu markr�w w aplikacji mobilnej
//zamiast wysy�a� ca�y obiekt klasy Track wysy�am tylko niezb�dne informacje do stworzenia makrera
//p�niej po klikni�ciu markera pobierany jest pe�ny obiekt klasy po ID
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
