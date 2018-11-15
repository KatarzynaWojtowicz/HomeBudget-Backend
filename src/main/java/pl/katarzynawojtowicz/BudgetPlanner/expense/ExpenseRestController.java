package pl.katarzynawojtowicz.BudgetPlanner.expense;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/expense")
public class ExpenseRestController {

	@PreAuthorize("isAuthenticated()")
	@RequestMapping(value = "/search", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ExpenseTo>> getFindByStatus(
			@RequestParam(value = "status", required = false) Status status,
			@RequestParam(value = "kategoria", required = false) String kategoria,
			@RequestParam(value = "nazwa", required = false) String nazwa) {
		List<ExpenseTo> searchByStatus = ExpenseDao.findByParameters(status, kategoria, nazwa);
		return new ResponseEntity<>(searchByStatus, HttpStatus.OK);
	}

	@PreAuthorize("isAuthenticated()")
	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> addNewExpense(@RequestBody ExpenseTo newExpense) {
		ExpenseDao.addNewExpense(newExpense);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PreAuthorize("isAuthenticated()")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> remove(@PathVariable long id) {
		ExpenseDao.removeExpense(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PreAuthorize("isAuthenticated()")
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> edit(@PathVariable long id, @RequestBody ExpenseTo newExpense) {
		ExpenseDao.editExpense(newExpense);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PreAuthorize("isAuthenticated()")
	@RequestMapping(value = "/details/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ExpenseTo> findById(@PathVariable long id) {
		ExpenseTo result = ExpenseDao.findById(id);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

}
