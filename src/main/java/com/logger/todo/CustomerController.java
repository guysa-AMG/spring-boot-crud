package com.logger.todo;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;


@RestController
@RequestScope
public class CustomerController {
    
    CustomersService cs;

    public CustomerController(CustomersService cis){this.cs=cis;};


    @GetMapping("/users")
    public List<Customers> getUser(  ) {
        return cs.getAll();
    }

    @CrossOrigin(originPatterns = "*")
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
