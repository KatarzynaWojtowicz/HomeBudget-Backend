package pl.katarzynawojtowicz.BudgetPlanner.profit;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import pl.katarzynawojtowicz.BudgetPlanner.user.CustomUserDetails;

@Service
public class ProfitServiceImpl implements ProfitService {

	@Override
	public void addNewProfit(ProfitTo newProfit) {
		CustomUserDetails userDetails = getUserDetails();
		ProfitDao.addNewProfit(newProfit, userDetails.getId());

	}

	@Override
	public List<ProfitTo> getFindByStatus(String nazwa, String dataPrzychodu) throws ParseException {
		Date date = dataPrzychodu != null ? new SimpleDateFormat("dd.MM.yyyy").parse(dataPrzychodu) : null;
		CustomUserDetails userDetails = getUserDetails();
		List<ProfitTo> searchByStatus = ProfitDao.findByParameters(nazwa, date, userDetails.getId());
		return searchByStatus;

	}

	@Override
	public void remove(long id) {
		CustomUserDetails userDetails = getUserDetails();
		ProfitDao.removeProfit(id, userDetails.getId());
	}

	@Override
	public void edit(long id, ProfitTo newProfit) {
		CustomUserDetails userDetails = getUserDetails();
		ProfitDao.editProfit(newProfit, userDetails.getId());
	}

	@Override
	public ProfitTo findById(long id) {
		CustomUserDetails userDetails = getUserDetails();
		ProfitTo result = ProfitDao.findById(id, userDetails.getId());
		return result;
	}

	private CustomUserDetails getUserDetails() {
		return (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
	}
}
