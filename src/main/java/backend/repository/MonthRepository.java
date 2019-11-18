package backend.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import backend.model.Month;

@Repository
public interface MonthRepository extends CrudRepository<Month, Integer> {
	List<Month> findAllByUserid(int userid);
}
