package mx.com.angeldev.marvelapi.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositoryDAO extends JpaRepository<User, Integer>{
	
	Optional<User> findOneByEmail(String email);

}
