package com.pranay.RestFullApi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pranay.RestFullApi.model.Customer;
import com.pranay.RestFullApi.service.CustomerService;

@RestController
@RequestMapping("/Demo")
public class CustomerController {
    @Autowired
	private CustomerService customerService;
     @PostMapping("/newCustomer")
    public ResponseEntity<String > addCustomer(@Valid@RequestBody Customer customer){
    	
    	customerService.save(customer);
    	return new ResponseEntity<String>("Recored Stored Succefully",HttpStatus.OK);
    	
}
     @GetMapping("/findAll")
     public ResponseEntity<List<Customer>>getAll(){
		return new ResponseEntity<List<Customer>>(customerService.findAll() , HttpStatus.OK);
    	 
     }
     
     @GetMapping("/findById/{id}")
     public ResponseEntity<Customer>getDetailById(@PathVariable Long id){
		return new ResponseEntity<Customer>(customerService.findById(id) , HttpStatus.OK);
    	 
     }
     
     @PutMapping("/updateRecord/{id}")
     public ResponseEntity<String>update(@PathVariable Long id , @RequestBody Customer customer){
    	 if(customerService.findById(id)==null)
    	 {
    		 return new ResponseEntity<String>("Record Not Found",HttpStatus.NOT_FOUND);
    	 }
    	 else
    	 {
    		 customerService.updateNameById(id);
    		
    	 }
    	 customerService.save(customer);
    	 return new ResponseEntity<String>("Record Update Succefully" , HttpStatus.OK);
     }
     

}