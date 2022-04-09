package eCommerceProject.business.concretes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import eCommerceProject.business.abstracts.UserRegisterLoginService;
import eCommerceProject.core.utilities.BusinessRules;
import eCommerceProject.core.utilities.Messages;
import eCommerceProject.dataAccess.abstracts.UserDao;
import eCommerceProject.entities.concretes.User;

public class UserRegisterLoginManager implements UserRegisterLoginService {
	private UserDao userDao;

	public UserRegisterLoginManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public void login(String email,String password) {
		var result = BusinessRules.run(emailAndPasswordFieldCheck(email, password),
				loginCheck(email, password));
		if(result != false) {
			System.out.println(Messages.loginUnSuccessful);
			return;
		}
		System.out.println(Messages.loginSuccessful);
	}

	@Override
	public void register(User user) {
		var result = BusinessRules.run(
				isFieldEmpty(user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword()),
				passwordLengthCheck(user.getPassword()),
				firstNameAndLastNameLengthCheck(user.getFirstName(), user.getLastName()),
				emailRegexValidation(user.getEmail()), checkIfEmailExist(user.getEmail()));
		if (result != false) {
			userDao.add(user);
			System.out.println(Messages.registerSuccessful + " : " + user.getFullName());
			return;
		}
		System.out.println(Messages.registerUnSuccessful + " : " + user.getFullName());
	}

	private boolean emailRegexValidation(String email) {
		Pattern pattern = Pattern
				.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		Matcher matcher = pattern.matcher(email);
		if (!matcher.find()) {
			System.out.println(Messages.emailMessage);
			return false;
		}

		return true;
	}

	private boolean passwordLengthCheck(String password) {
		if (password.length() < 6) {
			System.out.println(Messages.passwordMessage);
			return false;
		}
		return true;
	}

	private boolean isFieldEmpty(String firstName, String lastName, String email, String password) {
		if (email == "" || firstName == "" || lastName == "" || password == "") {
			System.out.println(Messages.fieldControl);
			return false;
		}
		return true;
	}

	private boolean firstNameAndLastNameLengthCheck(String firstName, String lastName) {
		if (firstName.length() < 2 || lastName.length() < 2) {
			System.out.println(Messages.firstNameAndLastNameLengthMessage);
			return false;
		}
		return true;
	}

	private boolean checkIfEmailExist(String email) {
		var result = userDao.getAll();
		for (User user : result) {
			if (user.getEmail() == email) {
				System.out.println(Messages.emailExist);
				return false;
			}
		}
		return true;
	}

	private boolean emailAndPasswordFieldCheck(String email, String password) {
		if (email == "" || password == "") {
			System.out.println(Messages.emailAndPasswordMessage);
			return false;
		}
		return true;
	}

	private boolean loginCheck(String email, String password) {
		var result = userDao.getAll();
		for (User user : result) {
			if (user.getEmail() != email && user.getPassword() != password) {
				return true;
			}
		}
		return false;
	}

}
