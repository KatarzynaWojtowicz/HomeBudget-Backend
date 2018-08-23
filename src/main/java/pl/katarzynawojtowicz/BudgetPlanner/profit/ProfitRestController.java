package pl.katarzynawojtowicz.BudgetPlanner.profit;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
}
