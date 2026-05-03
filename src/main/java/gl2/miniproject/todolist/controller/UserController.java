package gl2.miniproject.todolist.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gl2.miniproject.todolist.DTO.LoginDTO;
import gl2.miniproject.todolist.model.User;
import gl2.miniproject.todolist.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	@Autowired
	private UserService userService;

	@PostMapping("/signup")
	public ResponseEntity<?> signup(@RequestBody User user) {
		User createdUser = userService.addUser(user);
		if (createdUser == null)
			return ResponseEntity.status(HttpStatus.CONFLICT).body(Map.of("message", "Email is used"));
		else
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(Map.of("message", "User created with success", "user", createdUser));
	}

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginDTO login ) {
		HashMap<String, Object> map = new HashMap<>();
		if (userService.goodCredentials(login.getEmail(), login.getPwd())) {
			map.put("status", HttpStatus.OK.value());
			map.put("message", "Authentication successful");
			return ResponseEntity.ok(map);
		} else {
			map.put("status", HttpStatus.UNAUTHORIZED.value());
			map.put("message", "Authentication failed ");
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(map);
		}
	}
	@GetMapping
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}
}
