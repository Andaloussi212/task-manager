package model;

import java.util.ArrayList;

public class GestionnaireTaches {
    private ArrayList<Tache> listeTache;

    public GestionnaireTaches() {
        this.listeTache = new ArrayList<>();
    }

    public void ajouterTache(Tache t) {
        listeTache.add(t);
    }

    public void afficherTaches() {
        if (listeTache.size() == 0) {
            System.out.println("Il n'y a aucune tache dans la liste...");
        } else {
            for (int i = 0; i < listeTache.size(); i++) {
                System.out.println(listeTache.get(i));
            }
        }
    }

    public void supprimerTacheParId(int id) {
        for (int i = 0; i < listeTache.size(); i++) {
            if (id == listeTache.get(i).getId()) {
                listeTache.remove(i);
                break;
            }
        }
    }
}
