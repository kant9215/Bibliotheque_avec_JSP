package bins;

public class Livre {

	private String titre;
	private String auteur;
	private String reference;
	public Livre(String titre, String auteur, String reference) {
		super();
		this.titre = titre;
		this.auteur = auteur;
		this.reference = reference;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getAuteur() {
		return auteur;
	}
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	
	
}
