package gl2.miniproject.todolist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
// pour restcontroller et mapping
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gl2.miniproject.todolist.DTO.TaskDTO;
import gl2.miniproject.todolist.model.Task;
import gl2.miniproject.todolist.model.User;
import gl2.miniproject.todolist.service.TaskService;
import gl2.miniproject.todolist.service.UserService;

@RestController
@RequestMapping("/api/tasks")

public class TaskController {

	@Autowired
	private TaskService taskService;
	@Autowired
	private UserService userService;
	// GET task : show task
	@GetMapping
	public List<Task> getAllTasks() {
		return taskService.getAllTasks();
	}

	// POST task : create task

	@PostMapping
	public Task createTask(@RequestBody TaskDTO task) {
		
		
		User user = userService.getUserById(task.getId()).orElseThrow(
				() -> new RuntimeException("no user found"));
		
		Task newTask = new Task();
		newTask.setUser(user);
		newTask.setName(task.getName());
		return taskService.createTask(newTask);
	}

}
