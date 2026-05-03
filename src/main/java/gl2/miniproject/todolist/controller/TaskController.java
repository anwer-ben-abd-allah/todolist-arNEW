package gl2.miniproject.todolist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
// pour restcontroller et mapping
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	// delete task 
	@DeleteMapping("/{id}")
	public void deleteTask(@PathVariable Long id) {
		taskService.deleteById(id);
	}
	
	@PatchMapping("/{id}")
	public Task modifyTask(@PathVariable Long id,@RequestBody Task in_task) {
		Task real_task = taskService.getTaskById(id).orElse(null);
		if (real_task == null) 
			return null;
		if (in_task.getName()!= null) 
			real_task.setName(in_task.getName());
		if (in_task.isFinished() != false)
			real_task.setFinished(in_task.isFinished());
		return real_task;
	}
	
	//modify name
	@PatchMapping("/{id}/name")
	public Task modifyName(@PathVariable Long id, @RequestBody String newName) {
	    return taskService.modifyName(id, newName);
	}

	//modify status
	@PatchMapping("/{id}/status")
	public Task modifyStatus(@PathVariable Long id) {
	    return taskService.modifyStatus(id);
	}

}
