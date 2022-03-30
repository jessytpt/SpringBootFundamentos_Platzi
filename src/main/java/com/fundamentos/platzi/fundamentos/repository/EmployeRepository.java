package com.fundamentos.platzi.fundamentos.repository;

import com.fundamentos.platzi.fundamentos.dto.EmployeDto;
import com.fundamentos.platzi.fundamentos.entity.Employe;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeRepository extends JpaRepository<Employe, Long> {

  /* @Query(nativeQuery = true, value="select * from employe where email_employee = :email_employee")
    Employe findByEmployeEmail(@Param("email_employee")String email);

   @Query(value="select e from Employe e where e.email_employee = ?1")
    Optional<Employe> findByEmail_employee(String mail);

   @Query("select e from Employe e where e.name_employee like ?1%")
    List<Employe> findAndSort(String name, Sort sort);

   List<Employe> findByName_employee(String name_employee);

   List<Employe> findByNameLike(String name);
*/
   @Query("SELECT new com.fundamentos.platzi.fundamentos.dto.EmployeDto(u.id,u.name,u.email) " +
           "FROM Employe u " +
           "where u.email=:paramEmail")
   Optional<EmployeDto> getAllByEmail(@Param("paramEmail")String email);
}
