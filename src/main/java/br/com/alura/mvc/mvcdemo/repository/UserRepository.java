package br.com.alura.mvc.mvcdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.mvc.mvcdemo.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>{

	User findByUsername(String username);
		
}
