package model;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GestionnaireTaches gestionnaire = new GestionnaireTaches();
        gestionnaire.chargerDepuisFichier();
        Scanner sc = new Scanner(System.in);
        boolean continuer = true;
        while (continuer) {
            System.out.println("####################");
            System.out.println("1 - Ajouter une tâche");
            System.out.println("2 - Afficher les tâche");
            System.out.println("3 - Supprimer une tâche");
            System.out.println("4 - Marquer une tâche comme terminée");
            System.out.println("0 - Quitter");
            System.out.println("Quel est votre choix ?");
            System.out.println("####################");
            System.out.println("");
            int choix = sc.nextInt();
            sc.nextLine();
            switch (choix) {
                case 1:
                    System.out.println("");
                    System.out.println("Quel est l'ID de votre Tache ?");
                    System.out.println("");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.println("");
                    System.out.println("Quel est le titre de votre Tache ?");
                    System.out.println("");
                    String titre = sc.nextLine();
                    System.out.println("");
                    System.out.println("Quel est la description de votre Tache ?");
                    System.out.println("");
                    String description = sc.nextLine();
                    Tache tache = new Tache(id,titre,description);
                    gestionnaire.ajouterTache(tache);
                    System.out.println("");
                    System.out.println("Tache ajoutée avec succès !");
                    System.out.println("");
                    break;
                case 2:
                    gestionnaire.afficherTaches();
                    break;
                case 3:
                    System.out.println("");
                    System.out.println("Quel est l'ID de la Tache à supprimer ?");
                    System.out.println("");
                    int idsuppr = sc.nextInt();
                    sc.nextLine();
                    gestionnaire.supprimerTacheParId(idsuppr);
                    break;
                case 4:
                    System.out.println("");
                    System.out.println("Quel est l'ID de la Tache à marquer comme terminée ?");
                    System.out.println("");
                    int idterminee = sc.nextInt();
                    sc.nextLine();
                    gestionnaire.marquerTacheTerminee(idterminee);
                    break;
                case 0:
                    continuer = false;
                    System.out.println("");
                    System.out.println("A bientot !");
                    break;
                default:
                    System.out.println("");
                    System.out.println("Choix invalide...");
                    System.out.println("");
            }
        }
    }
}
