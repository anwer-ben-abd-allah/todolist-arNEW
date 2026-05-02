package gl2.miniproject.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import gl2.miniproject.todolist.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	public boolean existByEmail(User user);
	public boolean existsByEmailAndPwd(String email, String pwd);
}
