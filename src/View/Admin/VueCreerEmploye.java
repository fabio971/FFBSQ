package View.Admin;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Controler.Controleur;
import Model.Classes.Metiers.Employe;
import Model.Classes.Metiers.Resultat;
import Model.Classes.Metiers.TypeEmploye;
import View.Abstracts.AbstractVuePersonnalisable;

public class VueCreerEmploye extends AbstractVuePersonnalisable {
	
	private JLabel lbl_id_utilisateur;
	private JLabel lbl_prenom_utilisateur;
	private JLabel lbl_nom_utilisateur;
	private JLabel lbl_pseudo_utilisateur;
	private JLabel lbl_mdp_utilisateur;
	private JLabel lbl_conf_mdp_utilisateur;
	private JLabel lbl_tel_utilisateur;
	private JLabel lbl_mail_utilisateur;
	private JLabel lbl_type_employe;
	
	private JTextField jtf_id_utilisateur;
	private JTextField jtf_prenom_utilisateur;
	private JTextField jtf_nom_utilisateur;
	private JTextField jtf_pseudo_utilisateur;
	private JPasswordField jpf_mdp_utilisateur;
	private JPasswordField jpf_conf_mdp_utilisateur;
	private JTextField jtf_tel_utilisateur;
	private JTextField jtf_mail_utilisateur;
	private JComboBox<String> jcb_type_employe;
	
	private JButton btn_enregistrer;
	private JButton btn_annuler;
	
	private JPanel jp;
	
	private Resultat resultat;

	public VueCreerEmploye(JFrame parent, 
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
		String mdp = new String(this.jpf_mdp_utilisateur.getPassword());
		String conf_mdp = new String(this.jpf_conf_mdp_utilisateur.getPassword());
		
		if (!this.jtf_id_utilisateur.getText().equals("") &&
			!this.jtf_prenom_utilisateur.getText().equals("") &&
			!this.jtf_nom_utilisateur.getText().equals("") &&
			!this.jtf_pseudo_utilisateur.getText().equals("") &&
			!this.jtf_tel_utilisateur.getText().equals("") &&
			!mdp.equals("") &&
			!conf_mdp.equals("") &&
			!this.jtf_mail_utilisateur.getText().equals("")) {
			if (mdp.equals(conf_mdp)) {
				Employe employe = new Employe(
											this.jtf_id_utilisateur.getText(),
											this.jtf_prenom_utilisateur.getText(),
											this.jtf_nom_utilisateur.getText(),
											this.jtf_pseudo_utilisateur.getText(),
											this.jtf_tel_utilisateur.getText(),
											mdp,
											this.jtf_mail_utilisateur.getText(),
											this.jcb_type_employe.getSelectedItem().toString());
				
				resultat = this.controler.insertinto(employe);
				
				if (resultat.isSucces())
				{
					JOptionPane.showMessageDialog(this, 
												  "L'employé " + this.jtf_pseudo_utilisateur.getText().toUpperCase() + " a été bien enresgistré dans la base de données !",
												  "INFORMATION",
												  JOptionPane.INFORMATION_MESSAGE);
					this.viderFormulaire();
				}
				else
					JOptionPane.showMessageDialog(this, 
												  resultat.getMessage(),
												  "ERREUR",
												  JOptionPane.INFORMATION_MESSAGE);
			}
			else
				JOptionPane.showMessageDialog(this, 
											  "Le mot de passe et sa confirmation doivent être identiquess !",
											  "INFORMATION",
											  JOptionPane.INFORMATION_MESSAGE);
		}
		else
			JOptionPane.showMessageDialog(this, 
										  "Tous les champs doivent être saisis !",
										  "INFORMATION",
										  JOptionPane.INFORMATION_MESSAGE);
	}

	@Override
	public void initComponents() {
		// TODO Auto-generated method stub
		this.lbl_id_utilisateur = new JLabel("N.S. : ");
		this.lbl_prenom_utilisateur = new JLabel("Prénom : ");
		this.lbl_nom_utilisateur = new JLabel("Nom : ");
		this.lbl_pseudo_utilisateur = new JLabel("Pseudo : ");
		this.lbl_mdp_utilisateur = new JLabel("M. de passe : ");
		this.lbl_conf_mdp_utilisateur = new JLabel("Conf. Mdp : ");
		this.lbl_tel_utilisateur = new JLabel("Téléphone : ");
		this.lbl_mail_utilisateur = new JLabel("E-mail : ");
		this.lbl_type_employe = new JLabel("Type empl. : ");		
		
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
		
		resultat = this.controler.select(new TypeEmploye());
		
		if (resultat.isSucces()) {
			this.setValuesJCB(resultat.getReponse(), 
							  jcb_type_employe, 
							  new TypeEmploye());
		}
		else
			JOptionPane.showMessageDialog(this, 
										  resultat.getMessage(),
										  "ERREUR",
										  JOptionPane.ERROR_MESSAGE);
		
		this.btn_annuler = new JButton("Annuler");
		this.btn_enregistrer = new JButton("Enregistrer");
		
		this.jp = new JPanel();
		
		this.jp.add(this.lbl_id_utilisateur);
		this.jp.add(this.jtf_id_utilisateur);
		this.jp.add(this.lbl_prenom_utilisateur);
		this.jp.add(this.jtf_prenom_utilisateur);
		this.jp.add(this.lbl_nom_utilisateur);
		this.jp.add(this.jtf_nom_utilisateur);
		this.jp.add(this.lbl_pseudo_utilisateur);
		this.jp.add(this.jtf_pseudo_utilisateur);
		this.jp.add(this.lbl_mdp_utilisateur);
		this.jp.add(this.jpf_mdp_utilisateur);
		this.jp.add(this.lbl_conf_mdp_utilisateur);
		this.jp.add(this.jpf_conf_mdp_utilisateur);
		this.jp.add(this.lbl_tel_utilisateur);
		this.jp.add(this.jtf_tel_utilisateur);
		this.jp.add(this.lbl_mail_utilisateur);
		this.jp.add(this.jtf_mail_utilisateur);
		this.jp.add(this.lbl_type_employe);
		this.jp.add(this.jcb_type_employe);
		
		this.jp.add(this.btn_annuler);
		this.jp.add(this.btn_enregistrer);
		
		this.btn_annuler.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) 
			{
				dispose(); 
			}
		});
		this.btn_enregistrer.addActionListener(this);
		
		this.setButtonSubmit(btn_enregistrer);
		
		this.getContentPane().add(this.jp, BorderLayout.CENTER);
	}
	
	private void viderFormulaire() {
		this.jtf_id_utilisateur.setText("");
		this.jtf_prenom_utilisateur.setText("");
		this.jtf_nom_utilisateur.setText("");
		this.jtf_pseudo_utilisateur.setText("");
		this.jpf_mdp_utilisateur.setText("");
		this.jpf_conf_mdp_utilisateur.setText("");
		this.jtf_tel_utilisateur.setText("");
		this.jtf_mail_utilisateur.setText("");
		this.jcb_type_employe.setSelectedIndex(0);;	
	}

}
