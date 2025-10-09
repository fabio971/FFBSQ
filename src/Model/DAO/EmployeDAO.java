package Model.DAO;

import java.util.ArrayList;

import Model.Classes.Abstracts.AbstractCRUD;
import Model.Classes.Metiers.Employe;
import Model.Classes.Metiers.Resultat;
import Model.Classes.Systeme.ConnectionDB;

public class EmployeDAO extends AbstractCRUD {

	public EmployeDAO(ConnectionDB conn_db, String requete, ArrayList<String> listValeurs,
			ArrayList<String> listTypes) {
		super(conn_db, requete, listValeurs, listTypes);
		// TODO Auto-generated constructor stub
	}

	public EmployeDAO(ConnectionDB conn_db) {
		super(conn_db);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Resultat insertinto(Object obj) {
		// TODO Auto-generated method stub
		if (obj instanceof Employe) {
			Employe employe = (Employe) obj;
			
			String requete = "insert into UTILISATEUR values (?, ?, ?, ?, ?, ?, ?)";
			
			ArrayList<String> listValeurs = new ArrayList<String>();
			ArrayList<String> listTypes = new ArrayList<String>();
			
			this.setRequete(requete);
			
			listValeurs.add(employe.getId_utilisateur().toUpperCase());
			listValeurs.add(employe.getNom_utilisateur().toUpperCase());
			listValeurs.add(employe.getPrenom_utilisateur().toUpperCase());
			listValeurs.add(employe.getPseudo_utilisateur().toUpperCase());
			listValeurs.add(employe.getMdp_utilisateur());
			listValeurs.add(employe.getTel_utilisateur().toUpperCase());
			listValeurs.add(employe.getMail_utilisateur().toUpperCase());
			
			listTypes.add("string");
			listTypes.add("string");
			listTypes.add("string");
			listTypes.add("string");
			listTypes.add("string");
			listTypes.add("string");
			listTypes.add("string");
			
			this.setListValeurs(listValeurs);
			this.setListTypes(listTypes);
			
			this.prepare();
			
			Resultat r = this.execute();
			
			if (r.isSucces()) {
				requete = "insert into EMPLOYE values (?, "
													 + "(select id_type_employe from TYPE_EMPLOYE where libelle_type_employe = ?))";
				
				this.setRequete(requete);
				
				listValeurs = new ArrayList<String>();
				listTypes = new ArrayList<String>();
				
				listValeurs.add(employe.getId_utilisateur().toUpperCase());
				listValeurs.add(employe.getType_employe());
				
				listTypes.add("string");
				listTypes.add("string");
				
				this.setListValeurs(listValeurs);
				this.setListTypes(listTypes);
				
				this.prepare();
				
				return this.execute();
			}
			else
				return new Resultat (r.getMessage(),
								     false,
								     null);
		}
		else
			return new Resultat ("Incompatibilité entre la classe métier et la base de données !",
							      false,
							      null);
	}

	@Override
	public Resultat deletefrom(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultat update(Object newObj, Object oldObj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultat select(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultat selectAll(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultat selectAllInfo(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

}
