package ETicaretSistemi.googleAuth;

import ETicaretSistemi.entities.concretes.User;

public class GoogleAuthManager {
	public void register(User user) {
		System.out.println("Sayin " +user.getName()+ " " + user.getSurname()+ " Google hesabiniz ile kayit oldunuz..");
	}
	public void login(User user) {
		System.out.println("Sayin " +user.getName()+ " " + user.getSurname()+ " Google hesabiniz ile giris yaptiniz..");
	}
	

}
