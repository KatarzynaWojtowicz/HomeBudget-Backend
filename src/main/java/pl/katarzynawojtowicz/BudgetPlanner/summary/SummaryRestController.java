package pl.katarzynawojtowicz.BudgetPlanner.summary;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/summary")
public class SummaryRestController {

	@Autowired
	private SummaryService summaryService;

	@PreAuthorize("isAuthenticated()")
	@RequestMapping(value = "/monthly", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<MonthSummaryTo>> getMonthlySummary() {
		List<MonthSummaryTo> monthlySummary = summaryService.getMonthlySummary();
		return new ResponseEntity<>(monthlySummary, HttpStatus.OK);
	}

}
