package pl.katarzynawojtowicz.BudgetPlanner.expense;

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
@RequestMapping("/expense")
public class ExpenseRestController {

	@RequestMapping(value = "/search", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ExpenseTo>> getFindByStatus(
			@RequestParam(value = "status", required = false) Status status,
			@RequestParam(value = "kategoria", required = false) String kategoria,
			@RequestParam(value = "nazwa", required = false) String nazwa) {
		List<ExpenseTo> searchByStatus = ExpenseDao.findByParameters(status, kategoria, nazwa);
		return new ResponseEntity<>(searchByStatus, HttpStatus.OK);
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> addNewExpense(@RequestBody ExpenseTo newExpense) {
		ExpenseDao.addNewExpense(newExpense);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
