package pl.katarzynawojtowicz.BudgetPlanner.user;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Override
	public void addNewUser(RegisterTo newRegister) {
		UserDao.addNewUser(newRegister);
	}
}
