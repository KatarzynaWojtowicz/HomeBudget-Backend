package pl.katarzynawojtowicz.BudgetPlanner.user;

import org.springframework.web.bind.annotation.RequestBody;

public interface UserService {
	public void addNewUser(@RequestBody RegisterTo newRegister);

}
