package GestionLivre;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
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
        setNom(value.nextLine());

        System.out.println("Saisissez le nom du livre emprunté : ");
        setNomLivre(value.nextLine());

        System.out.println("Saisissez la date de l'emprunt : (format jj/mm/aaaa) ");
        setDateEmprunt(value.nextLine());

        emprunt.add(getNom()+" ,"+getNomLivre()+", "+getDateEmprunt());

        for(String add : emprunt)
        {
            writeInFile("emprunt.csv", add, true);
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

    public void modifierEmprunt() throws IOException {
        Scanner value = new Scanner(System.in);
        ArrayList<String> changeData = new ArrayList<>();
        System.out.println("Choisissez l'emprunt à modifier :");

        // Lecture du fichier 'test'
        FileReader fr = new FileReader("emprunt.csv");
        BufferedReader br = new BufferedReader(fr);

        String line = new String();

        int nbrLine = Integer.parseInt(value.nextLine());
        for (int i = 1; i < 20; i++) {
            if (i == nbrLine) {
                line = br.readLine();
                String[] caract = line.split(",");
                changeData.addAll(Arrays.asList(caract));
                // System.out.println(caract[0]);
            } else {
                br.readLine();
            }
        }

        System.out.println("modifier le nom de l'emprunter : ");
        setNom(value.nextLine());

        System.out.println("modifier le nom du livre emprunté : ");
        setNomLivre(value.nextLine());

        System.out.println("Modifier la date de naissance : ");
        setDateEmprunt(value.nextLine());


        changeData.set(0, getNom());
        changeData.set(1, getNomLivre());
        changeData.set(2, getDateEmprunt());

        for (String a : changeData) {
            System.out.println(a);
        }
    }

}
