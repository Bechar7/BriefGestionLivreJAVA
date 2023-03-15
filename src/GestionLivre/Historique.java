package GestionLivre;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Historique {

public void afficherHistoriqueEmprunt()
{
    ArrayList<String> emprunt = new ArrayList<>();

    try {
        FileInputStream fileIn = new FileInputStream("Emprunt");
        ObjectInputStream ois = new ObjectInputStream(fileIn);
        emprunt = (ArrayList) ois.readObject();
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

    System.out.println("\n Historique emprunt : \n");
    for(String o:emprunt)
        System.out.println("- " + o);
}
}

