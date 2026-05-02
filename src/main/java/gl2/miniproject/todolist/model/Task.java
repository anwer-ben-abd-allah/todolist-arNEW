package gl2.miniproject.todolist.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;


// Représentation des données 

@Entity
public class Task {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	
	private String name;
	
	private boolean finished;
	
	
	 @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
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
