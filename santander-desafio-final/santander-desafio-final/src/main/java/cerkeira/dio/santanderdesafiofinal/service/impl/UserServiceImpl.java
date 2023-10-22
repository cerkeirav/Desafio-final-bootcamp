package cerkeira.dio.santanderdesafiofinal.service.impl;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import cerkeira.dio.santanderdesafiofinal.domain.model.User;
import cerkeira.dio.santanderdesafiofinal.domain.repository.UserRepository;
import cerkeira.dio.santanderdesafiofinal.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	/*o spring entende que para criar o componente UserServiceImpl ele vai precisar 
	injetar uma instancia do UserRepository e ja faz isso de forma automatica*/
	
	private final UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public User findById(Long id) {
		return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
	}
	
	@Override
	public User create(User userToCreate) {
		if(userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())) {
			throw new IllegalArgumentException("The account number already exists");
		}
		return userRepository.save(userToCreate);
	}

}
