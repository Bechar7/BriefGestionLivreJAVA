package GestionLivre;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Emprunter {

    private String nom;
    private String dateNaissance;

    public String getDateNaissance() {
        return dateNaissance;
    }
    public String setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
        return dateNaissance;
    }

    public String getNom() {
        return nom;
    }
    public String setNom(String nom) {
        this.nom = nom;
        return nom;
    }

    public void addEmprunter()
    {
        ArrayList<String> arrayEmprunter = new ArrayList<>();
        Scanner value = new Scanner(System.in);

        System.out.println("Saisissez le nom de l'emprunter : ");
        arrayEmprunter.add(setNom(value.nextLine()));

        System.out.println("Saisissez la date de naissance de l'emprunter : (jj/mm/aaaa)");
        arrayEmprunter.add(setDateNaissance((value.nextLine())));

        try {
            FileOutputStream fileOut = new FileOutputStream("Emprunter");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(arrayEmprunter);
            fileOut.close();
            System.out.println("\nSerialisation terminée avec succès...\n");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void dataEmprunter()
    {
        ArrayList<String> arrayEmprunter = new ArrayList<>();

        // Lecture du fichier 'test'
        try {
            FileInputStream fileIn = new FileInputStream("Emprunter");
            ObjectInputStream ois = new ObjectInputStream(fileIn);
            arrayEmprunter = (ArrayList) ois.readObject();
            ois.close();
            fileIn.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("\n Emprunter: \n");
        for(String o:arrayEmprunter)
            System.out.println("- " + o);
    }

    public void modifierEmprunter()
    {
        ArrayList<String> arrayEmprunter = new ArrayList<>();
        Scanner value = new Scanner(System.in);

        System.out.println("Saisissez le nom du client : ");
        arrayEmprunter.set(0, setNom(value.nextLine()));

        System.out.println("Saisissez la date de naissance du client : ");
        arrayEmprunter.set(1, setNom(value.nextLine()));
    }

    public void modifierNom()
    {
        ArrayList<String> arrayEmprunter = new ArrayList<>();
        Scanner value = new Scanner(System.in);

        System.out.println("Saisissez le nom du livre : ");
        arrayEmprunter.set(0, setNom(value.nextLine()));
    }

    public void modifierDateNaissance()
    {
        ArrayList<String> arrayEmprunter = new ArrayList<>();
        Scanner value = new Scanner(System.in);

        System.out.println("Saisissez la date de naissance du client : ");
        arrayEmprunter.set(1, setNom(value.nextLine()));
    }
}