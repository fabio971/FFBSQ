package Model.Classes.Metiers;

public class Utilisateur {
	
	private String num_secu_employe;
	private String pseudo;
	private String nom_employe;
	private String prenom_employe;
	private String date_embauche_employe;
	private int id_agence;
	private String num_adr_employe;
	private String rue_adr_employe;
	private String cp_adr_employe;
	private String mobile_employe;
	private String mot_de_passe;
	
	
	public Utilisateur() {
		super();
		this.num_secu_employe = "";
		this.pseudo = "";
		this.nom_employe = "";
		this.prenom_employe = "";
		this.mobile_employe = "";
		this.mot_de_passe = "";
		this.date_embauche_employe = "";
		this.id_agence = 0;
		this.num_adr_employe = "";
		this.rue_adr_employe = "";
		this.cp_adr_employe = "";
	}

	public Utilisateur(String num_sec_employe,
					   String pseudo, 
					   String nom, 
					   String prenom, 
					   String tel_cel,
					   String mdp,
					   String date,
					   int idagence,
					   String numadr,
					   String rueadr,
					   String cpadr) {
		super();
		this.num_secu_employe = num_sec_employe;
		this.pseudo = pseudo;
		this.nom_employe = nom;
		this.prenom_employe = prenom;
		this.mobile_employe = tel_cel;
		this.mot_de_passe = mdp;
		this.date_embauche_employe = date;
		this.id_agence = 0;
		this.num_adr_employe = numadr;
		this.rue_adr_employe = rueadr;
		this.cp_adr_employe = cpadr;
	}
	
	public Utilisateur(String nom, 
			   	   String prenom) {
		super();
		this.num_secu_employe = "";
		this.pseudo = "";
		this.nom_employe = nom;
		this.prenom_employe = prenom;
		this.mobile_employe = "";
		this.mot_de_passe = "";
		this.date_embauche_employe = "";
		this.id_agence = 0;
		this.num_adr_employe = "";
		this.rue_adr_employe = "";
		this.cp_adr_employe = "";
	}

	public String getNum_secu_employe() {
		return num_secu_employe;
	}

	public void setNum_sec_employe(String num_sec_employe) {
		this.num_secu_employe = num_sec_employe;
	}

	public String getMobile_employe() {
		return mobile_employe;
	}

	public void setMobile_employe(String tel_cel) {
		this.mobile_employe = tel_cel;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo.toUpperCase();
	}

	public String getNom() {
		return nom_employe;
	}

	public void setNom(String nom) {
		this.nom_employe = nom;
	}

	public String getPrenom() {
		return prenom_employe;
	}

	public void setPrenom(String prenom) {
		this.prenom_employe = prenom;
	}

	public String getMot_de_passe() {
		return mot_de_passe;
	}

	public void setMot_de_passe(String mdp) {
		this.mot_de_passe = mdp;
	}
	
	public String getNom_employe() {
		return nom_employe;
	}

	public void setNom_employe(String nom_employe) {
		this.nom_employe = nom_employe;
	}

	public String getPrenom_employe() {
		return prenom_employe;
	}

	public void setPrenom_employe(String prenom_employe) {
		this.prenom_employe = prenom_employe;
	}

	public String getDate_embauche_employe() {
		return date_embauche_employe;
	}

	public void setDate_embauche_employe(String date_embauche_employe) {
		this.date_embauche_employe = date_embauche_employe;
	}

	public int getId_agence() {
		return id_agence;
	}

	public void setId_agence(int id_agence) {
		this.id_agence = id_agence;
	}

	public String getNum_adr_employe() {
		return num_adr_employe;
	}

	public void setNum_adr_employe(String num_adr_employe) {
		this.num_adr_employe = num_adr_employe;
	}

	public String getRue_adr_employe() {
		return rue_adr_employe;
	}

	public void setRue_adr_employe(String rue_adr_employe) {
		this.rue_adr_employe = rue_adr_employe;
	}

	public String getCp_adr_employe() {
		return cp_adr_employe;
	}

	public void setCp_adr_employe(String cp_adr_employe) {
		this.cp_adr_employe = cp_adr_employe;
	}

	public void setNum_secu_employe(String num_secu_employe) {
		this.num_secu_employe = num_secu_employe;
	}

	@Override
	public String toString() {
		return "Employe [num_secu_employe=" + num_secu_employe + ", pseudo=" + pseudo + ", nom_employe=" + nom_employe
				+ ", prenom_employe=" + prenom_employe + ", date_embauche_employe=" + date_embauche_employe
				+ ", id_agence=" + id_agence + ", num_adr_employe=" + num_adr_employe + ", rue_adr_employe="
				+ rue_adr_employe + ", cp_adr_employe=" + cp_adr_employe + ", mobile_employe=" + mobile_employe
				+ ", mot_de_passe=" + mot_de_passe + "]";
	}

}
