package pl.katarzynawojtowicz.BudgetPlanner.login;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/signin")

public class LoginRestController {
	@RequestMapping(value = "/user", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> login(@RequestBody LoginTo newLogin) {
		LoginDao.login(newLogin);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/all")
	public String hello() {
		return "Hello";
	}

	@PreAuthorize("hasAnyRole('Admin')")
	@GetMapping("/secured/all")
	public String securedHello() {
		return "Secured Hello";
	}

	@PreAuthorize("isAuthenticated()")
	@GetMapping("/secured/alternate")
	public String alternate() {
		return "alternate";
	}
}
