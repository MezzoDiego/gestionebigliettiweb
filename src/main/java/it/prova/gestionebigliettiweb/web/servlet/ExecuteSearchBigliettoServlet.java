package it.prova.gestionebigliettiweb.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.gestionebigliettiweb.model.Biglietto;
import it.prova.gestionebigliettiweb.service.MyServiceFactory;
import it.prova.gestionebigliettiweb.utility.UtilityBigliettoForm;

/**
 * Servlet implementation class ExecuteSearchBigliettoServlet
 */
@WebServlet("/ExecuteSearchBigliettoServlet")
public class ExecuteSearchBigliettoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String provenienzaInputParam = request.getParameter("provenienza");
		String destinazioneInputParam = request.getParameter("destinazione");
		String dataInputParam = request.getParameter("data");
		String prezzoInputParam = request.getParameter("prezzo");
		
		Biglietto bigliettoInstance = UtilityBigliettoForm.createBigliettoFromParams(provenienzaInputParam,
				destinazioneInputParam, dataInputParam, prezzoInputParam);
		try {
			request.setAttribute("listaBigliettiAttribute", MyServiceFactory.getBigliettoServiceInstance().ricerca(bigliettoInstance));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("/biglietto/results.jsp").forward(request, response);
	}

}
