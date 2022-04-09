package eCommerceProject.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import eCommerceProject.dataAccess.abstracts.UserDao;
import eCommerceProject.entities.concretes.User;

public class HibernateUserDao implements UserDao {
	List<User> users;

	public HibernateUserDao() {
		users = new ArrayList<User>();
	}

	@Override
	public void add(User user) {
		users.add(user);
		//System.out.println("hibernate ile eklendi(register) : " + user.getFullName());
	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public User getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getAll() {
		return users;
	}

}
