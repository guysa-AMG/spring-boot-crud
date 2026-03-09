package com.logger.todo;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;


@RestController
@RequestScope
public class CustomerController {
    
    CustomersService cs;

    public CustomerController(CustomersService cis){this.cs=cis;};


    @GetMapping("/users")
    public List<Customers> getUser(  ) {
        return cs.getAll();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/adduser")
    public boolean addUser(@RequestBody Customers request){
        this.cs.add_Customer(request);
        return true;
    };

    @DeleteMapping("/user/{id}")
    public ResponseEntity<Void> remove(@PathVariable long id){
        boolean successful =this.cs.removeCustomerById(id);
        if (successful){
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }


    
}
