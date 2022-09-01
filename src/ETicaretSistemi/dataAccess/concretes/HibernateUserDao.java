package ETicaretSistemi.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import ETicaretSistemi.dataAccess.abstracts.UserDao;
import ETicaretSistemi.entities.concretes.User;

public class HibernateUserDao implements UserDao {

	List<User> users = new ArrayList<User>();
	
	@Override
	public void register(User user) {
		System.out.println(user.getName() + " isimli kullanici basarili bir sekilde kayit olmustur..");
		users.add(user);
		
	}

	@Override
	public void login(User user) {
		System.out.println(user.getName() + " adli kullanici giris yapti..");
		
	}

	@Override
	public void confirm(User user) {
		System.out.println(user.getEmail() + " email adresiniz onaylanmistir.");
		user.setVerify(true);
		
	}

	@Override
	public List<User> getAll() {
	
		return this.users;
	}

}
