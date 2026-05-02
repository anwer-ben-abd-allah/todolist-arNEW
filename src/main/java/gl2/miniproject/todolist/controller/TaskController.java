package gl2.miniproject.todolist.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*; // pour restcontroller et mapping

import gl2.miniproject.todolist.model.Task;
import gl2.miniproject.todolist.service.TaskService;



@RestController
@RequestMapping("/api/tasks")

public class TaskController {
	
	@Autowired
	private TaskService taskService;
	
	// GET task : show task
	@GetMapping
	public List<Task> getAllTasks(){
		return taskService.getAllTasks();
	}
	
	// POST task : create task
	
	@PostMapping
	public Task createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }
				
	}
	
	
	



