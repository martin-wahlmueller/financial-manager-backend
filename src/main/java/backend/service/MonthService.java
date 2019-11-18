package backend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.model.Month;
import backend.repository.MonthRepository;

@Service
public class MonthService {

	@Autowired
	private MonthRepository monthRepository;
	
	public List<Month> findAll() {
		List<Month> list = new ArrayList<Month>();
		monthRepository.findAll().forEach(item -> list.add(item));
		return list;
	}
	
	public Month findById(int id) {
		return monthRepository.findById(id).get();
				
	}
	
	public List<Month> findAllByUserid(int userid) {
		List<Month> list = new ArrayList<Month>();
		monthRepository.findAll().forEach(item -> {
			if(item.getUserid() == userid) {
				list.add(item);
			}
		});
		return list;
	}

}
