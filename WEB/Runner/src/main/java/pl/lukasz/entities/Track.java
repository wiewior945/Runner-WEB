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
	private List<Double> longtitude;
	
	@Column private Double stratLatitude;
	@Column private Double stratLongtitude;
	@Column private Double endLatitude;
	@Column private Double endLongtitude;
	@Column private Date dateCreated;
	@Column private String startDescription;
	@Column private String finishDescription;
	@Column private String name;
	@Column private String time;
	
	
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
	public List<Double> getLongtitude() {
		return longtitude;
	}
	public void setLongtitude(List<Double> longtitude) {
		this.longtitude = longtitude;
	}
	public Double getStratLatitude() {
		return stratLatitude;
	}
	public void setStratLatitude(Double stratLatitude) {
		this.stratLatitude = stratLatitude;
	}
	public Double getStratLongtitude() {
		return stratLongtitude;
	}
	public void setStratLongtitude(Double stratLongtitude) {
		this.stratLongtitude = stratLongtitude;
	}
	public Double getEndLatitude() {
		return endLatitude;
	}
	public void setEndLatitude(Double endLatitude) {
		this.endLatitude = endLatitude;
	}
	public Double getEndLongtitude() {
		return endLongtitude;
	}
	public void setEndLongtitude(Double endLongtitude) {
		this.endLongtitude = endLongtitude;
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
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
}
