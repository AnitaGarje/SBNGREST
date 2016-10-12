package com.jgal.web.crud.jpa.da;
 
import org.springframework.data.repository.CrudRepository;
 
import com.jgal.web.crud.jpa.model.User;
 
public interface UserDAO extends CrudRepository<User, Long>{
 
}