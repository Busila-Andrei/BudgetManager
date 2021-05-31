package org.example.persistance;

import org.example.domain.ListProducts;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileLoad {
    private final Scanner scanner;

    public FileLoad() throws IOException {
        String pathFile = "purchases.txt";
        scanner = new Scanner(new File(pathFile));
    }

    public ListProducts loadPurchases(ListProducts listProducts){
        String category;
        String nameProduct;
        double priceProduct;
        listProducts.setSold(listProducts.getSold() + Double.parseDouble(scanner.nextLine().split("\\$")[1]));
        while (scanner.hasNextLine()){
            category = scanner.nextLine();
            nameProduct = scanner.nextLine();
            priceProduct = Double.parseDouble(scanner.nextLine().split("\\$")[1]);
            switch (category) {
                case "FOOD":
                    listProducts.setListOfFood(nameProduct, priceProduct);
                    listProducts.setMoneyFood(listProducts.getMoneyFood()+priceProduct);
                    listProducts.setMoneyAll(listProducts.getMoneyAll()+priceProduct);
                    break;
                case "CLOTHES":
                    listProducts.setListOfClothes(nameProduct, priceProduct);
                    listProducts.setMoneyClothes(listProducts.getMoneyClothes()+priceProduct);
                    listProducts.setMoneyAll(listProducts.getMoneyAll()+priceProduct);
                    break;
                case "ENTERTAINMENT":
                    listProducts.setListOfEntertainment(nameProduct, priceProduct);
                    listProducts.setMoneyEntertainment(listProducts.getMoneyEntertainment()+priceProduct);
                    listProducts.setMoneyAll(listProducts.getMoneyAll()+priceProduct);
                    break;
                case "OTHER":
                    listProducts.setListOfOther(nameProduct, priceProduct);
                    listProducts.setMoneyOther(listProducts.getMoneyOther()+priceProduct);
                    listProducts.setMoneyAll(listProducts.getMoneyAll()+priceProduct);
                    break;
            }
            listProducts.setListAll(nameProduct, priceProduct);
        }
        System.out.println("Purchases were loaded!\n");
        return listProducts;

    }

    public void close() throws IOException {
        scanner.close();
    }
}
