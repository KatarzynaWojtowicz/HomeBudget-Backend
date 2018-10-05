package pl.katarzynawojtowicz.BudgetPlanner.profit;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/profit")
public class ProfitRestController {

	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> addNewProfit(@RequestBody ProfitTo newProfit) {
		ProfitDao.addNewProfit(newProfit);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ProfitTo>> getFindByStatus(
			@RequestParam(value = "nazwa", required = false) String nazwa) {
		List<ProfitTo> searchByStatus = ProfitDao.findByParameters(nazwa);
		return new ResponseEntity<>(searchByStatus, HttpStatus.OK);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> remove(@PathVariable long id) {
		ProfitDao.removeProfit(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> edit(@PathVariable long id, @RequestBody ProfitTo newProfit) {
		ProfitDao.editProfit(newProfit);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(value = "/details/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProfitTo> findById(@PathVariable long id) {
		ProfitTo result = ProfitDao.findById(id);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

}