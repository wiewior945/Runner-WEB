package pl.lukasz.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import pl.lukasz.entities.TrackTime;

@Repository
public class TrackTimeDao {

	private Session getSession(){
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		return sessionFactory.openSession();
	}
	
	public void saveTrackTime(TrackTime trackTime){
		Session session = getSession();
		session.beginTransaction();
		session.save(trackTime);
		session.getTransaction().commit();
		session.close();
	}
}
