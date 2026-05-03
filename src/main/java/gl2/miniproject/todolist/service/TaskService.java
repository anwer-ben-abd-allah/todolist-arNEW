package gl2.miniproject.todolist.service;

import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gl2.miniproject.todolist.model.Task;
import gl2.miniproject.todolist.model.User;
import gl2.miniproject.todolist.repository.TaskRepository;
import gl2.miniproject.todolist.repository.UserRepository;

@Service
public class TaskService {

	
	
	@Autowired //donner une instance de cette classe
	private TaskRepository taskRepository;



	//1. afficher toutes les taches:
	
	public List<Task> getAllTasks(){
		return taskRepository.findAll();
	}

	//2. create new task:
	
	public Task createTask(Task task) {
		
		return taskRepository.save(task);
	}
}
