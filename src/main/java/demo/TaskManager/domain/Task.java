package demo.TaskManager.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

//Standard class as demonstrated in class with a join to catergory class.
@Entity
public class Task {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String title;
	private String TaskDesc;
	private String TaskDueDate;
	private String TaskCreateDate;
	private String TaskCreator;
	
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "categoryid")
    private Category category;
    
	public Task(){
		
	}
	
	public Task(String title, String TaskDesc, String TaskDueDate, String TaskCreateDate, String TaskCreator, Category category) {
		super();
		this.title = title;
		this.TaskDesc = TaskDesc;
		this.TaskDueDate = TaskDueDate;
		this.TaskCreateDate = TaskCreateDate;
		this.TaskCreator = TaskCreator;
		this.category = category;
	}
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTaskDesc() {
		return TaskDesc;
	}
	public void setTaskDesc(String TaskDesc) {
		this.TaskDesc = TaskDesc;
	}
	public String getTaskDueDate() {
		return TaskDueDate;
	}
	public void setTaskDueDate(String TaskDueDate) {
		this.TaskDueDate = TaskDueDate;
	}
	public String getTaskCreateDate() {
		return TaskCreateDate;
	}
	public void setTaskCreateDate(String TaskCreateDate) {
		this.TaskCreateDate = TaskCreateDate;
	}
	public String getTaskCreator() {
		return TaskCreator;
	}
	public void setTaskCreator(String TaskCreator) {
		this.TaskCreator = TaskCreator;
	}
	@Override
	public String toString() {
		if (this.category != null)
			return "Task [id=" + id + ", title=" + title + ", TaskDesc=" + TaskDesc + ", TaskDueDate=" + TaskDueDate + ", TaskCreateDate=" + TaskCreateDate
					+ ", TaskCreator=" + TaskCreator + "]";
		else
			
		return "Task [id=" + id + ", title=" + title + ", TaskDesc=" + TaskDesc + ", TaskDueDate=" + TaskDueDate + ", TaskCreateDate=" + TaskCreateDate
				+ ", TaskCreator=" + TaskCreator + ", category=" + category + "]";
	}
	
}
