package GestionLivre;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Emprunt extends Emprunter{

    private String nomLivre;
    private String dateEmprunt;

    public String getNomLivre() {
        return nomLivre;
    }
    public String setNomLivre(String nomLivre) {
        this.nomLivre = nomLivre;
        return nomLivre ;
    }

    public String getDateEmprunt() {
        return dateEmprunt;
    }
    public String setDateEmprunt(String dateEmprunt) {
        this.dateEmprunt = dateEmprunt;
        return dateEmprunt;
    }

    public void addEmprunt()
    {
        ArrayList<String> emprunt = new ArrayList<>();
        Scanner value = new Scanner(System.in);

        System.out.println("Saisissez le nom de l'emprunter : ");
        emprunt.add(setNom(value.nextLine()));

        System.out.println("Saisissez le nom du livre emprunté : ");
        emprunt.add(setNomLivre(value.nextLine()));

        System.out.println("Saisissez la date de l'emprunt : (format jj/mm/aaaa) ");
        emprunt.add(setDateEmprunt(value.nextLine()));

        try {
            FileOutputStream fileOut = new FileOutputStream("Emprunt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(emprunt);
            fileOut.close();
            System.out.println("\nSerialisation terminée avec succès...\n");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
