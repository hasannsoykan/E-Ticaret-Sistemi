package ETicaretSistemi.business.concretes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ETicaretSistemi.business.abstracts.UserService;
import ETicaretSistemi.core.AuthService;
import ETicaretSistemi.dataAccess.abstracts.UserDao;
import ETicaretSistemi.entities.concretes.User;

public class UserManager implements UserService{

	private UserDao userDao;
	private AuthService authService;
	
	public UserManager(UserDao userDao, AuthService authService) {
		this.userDao = userDao;
		this.authService = authService;
	}

	@Override
	public void register(User user) {
		if (user.getPassword().length() < 6) {
			System.out.println("Sifre en az 6 karakter olmalidir..");
		}
		final String EMAIL_PATTERN = "^[A-Za-z0-9+_.-]+@(.+)$";
		final Pattern pattern = Pattern.compile(EMAIL_PATTERN);
		Matcher matcher = pattern.matcher(user.getEmail());
		
		if(!matcher.matches()) {
			System.out.println(user.getEmail() + " bu e-mail, e-mail formatina uygun degildir..");
		}
		for(User users:userDao.getAll()) {
			if (users.getEmail().equals(user.getEmail())) {
				System.out.println(user.getEmail()+ " bu e-mail adresi sistemde mevcuttur. ");
			}
		}
		if (user.getName().length() < 2 & user.getSurname().length() < 2) {
			System.out.println("Isim ve soyisim en az 2 karakterden olusmalidir.");
		}
		
	}

	@Override
	public void login(User user) {
		if (user.isVerify()== true) {
			userDao.login(user);
		} else {
			System.out.println("Giris basarisiz bilgilerinizi lütfen kontrol ediniz..");
		}
		
	}

	@Override
	public void confirm(User user) {
		if (user.isVerify()== true) {
			userDao.confirm(user);
			System.out.println("Sayin " +user.getName()+ " " +user.getSurname()+" e-mail adresiniz dogrulanmistir..");

		}else {
			System.out.println("Sayin " +user.getName()+ " " +user.getSurname()+" e-mail adresiniz dogrulanmamistir..");
		}
		
	}

	@Override
	public void registerWithAccount(User user) {
		user.setVerify(true);
		this.authService.register(user);
		
	}

	@Override
	public void loginWithAccount(User user) {
		if (user.isVerify()==true) {
			this.authService.login(user);
		}else {
			System.out.println("Kaydiniz bulunmamaktadir..");
		}
		
	}

}
