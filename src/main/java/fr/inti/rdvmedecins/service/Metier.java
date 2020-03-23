package fr.inti.rdvmedecins.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import fr.inti.rdvmedecins.crud.ClientRepository;
import fr.inti.rdvmedecins.crud.CreneauRepository;
import fr.inti.rdvmedecins.crud.MedecinRepository;
import fr.inti.rdvmedecins.crud.RvRepository;
import fr.inti.rdvmedecins.entites.AgendaMedecinJour;
import fr.inti.rdvmedecins.jpa.Client;
import fr.inti.rdvmedecins.jpa.Creneau;
import fr.inti.rdvmedecins.jpa.Medecin;
import fr.inti.rdvmedecins.jpa.Rv;

@Transactional
public class Metier implements IMetier, Serializable {

  // couche dao
	
 // private IDao dao;
	@Autowired
  private  ClientRepository clr ;
	@Autowired
  private MedecinRepository mr ;
	@Autowired
  private RvRepository  rr;
	@Autowired
  private CreneauRepository  crr;
	
  public Metier() {
  }

  
  public List<Client> getAllClients() {
	  Iterable<Client> it = clr.findAll() ;
	  List<Client> resultat = new ArrayList<Client>();
	    for (Client cl : it) {
	    	resultat.add(cl);
	    }
    return resultat;
  }

  public List<Medecin> getAllMedecins() {
	  Iterable<Medecin> it = mr.findAll() ;
	  List<Medecin> resultat = new ArrayList<Medecin>();
	    for (Medecin md : it) {
	    	resultat.add(md);
	    }
    return resultat;
  }
  
  public List<Rv> getAllRv() {
	  Iterable<Rv> it = rr.findAll() ;
	  List<Rv> resultat = new ArrayList<Rv>();
	    for (Rv rv : it) {
	    	resultat.add(rv);
	    }
    return resultat;
  }

  public List<Creneau> getAllCreneaux(Medecin medecin) {
	  Iterable<Creneau> it = crr.findAll() ;
	  List<Creneau> resultat = new ArrayList<Creneau>();
	    for (Creneau cr : it) {
	    	resultat.add(cr);
	    }
    return resultat;
  }
  
  
/*
  public List<Rv> getRvMedecinJour(Medecin medecin, Date jour) {
    return dao.getRvMedecinJour(medecin, jour);
  }


  public Rv ajouterRv(Date jour, Creneau creneau, Client client) {
    return dao.ajouterRv(jour, creneau, client);
  }

  public void supprimerRv(Rv rv) {
    dao.supprimerRv(rv);
  }

  public AgendaMedecinJour getAgendaMedecinJour(Medecin medecin, Date jour) {
    // liste des créneaux horaires du médecin
    List<Creneau> creneauxHoraires = dao.getAllCreneaux(medecin);
    // liste des réservations de ce même médecin pour ce même jour
    List<Rv> reservations = dao.getRvMedecinJour(medecin, jour);
    // on crée un dictionnaire à partir des Rv pris
    Map<Long, Rv> hReservations = new Hashtable<Long, Rv>();
    for (Rv resa : reservations) {
      hReservations.put(resa.getCreneau().getId(), resa);
    }
    // on crée l'agenda pour le jour demandé
    AgendaMedecinJour agenda = new AgendaMedecinJour();
    // le médecin
    agenda.setMedecin(medecin);
    // le jour
    agenda.setJour(jour);
    // les créneaux de réservation
    CreneauMedecinJour[] creneauxMedecinJour = new CreneauMedecinJour[creneauxHoraires.size()];
    agenda.setCreneauxMedecinJour(creneauxMedecinJour);
    // remplissage des créneaux de réservation
    for (int i = 0; i < creneauxHoraires.size(); i++) {
      // ligne i agenda
      creneauxMedecinJour[i] = new CreneauMedecinJour();
      // id du créneau
      creneauxMedecinJour[i].setCreneau(creneauxHoraires.get(i));
      // le créneau est-il libre ou réservé ?
      if (hReservations.containsKey(creneauxHoraires.get(i).getId())) {
        // le créneau est occupé - on note la resa
        Rv resa = hReservations.get(creneauxHoraires.get(i).getId());
        creneauxMedecinJour[i].setRv(resa);
      }
    }
    // on rend le résultat
    return agenda;
  }
  
    private  ClientRepository clr ;
	@Autowired
  private MedecinRepository mr ;
	@Autowired
  private RvRepository  rr;
	@Autowired
  private CreneauRepository  crr;
*/
@Override
public Client getClientById(Long id) {
	Client resultat = null ;
	//TODO delete this clr mr rr crr
	Optional<Client> resultatReq = clr.findById(id) ;
	if (resultatReq.isPresent()) {
	resultat = resultatReq.get() ;
	}
	return resultat;
}

@Override
public Rv ajouterRv(Date jour, Creneau creneau, Client client) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public AgendaMedecinJour getAgendaMedecinJour(Medecin medecin, Date jour) {
	//TODO delete this clr mr rr crr
	return null;
}


@Override
public List<Rv> getRvMedecinJour(Medecin medecin, Date jour) {
	//TODO delete this clr mr rr crr
	
	return null;
}


@Override
public Medecin getMedecinById(Long id) {
	Medecin resultat = null ;
	Optional<Medecin> resultatReq = mr.findById(id) ;
	if (resultatReq.isPresent()) {
	resultat = resultatReq.get() ;
	}
	return resultat;
}


@Override
public Rv getRvById(Long id) {
	Rv resultat = null ;
	//TODO delete this clr mr rr crr
	Optional<Rv> resultatReq = rr.findById(id) ;
	if (resultatReq.isPresent()) {
	resultat = resultatReq.get() ;
	}
	return resultat;
}


@Override
public Creneau getCreneauById(Long id) {
	Creneau resultat = null ;
	//TODO delete this clr mr rr crr
	Optional<Creneau> resultatReq = crr.findById(id) ;
	if (resultatReq.isPresent()) {
	resultat = resultatReq.get() ;
	}
	return resultat;
}


@Override
public void supprimerRv(Rv rv) {
	//TODO delete this clr mr rr crr
rr.delete(rv);	
}
  

  
}
