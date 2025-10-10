package Model.Classes.Metiers;

public class Utilisateur {
	
	private String id_utilisateur;
	private String pseudo_utilisateur;
	private String nom_utilisateur;
	private String prenom_utilisateur;
	private String mdp_utilisateur;
	private String tel_utilisateur;
	private String mail_utilisateur;
	
	public Utilisateur(String id_utilisateur,  
			           String nom_utilisateur,
			           String prenom_utilisateur, 
			           String pseudo_utilisateur,
			           String mdp_utilisateur, 
			           String tel_utilisateur, 
			           String mail_utilisateur) {
		super();
		this.id_utilisateur = id_utilisateur;
		this.pseudo_utilisateur = pseudo_utilisateur;
		this.nom_utilisateur = nom_utilisateur;
		this.prenom_utilisateur = prenom_utilisateur;
		this.mdp_utilisateur = mdp_utilisateur;
		this.tel_utilisateur = tel_utilisateur;
		this.mail_utilisateur = mail_utilisateur;
	}	
	
	public Utilisateur() {
		super();
		this.id_utilisateur = "";
		this.pseudo_utilisateur = "";
		this.nom_utilisateur = "";
		this.prenom_utilisateur = "";
		this.mdp_utilisateur = "";
		this.tel_utilisateur = "";
		this.mail_utilisateur = "";
	}

	public String getId_utilisateur() {
		return id_utilisateur;
	}

	public void setId_utilisateur(String id_utilisateur) {
		this.id_utilisateur = id_utilisateur;
	}

	public String getPseudo_utilisateur() {
		return pseudo_utilisateur;
	}

	public void setPseudo_utilisateur(String pseudo_utilisateur) {
		this.pseudo_utilisateur = pseudo_utilisateur;
	}

	public String getNom_utilisateur() {
		return nom_utilisateur;
	}

	public void setNom_utilisateur(String nom_utilisateur) {
		this.nom_utilisateur = nom_utilisateur;
	}

	public String getPrenom_utilisateur() {
		return prenom_utilisateur;
	}

	public void setPrenom_utilisateur(String prenom_utilisateur) {
		this.prenom_utilisateur = prenom_utilisateur;
	}

	public String getMdp_utilisateur() {
		return mdp_utilisateur;
	}

	public void setMdp_utilisateur(String mdp_utilisateur) {
		this.mdp_utilisateur = mdp_utilisateur;
	}

	public String getTel_utilisateur() {
		return tel_utilisateur;
	}

	public void setTel_utilisateur(String tel_utilisateur) {
		this.tel_utilisateur = tel_utilisateur;
	}

	public String getMail_utilisateur() {
		return mail_utilisateur;
	}

	public void setMail_utilisateur(String mail_utilisateur) {
		this.mail_utilisateur = mail_utilisateur;
	}

	@Override
	public String toString() {
		return "Utilisateur [id_utilisateur=" + id_utilisateur + ", pseudo_utilisateur=" + pseudo_utilisateur
				+ ", nom_utilisateur=" + nom_utilisateur + ", prenom_utilisateur=" + prenom_utilisateur
				+ ", mdp_utilisateur=" + mdp_utilisateur + ", tel_utilisateur=" + tel_utilisateur
				+ ", mail_utilisateur=" + mail_utilisateur + "]";
	}	

}
