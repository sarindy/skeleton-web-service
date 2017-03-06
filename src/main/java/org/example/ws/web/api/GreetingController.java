package org.example.ws.web.api;

import java.util.Collection;

import org.example.ws.model.Greeting;
import org.example.ws.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author dy
 *
 */

@RestController
public class GreetingController {
	
	@Autowired
	private GreetingService greetingService;
	

	/**
	 * The method below is the helper to generate the hard coding list of the
	 * greeting
	 **/

//	private static BigInteger nextId;
//	private static Map<BigInteger, Greeting> greetingMap;
//
//	private static Greeting save(Greeting greeting) {
//		if (greetingMap == null) {
//			greetingMap = new HashMap<BigInteger, Greeting>();
//			nextId = BigInteger.ONE;
//		}
//
//		// If Update
//
//		if (greeting.getId() != null) {
//			Greeting oldGreeting = greetingMap.get(greeting.getId());
//			if (oldGreeting == null) {
//				return null;
//			}
//			greetingMap.remove(greeting.getId());
//			greetingMap.put(greeting.getId(), greeting);
//			return greeting;
//		}
//		// If Update
//		greeting.setId(nextId);
//		nextId = nextId.add(BigInteger.ONE);
//		greetingMap.put(greeting.getId(), greeting);
//		return greeting;
//
//	}
//
//	private static boolean delete(BigInteger id) {
//		Greeting deleteGreeting = greetingMap.remove(id);
//		if (deleteGreeting == null) {
//			return false;
//		}
//		return true;
//	}
//
//	static {
//		Greeting g1 = new Greeting();
//		g1.setText("Hello World");
//		save(g1);
//
//		Greeting g2 = new Greeting();
//		g2.setText("សួរស្តីបាទ");
//		save(g2);
//
//		Greeting g3 = new Greeting();
//		g3.setText("你好");
//		save(g3);
//
//		Greeting g4 = new Greeting();
//		g4.setText("สวัสดี");
//		save(g4);
//
//		Greeting g5 = new Greeting();
//		g5.setText("வணக்கம்");
//		save(g5);
//
//	}
//
//	// ***********************************

	@RequestMapping(value = "/api/greetings", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Greeting>> GetGreeting() {
		/**
		 * This ResponseEntity here is tell spring to convert the response into
		 * http response.
		 **/

		//Collection<Greeting> greetings = greetingMap.values();
		Collection<Greeting> greetings=greetingService.findAll();
		return new ResponseEntity<Collection<Greeting>>(greetings, HttpStatus.OK);
	}

	@RequestMapping(value = "/api/greetings/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Greeting> GetGreetingById(@PathVariable("id") Long id) {
		//Greeting greeting = greetingMap.get(id);
		Greeting greeting = greetingService.findOne(id);
		if (greeting == null) {
			return new ResponseEntity<Greeting>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Greeting>(greeting, HttpStatus.OK);
	}

	@RequestMapping(value = "/api/greetings/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Greeting> addGreeting(@RequestBody Greeting greeting) {
		Greeting saveGreeting = greetingService.create(greeting);
		return new ResponseEntity<Greeting>(saveGreeting, HttpStatus.CREATED);

	}

	@RequestMapping(value = "/api/greetings/update", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Greeting> updateGreeting(@RequestBody Greeting greeting) {
		Greeting updateGreeting = greetingService.update(greeting);
		if (updateGreeting == null) {
			return new ResponseEntity<Greeting>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Greeting>(updateGreeting, HttpStatus.OK);
	}

	@RequestMapping(
            value = "/api/greetings/{id}",
            method = RequestMethod.DELETE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Greeting> deleteGreeting(@PathVariable("id") Long id,
            @RequestBody Greeting greeting) {

        greetingService.delete(id);

        return new ResponseEntity<Greeting>(HttpStatus.NO_CONTENT);
    }
}
