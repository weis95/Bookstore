package demo.TaskManager.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

//Standard class as demonstrated during class, with One to many relation
@Entity
public class Category {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long categoryid;
    private String name;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
	private List<Task> task;
    
    public Category() {}

 	public Category(String name) {
 		super();
 		this.name = name;
 	}

	public Long getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(Long categoryid) {
		this.categoryid = categoryid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Task> getTasks() {
		return task;
	}

	public void setTasks(List<Task> task) {
		this.task = task;
	}

	@Override
	public String toString() {
		return "Category [categoryid=" + categoryid + ", name=" + name + "]";
	}
 	
	
}
