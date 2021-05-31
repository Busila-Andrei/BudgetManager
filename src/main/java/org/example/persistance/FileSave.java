package org.example.persistance;

import org.example.domain.ListProducts;
import org.example.domain.Product;

import javax.imageio.IIOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class FileSave {

    private final BufferedWriter bufferedWriter;
    private final DecimalFormat df = new DecimalFormat("0.00");

    public FileSave() throws IOException {
        String pathFile = "purchases.txt";
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(pathFile));
        } catch (IIOException e) {
            throw new RuntimeException("Failed to open file: " + pathFile);
        }
    }

    public void savePurchases(ListProducts listProducts) throws IOException {
        bufferedWriter.write("Balance: $" + df.format(listProducts.getSold()) + "\n");
        printProduct("FOOD",listProducts.getListOfFood());
        printProduct("CLOTHES",listProducts.getListOfClothes());
        printProduct("ENTERTAINMENT",listProducts.getListOfEntertainment());
        printProduct("OTHER",listProducts.getListOfOther());
    }

    public void printProduct(String categoryProduct, ArrayList<Product> list) throws IOException {
        try {
            for (Product product : list) {
                bufferedWriter.write(categoryProduct + "\n");
                bufferedWriter.write(product.getName() + "\n");
                bufferedWriter.write("$" + df.format(product.getPrice()) + "\n");
            }
        } catch (IIOException e) {
            throw new RuntimeException("Failed to write content to file");
        }

    }

    public void close() throws IOException {
        try {
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IIOException e) {
            throw new RuntimeException("Failed to save file");
        }
    }
}
