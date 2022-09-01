package ETicaretSistemi;

import ETicaretSistemi.business.abstracts.UserService;
import ETicaretSistemi.business.concretes.UserManager;
import ETicaretSistemi.core.GoogleAuthManagerAdapter;
import ETicaretSistemi.dataAccess.concretes.HibernateUserDao;
import ETicaretSistemi.entities.concretes.User;
import ETicaretSistemi.googleAuth.GoogleAuthManager;

public class Main {

	public static void main(String[] args) {
		
		UserService userService = new UserManager(new HibernateUserDao(), new GoogleAuthManagerAdapter(new GoogleAuthManager()));
		User user1 = new User("Hasan", "Soykan", "hasannsoykan@gmail.com", "123456", true);
		User user2 = new User("Mehmet", "Ok", "mehmetok@gmail.com", "234567", true);
		userService.register(user1);
		userService.login(user1);
		userService.confirm(user1);
		userService.registerWithAccount(user1);
		userService.loginWithAccount(user1);

	}

}
