package fr.inti.rdvmedecins;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.inti.rdvmedecins.crud.ClientRepository;
import fr.inti.rdvmedecins.crud.CreneauRepository;
import fr.inti.rdvmedecins.crud.MedecinRepository;
import fr.inti.rdvmedecins.crud.RvRepository;


@SpringBootApplication
public class RdvmedecinsMetierApplication {
	  Date jour = new Date();
		private static final Logger log = LoggerFactory.getLogger(RdvmedecinsMetierApplication.class);
		
	public static void main(String[] args) {
		SpringApplication.run(RdvmedecinsMetierApplication.class, args);
	}
	
	
	@Bean
	public CommandLineRunner demoMetier(ClientRepository clr , MedecinRepository medr , RvRepository rvr , CreneauRepository crr) {
		return (args) -> {
		log.info("Demarrage");
		log.info("Consulter les clients");
		System.out.println(clr.findAll());
		log.info("Consulter les Medecins");	
		System.out.println(medr.findAll());
		log.info("Consulter les Rendez-vous");	
		System.out.println(rvr.findAll());
		log.info("Consulter les Rendez-vous");	
		System.out.println(crr.findAll());
		} ;
	}
	
	
	/*
	 *  public static void main(String[] args) {
    try {
      // instanciation couche [métier]
      ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config-metier-dao.xml");
      IMetier metier = (IMetier) ctx.getBean("metier");
      // affichage clients
      List<Client> clients = metier.getAllClients();
      display("Liste des clients :", clients);
      // affichage médecins
      List<Medecin> medecins = metier.getAllMedecins();
      display("Liste des médecins :", medecins);
      // affichage créneaux d'un médecin
      Medecin medecin = medecins.get(0);
      List<Creneau> creneaux = metier.getAllCreneaux(medecin);
      display(String.format("Liste des créneaux du médecin %s", medecin), creneaux);
      // liste des Rv d'un médecin, un jour donné
      display(String.format("Liste des rendez-vous du médecin %s, le [%s]", medecin, jour), metier.getRvMedecinJour(medecin, jour));
      // affichage agenda
      AgendaMedecinJour agenda = metier.getAgendaMedecinJour(medecin, jour);
      System.out.println(agenda);
      // ajouter un RV
      Rv rv = null;
      Creneau creneau = creneaux.get(2);
      Client client = clients.get(0);
      System.out.println(String.format("Ajout d'un Rv le [%s] dans le créneau %s pour le client %s", jour, creneau, client));
      rv = metier.ajouterRv(jour, creneau, client);
      System.out.println("Rv ajouté");
      display(String.format("Liste des Rv du médecin %s, le [%s]", medecin, jour), metier.getRvMedecinJour(medecin, jour));
      // affichage agenda
      agenda = metier.getAgendaMedecinJour(medecin, jour);
      System.out.println(agenda);
      // supprimer un RV
      System.out.println("Suppression du Rv ajouté");
      metier.supprimerRv(rv);
      System.out.println("Rv supprimé");
      display(String.format("Liste des Rv du médecin %s, le [%s]", medecin, jour), metier.getRvMedecinJour(medecin, jour));
      // affichage agenda
      agenda = metier.getAgendaMedecinJour(medecin, jour);
      System.out.println(agenda);
    } catch (Throwable ex) {
      System.out.println("Erreur...");
      while (ex != null) {
        System.out.println(String.format("%s : %s", ex.getClass().getName(), ex.getMessage()));
        ex = ex.getCause();
      }
    }
  }

  // méthode utilitaire - affiche les éléments d'une collection
  private static void display(String message, List elements) {
    System.out.println(message);
    for (Object element : elements) {
      System.out.println(element);
    }
  }
	 * */

}
