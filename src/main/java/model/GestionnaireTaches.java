package model;

import java.io.*;
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

    public void marquerTacheTerminee(int id) {
        for (int i = 0; i < listeTache.size(); i++) {
            if (id == listeTache.get(i).getId()) {
                listeTache.get(i).marquerTerminee();
                break;
            }
        }
    }

    public void sauvegardeDansFichier() {
        String fichier = "taches.txt";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fichier))) {
            for (int i = 0; i < listeTache.size(); i++) {
                bw.write(
                        listeTache.get(i).getId()+ ";" +
                        listeTache.get(i).getTitre()+ ";" +
                        listeTache.get(i).getDescription() + ";" +
                        listeTache.get(i).isTerminee()
                );
                bw.newLine();
            }
            } catch (IOException e) {
            System.out.println("Erreur lors de la sauvegarde du fichier...");
        }
    }

    public void chargerDepuisFichier() {
       try (BufferedReader br = new BufferedReader(new FileReader("taches.txt"))) {
           String ligne;
           while ((ligne = br.readLine()) != null) {
               String[] decoupage = ligne.split(";");
               int id = Integer.parseInt(decoupage[0]);
               String titre = decoupage[1];
               String description = decoupage[2];
               boolean terminee = Boolean.parseBoolean(decoupage[3]);
               Tache tache = new Tache(id, titre, description);
               if (terminee) {
                   tache.marquerTerminee();
               }
               listeTache.add(tache);
           }
       } catch (IOException e) {
           System.out.println("Erreur lors de la lecture du fichier...");
       }
    }
}
