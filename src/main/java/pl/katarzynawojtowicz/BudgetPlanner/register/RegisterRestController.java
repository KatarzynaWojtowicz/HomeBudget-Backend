package pl.katarzynawojtowicz.BudgetPlanner.register;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class RegisterRestController {
	@RequestMapping(value = "/newUser", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> addNewUser(@RequestBody RegisterTo newRegister) {
		RegisterDao.addNewUser(newRegister);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
