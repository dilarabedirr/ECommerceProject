package eCommerceProject.business.abstracts;

import eCommerceProject.entities.concretes.User;

public interface UserRegisterLoginService {
	
	void login(String email, String password);
	
	void register(User user);
}
