package GestionLivre;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Livre livres = new Livre();
        Emprunter client = new Emprunter();
        Emprunt emprunt = new Emprunt();
        Historique historique = new Historique();


        Scanner value = new Scanner(System.in);
        System.out.println("\n Votre demande concerne \n - Les livres ? (livres) \n - Un client ? (client) \n - L'historique ? (historique) \n - Le Stock ? (stock) \n - Noter un emprunt ? (emprunt) ");
        String sujet = value.nextLine();
        if(Objects.equals(sujet.toLowerCase(), "livres"))
        {
            System.out.println("Souhaitez-vous ajouter ou modifier un livre ? ");
            String user = value.nextLine();
            if(Objects.equals(user, "ajouter"))
            {
                System.out.println("---------Ajout Livre----------");
                livres.addLivres();
                livres.dataLivre();
            }
            else if (Objects.equals(user, "modifier"))
            {
                System.out.println("Souhaitez-vous modifier toutes les caractéristiques d'un livre ? (oui) ou (non)");
                String modifier = value.nextLine();
                if(Objects.equals(modifier.toLowerCase(), "oui"))
                {
                    livres.modifierLivres();
                }
                else if(Objects.equals(modifier.toLowerCase(), "non"))
                {
                    System.out.print("Quelle caractéristisque souhaitez-vous modifier ?");
                    System.out.print("Le nom du livre ? (nom) | L'auteur ? (auteur) | Le genre ? (genre) | Ou la collection ? (collection)");
                    String modifier2 = value.nextLine();
                    if(Objects.equals(modifier2.toLowerCase(), "nom"))
                    {
                        livres.modifierNom();
                    }
                    else if (Objects.equals(modifier2.toLowerCase(), "auteur"))
                    {
                        livres.modifierAuteur();
                    }
                    else if (Objects.equals(modifier2.toLowerCase(), "genre"))
                    {
                        livres.modifierGenre();
                    }
                    else if (Objects.equals(modifier2.toLowerCase(), "collection"))
                    {
                        livres.modifierCollection();
                    }
                    else{
                        System.out.print("Réponse non acceptée. Veuillez réessayer");
                    }
                }
                else{
                    System.out.print("Réponse non acceptée. Veuillez réessayer");
                }

            }
            else{
                System.out.println("Je n'ai pas compris la réponse. Veuillez réessayer");
            }
        }
        else if (Objects.equals(sujet.toLowerCase(), "client")) {
            System.out.println("Souhaitez-vous ajouter un client ? ");
            String user = value.nextLine();
            if (Objects.equals(user, "ajouter")) {
                System.out.println("---------Ajout Client----------");
                client.addEmprunter();
                client.dataEmprunter();
            } else if (Objects.equals(user, "modifier")) {

                System.out.println("Souhaitez-vous modifier toutes les caractéristiques d'un emprunteur ? (oui) ou (non)");
                String modifier = value.nextLine();
                if (Objects.equals(modifier.toLowerCase(), "oui")) {
                    client.modifierEmprunter();
                } else if (Objects.equals(modifier.toLowerCase(), "non")) {
                    System.out.print("Quelle caractéristisque souhaitez-vous  modifier ?");
                    System.out.print("La modification concerne \n - Le nom ? (nom) \n - La date de naissance ? (dt)");
                    String modifier3 = value.nextLine();
                    if (Objects.equals(modifier3.toLowerCase(), "nom")) {
                        client.modifierNom();
                    } else if (Objects.equals(modifier3.toLowerCase(), "dt")) {
                        client.modifierDateNaissance();
                    } else {
                        System.out.print("Réponse non acceptée. Veuillez réessayer");
                    }
                }
            }
        }
        else if (Objects.equals(sujet.toLowerCase(), "historique"))
        {
            System.out.println("Consulter l'historique d'emprunt ? (oui)");
            String consulter = value.nextLine();
            if(Objects.equals(consulter, "oui"))
            {
                System.out.println("Voici le/les dernier(s) emprunt(s) ");
                historique.afficherHistoriqueEmprunt();
            }
        }
        else if (Objects.equals(sujet.toLowerCase(), "stock"))
        {
            System.out.println("---stock---");
        }
        else if (Objects.equals(sujet.toLowerCase(), "emprunt"))
        {
            System.out.println("Souhaitez-vous ajouter un emprunt ? (oui)");
            String ajouter = value.nextLine();
            if(Objects.equals(ajouter, "oui"))
            {
                System.out.println("---------Ajout emprunt----------");
                emprunt.addEmprunt();
            }
        }
    }
}
