package gl2.miniproject.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import gl2.miniproject.todolist.model.User;

public interface UserRepository extends JpaRepository<Long, User> {
	
}
