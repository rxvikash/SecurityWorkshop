package com.security.securityWorkshop.Repositery;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeeRepo extends JpaRepository<Employees, Long> {

    Employees findByEmail(String email);
}