package org.example.ws.service;

import java.util.Collection;

import org.example.ws.model.Greeting;
import org.example.ws.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GreetingServiceBean implements GreetingService {

	@Autowired
	private GreetingRepository greetingRepository;

	
	@Override
	public Collection<Greeting> findAll() {
		Collection<Greeting> greeting = greetingRepository.findAll();
		return greeting;
	}

	@Override
	public Greeting findOne(Long id) {
		Greeting greeting = greetingRepository.findOne(id);
		return greeting;
	}

	@Override
	public Greeting create(Greeting greeting) {

		if (greeting.getId() != null) {
			// Can not create greeting with this ID
			return null;
		}
		Greeting savedGreeting = greetingRepository.save(greeting);
		return savedGreeting;
	}

	@Override
	public Greeting update(Greeting greeting) {
		Greeting persistedGreeting = findOne(greeting.getId());
		if (persistedGreeting == null) {
			// Can not update
			return null;
		}
		persistedGreeting.setText(greeting.getText());
		Greeting updateGreeting = greetingRepository.save(persistedGreeting);

		return updateGreeting;
	}

	@Override
	public void delete(Long id) {
		greetingRepository.delete(id);
	}
	

}
