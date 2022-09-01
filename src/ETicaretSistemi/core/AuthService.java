package ETicaretSistemi.core;

import ETicaretSistemi.entities.concretes.User;

public interface AuthService {
	void register(User user);
	void login(User user);
}
