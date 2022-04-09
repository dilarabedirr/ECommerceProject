package eCommerceProject;

import java.util.List;

import eCommerceProject.business.abstracts.UserService;
import eCommerceProject.business.concretes.UserManager;
import eCommerceProject.business.concretes.UserRegisterLoginManager;
import eCommerceProject.core.adapter.GoogleManagerAdapter;
import eCommerceProject.dataAccess.abstracts.UserDao;
import eCommerceProject.dataAccess.concretes.HibernateUserDao;
import eCommerceProject.entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		User user1 = new User(1, "Dilara", "Bedir", "dilara_bedir@hotmail.com", "123456");
		User user2 = new User(2, "Batuhan", "Bedir", "batuhan_bedir@hotmail.com", "123456");
		User user3 = new User(3, "Engin", "Demiroð", "engindemirog", "123456");
		UserService userService = new UserManager(new GoogleManagerAdapter());
		userService.register(user1);
		userService.register(user2);
		userService.register(user3);
		userService.login("dilara_bedir@hotmail.com","12345");

	}

}
