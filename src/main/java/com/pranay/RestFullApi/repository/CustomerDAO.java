 package com.pranay.RestFullApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pranay.RestFullApi.model.Customer;
@Repository
public interface CustomerDAO extends JpaRepository<Customer, Long> {

}
