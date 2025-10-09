package Model.Classes.Metiers;

public class Employe extends Utilisateur {
	
	private String type_employe;

	public Employe(String id_utilisateur, 
			       String nom_utilisateur, 
			       String prenom_utilisateur, 
			       String pseudo_utilisateur,
			       String mdp_utilisateur, 
			       String tel_utilisateur, 
			       String mail_utilisateur,
			       String type_employe) {
		super(id_utilisateur, 
			  nom_utilisateur, 
			  prenom_utilisateur, 
			  pseudo_utilisateur, 
			  mdp_utilisateur, 
			  tel_utilisateur,
			  mail_utilisateur);
		// TODO Auto-generated constructor stub
		this.type_employe = type_employe;
	}

	public Employe() {
		// TODO Auto-generated constructor stub
		this.type_employe = "";
	}

	public String getType_employe() {
		return type_employe;
	}

	public void setType_employe(String type_employe) {
		this.type_employe = type_employe;
	}

	@Override
	public String toString() {
		return "Employe [" + super.toString() +" type_employe=" + type_employe + "]";
	}
		
	
}
