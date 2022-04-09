package eCommerceProject.dataAccess.abstracts;

import java.util.List;

import eCommerceProject.entities.concretes.User;

public interface UserDao {

	void add(User user);
	
	void delete(User user);

	void update(User user);

	User getById(int id);

	List<User> getAll();

}
