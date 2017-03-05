package org.example.ws.service;

import java.math.BigInteger;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.example.ws.model.Greeting;
import org.springframework.stereotype.Service;

@Service
public class GreetingServiceBean implements GreetingService {

	private static Long nextId;
	private static Map<Long, Greeting> greetingMap;

	private static Greeting save(Greeting greeting) {
		if (greetingMap == null) {
			greetingMap = new HashMap<Long, Greeting>();
			nextId = new Long(1);
		}

		// If Update

		if (greeting.getId() != null) {
			Greeting oldGreeting = greetingMap.get(greeting.getId());
			if (oldGreeting == null) {
				return null;
			}
			greetingMap.remove(greeting.getId());
			greetingMap.put(greeting.getId(), greeting);
			return greeting;
		}
		// If Update
		greeting.setId(nextId);
		nextId +=1;
		greetingMap.put(greeting.getId(), greeting);
		return greeting;

	}

	private static  void remove(Long id) {
		greetingMap.remove(id);
		System.out.println(greetingMap.get(id));
		
	}

	static {
		Greeting g1 = new Greeting();
		g1.setText("Hello World");
		save(g1);

		Greeting g2 = new Greeting();
		g2.setText("សួរស្តីបាទ");
		save(g2);

		Greeting g3 = new Greeting();
		g3.setText("你好");
		save(g3);

		Greeting g4 = new Greeting();
		g4.setText("สวัสดี");
		save(g4);

		Greeting g5 = new Greeting();
		g5.setText("வணக்கம்");
		save(g5);

	}

	// ***********************************

	@Override
	public Collection<Greeting> findAll() {
		Collection<Greeting> greetings = greetingMap.values();
		return greetings;
	}

	@Override
	public Greeting create(Greeting greeting) {
		Greeting saveGreeting = save(greeting);
		return saveGreeting;
	}

	@Override
	public Greeting update(Greeting greeting) {
		Greeting updateGreeting = save(greeting);
		return updateGreeting;
	}

	@Override
	public void delete(Long id) {
		remove(id);

	}

	@Override
	public Greeting findOne(BigInteger id) {
		Greeting greeting = greetingMap.get(id);
		return greeting;

	}

}
