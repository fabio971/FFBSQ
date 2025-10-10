package Model.Classes.Metiers;

public class TypeEmploye {
	
	private int id_type_employe;
	private String libelle_type_employe;
	
	public TypeEmploye(int id_type_employe, 
			   		   String libelle_type_employe) {
		super();
		this.id_type_employe = id_type_employe;
		this.libelle_type_employe = libelle_type_employe;
	}
	
	public TypeEmploye() {
		super();
		this.id_type_employe = 0;
		this.libelle_type_employe = "";
	}

	public int getId_type_employe() {
		return id_type_employe;
	}

	public void setId_type_employe(int id_type_employe) {
		this.id_type_employe = id_type_employe;
	}

	public String getLibelle_type_employe() {
		return libelle_type_employe;
	}

	public void setLibelle_type_employe(String libelle_type_employe) {
		this.libelle_type_employe = libelle_type_employe;
	}

	@Override
	public String toString() {
		return "TypeEmploye [id_type_employe=" + id_type_employe + ", libelle_type_employe=" + libelle_type_employe
				+ "]";
	}
}
