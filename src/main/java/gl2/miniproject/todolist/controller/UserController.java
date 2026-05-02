package gl2.miniproject.todolist.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	public ResponseEntity<?> login(@RequestBody User user) {
		HashMap<String, Object> map = new HashMap<>();
		if (userService.goodCredentials(user.getEmail(), user.getPwd())) {
			map.put("status", HttpStatus.OK.value());
			map.put("message", "Authentication successful");
			return ResponseEntity.ok(map);
		} else {
			map.put("status", HttpStatus.UNAUTHORIZED.value());
			map.put("message", "Authentication failed ");
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(map);
		}
	}
}
