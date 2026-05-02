package gl2.miniproject.todolist.repository;

import gl2.miniproject.todolist.model.Task;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {
	
}
