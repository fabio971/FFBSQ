package View.Admin;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Controler.Controleur;
import Model.Classes.Metiers.Employe;
import Model.Classes.Metiers.Resultat;
import Model.Classes.Metiers.TypeEmploye;
import View.Abstracts.AbstractVuePersonnalisable;

public class VueListerEmployes extends AbstractVuePersonnalisable 
							   implements ListSelectionListener,
							              DocumentListener {
	
	/*
	 * ListSelectionListener : C'est une interface qui possède la méthode
	 * public void valueChanged(ListSelectionEvent e)
	 * où on peut détecter les changements dans la sélection de la 
	 * liste et vous permettra d'accéder à l'élément sélectionné.
	 * 
	 * e.getValueIsAdjusting()) : Vérifier que la sélection ne se 
	 * déclenche pas en milieu d'une mise à jour
	 * 
	 * list.getSelectedValue() : Récupérer l'élément sélectionné
	 */
	
	private JLabel jlbl_id_utilisateur;
	private JLabel jlbl_prenom_utilisateur;
	private JLabel jlbl_nom_utilisateur;
	private JLabel jlbl_pseudo_utilisateur;
	private JLabel jlbl_mdp_utilisateur;
	private JLabel jlbl_conf_mdp_utilisateur;
	private JLabel jlbl_tel_utilisateur;
	private JLabel jlbl_mail_utilisateur;
	private JLabel jlbl_type_employe;
	private JLabel jlbl_search_employe;
	private JLabel jlbl_employes;
	
	private JTextField jtf_id_utilisateur;
	private JTextField jtf_prenom_utilisateur;
	private JTextField jtf_nom_utilisateur;
	private JTextField jtf_pseudo_utilisateur;
	private JPasswordField jpf_mdp_utilisateur;
	private JPasswordField jpf_conf_mdp_utilisateur;
	private JTextField jtf_tel_utilisateur;
	private JTextField jtf_mail_utilisateur;
	
	private JComboBox<String> jcb_type_employe;
	
	private JTextField jtf_search_employe;
	
	private JList<String> jl_employes;
	
	private JPanel jp;
	private JPanel jpg;
	private JPanel jpd;
	
	private JButton jbtn_enregistrer;
	private JButton jbtn_annuler;
	private JButton jbtn_delete;
	
	private Resultat resultat;
	
	/*
	 * Il s'agit du Model pour le JList.
	 * Il faut l'associer au JList
	 * Exemple : <nom_du_JList> = new JList<String>(this.listModel);
	 */
	private DefaultListModel<String> listModel;
	private LinkedList<String> listBackupLModel;
	
	private Employe old_employe;
	private Employe new_employe;

	public VueListerEmployes(JFrame parent, 
			                 String title, 
			                 boolean modal, 
			                 Controleur controleur) {
		super(parent, title, modal, controleur);
		// TODO Auto-generated constructor stub
		this.initComponents();
		
		this.setVisible(true);
	}

	public VueListerEmployes(JFrame parent, 
			                 Dimension dimension, 
			                 String title, 
			                 boolean modal, 
			                 Controleur controleur) {
		super(parent, dimension, title, modal, controleur);
		// TODO Auto-generated constructor stub
		this.initComponents();
		
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("M.A.J."))
		{
			if (!this.jtf_prenom_utilisateur.getText().equals("") &&
				!this.jtf_nom_utilisateur.getText().equals("") &&
				!this.jtf_tel_utilisateur.getText().equals("") &&
				!this.jtf_mail_utilisateur.getText().equals("")) {
				this.new_employe = new Employe(
										this.jtf_id_utilisateur.getText().toUpperCase(),
										this.jtf_nom_utilisateur.getText().toUpperCase(),
										this.jtf_prenom_utilisateur.getText().toUpperCase(),
										"",
										"",
										this.jtf_tel_utilisateur.getText().toUpperCase(),
										this.jtf_mail_utilisateur.getText().toUpperCase(),
										this.jcb_type_employe.getSelectedItem().toString());
				
				this.old_employe.setId_utilisateur(this.jtf_id_utilisateur.getText());
				
				Resultat r = this.controler.update(this.new_employe, 
                        						   this.old_employe);
				
				this.viderFormulaire();

				if (r.isSucces())
				{
					this.remplirListEmployes();
					
					(new JOptionPane()).showMessageDialog(null, 
														  "La mise à jour de l'employé s'est effectuée avec succès !!!", 
														  "INFORMATION", 
														  JOptionPane.INFORMATION_MESSAGE);
				}
				else
					(new JOptionPane()).showMessageDialog(null, 
														  r.getMessage(), 
														  "ERREUR", 
														  JOptionPane.ERROR_MESSAGE);
			}
		}
		else if (e.getActionCommand().equals("Supprimer"))
		{
			int option = (new JOptionPane()).showConfirmDialog(null, 
									                           "Voulez-vous supprimer l'employé ?", 
									                           "CONFIRMATION",
									                           JOptionPane.YES_NO_CANCEL_OPTION, 
									                           JOptionPane.QUESTION_MESSAGE);
			
			if (option == JOptionPane.OK_OPTION)	
			{
				String id_utilisateur = this.jtf_id_utilisateur.getText().toUpperCase();
				
				this.old_employe.setId_utilisateur(id_utilisateur);
				
				this.viderFormulaire();
				
				Resultat r = this.controler.deletefrom(this.old_employe);
				
				if (r.isSucces())
				{
					this.remplirListEmployes();
					
					(new JOptionPane()).showMessageDialog(null, 
														  "La suppression de l'employé a été effectuée avec succès !!!", 
														  "INFORMATION", 
														  JOptionPane.INFORMATION_MESSAGE);
				}
				else
					(new JOptionPane()).showMessageDialog(null, 
														  r.getMessage(), 
														  "ERREUR", 
														  JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		filterList();
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		filterList();
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		filterList();
	}

	@Override
	public void initComponents() {
		// TODO Auto-generated method stub
		this.listModel = new DefaultListModel<>();
		
		this.jp = new JPanel();
		this.jpg = new JPanel();
		this.jpg.setPreferredSize(new Dimension(300, 340));
		this.jpd = new JPanel();
		this.jpd.setPreferredSize(new Dimension(300, 340));
		
		this.jlbl_id_utilisateur = new JLabel("N.S. : ");
		this.jlbl_prenom_utilisateur = new JLabel("Prénom : ");
		this.jlbl_nom_utilisateur = new JLabel("Nom : ");
		this.jlbl_pseudo_utilisateur = new JLabel("Pseudo : ");
		this.jlbl_mdp_utilisateur = new JLabel("M. de passe : ");
		this.jlbl_conf_mdp_utilisateur = new JLabel("Conf. Mdp : ");
		this.jlbl_tel_utilisateur = new JLabel("Téléphone : ");
		this.jlbl_mail_utilisateur = new JLabel("E-mail : ");
		this.jlbl_type_employe = new JLabel("Type empl. : ");
		this.jlbl_employes = new JLabel("Liste d'employés : ");
		this.jlbl_search_employe = new JLabel("Filtrer : ");
		
		this.jtf_id_utilisateur = new JTextField();
		this.jtf_id_utilisateur.setPreferredSize(new Dimension(200, 30));
		this.jtf_prenom_utilisateur = new JTextField();
		this.jtf_prenom_utilisateur.setPreferredSize(new Dimension(200, 30));
		this.jtf_nom_utilisateur = new JTextField();
		this.jtf_nom_utilisateur.setPreferredSize(new Dimension(200, 30));
		this.jtf_pseudo_utilisateur = new JTextField();
		this.jtf_pseudo_utilisateur.setPreferredSize(new Dimension(200, 30));
		this.jpf_mdp_utilisateur = new JPasswordField();
		this.jpf_mdp_utilisateur.setPreferredSize(new Dimension(200, 30));
		this.jpf_conf_mdp_utilisateur = new JPasswordField();
		this.jpf_conf_mdp_utilisateur.setPreferredSize(new Dimension(200, 30));
		this.jtf_tel_utilisateur = new JTextField();
		this.jtf_tel_utilisateur.setPreferredSize(new Dimension(200, 30));
		this.jtf_mail_utilisateur = new JTextField();
		this.jtf_mail_utilisateur.setPreferredSize(new Dimension(200, 30));
		this.jcb_type_employe = new JComboBox<String>();
		
		this.resultat = this.controler.select(new TypeEmploye());
		
		if (this.resultat.isSucces()) {
			this.setValuesJCB(resultat.getReponse(), 
							  jcb_type_employe, 
							  new TypeEmploye());
		}
		else
			JOptionPane.showMessageDialog(this, 
										  resultat.getMessage(),
										  "ERREUR",
										  JOptionPane.ERROR_MESSAGE);
		
		this.jbtn_annuler = new JButton("Annuler");
		this.jbtn_enregistrer = new JButton("M.A.J.");
		this.jbtn_delete = new JButton("Supprimer");
		
		this.jbtn_delete.setEnabled(false);
		this.jbtn_enregistrer.setEnabled(false);
		
		this.jtf_id_utilisateur.setEnabled(false);
		this.jtf_nom_utilisateur.setEnabled(false);
		this.jtf_prenom_utilisateur.setEnabled(false);
		this.jtf_pseudo_utilisateur.setEnabled(false);
		this.jpf_mdp_utilisateur.setEnabled(false);
		this.jpf_conf_mdp_utilisateur.setEnabled(false);
		this.jtf_tel_utilisateur.setEnabled(false);
		this.jtf_mail_utilisateur.setEnabled(false);
		this.jcb_type_employe.setEnabled(false);
		
		this.jbtn_annuler.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) 
			{
				dispose(); 
			}
		});
		this.jbtn_enregistrer.addActionListener(this);
		this.jbtn_delete.addActionListener(this);
		
		this.jl_employes = new JList<String>(this.listModel);
		// écouteur de la selection de la liste
		this.jl_employes.addListSelectionListener(this);
		this.jl_employes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.jl_employes.setFixedCellHeight(15);
		this.jl_employes.setFixedCellWidth(250);
		this.jl_employes.setVisibleRowCount(20);
		
		this.remplirListEmployes();
		
		this.jtf_search_employe = new JTextField();
		this.jtf_search_employe.setPreferredSize(new Dimension(200, 30));
		/*
		 *  Ecouteur du JTextField : Interface DocumentListener
		 *  
		 *  Méthodes :
		 *  
		 *  public void insertUpdate(DocumentEvent e)
		 *  public void removeUpdate(DocumentEvent e)
		 *  public void changedtUpdate(DocumentEvent e)
		 *  
		 */
		this.jtf_search_employe.getDocument().addDocumentListener(this);
		
		this.setButtonSubmit(this.jbtn_enregistrer);
		
		this.jpg.add(this.jlbl_id_utilisateur);
		this.jpg.add(this.jtf_id_utilisateur);
		this.jpg.add(this.jlbl_prenom_utilisateur);
		this.jpg.add(this.jtf_prenom_utilisateur);
		this.jpg.add(this.jlbl_nom_utilisateur);
		this.jpg.add(this.jtf_nom_utilisateur);
		this.jpg.add(this.jlbl_pseudo_utilisateur);
		this.jpg.add(this.jtf_pseudo_utilisateur);
		this.jpg.add(this.jlbl_mdp_utilisateur);
		this.jpg.add(this.jpf_mdp_utilisateur);
		this.jpg.add(this.jlbl_conf_mdp_utilisateur);
		this.jpg.add(this.jpf_conf_mdp_utilisateur);
		this.jpg.add(this.jlbl_tel_utilisateur);
		this.jpg.add(this.jtf_tel_utilisateur);
		this.jpg.add(this.jlbl_mail_utilisateur);
		this.jpg.add(this.jtf_mail_utilisateur);
		this.jpg.add(this.jlbl_type_employe);
		this.jpg.add(this.jcb_type_employe);
		
		this.jpg.add(this.jbtn_annuler);
		this.jpg.add(this.jbtn_delete);
		this.jpg.add(this.jbtn_enregistrer);
		
		this.jpd.add(this.jlbl_search_employe);
		this.jpd.add(this.jtf_search_employe);
		this.jpd.add(this.jlbl_employes);
		this.jpd.add(new JScrollPane(this.jl_employes));
		
		this.jp.add(this.jpg, BorderLayout.WEST);
		this.jp.add(this.jpd, BorderLayout.EAST);
		
		this.getContentPane().add(this.jp, BorderLayout.CENTER);
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		// Vérifier que la sélection ne se déclenche pas en milieu d'une mise à jour
        if (this.jl_employes.getSelectedValue() != null && 
        	!e.getValueIsAdjusting()) {
            // Récupérer l'élément sélectionné
            String selectedOuvrage = this.jl_employes.getSelectedValue().toString();
            
            this.old_employe = new Employe("", 
		            		                selectedOuvrage, 
		            		                "", "", "", "", "", "");
            
            Resultat r = this.controler.selectAllInfo(this.old_employe);
            
            if (r.isSucces())
            {
            	ResultSet source = r.getReponse();
            	
            	try {
					source.next();
					
					this.jtf_id_utilisateur.setText(source.getString("id_utilisateur"));
					this.jtf_nom_utilisateur.setText(source.getString("nom_utilisateur"));
					this.jtf_nom_utilisateur.setEnabled(true);
					this.jtf_prenom_utilisateur.setText(source.getString("prenom_utilisateur"));
					this.jtf_prenom_utilisateur.setEnabled(true);
					this.jtf_pseudo_utilisateur.setText(source.getString("pseudo_utilisateur"));
					this.jpf_mdp_utilisateur.setText("****");
					this.jpf_conf_mdp_utilisateur.setText("****");
					this.jtf_tel_utilisateur.setText(source.getString("tel_utilisateur"));
					this.jtf_tel_utilisateur.setEnabled(true);
					this.jtf_mail_utilisateur.setText(source.getString("mail_utilisateur"));
					this.jtf_mail_utilisateur.setEnabled(true);
					this.jcb_type_employe.setSelectedItem(source.getString("libelle_type_employe"));
					this.jcb_type_employe.setEnabled(true);
					
					this.jbtn_annuler.setEnabled(true);
					this.jbtn_delete.setEnabled(true);
					this.jbtn_enregistrer.setEnabled(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
            else
            	(new JOptionPane()).showMessageDialog(null, 
													  r.getMessage(), 
													  "ERREUR", 
													  JOptionPane.ERROR_MESSAGE);
        }
	}
	
	private void remplirListEmployes()
	{
		Resultat r = this.controler.select(new Employe());
		
		if (r.isSucces())
		{
			this.setValuesJL(r.getReponse(), this.listModel, new Employe());
			
			this.listBackupLModel = new LinkedList<String>();
			
			for (int i = 0; i < this.listModel.getSize(); i++)
				this.listBackupLModel.add(this.listModel.get(i));
		}
		else
			(new JOptionPane()).showMessageDialog(null, 
												  r.getMessage(), 
												  "ERREUR", 
												  JOptionPane.ERROR_MESSAGE);
	}
	
	private void viderFormulaire() {
		this.jtf_id_utilisateur.setText("");
		this.jtf_nom_utilisateur.setText("");
		this.jtf_nom_utilisateur.setEnabled(false);
		this.jtf_prenom_utilisateur.setText("");
		this.jtf_prenom_utilisateur.setEnabled(false);
		this.jtf_pseudo_utilisateur.setText("");
		this.jpf_mdp_utilisateur.setText("");
		this.jpf_conf_mdp_utilisateur.setText("");
		this.jtf_tel_utilisateur.setText("");
		this.jtf_tel_utilisateur.setEnabled(false);
		this.jtf_mail_utilisateur.setText("");
		this.jtf_mail_utilisateur.setEnabled(false);
		this.jcb_type_employe.setSelectedIndex(0);
		this.jcb_type_employe.setEnabled(false);
		
		this.jbtn_delete.setEnabled(false);
		this.jbtn_enregistrer.setEnabled(false);
		
		this.listModel.clear();
	}
	
	private void filterList() {
        String filterText = this.jtf_search_employe.getText();
        this.listModel.clear();
        for (String item : this.listBackupLModel) {
            if (item.toLowerCase().contains(filterText.toLowerCase())) {
                this.listModel.addElement(item);
            }
        }
    }

}
