package backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import backend.model.Month;
import backend.service.MonthService;

@RestController
@RequestMapping(path = "/api/months", produces = "application/json")
public class MonthController {

	@Autowired
	private MonthService monthService;

	@GetMapping
	public ResponseEntity<List<Month>> getMonths() {
		return new ResponseEntity<List<Month>>(monthService.findAll(), HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Month> getMonthById(@PathVariable(value = "id") int id) {
		return new ResponseEntity<Month>(monthService.findById(id), HttpStatus.OK);
	}

	@GetMapping(value = "/users/{userid}")
	public ResponseEntity<List<Month>> getMonthsByUserid(@PathVariable(value = "userid") int userid) {
		List<Month> months = monthService.findAllByUserid(userid);
		if (!months.isEmpty()) {
			return new ResponseEntity<List<Month>>(months, HttpStatus.OK);
		}
		return new ResponseEntity<List<Month>>(months, HttpStatus.NOT_FOUND);
	}
}
