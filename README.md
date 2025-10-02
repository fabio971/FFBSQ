# Prototype MVC - Projet Pédagogique en Java

## 📌 Description

Le **BTS SIO**, avec l'option **SLAM**, constitue une formation complète destinée à vous armer de compétences essentielles pour la mise en place de solutions informatiques au sein des entreprises. Les étudiants orientés vers la filière **SLAM** sont formés pour acquérir les compétences indispensables qui leur permettront de résoudre les éventuels problèmes rencontrés au sein des systèmes d'information d'une organisation.

Au cœur de leur quotidien, les étudiants **SLAM** se voient confier la tâche cruciale de collecter, analyser, optimiser, traiter et diffuser les informations nécessaires. Leur mission ultime est de proposer des solutions ingénieuses capables de répondre aux exigences complexes de la gestion d'entreprise. Cette approche holistique ne se limite pas à la résolution des problèmes informatiques, mais elle s'étend à une compréhension approfondie des besoins spécifiques de chaque organisation.

Le concept de système d'information **(SI)** prend une place centrale dans cette formation. Le **SI**, dans ce contexte, peut être défini comme l'ensemble des moyens humains, matériels et immatériels déployés pour gérer l'information au sein d'une unité, comme une entreprise. Les étudiants apprennent à naviguer dans ce paysage complexe en comprenant la dynamique entre les différentes composantes du **SI**, tout en développant des compétences stratégiques pour optimiser son fonctionnement et en garantir l'efficacité.

En somme, le **BTS SIO** option **SLAM** va au-delà de la simple acquisition de connaissances techniques. Il vise à former des professionnels capables d'appréhender les défis contemporains liés à l'informatique au sein des organisations, et de proposer des solutions innovantes et adaptées à l'évolution rapide du monde numérique.

Ce projet est un **prototype MVC** développé à des fins pédagogiques pour les étudiants du **BTS SIO (SLAM)**.  
Il illustre l'architecture **M**odèle-**Vue**-**C**ontrôleur **(MVC)** en **Java**.

## 🛠️ Technologies utilisées
- **Langage** : Java (JDK 17+ recommandé)
- **IDE** : Eclipse(w)
- **Base de données** : Compatible avec ODBC **(Mysql, PostgreSql)**
- **Dépendances** : Le projet inclut déjà les bibliothèques nécessaires (ex : driver ODBC).

## 📂 Structure du projet

```
PROTOTYPE-MVC/ 
│── src/ 
│ ├── Controller/ 
│ │ ├── Controleur.java 
│ ├── Controller.Abstracts/ 
│ │ ├── AbstractController.java 
│ ├── Model/ 
│ │ ├── Modele.java 
│ ├── Model.Classes.Abstracts/ 
│ │ ├── AbstractCRUD.java 
│ │ ├── AbstractModel.java 
│ ├── Model.Classes.Autres/ 
│ │ ├── DateChecker.java 
│ │ ├── MonDefaultTableModel.java 
│ │ ├── Outils.java 
│ │ ├── XML_POJO.java 
│ ├── Model.Classes.Metiers/ 
│ │ ├── MonJTable.java 
│ │ ├── Options.java 
│ │ ├── Resultat.java 
│ │ ├── Utilisateur.java 
│ ├── Model.Classes.Systeme/ 
│ │ ├── ConfigurationDB.java 
│ │ ├── ConnectionDB.java 
│ │ ├── Menu.java 
│ │ ├── Option.java 
│ │ ├── Session.java 
│ ├── Model.DAO/ 
│ │ ├── OptionsDAO.java 
│ │ ├── SystemeDAO.java 
│ │ ├── UtilisateurDAO.java 
│ ├── Model.DAO.MesFonctions/ 
│ ├── Model.Interfaces/ 
│ │ ├── InterfCRUD.java 
│ │ ├── InterfOperationsAdmin.java 
│ │ ├── InterfOperationsDataBase.java 
│ │ ├── InterfOperationsVuePrincipale.java 
│ ├── Model.Interfaces.Observer/ 
│ │ ├── InterfObservable.java 
│ │ ├── InterfObservateur.java 
│ ├── Model.XML/ 
│ ├── View/ 
│ │ ├── Systeme.java 
│ │ ├── Test.java 
│ │ ├── VueConfiguration.java 
│ │ ├── VueConnexion.java 
│ │ ├── VueMessage.java 
│ │ ├── VuePrincipal.java 
│ ├── View.Abstracts/ 
│ │ ├── AbstractVuePersonnalisable.java 
│── libraries/ 
│── doc/ 
│── Referenced Libraries/ 
│── LICENSE 
│── README.md 
│── hs_err_pid23882.log 
│── JRE System Library [JavaSE-22]
```

