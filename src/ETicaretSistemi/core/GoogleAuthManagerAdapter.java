package ETicaretSistemi.core;

import ETicaretSistemi.entities.concretes.User;
import ETicaretSistemi.googleAuth.GoogleAuthManager;

public class GoogleAuthManagerAdapter implements AuthService{
	
	private GoogleAuthManager googleAuthManager;

	public GoogleAuthManagerAdapter(GoogleAuthManager googleAuthManager) {
		this.googleAuthManager = googleAuthManager;
	}

	@Override
	public void register(User user) {
		googleAuthManager.register(user);
		
	}

	@Override
	public void login(User user) {
		googleAuthManager.login(user);
		
	}

}
