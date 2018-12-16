package pl.katarzynawojtowicz.BudgetPlanner.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.katarzynawojtowicz.BudgetPlanner.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	Optional<User> findByUsername(String username);
}