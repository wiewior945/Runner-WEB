package pl.lukasz.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CascadeType;

@Entity
public class TrackTime {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private User user;
	
	@ManyToOne
	private Track track;
	
	
	@ElementCollection(targetClass=Double.class)
	private List<Double> latitude; 
	

	@ElementCollection(targetClass=Double.class)
	private List<Double> longitude;
	
	@Column private String time;
	@Column private Date date;
	@Column private Long timeInMiliseconds;
	
	
	
	public Long getTimeInMiliseconds() {
		return timeInMiliseconds;
	}
	public void setTimeInMiliseconds(Long timeInMiliseconds) {
		this.timeInMiliseconds = timeInMiliseconds;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Track getTrack() {
		return track;
	}
	public void setTrack(Track track) {
		this.track = track;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}	
	public List<Double> getLatitude() {
		return latitude;
	}
	public void setLatitude(List<Double> latitude) {
		this.latitude = latitude;
	}
	public List<Double> getLongitude() {
		return longitude;
	}
	public void setLongitude(List<Double> longitude) {
		this.longitude = longitude;
	}
}
