package org.dico.rh.services;

import java.util.List;
import java.util.Optional;

import org.dico.rh.models.User;
import org.dico.rh.repositories.jpa.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> get() throws Exception {
		return userRepository.findAll();
	}

	@Override
	public User get(int id) throws Exception {
		Optional<User> user = userRepository.findById(id);
		if (user.isPresent()) {
			return user.get();
		}
		return null;
	}

	@Override
	public User insert(User user) throws Exception {
		if (user.getId() == 0) {
			return userRepository.save(user);
		}
		return null;
	}

	@Override
	public User update(User user) throws Exception {
		if (user.getId() != 0) {
			if (get(user.getId()) != null) {
				return userRepository.save(user);
			} else {
				throw new Exception("Id [" + user.getId() + "] not found;");
			}
		}
		return null;
	}

	@Override
	public User getByUserName(String username) throws Exception {
		List<User> users = userRepository.findByUsername(username);
		return users.isEmpty() ? null : users.get(0);
	}
}
