package crudCadastro.crud.controller;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import crudCadastro.crud.model.Greeting;
import crudCadastro.crud.model.User;
import crudCadastro.crud.repository.CrudRepository;

@RestController
public class CrudController {
	
	private static final String template = "Hello, %s!";

	private final AtomicLong counter = new AtomicLong();
	
	@Autowired
	CrudRepository crudRepository;
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/usr/all")
    public List<User> getAllUsr(){
        return crudRepository.findAll();
    }
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(path = "/usr", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public User saveUsr(@Validated @RequestBody User user){
        return crudRepository.save(user);
    }
	
	@CrossOrigin(origins = "http://localhost:3000")
	@DeleteMapping("/usr/{id}")
	public void delUsr(@PathVariable Integer id) {
		User user = crudRepository.getReferenceById(id);
		crudRepository.delete(user);
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/usr/{id}")
    public User getUsrById(@PathVariable Integer id){
        return crudRepository.getById(id);
    }
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(required = false, defaultValue = "World") String name) {
		System.out.println("==== get greeting ====");
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}

	@GetMapping("/greeting-javaconfig")
	public Greeting greetingWithJavaconfig(@RequestParam(required = false, defaultValue = "World") String name) {
		System.out.println("==== in greeting ====");
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
	

}
