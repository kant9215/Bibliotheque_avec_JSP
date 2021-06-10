package bins;

import java.util.ArrayList;

public class Biblio {

	private ArrayList<Livre> livres;

	public Biblio(ArrayList<Livre> livres) {
		super();
		this.livres = livres;
	}

	public ArrayList<Livre> getLivres() {
		return livres;
	}

	public void setLivres(ArrayList<Livre> livres) {
		this.livres = livres;
	}
	
	
}
