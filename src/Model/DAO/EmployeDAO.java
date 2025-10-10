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
		if (obj instanceof Employe) {
			Employe employe = (Employe) obj;
			
			String requete = "delete from EMPLOYE "
					       + "where id_employe = ?";
			
			ArrayList<String> listValeurs = new ArrayList<String>();
			ArrayList<String> listTypes = new ArrayList<String>();
			
			this.setRequete(requete);
			
			listValeurs.add(employe.getId_utilisateur().toUpperCase());
			
			listTypes.add("string");
			
			this.setListValeurs(listValeurs);
			this.setListTypes(listTypes);
			
			this.prepare();
			
			Resultat r = this.execute();
			
			if (r.isSucces())
			{
				requete = "delete from UTILISATEUR "
						+ "where id_utilisateur = ?";
				
				listValeurs = new ArrayList<String>();
				listTypes = new ArrayList<String>();
				
				this.setRequete(requete);
				
				listValeurs.add(employe.getId_utilisateur().toUpperCase());
				
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
	public Resultat update(Object newObj, Object oldObj) {
		// TODO Auto-generated method stub
		if (newObj instanceof Employe && 
			oldObj instanceof Employe) {
			Employe new_employe = (Employe) newObj;
			Employe old_employe = (Employe) oldObj;
			
			String requete = "update UTILISATEUR "
					       + "set nom_utilisateur = ?, "
					       + "prenom_utilisateur = ?, "
					       + "tel_utilisateur = ?, "
					       + "mail_utilisateur = ? "
					       + "where id_utilisateur = ?";
			
			ArrayList<String> listValeurs = new ArrayList<String>();
			ArrayList<String> listTypes = new ArrayList<String>();
			
			this.setRequete(requete);
			
			listValeurs.add(new_employe.getNom_utilisateur().toUpperCase());
			listValeurs.add(new_employe.getPrenom_utilisateur().toUpperCase());
			listValeurs.add(new_employe.getTel_utilisateur().toUpperCase());
			listValeurs.add(new_employe.getMail_utilisateur().toUpperCase());
			listValeurs.add(old_employe.getId_utilisateur());
			
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
				requete = "update EMPLOYE "
						+ "set id_type_employe = (select id_type_employe from TYPE_EMPLOYE where libelle_type_employe = ?) "
						+ "where id_employe = ?";
				
				this.setRequete(requete);
				
				listValeurs = new ArrayList<String>();
				listTypes = new ArrayList<String>();
				
				listValeurs.add(new_employe.getType_employe());
				listValeurs.add(old_employe.getId_utilisateur());
				
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
	public Resultat select(Object obj) {
		// TODO Auto-generated method stub
		if (obj instanceof Employe) {			
			String requete = "select id_utilisateur, "
						   		  + "nom_utilisateur, "
						   		  + "prenom_utilisateur, "
						   		  + "pseudo_utilisateur, "
						   		  + "mdp_utilisateur, "
						   		  + "tel_utilisateur, "
						   		  + "mail_utilisateur, "
						   		  + "TE.id_type_employe, "
						   		  + "libelle_type_employe "
						   + "from UTILISATEUR U "
					       + "inner join EMPLOYE E on U.id_utilisateur = E.id_employe "
					       + "inner join TYPE_EMPLOYE TE on TE.id_type_employe = E.id_type_employe "
					       + "order by nom_utilisateur, prenom_utilisateur";
			
			this.setRequete(requete);
			
			this.prepare();
				
			return this.execute();
		}
		else
			return new Resultat ("Incompatibilité entre la classe métier et la base de données !",
							      false,
							      null);
	}

	@Override
	public Resultat selectAll(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultat selectAllInfo(Object obj) {
		// TODO Auto-generated method stub
		if (obj instanceof Employe) {
			Employe employe = (Employe) obj;
			String requete =  "select id_utilisateur, "
						   		  + "nom_utilisateur, "
						   		  + "prenom_utilisateur, "
						   		  + "pseudo_utilisateur, "
						   		  + "mdp_utilisateur, "
						   		  + "tel_utilisateur, "
						   		  + "mail_utilisateur, "
						   		  + "TE.id_type_employe, "
						   		  + "libelle_type_employe "
						   + "from UTILISATEUR U "
					       + "inner join EMPLOYE E on U.id_utilisateur = E.id_employe "
					       + "inner join TYPE_EMPLOYE TE on TE.id_type_employe = E.id_type_employe "
					       + "where nom_utilisateur = ?";
			
			ArrayList<String> listValeurs = new ArrayList<String>();
			ArrayList<String> listTypes = new ArrayList<String>();
			
			this.setRequete(requete);
			
			listValeurs.add(employe.getNom_utilisateur().toUpperCase());
			
			listTypes.add("string");
			
			this.setListValeurs(listValeurs);
			this.setListTypes(listTypes);
			
			this.prepare();
			
			return this.execute();
			
		}
		return new Resultat ("Incompatibilité entre la classe métier et la base de données !",
						      false,
						      null);
	}

}
