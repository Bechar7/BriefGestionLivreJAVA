package GestionLivre;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Stock {

    private String stock;

    public String getStock() {
        return stock;
    }
    public String setStock(String stock) {
        this.stock = stock;
        return stock;
    }


    public void voirNombreLivreGeneral() throws IOException {
        FileReader fr = new FileReader("livres.csv");
        BufferedReader br = new BufferedReader(fr);

        while(setStock(br.readLine()) != null)
        {
            System.out.println(getStock());
        }
    }

}
