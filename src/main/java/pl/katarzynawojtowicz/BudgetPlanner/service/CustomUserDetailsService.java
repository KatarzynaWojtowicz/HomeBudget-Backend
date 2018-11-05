package pl.katarzynawojtowicz.BudgetPlanner.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import pl.katarzynawojtowicz.BudgetPlanner.model.CustomUserDetails;
import pl.katarzynawojtowicz.BudgetPlanner.model.User;
import pl.katarzynawojtowicz.BudgetPlanner.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> optionalUsers = userRepository.findByName(username);

		optionalUsers
				.orElseThrow(() -> new UsernameNotFoundException("Username not found"));
		return optionalUsers
				.map(CustomUserDetails::new).get();
	}
}