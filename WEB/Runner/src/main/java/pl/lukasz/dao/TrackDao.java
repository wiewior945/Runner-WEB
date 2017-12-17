package pl.lukasz.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import pl.lukasz.entities.LatLng;
import pl.lukasz.entities.Track;


@Repository
public class TrackDao {

	
	//zwraca obiekt sesji Hibernate
		private Session getSession(){
			Configuration configuration = new Configuration().configure();
			SessionFactory sessionFactory = configuration.buildSessionFactory();
			return sessionFactory.openSession();
		}
		
		public Long saveTrack(Track track){
			Session session = getSession();
			session.beginTransaction();
			Long id = (Long) session.save(track);
			session.getTransaction().commit();
			session.close();
			return id;
		}
		
		//zwraca wszystkie trasy dostêpne na widocznym fragmencie mapy
		public List<Track> getMarkersForMapPiece(LatLng leftTop, LatLng rightBottom){
			Session session = getSession();
			Criteria criteria = session.createCriteria(Track.class);
			if(leftTop.getLatitude()<rightBottom.getLatitude()){
				criteria.add(Restrictions.between("startLatitude", leftTop.getLatitude(), rightBottom.getLatitude()));
			}else{
				criteria.add(Restrictions.between("startLatitude", rightBottom.getLatitude(), leftTop.getLatitude()));
			}
			if(leftTop.getLongitude()<rightBottom.getLongitude()){
				criteria.add(Restrictions.between("startLongitude", leftTop.getLongitude(), rightBottom.getLongitude()));
			}else{
				criteria.add(Restrictions.between("startLongitude", rightBottom.getLongitude(), leftTop.getLongitude()));
			}
			List<Track> results = criteria.list();
			session.close();
			return results;
		}
}
