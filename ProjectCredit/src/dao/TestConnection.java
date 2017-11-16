package dao;

import java.util.List;

import model.Credit;

public class TestConnection {
	public static void main(String[] args) {
		CreditDAOImpl creditDAOImpl = new CreditDAOImpl();
		creditDAOImpl.createCredit(new Credit(6L, "Gerardo","12/07/1998","Activo"));
		
		List<Credit> credits = creditDAOImpl.readAllCredits();
		for (Credit credit : credits) {
			System.out.println(credit);
			
		}
	}

}
