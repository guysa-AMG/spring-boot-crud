package com.logger.todo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomersRepository extends JpaRepository<Customers,Integer>{

    void removeById(long id);
}
