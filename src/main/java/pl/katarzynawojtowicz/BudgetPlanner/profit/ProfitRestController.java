package pl.katarzynawojtowicz.BudgetPlanner.profit;

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
@RequestMapping("/api/profit")
public class ProfitRestController {

	@Autowired
	private ProfitService profitService;

	@PreAuthorize("isAuthenticated()")
	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void addNewProfit(@RequestBody ProfitTo newProfit) {
		profitService.addNewProfit(newProfit);

	}

	@PreAuthorize("isAuthenticated()")
	@RequestMapping(value = "/search", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ProfitTo>> getFindByStatus(
			@RequestParam(value = "nazwa", required = false) String nazwa,
			@RequestParam(value = "data-przychodu", required = false) String dataPrzychodu) throws ParseException {

		List<ProfitTo> profitList = profitService.getFindByStatus(nazwa, dataPrzychodu);
		return new ResponseEntity<>(profitList, HttpStatus.OK);

	}

	@PreAuthorize("isAuthenticated()")
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public void remove(@PathVariable long id) {
		profitService.remove(id);
	}

	@PreAuthorize("isAuthenticated()")
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void edit(@PathVariable long id, @RequestBody ProfitTo newProfit) {
		profitService.edit(id, newProfit);
	}

	@PreAuthorize("isAuthenticated()")
	@RequestMapping(value = "/details/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProfitTo> findById(@PathVariable long id) {
		ProfitTo findById = profitService.findById(id);
		return new ResponseEntity<>(findById, HttpStatus.OK);

	}

}