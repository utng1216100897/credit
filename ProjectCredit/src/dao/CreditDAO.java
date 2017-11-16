package dao;

import java.util.List;

import model.Credit;

public interface CreditDAO {

	Credit readCredit(Long id);
	List<Credit> readAllCredits();
void updateCredit(Credit credit);
void deleteCredit(Long id);
void createCredit(Credit credit);
}