## 🚀 Installation & Exécution sous **Eclipse**

### 1️⃣ Prérequis
- **Installer [Eclipse](w)** (si ce n’est pas déjà fait)
- **Installer Java JDK** (vérifier avec `java -version`)
- **S'assurer que le driver ODBC est bien configuré** sur votre machine.

### 2️⃣ Importer le projet dans Eclipse
1. **Télécharger et extraire** le fichier `ProjetMVC.zip`
2. Ouvrir **Eclipse** et aller dans :  
   **File** > **Import...** > **Existing Projects into Workspace**
3. Sélectionner **"Select archive file"** et choisir `ProjetMVC.zip`
4. Valider en cliquant sur **Finish**  
   👉 Le projet s'affiche dans l'Explorateur de projets.

### 3️⃣ Exécution du projet
1. Ouvrir le fichier contenant la **méthode `main`** (`Systeme.java`).
2. Clic droit > **Run As** > **Java Application**.

## 📜 Licence
Ce projet est distribué sous licence **Creative Commons BY-NC 4.0**.  
Vous êtes libre d'utiliser, modifier et partager ce code, **mais vous ne pouvez pas l’utiliser à des fins commerciales**.  
Vous devez également **mentionner l’auteur original**.  

📖 **Détails de la licence** :  
[https://creativecommons.org/licenses/by-nc/4.0/](https://creativecommons.org/licenses/by-nc/4.0/)  

## ✨ Auteur
Développé par **CISNEROS BRIDON Fabian** - Enseignant en SIO SLAM.  

## 🎯 Objectif pédagogique

Dans le contexte de l'enseignement en BTS SIO option SLAM, comment concevoir une application Java qui ne se limite pas à une simple démonstration de compétences, mais qui devient un outil pédagogique fonctionnel, opérationnel, puissant, favorisant la compréhension des concepts clés de la **Programmation Orientée Objet (POO), Modèle-Vue-Contrôleur (MVC), Unified Modeling Language (UML), Bases de données (BDD) et les Systèmes de Gestion de BDD Rélationnelles (SGBDR)  et d’autres, tout en encourageant la réflexion, la créativité, et la réutilisation du code ?**

**Cohérence et unicité :** Développer une application dont l'architecture présente une cohérence interne et assure l'unicité des concepts, offrant ainsi un modèle structuré et compréhensible.

**Architecture facilitant la compréhension :** Proposer une architecture claire et bien documentée, facilitant la compréhension des étudiants, afin de les guider dans la découverte et/ou révision des principes fondamentaux de la POO.

**Stimulation à la réflexion :** Concevoir l'application de manière à inciter les étudiants à réfléchir sur la création de nouvelles structures similaires, promouvant ainsi une approche proactive dans l'apprentissage.

**Participation des étudiants :** Encourager les étudiants à proposer des idées pour enrichir l'architecture existante, favorisant ainsi la collaboration et la créativité au sein du groupe.

**Réutilisabilité du code :** Mettre en évidence la réutilisabilité du code à travers des exemples concrets, démontrant comment des composants spécifiques peuvent être adaptés et intégrés dans d'autres projets (J2E, Android, etc.).

**Révision des concepts de la POO :** Offrir aux étudiants la possibilité de revisiter et d'approfondir leurs connaissances en Programmation Orientée Objet à travers des applications concrètes et des cas pratiques.

**Utilisation dans les projets d'atelier de professionnalisation :** Intégrer l'application dans le cadre des projets d'Atelier de Professionnalisation, permettant aux étudiants de mettre en pratique les compétences acquises dans des contextes professionnels simulés.

Ainsi, la problématique souligne la nécessité de concevoir une application qui va au-delà de la simple démonstration technique, en mettant l'accent sur son utilité pédagogique et son potentiel à nourrir la réflexion et la créativité des étudiants. Les objectifs spécifiques détaillent comment atteindre ces ambitions éducatives.


Merci de respecter l'esprit pédagogique de ce projet et de ne pas en revendiquer la paternité.  

Pour toute question ou suggestion, vous pouvez me contacter à l'adresse suivante : [fcisnerosbridon@gmail.com](mailto:fcisnerosbridon@gmail.com)
