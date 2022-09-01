package ETicaretSistemi.dataAccess.abstracts;

import java.util.List;

import ETicaretSistemi.entities.concretes.User;

public interface UserDao {
	
	void register(User user);
	void login(User user);
	void confirm(User user);
	List<User> getAll();

}
