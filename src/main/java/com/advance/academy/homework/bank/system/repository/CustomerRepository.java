package com.advance.academy.homework.bank.system.repository;

import com.advance.academy.homework.bank.system.model.Customer;
import com.advance.academy.homework.bank.system.model.enums.UserType;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface  CustomerRepository extends CrudRepository<Customer, Integer> {

    @Query("SELECT c FROM Customer c where userType=:userType")
    List<Customer> getByUserType(@Param("userType") UserType userType);

    @Query(value = "SELECT c.* FROM customers c where c.user_type=:userType", nativeQuery = true)
    List<Customer> getByUserTypeNativeQuery(@Param("userType") UserType userType);

    @Modifying
    @Query("UPDATE Customer SET isDeleted = true WHERE id = :customerId ")
    void deactivateCustomer(@Param("customerId") Integer id);

    @Modifying
    @Query("UPDATE Customer SET isDeleted = true WHERE id = :customerId AND userName=:userName ")
    void deactivateCustomer(
            @Param("customerId") Integer id,
            @Param("userName") String userName
    );
}
