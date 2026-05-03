package gl2.miniproject.todolist.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

// Représentation des données 

@Entity
@Table(name = "tasks")
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "task_id")
	private Long id;

	private String name;

	private boolean finished;

	
	private LocalDateTime creationDate;
	@ManyToOne
	@JoinColumn(name = "user_id")
	@JsonIgnoreProperties("tasks")
	private User user;
	// constructeurs:

	public Task() {
		this.finished = false;
		this.creationDate = LocalDateTime.now();

	}

	public Task(String name, User user) {
		this.user = user;
		this.name = name;
		this.finished = false; // par defaut non fait
		this.creationDate = LocalDateTime.now();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public boolean isFinished() {
		return finished;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setFinished(boolean finished) {
		this.finished = finished;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}


}
