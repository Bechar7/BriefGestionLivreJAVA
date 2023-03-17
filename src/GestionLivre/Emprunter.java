package GestionLivre;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
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
        setNom(value.nextLine());

        System.out.println("Saisissez la date de naissance de l'emprunter : (jj/mm/aaaa)");
        setDateNaissance(value.nextLine());

        arrayEmprunter.add(getNom()+" ,"+getDateNaissance());

        for(String add : arrayEmprunter)
        {
            writeInFile("emprunter.csv", add, true);
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

    public void modifierEmprunter() throws IOException {
        Scanner value = new Scanner(System.in);
        ArrayList<String> changeData = new ArrayList<>();
        System.out.println("Choisissez le client à modifier :");

        // Lecture du fichier 'test'
        FileReader fr = new FileReader("emprunter.csv");
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

        System.out.println("modifier le nom du client : ");
        setNom(value.nextLine());

        System.out.println("Modifier la date de naissance : ");
        setDateNaissance(value.nextLine());

        changeData.set(0, getNom());
        changeData.set(1, getDateNaissance());

        for (String a : changeData) {
            System.out.println(a);
        }
    }



}