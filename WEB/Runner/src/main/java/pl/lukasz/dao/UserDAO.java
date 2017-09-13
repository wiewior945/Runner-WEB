package pl.lukasz.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import pl.lukasz.entities.User;

@Repository
public class UserDAO {

	//zwraca obiekt sesji Hibernate
	private Session getSession(){
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		return sessionFactory.openSession();
	}
	
	public void saveUser(User user){
		Session session = getSession();
		session.save(user);
		session.close();
	}
	
	public User getUserByName(String username){
		Session session = getSession();
		Criteria c = session.createCriteria(User.class);
		c.add(Restrictions.eq("name", username));
		User user = (User)c.uniqueResult();
		session.close();
		return user;
	}
}
