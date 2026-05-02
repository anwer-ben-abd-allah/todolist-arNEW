package gl2.miniproject.todolist.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gl2.miniproject.todolist.model.User;
import gl2.miniproject.todolist.repository.UserRepository;

@Service
public class UserService {
	@Autowired 
	private UserRepository userRepo;
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}
	public Optional<User> getUserById(Long id) {
		return userRepo.findById(id);
	}
	public User addUser(User user) {
		if (userRepo.existByEmail(user))
			return null;
		return userRepo.save(user);
	}
	public void deleteUserById(Long id) {
		userRepo.deleteById(id);
	}
	public User editUser(User user) {
		return userRepo.save(user);
	}
	public boolean goodCredentials(String email, String pwd) {
		return userRepo.existsByEmailAndPwd(email, pwd);
	}
}
