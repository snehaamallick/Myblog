package com.myweb.myblog.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.myweb.myblog.model.*;


@Repository
public class UserDAOImpl{
	@Autowired
	private SessionFactory sessionFactory;
	
	public UserDAOImpl()
	{
		
	}
	
	public void addUser(User u) {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(u);
        
    }
    
    public void updateUser(User u) {
       // Session session = this.sessionFactory.getCurrentSession();
        //session.update(u);
        
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(u);
        session.flush();
    }
    
    public List<User> listUsers() {
        Session session = this.sessionFactory.getCurrentSession();
        List<User> usersList = session.createQuery("from User").list();
        return usersList;
    }
    
    public User getUserById(int userid) {
        Session session = this.sessionFactory.getCurrentSession();      
        User u = (User) session.load(User.class, new Integer(userid));
        
        return u;
    }
    

/*public List<User> detailsUser(String username)
                {
                                  Session session=sessionFactory.getCurrentSession();
                                  List<User> specificUser =(List<User>)session.createSQLQuery("select * from User where User.username="+username ).addEntity(User.class).list();
                                  //System.out.println(user.getFirstname());
                                  //List<Niitusers> list=new ArrayList();
                                  return specificUser;
                }*/
    
    
    @Transactional
    public void removeUser(int userid) {
        Session session = this.sessionFactory.getCurrentSession();
        User u = (User) session.load(User.class, new Integer(userid));
        if(null != u){
            session.delete(u);
            session.flush();
        }
    }
		
    @Transactional
    public User getUserByusername(String username){
    	Session session = this.sessionFactory.getCurrentSession(); 
    	//String hql = "from User u where ute.username="+username+"";
    	//Query q = session.createQuery("from User u where u.username=" + "'"+ username+"'");
    	//Query q = sessionFactory.getCurrentSession().createQuery(hql);
    	
    	/*Query q = session.createQuery("from User u where u.username=" + "'"+ username+"'");
    	List<User> users = (List<User>) q.list();
    	User user=users.get(0);
    	*/
    	List<User> users = session.createQuery("from User u where u.username='" + username + "'").list();
		User user=users.get(0);
    	
    	
    	/*List<User> users=session.createQuery("FROM User").list();
    	User user=users.get(0);*/
    	return user;
    }
    public User getUserByEmail(String email) {
		Session session = sessionFactory.getCurrentSession();

		List<User> users = session.createQuery("from User u where u.email='" + email + "'").list();
		User user=users.get(0);

		return user;
	}
	}


