package GestionLivre;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Livre {

    private String nom;
    private String auteur;
    private String genre;
    private String collection;


    public String getNom() {
        return nom;
    }

    public String setNom(String nom) {
        this.nom = nom;
        return nom;
    }

    public String setAuteur (String auteur)
    {
        this.auteur = auteur;
        return auteur;
    }
    public String getAuteur()
    {
        return auteur;
    }

    public String setGenre (String genre)
    {
        this.genre = genre;
        return genre;
    }
    public String getGenre()
    {
        return genre;
    }

    public String setCollection (String collection)
    {
        this.collection = collection;
        return collection;
    }
    public String getCollection()
    {
        return collection;
    }

    public void addLivres() {
        ArrayList<String> arrayLivre = new ArrayList<>();
        Scanner value = new Scanner(System.in);

        System.out.println("Saisissez le nom du livre : ");
        arrayLivre.add(setNom(value.nextLine()));

        System.out.println("Saisissez le nom de l'auteur : ");
        arrayLivre.add(setAuteur(value.nextLine()));

        System.out.println("Saisissez le genre : ");
        arrayLivre.add(setGenre(value.nextLine()));

        System.out.println("Saisissez la collection : ");
        arrayLivre.add(setCollection(value.nextLine()));


        // écriture des données sur le fichier 'Livre'
        // cela ne vaut pas un fichier csv mais je n'avais le temps de m'y consacrer
        try {
            FileOutputStream fileOut = new FileOutputStream("Livre");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(arrayLivre);
            fileOut.close();
            System.out.println("\nSerialisation terminée avec succès...\n");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void dataLivre()
    {
        ArrayList<String> arrayLivre = new ArrayList<>();

        // Lecture du fichier 'test'
        try {
            FileInputStream fileIn = new FileInputStream("Livre");
            ObjectInputStream ois = new ObjectInputStream(fileIn);
            arrayLivre = (ArrayList) ois.readObject();
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

        System.out.println("Livres : \n");
        for(String o:arrayLivre)
            System.out.println("- " + o);
    }

    public void modifierLivres()
    {
        ArrayList<String> arrayLivre = new ArrayList<>();
        Scanner value = new Scanner(System.in);

        System.out.println("Saisissez le nom du livre : ");
        arrayLivre.set(0, setNom(value.nextLine()));

        System.out.println("Saisissez le nom de l'auteur : ");
        arrayLivre.set(1, setAuteur(value.nextLine()));

        System.out.println("Saisissez le genre : ");
        arrayLivre.set(2, setGenre(value.nextLine()));

        System.out.println("Saisissez la collection : ");
        arrayLivre.set(3, setCollection(value.nextLine()));
    }

    public void modifierNom()
    {
        ArrayList<String> arrayLivre = new ArrayList<>();
        Scanner value = new Scanner(System.in);

        System.out.println("Saisissez le nom du livre : ");
        arrayLivre.set(0, setNom(value.nextLine()));
    }

    public void modifierAuteur()
    {
        ArrayList<String> arrayLivre = new ArrayList<>();
        Scanner value = new Scanner(System.in);

        System.out.println("Saisissez l'auteur du livre : ");
        arrayLivre.set(0, setAuteur(value.nextLine()));
    }

    public void modifierGenre()
    {
        ArrayList<String> arrayLivre = new ArrayList<>();
        Scanner value = new Scanner(System.in);

        System.out.println("Saisissez le genre : ");
        arrayLivre.set(2, setGenre(value.nextLine()));
    }

    public void modifierCollection()
    {
        ArrayList<String> arrayLivre = new ArrayList<>();
        Scanner value = new Scanner(System.in);

        System.out.println("Saisissez la collection : ");
        arrayLivre.set(3, setCollection(value.nextLine()));
    }

}
