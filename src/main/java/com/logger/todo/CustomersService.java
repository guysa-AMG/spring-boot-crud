package com.logger.todo;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CustomersService {
    protected CustomersRepository customerRepo;

    public CustomersService(CustomersRepository customersRepository){
        this.customerRepo= customersRepository;
    }

    public List<Customers> getAll (){
        return customerRepo.findAll();
    }


    public void add_Customer(Customers user){
        this.customerRepo.save(user);
    }

    public boolean removeCustomerById(long id){
        this.customerRepo.removeById(id);
        return true;
    }
    public int getCount(){
        return Math.toIntExact(this.customerRepo.count());
    }

}
