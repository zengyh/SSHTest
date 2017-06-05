package edu.dao.impl;

import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import edu.dao.UserDao;
import edu.po.User;

public class UserDaoImpl extends HibernateDaoSupport  implements UserDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return (List<User>)this.getHibernateTemplate().find("from User user ");
	}

	@Override
	public User findById(Integer id) {
		// TODO Auto-generated method stub
		return (User)this.getHibernateTemplate().get(User.class, id);
	}

	@Override
	public void save(User user) {
		this.getHibernateTemplate().save(user);
	}

	@Override
	public void update(User user) {
		this.getHibernateTemplate().update(user);

	}

	@Override
	public void delete(User user) {
		this.getHibernateTemplate().delete(user);

	}

}
