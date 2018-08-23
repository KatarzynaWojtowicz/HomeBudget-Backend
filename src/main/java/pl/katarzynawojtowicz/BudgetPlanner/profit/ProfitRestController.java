package pl.katarzynawojtowicz.BudgetPlanner.profit;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

public class ProfitRestController {

	@CrossOrigin
	@RestController
	@RequestMapping("/profit")
	public class ExpenseRestController {

		@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Object> addNewProfit(@RequestBody ProfitTo newProfit) {
			ProfitDao.addNewProfit(newProfit);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
}
