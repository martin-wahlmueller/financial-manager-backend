package backend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {

	@GetMapping
	public ResponseEntity<String> test() {
		return new ResponseEntity<String>("Hello World", HttpStatus.OK);
	}
}
