package report;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CreditDAO;
import dao.CreditDAOImpl;
import model.Credit;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

/**
 * Servlet implementation class CreditReport
 */
@WebServlet("/CreditReport")
public class CreditReport extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CreditDAOImpl dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreditReport() {
        super();
        dao = new CreditDAOImpl() {
			
			@Override
			public void updateCredit(Credit credit) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public Credit readCredit(Long id) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public List<Credit> readAllCredits() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public void deleteCredit(Long id) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void createCredit(Credit credit) {
				// TODO Auto-generated method stub
				
			}
		};
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String reportPath = "C:\\Users\\gerardo\\eclipse-workspace\\ProjectCredit\\src\\report\\creditsReport.jrxml";
		try {
			
			JasperReport report = JasperCompileManager.compileReport(reportPath);
			
			Map<String, Object> data = new HashMap<String, Object>();
			// data.put("Image", this.getServletContext().getRealPath("/")+"/images/helloWorld.jpg");
			JasperPrint print = JasperFillManager.fillReport(report, data, dao.getConnetion());
			
			JasperExportManager.exportReportToPdfStream(print, response.getOutputStream());
			
			response.getOutputStream().flush();
			response.getOutputStream().close();
			
			
			
			
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
