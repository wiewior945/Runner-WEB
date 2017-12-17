package pl.lukasz.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "track")
public class Track {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private User user;
	
	@Column 
	@ElementCollection(targetClass=Double.class)
	private List<Double> latitude; 
	
	@Column
	@ElementCollection(targetClass=Double.class)
	private List<Double> longitude;
	
	@Column private Double startLatitude;
	@Column private Double startLongitude;
	@Column private Double endLatitude;
	@Column private Double endLongitude;
	@Column private Date dateCreated;
	@Column private String startDescription;
	@Column private String finishDescription;
	@Column private String name;
	
	
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
	public Double getStartLatitude() {
		return startLatitude;
	}
	public void setStartLatitude(Double stratLatitude) {
		this.startLatitude = stratLatitude;
	}
	public Double getStartLongitude() {
		return startLongitude;
	}
	public void setStartLongitude(Double stratLongitude) {
		this.startLongitude = stratLongitude;
	}
	public Double getEndLatitude() {
		return endLatitude;
	}
	public void setEndLatitude(Double endLatitude) {
		this.endLatitude = endLatitude;
	}
	public Double getEndLongtitude() {
		return endLongitude;
	}
	public void setEndLongitude(Double endLongitude) {
		this.endLongitude = endLongitude;
	}
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	public String getStartDescription() {
		return startDescription;
	}
	public void setStartDescription(String startDescription) {
		this.startDescription = startDescription;
	}
	public String getFinishDescription() {
		return finishDescription;
	}
	public void setFinishDescription(String finishDescription) {
		this.finishDescription = finishDescription;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
