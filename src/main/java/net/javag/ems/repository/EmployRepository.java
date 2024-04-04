package net.javag.ems.repository;

import net.javag.ems.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployRepository extends JpaRepository<Employee,Long> {




}
