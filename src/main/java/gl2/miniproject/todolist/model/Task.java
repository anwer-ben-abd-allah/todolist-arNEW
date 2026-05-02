package gl2.miniproject.todolist.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;


// Représentation des données 

@Entity
public class Task {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	
	
	private String name;
	
	private boolean finished;
	
	private LocalDateTime creationDate;
	
	
	// constructeurs:
	
	public Task() {
		this.creationDate =LocalDateTime.now(); 
	}
	
	public Task(String name) {
		this.name=name;
		this.finished=false; // par defaut non fait
		this.creationDate=LocalDateTime.now();
	}

	// getters:
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
	
	// setters:
    public void setId(Long id) {
        this.id = id;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setFinished(boolean finished) {
        this.finished = finished;
    }
    
    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }


	 
}
