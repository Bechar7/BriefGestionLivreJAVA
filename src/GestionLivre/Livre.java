package GestionLivre;

import javax.xml.transform.stream.StreamSource;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;



public class Livre {

    private String nom;
    private String auteur;
    private String genre;
    private String collection;
    ArrayList<String> arrayLivre = new ArrayList<>();
    Scanner value = new Scanner(System.in);


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

        System.out.println("Saisissez le nom du livre : ");
        setNom(value.nextLine());

        System.out.println("Saisissez le nom de l'auteur : ");
        setAuteur(value.nextLine());

        System.out.println("Saisissez le genre : ");
        setGenre(value.nextLine());

        System.out.println("Saisissez la collection : ");
        setCollection(value.nextLine());

        arrayLivre.add(getNom()+ " ,"+getAuteur()+" ,"+getGenre()+" ,"+getCollection());

        for(String test : arrayLivre)
        {
            writeInFile("livres.csv", test, true);
        }
    }

    public static void writeInFile(String file, String inputString, boolean append){

        try(FileWriter fw = new FileWriter(file, append);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw))
        {
            out.println(inputString);
        } catch (IOException e) {
            //exception handling left as an exercise for the reader
        }
    }

    public void modifierLivres() throws IOException {

        Scanner value = new Scanner(System.in);
        ArrayList<String> changeData = new ArrayList<>();
        System.out.println("Choisissez un livre à modifier :");

        // Lecture du fichier 'test'
        FileReader fr = new FileReader("livres.csv");
        BufferedReader br = new BufferedReader(fr);

        String line = new String();

        int nbrLine = Integer.parseInt(value.nextLine());
        for(int i = 1; i < 20; i++)
        {
            if(i == nbrLine)
            {
                line = br.readLine();
                String[] caract = line.split(",");
                changeData.addAll(Arrays.asList(caract));
                // System.out.println(caract[0]);
            }
            else
            {
                br.readLine();
            }
        }

        System.out.println("modifier le nom du livre : ");
        setNom(value.nextLine());

        System.out.println("Modifier le nom de l'auteur : ");
        setAuteur(value.nextLine());

        System.out.println("Modifier le genre : ");
        setGenre(value.nextLine());

        System.out.println("Modifier la collection : ");
        setCollection(value.nextLine());

        changeData.set(0, getNom());
        changeData.set(1, getAuteur());
        changeData.set(2, getGenre());
        changeData.set(3, getCollection());

        for(String a : changeData)
        {
            System.out.println(a);
        }

    }
}