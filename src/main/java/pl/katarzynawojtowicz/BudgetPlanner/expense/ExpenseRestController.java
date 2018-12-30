package pl.katarzynawojtowicz.BudgetPlanner.expense;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/expense")
public class ExpenseRestController {

	@Autowired
	private ExpenseService expenseService;

	@PreAuthorize("isAuthenticated()")
	@RequestMapping(value = "/search", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ExpenseTo>> getFindByStatus(
			@RequestParam(value = "status", required = false) Status status,
			@RequestParam(value = "kategoria", required = false) String kategoria,
			@RequestParam(value = "nazwa", required = false) String nazwa,
			@RequestParam(value = "data-wydatku", required = false) String dataWydatku) throws ParseException {

		List<ExpenseTo> expenseList = expenseService.getFindByStatus(status, kategoria, nazwa, dataWydatku);
		return new ResponseEntity<>(expenseList, HttpStatus.OK);
	}

	@PreAuthorize("isAuthenticated()")
	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void addNewExpense(@RequestBody ExpenseTo newExpense) {
		addNewExpense(newExpense);
	}

	@PreAuthorize("isAuthenticated()")
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public void remove(@PathVariable long id) {
		remove(id);

	}

	@PreAuthorize("isAuthenticated()")
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void edit(@PathVariable long id, @RequestBody ExpenseTo newExpense) {
		edit(id, newExpense);
	}

	@PreAuthorize("isAuthenticated()")
	@RequestMapping(value = "/details/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ExpenseTo> findById(@PathVariable long id) {
		ExpenseTo findById = expenseService.findById(id);
		return new ResponseEntity<>(findById, HttpStatus.OK);

	}

}
