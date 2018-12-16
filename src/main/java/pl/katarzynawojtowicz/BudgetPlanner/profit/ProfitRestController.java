package pl.katarzynawojtowicz.BudgetPlanner.profit;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pl.katarzynawojtowicz.BudgetPlanner.model.CustomUserDetails;

@RestController
@RequestMapping("/api/profit")
public class ProfitRestController {

	@PreAuthorize("isAuthenticated()")
	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> addNewProfit(@RequestBody ProfitTo newProfit) {

		CustomUserDetails userDetails = getUserDetails();
		ProfitDao.addNewProfit(newProfit, userDetails.getId());
		return new ResponseEntity<>(HttpStatus.OK);

	}

	@PreAuthorize("isAuthenticated()")
	@RequestMapping(value = "/search", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ProfitTo>> getFindByStatus(
			@RequestParam(value = "nazwa", required = false) String nazwa,
			@RequestParam(value = "data-przychodu", required = false) String dataPrzychodu) throws ParseException {

		Date date = dataPrzychodu != null ? new SimpleDateFormat("dd.MM.yyyy").parse(dataPrzychodu) : null;
		CustomUserDetails userDetails = getUserDetails();
		List<ProfitTo> searchByStatus = ProfitDao.findByParameters(nazwa, date, userDetails.getId());
		return new ResponseEntity<>(searchByStatus, HttpStatus.OK);

	}

	@PreAuthorize("isAuthenticated()")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> remove(@PathVariable long id) {

		CustomUserDetails userDetails = getUserDetails();
		ProfitDao.removeProfit(id, userDetails.getId());
		return new ResponseEntity<>(HttpStatus.OK);

	}

	@PreAuthorize("isAuthenticated()")
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> edit(@PathVariable long id, @RequestBody ProfitTo newProfit) {

		CustomUserDetails userDetails = getUserDetails();
		ProfitDao.editProfit(newProfit, userDetails.getId());
		return new ResponseEntity<>(HttpStatus.OK);

	}

	@PreAuthorize("isAuthenticated()")
	@RequestMapping(value = "/details/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProfitTo> findById(@PathVariable long id) {

		CustomUserDetails userDetails = getUserDetails();
		ProfitTo result = ProfitDao.findById(id, userDetails.getId());
		return new ResponseEntity<>(result, HttpStatus.OK);

	}

	private CustomUserDetails getUserDetails() {
		return (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
	}

}