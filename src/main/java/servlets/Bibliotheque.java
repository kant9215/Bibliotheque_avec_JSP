package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import bins.Biblio;
import bins.Livre;

/**
 * Servlet implementation class Bibliotheque
 */
@WebServlet(
		name = "bibliotheque", 
		urlPatterns = { 
				"/bibliotheque", 
				""
		})
public class Bibliotheque extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Bibliotheque() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("bibliotheque", initBibli());
		this.getServletContext().getRequestDispatcher("/jsp/bibliotheque.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	public Biblio initBibli() {
		Livre l1 = new Livre("Machin","contenu","1");
		Livre l2 = new Livre("Truc","contenu","2");
		Livre l3 = new Livre("Bidule","contenu","3");
		ArrayList<Livre> livres = new ArrayList<>();
		livres.add(l1);
		livres.add(l2);
		livres.add(l3);
		Biblio bibli = new Biblio(livres);
		return bibli;
	}
	
}
