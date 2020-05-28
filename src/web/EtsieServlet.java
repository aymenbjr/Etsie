package web;

import java.io.IOException;
import java.util.Date;
import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ClientImpl;
import dao.CommandeImpl;
import dao.FamilleImpl;
import dao.IClient; 
import dao.ICommande;
import dao.IFamille;
import dao.IProduit;
import dao.ProduitImpl;
import entities.Client;
import entities.Commande;
import entities.Famille; 
import entities.Produit;  




@WebServlet({"/Acceuil","/Produit","/login","/Deconnexion","/Admin","/utilisateur_commande","/registration","/recherche","/detail","/ajoutProd","/deleteProduit","/editProduit"})
public class EtsieServlet extends HttpServlet { 
	private IClient clientDAO;
	private IFamille familleDAO;
	private IProduit produitDAO;
	private ICommande commandeDAO;
	
	HttpSession session;
	
	@Override
	public void init() throws ServletException {
		clientDAO = new ClientImpl();
		familleDAO = new FamilleImpl();
		produitDAO = new ProduitImpl();
		commandeDAO = new CommandeImpl();
	}
    public EtsieServlet() {
        super();
       
    }



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getServletPath().equals("/utilisateur_commande")) {
			Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = new Date();
			String s = formatter.format(date);
			String dat = s;
			Commande c=new Commande (dat);
			commandeDAO.addCommande(c);
			List<Famille> famille =  familleDAO.ListFam();
			request.setAttribute("famille", famille);
			request.setAttribute("succes", "Votre Commande a été ajouter");
			request.getRequestDispatcher("WEB-INF/acceuil.jsp").forward(request, response);
		}
	
	if(request.getServletPath().equals("/Acceuil")) {
		List<Famille> famille =  familleDAO.ListFam();
		request.setAttribute("famille", famille);
		request.getRequestDispatcher("WEB-INF/acceuil.jsp").forward(request, response);
	}
		
		if(request.getServletPath().equals("/Produit")) {

			try {
			String catalogue_famille = request.getParameter( "cata_fam" );
	    	if(catalogue_famille == null) {
				List<Produit> produit =  produitDAO.ListProduit();	
				request.setAttribute("produit", produit);
			} else {		
				List<Produit> produit =  produitDAO.ListProduitFamille(catalogue_famille);
				request.setAttribute("produit", produit);
				
			}
			}catch (Exception e) {
				request.setAttribute("erreur", "Une erreur est survenue.");	
				
			}finally{
					
					request.getRequestDispatcher("WEB-INF/produit.jsp").forward(request, response);
				}
				
			}
		
		if(request.getServletPath().equals("/detail")) {

			try {
			String id = request.getParameter( "id_p" );
	    	if(id == null) {
	    		request.setAttribute("erreur", "Une erreur est survenue.");
				request.getRequestDispatcher("WEB-INF/acceuil.jsp").forward(request, response);
			} else {
				int idd=Integer.parseInt(id);		
				Produit produit =  produitDAO.getProduit(idd);
				request.setAttribute("produit", produit);
				
			Client utilisateurConnecte = (Client) request.getSession().getAttribute("session");
				
//				 si l'utilisateur est connecté, on récupère son id
				if(utilisateurConnecte != null) {
					request.setAttribute("idUtilisateur", utilisateurConnecte.getNumCli());
				}
			}
			}catch (Exception e) {
				request.setAttribute("erreur", "Une erreur est survenue.");	
				request.getRequestDispatcher("WEB-INF/acceuil.jsp").forward(request, response);
			}finally{
					
					request.getRequestDispatcher("WEB-INF/details.jsp").forward(request, response);
				}
				
			}
		
		
		if(request.getServletPath().equals("/login")) {
			request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
		}
		
		if(request.getServletPath().equals("/ajoutProd")) {
			request.getRequestDispatcher("WEB-INF/ajoutProd.jsp").forward(request, response);
		}
		
		if(request.getServletPath().equals("/registration")) {
			request.getRequestDispatcher("WEB-INF/registration.jsp").forward(request, response);
		}
		
		if(request.getServletPath().equals("/Admin")) {
			List<Produit> produit =  produitDAO.ListProduit();	
			request.setAttribute("produit", produit);
			List<Commande> commande =  commandeDAO.ListCommande();	
			request.setAttribute("commande", commande);
			request.getRequestDispatcher("WEB-INF/admin.jsp").forward(request, response);
		}
		
		if(request.getServletPath().equals("/Deconnexion")) {
			
			
			session = request.getSession();
			session.invalidate();
			
			request.setAttribute("succes", "Vous vous êtes bien déconnecté(e)");
			List<Famille> famille =  familleDAO.ListFam();
			request.setAttribute("famille", famille);
			request.getRequestDispatcher("WEB-INF/acceuil.jsp").forward(request, response);
		}
		
		if(request.getServletPath().equals("/deleteProduit")) {
			
			String idProduit = request.getParameter( "id_p" );
			System.out.println(idProduit );	
	    	if(idProduit == null) {
	    		request.setAttribute("erreur", "une erreur est dddsurvenue");
	    		request.getRequestDispatcher("WEB-INF/admin.jsp").forward(request, response);
	    	}else{
	    		int idd=Integer.parseInt(idProduit);
	    		produitDAO.supprimerProd(idd);
	    		
	    		List<Produit> produit =  produitDAO.ListProduit();	
			request.setAttribute("produit", produit);
			List<Commande> commande =  commandeDAO.ListCommande();	
			request.setAttribute("commande", commande);
			request.setAttribute("succes", "Votre Produit est supprimé");
	    	request.getRequestDispatcher("WEB-INF/admin.jsp").forward(request, response);
	    	}
		
		}
		
		if(request.getServletPath().equals("/editProduit")) {
			
			String idProduit = request.getParameter( "id_p" );
	    	if(idProduit == null) {
	    		request.setAttribute("erreur", "une erreur est survenue");
	    		request.getRequestDispatcher("WEB-INF/admin.jsp").forward(request, response);
	    	}else{
	    		int idd=Integer.parseInt(idProduit);
	    		Produit produit = produitDAO.getProduit(idd);
			request.setAttribute("produit", produit);
	    	request.getRequestDispatcher("WEB-INF/editProd.jsp").forward(request, response);
	    	}
		
		}
		
	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getServletPath().equals("/login")) {
			String exceptionContent = "Une erreur est survenue lors de l'authentification";
			try{
				String nom = request.getParameter("nom");
				String pass = request.getParameter("password");
				if(nom.equals("aymen") && pass.equals("000")){
					List<Produit> produit =  produitDAO.ListProduit();	
					request.setAttribute("produit", produit);
					List<Commande> commande =  commandeDAO.ListCommande();	
					request.setAttribute("commande", commande);
				request.getRequestDispatcher("WEB-INF/admin.jsp").forward(request, response);
				}else{
					boolean status = false;
					status=clientDAO.login(nom, pass);
					if(status){
						session = request.getSession();
						Client utilisateur = clientDAO.getClient(nom, pass);
						session.setAttribute("session", utilisateur);
						request.setAttribute("succes", "Bienvenue "/*+ utilisateur.getNom() */+ "! Vous vous êtes bien authentifié");
						
						List<Famille> famille =  familleDAO.ListFam();
						request.setAttribute("famille", famille);
						request.getRequestDispatcher("WEB-INF/acceuil.jsp").forward(request, response);
					
					}else{
					exceptionContent = "login / mdp incorrect";
					throw new Exception(exceptionContent);
					}
				}
			} catch (Exception e) {
				request.setAttribute("erreur", exceptionContent);	
				request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
			
			}
		}
		
		if(request.getServletPath().equals("/registration")) {
			try {
				// Restitution des données depuis le formulaire
				String nom = request.getParameter("nom");
				String prenom = request.getParameter("prenom");
				String adresse = request.getParameter("adresse");
				String password = request.getParameter("password");
				
				
				
				Client client = new Client(nom,prenom ,adresse ,password);		
				clientDAO.addClient(client);
				 
				request.setAttribute("succes", "Identifiez Vous à nouveau");
				
			} catch (Exception e) {
				request.setAttribute("erreur", "Une erreur est survenue. Veuillez verifier que vous avez bien saisi les shamps du formulaire ");	
			} finally {
				request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
			}
		}
		
		if(request.getServletPath().equals("/ajoutProd")) {
			try {
				String prix = request.getParameter("prix");
				String nom = request.getParameter("nom");
				String famille = request.getParameter("famille");
				
				Produit nouveauProduit = new Produit(Double.valueOf(prix), nom, Integer.parseInt(famille));
				produitDAO.addProduit(nouveauProduit);
				
				// chargement des listes 
				List<Produit> produit =  produitDAO.ListProduit();	
				request.setAttribute("produit", produit);	
				request.setAttribute("succes", "votre Produit a été bien ajouté");
				List<Commande> commande =  commandeDAO.ListCommande();	
				request.setAttribute("commande", commande);
			} catch (Exception e) {
				request.setAttribute("erreur", "Bitte überprüfen Sie, ob Sie die Formularfelder korrekt ausgefüllt haben! ");	
			} finally {
				request.getRequestDispatcher("WEB-INF/admin.jsp").forward(request, response);
			}	
	}
		
		if(request.getServletPath().equals("/editProduit")) {
			try {
				String id = request.getParameter("id");
				String prix = request.getParameter("prix");
				String nom = request.getParameter("nom");
				String famille = request.getParameter("famille");
				
				Produit nouveauProduit = new Produit(Double.valueOf(prix), nom, Integer.parseInt(famille));
				nouveauProduit.setNumPro(Integer.parseInt(id));
				produitDAO.editProduit(nouveauProduit);
				
				// chargement des listes 
				List<Produit> produit =  produitDAO.ListProduit();	
				request.setAttribute("produit", produit);	
				request.setAttribute("succes", "votre Produit a été bien modifier");
				List<Commande> commande =  commandeDAO.ListCommande();	
				request.setAttribute("commande", commande);
			} catch (Exception e) {
				request.setAttribute("erreur", "Bitte überprüfen Sie, ob Sie die Formularfelder korrekt ausgefüllt haben! ");	
			} finally {
				request.getRequestDispatcher("WEB-INF/admin.jsp").forward(request, response);
			}	
	}
		
		if(request.getServletPath().equals("/recherche")) {
			try {
				String recherche = request.getParameter("recherche");
				List<Produit> produit =  produitDAO.ListParRech(recherche);
				request.setAttribute("produit", produit); 
				
			} catch (Exception e) {
				request.setAttribute("erreur", "Une erreur est survenue. Veuillez verifier que vous avez bien saisi les shamps du formulaire ");	
			} finally {
				request.getRequestDispatcher("WEB-INF/produit.jsp").forward(request, response);
			}
		}
	}

}
