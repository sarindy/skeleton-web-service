package org.example.ws.service;

import java.util.Collection;

import org.example.ws.model.Greeting;
import org.example.ws.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GreetingServiceBean implements GreetingService {

	/**
	 * Rem the below helper method in order to use Data JPA
	 */
	/*
	 * private static Long nextId; private static Map<Long, Greeting>
	 * greetingMap;
	 * 
	 * private static Greeting save(Greeting greeting) { if (greetingMap ==
	 * null) { greetingMap = new HashMap<Long, Greeting>(); nextId = new
	 * Long(1); }
	 * 
	 * // If Update
	 * 
	 * if (greeting.getId() != null) { Greeting oldGreeting =
	 * greetingMap.get(greeting.getId()); if (oldGreeting == null) { return
	 * null; } greetingMap.remove(greeting.getId());
	 * greetingMap.put(greeting.getId(), greeting); return greeting; } // If
	 * Update greeting.setId(nextId); nextId +=1;
	 * greetingMap.put(greeting.getId(), greeting); return greeting;
	 * 
	 * }
	 * 
	 * private static void remove(Long id) { greetingMap.remove(id);
	 * System.out.println(greetingMap.get(id));
	 * 
	 * }
	 * 
	 * static { Greeting g1 = new Greeting(); g1.setText("Hello World");
	 * save(g1);
	 * 
	 * Greeting g2 = new Greeting(); g2.setText("សួរស្តីបាទ"); save(g2);
	 * 
	 * Greeting g3 = new Greeting(); g3.setText("你好"); save(g3);
	 * 
	 * Greeting g4 = new Greeting(); g4.setText("สวัสดี"); save(g4);
	 * 
	 * Greeting g5 = new Greeting(); g5.setText("வணக்கம்"); save(g5);
	 * 
	 * }
	 * 
	 * // ***********************************
	 */

	@Autowired
	private GreetingRepository greetingRepository;

	@Override
	public Collection<Greeting> findAll() {
		// Collection<Greeting> greetings = greetingMap.values();
		// return greetings;
		Collection<Greeting> greeting = greetingRepository.findAll();
		return greeting;
	}

	@Override
	public Greeting create(Greeting greeting) {
		// Greeting saveGreeting = save(greeting);

		if (greeting.getId() != null) {
			// Can not create greeting with this ID
			return null;
		}
		Greeting saveGreeting = greetingRepository.save(greeting);
		return saveGreeting;
	}

	@Override
	public Greeting update(Greeting greeting) {
		Greeting persistedGreeting = findOne(greeting.getId());
		if (persistedGreeting == null) {
			// Can not update
			return null;
		}

		Greeting updateGreeting = greetingRepository.save(greeting);

		return updateGreeting;
	}

	@Override
	public void delete(Long id) {
		greetingRepository.delete(id);
	}

	@Override
	public Greeting findOne(Long id) {
		Greeting greeting = greetingRepository.findOne(id);
		return greeting;

	}

}
