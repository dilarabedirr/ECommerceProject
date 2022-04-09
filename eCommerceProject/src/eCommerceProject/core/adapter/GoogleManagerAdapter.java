package eCommerceProject.core.adapter;

import eCommerceProject.business.abstracts.UserRegisterLoginService;
import eCommerceProject.entities.concretes.User;
import eCommerceProject.google.GoogleManager;

public class GoogleManagerAdapter implements UserRegisterLoginService {
	private GoogleManager googleManager;

	public GoogleManagerAdapter() {
		googleManager = new GoogleManager();
	}

	@Override
	public void login(String email,String password) {
		googleManager.login(email);
	}

	@Override
	public void register(User user) {
		googleManager.register(user.getFullName());
	}
}
