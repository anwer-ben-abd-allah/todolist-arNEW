package gl2.miniproject.todolist.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gl2.miniproject.todolist.model.Task;
import gl2.miniproject.todolist.repository.TaskRepository;

@Service
public class TaskService {

	@Autowired // donner une instance de cette classe
	private TaskRepository taskRepository;

	// 1. afficher toutes les taches:

	public List<Task> getAllTasks() {
		return taskRepository.findAll();
	}

	// 2. create new task:

	public Task createTask(Task task) {

		return taskRepository.save(task);
	}

	public void deleteById(Long id) {
		taskRepository.deleteById(id);
	}

	public Task modify(Task task) {
		return taskRepository.save(task);
	}
	
	public Optional<Task> getTaskById(Long id) {
		return taskRepository.findById(id);
	}
		
		
	public Task modifyName(Long id, String newName) {
	    Task task = taskRepository.findById(id)
	        .orElseThrow(() -> new RuntimeException("Task not found"));
	    task.setName(newName);
	    return taskRepository.save(task);
	}

	public Task modifyStatus(Long id) {
	    Task task = taskRepository.findById(id)
	        .orElseThrow(() -> new RuntimeException("Task not found"));
	    task.setFinished(!task.isFinished()); 
	    return taskRepository.save(task);
	}
}
