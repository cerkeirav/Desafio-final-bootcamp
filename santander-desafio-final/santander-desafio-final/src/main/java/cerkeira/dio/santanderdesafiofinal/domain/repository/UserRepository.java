package cerkeira.dio.santanderdesafiofinal.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cerkeira.dio.santanderdesafiofinal.domain.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

	boolean existsByAccountNumber(String accountNUmber);
}	
