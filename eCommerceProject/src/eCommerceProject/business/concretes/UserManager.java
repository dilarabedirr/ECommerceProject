package eCommerceProject.business.concretes;

import eCommerceProject.business.abstracts.UserRegisterLoginService;
import eCommerceProject.business.abstracts.UserService;
import eCommerceProject.dataAccess.abstracts.UserDao;
import eCommerceProject.entities.concretes.User;

public class UserManager implements UserService {
	
	private UserRegisterLoginService userRegisterLoginService;

	public UserManager(UserRegisterLoginService userRegisterLoginService) {
		super();
		this.userRegisterLoginService = userRegisterLoginService;
	}

	@Override
	public void login(String email, String password) {
		userRegisterLoginService.login(email,password);

	}

	@Override
	public void register(User user) {
		userRegisterLoginService.register(user);
//		var result = BusinessRules.run(
//				isFieldEmpty(user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword()),
//				passwordLengthCheck(user.getPassword()),
//				firstNameAndLastNameLengthCheck(user.getFirstName(), user.getLastName()),
//				emailRegexValidation(user.getEmail()), checkIfEmailExist(user.getEmail()));
//		if (result != false) {
//			userDao.add(user);
//			System.out.println(Messages.registerSuccessful + " : " + user.getFullName());
//			return;
//		}
//		System.out.println(Messages.registerUnSuccessful + " : " + user.getFullName());
	}

//	private boolean emailRegexValidation(String email) {
//		Pattern pattern = Pattern
//				.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
//		Matcher matcher = pattern.matcher(email);
//		if (!matcher.find()) {
//			System.out.println(Messages.emailMessage);
//			return false;
//		}
//
//		return true;
//	}
//
//	private boolean passwordLengthCheck(String password) {
//		if (password.length() < 6) {
//			System.out.println(Messages.passwordMessage);
//			return false;
//		}
//		return true;
//	}
//
//	private boolean isFieldEmpty(String firstName, String lastName, String email, String password) {
//		if (email == "" || firstName == "" || lastName == "" || password == "") {
//			System.out.println(Messages.fieldControl);
//			return false;
//		}
//		return true;
//	}
//
//	private boolean firstNameAndLastNameLengthCheck(String firstName, String lastName) {
//		if (firstName.length() < 2 || lastName.length() < 2) {
//			System.out.println(Messages.firstNameAndLastNameLengthMessage);
//			return false;
//		}
//		return true;
//	}
//
//	private boolean checkIfEmailExist(String email) {
//		var result = userDao.getAll();
//		for (User user : result) {
//			if (user.getEmail() == email) {
//				System.out.println(Messages.emailExist);
//				return false;
//			}
//		}
//		return true;
//	}

}
