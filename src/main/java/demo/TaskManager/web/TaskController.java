package demo.TaskManager.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import demo.TaskManager.domain.Task;
import demo.TaskManager.domain.TaskRepository;
import demo.TaskManager.domain.CategoryRepository;


@Controller
public class TaskController {
	@Autowired
	private TaskRepository repository; 
	
	@Autowired
	private CategoryRepository crepository; 
	
    @RequestMapping(value="/login")
    public String login() {	
        return "login";
    }	
	
    @RequestMapping(value= {"/", "/tasklist"})
    public String tasklist(Model model) {	
        model.addAttribute("tasks", repository.findAll());
        return "tasklist";
    }
  
    @RequestMapping(value = "/add")
    public String addStudent(Model model){
    	model.addAttribute("task", new Task());
    	model.addAttribute("categories", crepository.findAll());
        return "addtask";
    }     
    
	// RESTful service to get all students
    @RequestMapping(value="/tasks", method = RequestMethod.GET)
    public @ResponseBody List<Task> tasklistRest() {	
        return (List<Task>) repository.findAll();
    }    

	// RESTful service to get by id
    @RequestMapping(value="/task/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Task> findTaskRest(@PathVariable("id") Long taskId) {	
    System.out.println(repository.findById(taskId));
    	return repository.findById(taskId);
    }   
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Task task){
        repository.save(task);
        return "redirect:tasklist";
    }    
 
    
    @RequestMapping(value = "/edit/{id}")
    public String addTask(@PathVariable("id") Long taskId, Model model){
    model.addAttribute("task", repository.findById(taskId));
    model.addAttribute("categories", crepository.findAll());
    return "edittask";
    }
    
    // Delete student
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteTask(@PathVariable("id") Long taskId, Model model) {
    	repository.deleteById(taskId);
        return "redirect:../tasklist";
    } 

}

