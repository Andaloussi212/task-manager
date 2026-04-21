package model;

public class Tache {
    private int id;
    private String titre;
    private String description;
    private boolean terminee;

    public Tache(int i, String t, String d) {
        this.id = i;
        this.titre = t;
        this.description = d;
        this.terminee = false;
    }

    public int getId() {
        return this.id;
    }

    public String getTitre() {
        return this.titre;
    }

    public String getDescription() {
        return this.description;
    }

    public boolean isTerminee() {
        return this.terminee;
    }

    public void marquerTerminee() {
        this.terminee = true;
    }

    public String toString() {
        if (isTerminee()) {
            return "[" + this.id + "] " + this.titre + " - terminee";
        } else {
            return "[" + this.id + "] " + this.titre + " - non terminee";
        }
    }
}
