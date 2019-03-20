package org.dico.rh.repositories.jpa;

import java.util.List;

import org.dico.rh.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
	public List<User> findByUsername(String username);
}
