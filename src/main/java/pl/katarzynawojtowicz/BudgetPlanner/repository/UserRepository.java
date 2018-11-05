package pl.katarzynawojtowicz.BudgetPlanner.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.katarzynawojtowicz.BudgetPlanner.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	Optional<User> findByName(String username);
}