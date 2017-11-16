package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CreditDAO;
import dao.CreditDAOImpl;
import model.Credit;



/**
 * Servlet implementation class CreditController
 */
@WebServlet("/CreditController")
public class CreditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Credit credit;
	private List<Credit> credits;
	private CreditDAO creditDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreditController() {
        super();
        credit = new Credit();
        credits = new ArrayList<Credit>();
        creditDAO = new CreditDAOImpl();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
if (request.getParameter("btn_save")!= null) {
			
			credit.setName(request.getParameter("name"));
			credit.setExpeditionDate(request.getParameter("expeditionDate"));
			credit.setType(request.getParameter("type"));
				
				
			if(credit.getId()==0L) {
				creditDAO.createCredit(credit);
				}else {
				creditDAO.updateCredit(credit);
			}
			
			credits = creditDAO.readAllCredits();
			request.setAttribute("credits", credits);
			request.getRequestDispatcher("credit_list.jsp").forward(request, response);
			
		}else if (request.getParameter("btn_new")!=null) {
			credit = new Credit();
			request.getRequestDispatcher("credit_form.jsp").forward(request, response);
			
		
		}else if(request.getParameter("btn_edit")!=null) {	
			try {
				Long id = Long.parseLong(request.getParameter("id"));
				credit = creditDAO.readCredit(id);
				
			}catch (Exception e) {
				
				credit = new Credit();
			}
			request.setAttribute("credit", credit);
			
			request.getRequestDispatcher("credit_form.jsp").forward(request, response);
			
			
			
		}else if(request.getParameter("btn_delete")!=null) {
		
			
			try {
			Long id = Long.parseLong(request.getParameter("id"));
			creditDAO.deleteCredit(id);
			credits = creditDAO.readAllCredits();
			
			}catch(Exception e) {
				e.printStackTrace();
				
				
			}
			request.setAttribute("credits", credits);
			request.getRequestDispatcher("credit_list.jsp").forward(request, response);
		}else {
			credits = creditDAO.readAllCredits();
			request.setAttribute("credits", credits);
			request.getRequestDispatcher("credit_list.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
