package pl.lukasz.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import pl.lukasz.entities.Track;


@Repository
public class TrackDao {

	
	//zwraca obiekt sesji Hibernate
		private Session getSession(){
			Configuration configuration = new Configuration().configure();
			SessionFactory sessionFactory = configuration.buildSessionFactory();
			return sessionFactory.openSession();
		}
		
		public void saveTrack(Track track){
			Session session = getSession();
			session.save(track);
			session.close();
		}
}
