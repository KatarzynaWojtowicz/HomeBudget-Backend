package pl.katarzynawojtowicz.BudgetPlanner.user;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import pl.katarzynawojtowicz.BudgetPlanner.model.CustomUserDetails;
import pl.katarzynawojtowicz.BudgetPlanner.model.User;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> optionalUsers = userRepository.findByUsername(username);

		optionalUsers
				.orElseThrow(() -> new UsernameNotFoundException("Username not found"));
		return optionalUsers
				.map(CustomUserDetails::new).get();
	}
}