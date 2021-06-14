package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	private ArrayList<Livre> biblio;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Bibliotheque() {
        super();
        biblio = new ArrayList<Livre>();
    }

    @Override
    public void init() throws ServletException {
    	super.init();
    	initBibli();
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("action") != null && request.getParameter("reference") != null) {
			if (request.getParameter("action").equals("delete"))
				delLivre(request.getParameter("reference"));	//method supp du livre
			else if (request.getParameter("action").equals("modif"))
				request.setAttribute("modifLivre",findLivre(request.getParameter("reference"))); // on ajoute ce livre dans la request
		}
		request.setAttribute("bibliotheque", biblio);
		this.getServletContext().getRequestDispatcher("/jsp/bibliotheque.jsp").forward(request, response);
		
	}

	

	private void delLivre(String parameter) {
		if (findLivre(parameter) != null)
			this.biblio.remove(findLivre(parameter));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("to") != null && request.getParameter("to").equals("add")) {
		Livre livreNew = new Livre(request.getParameter("auteur"),request.getParameter("titre"),request.getParameter("reference"));
		this.biblio.add(livreNew);
		
		}
		else if (request.getParameter("to") != null && request.getParameter("to").equals("mod")) {
			Livre mLivre = findLivre(request.getParameter("reference"));
			mLivre.setTitre(request.getParameter("titre"));
			mLivre.setAuteur(request.getParameter("auteur"));
		}
		response.sendRedirect(request.getContextPath()); // 
	}

	public void initBibli() {
		Livre l1 = new Livre("Machin","contenu","1");
		Livre l2 = new Livre("Truc","contenu","2");
		Livre l3 = new Livre("Bidule","contenu","3");
		
		this.biblio.add(l1);
		this.biblio.add(l2);
		this.biblio.add(l3);
		
	}
	
	private Livre findLivre(String reference) {
		Livre temp = null;;
		for (Livre livre : biblio) {
			if (livre.getReference().equals(reference)) {
				temp = livre;
			}
		}
		return temp != null ? temp:null;
	}
	
}
