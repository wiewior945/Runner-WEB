package pl.lukasz.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
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
	
	public List<TrackTime> getBestFive(Long trackId){
		Session session = getSession();
		Criteria criteria = session.createCriteria(TrackTime.class);
		criteria.add(Restrictions.eq("track.id", trackId));
		criteria.addOrder(Order.asc("timeInMiliseconds"));
		criteria.setMaxResults(5);
		List<TrackTime> results = criteria.list();
		session.close();
		return results;
	}
}
