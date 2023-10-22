package cerkeira.dio.santanderdesafiofinal.service;

import cerkeira.dio.santanderdesafiofinal.domain.model.User;

public interface UserService {
	
	User findById(Long id);
	User create(User userToCreate);
}
