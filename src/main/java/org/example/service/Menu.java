package org.example.service;

import org.example.controller.StdinController;
import org.example.controller.UserInputController;
import org.example.controller.utils.ScannerUtils;
import org.example.domain.ListProducts;
import org.example.domain.Product;
import org.example.persistance.FileLoad;
import org.example.persistance.FileSave;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;

public class Menu {
    ListProducts listProducts = new ListProducts();
    DecimalFormat df = new DecimalFormat("0.00");
    private final UserInputController userInputController = new StdinController();

    public void menu() {
        String choice;
        do {
            choice = userInputController.getMenu();
            switch (choice) {
                case "1":
                    addIncome();
                    break;
                case "2":
                    addPurchase();
                    break;
                case "3":
                    showListOfPurchase();
                    break;
                case "4":
                    getBalance();
                    break;
                case "5":
                    saveList();
                    break;
                case "6":
                    loadList();
                    break;
                case "7":
                    analyze();
                    break;
                case "0":
                    System.out.println("Bye!");
                    break;
            }
        } while (!choice.equals("0"));

    }

    public void addIncome() {
        listProducts.setSold(listProducts.getSold() + userInputController.getIncome());
        System.out.println("Income was added!\n");
    }

    public void addPurchase() {
        String choice;
        do {
            choice = userInputController.getMenuProduct();
            switch (choice) {
                case "1":
                    addFood();
                    break;
                case "2":
                    addClothes();
                    break;
                case "3":
                    addEntertainment();
                    break;
                case "4":
                    addOther();
                    break;
            }
        } while (!choice.equals("5"));
    }

    public void addFood() {
        String nameProduct = userInputController.getNameProduct();
        double priceProduct = userInputController.getPriceProduct();
        listProducts.setListOfFood(nameProduct, priceProduct);
        listProducts.setListAll(nameProduct, priceProduct);
        listProducts.setSold(listProducts.getSold() - priceProduct);
        listProducts.setMoneyFood(listProducts.getMoneyFood()+priceProduct);
        listProducts.setMoneyAll(listProducts.getMoneyAll()+priceProduct);
        System.out.println("Purchase was added!\n");
    }

    public void addClothes() {
        String nameProduct = userInputController.getNameProduct();
        double priceProduct = userInputController.getPriceProduct();
        listProducts.setListOfClothes(nameProduct, priceProduct);
        listProducts.setListAll(nameProduct, priceProduct);
        listProducts.setSold(listProducts.getSold() - priceProduct);
        listProducts.setMoneyClothes(listProducts.getMoneyClothes()+priceProduct);
        listProducts.setMoneyAll(listProducts.getMoneyAll()+priceProduct);
        System.out.println("Purchase was added!\n");
    }

    public void addEntertainment() {
        String nameProduct = userInputController.getNameProduct();
        double priceProduct = userInputController.getPriceProduct();
        listProducts.setListOfEntertainment(nameProduct, priceProduct);
        listProducts.setListAll(nameProduct, priceProduct);
        listProducts.setSold(listProducts.getSold() - priceProduct);
        listProducts.setMoneyEntertainment(listProducts.getMoneyEntertainment()+priceProduct);
        listProducts.setMoneyAll(listProducts.getMoneyAll()+priceProduct);
        System.out.println("Purchase was added!\n");
    }

    public void addOther() {
        String nameProduct = userInputController.getNameProduct();
        double priceProduct = userInputController.getPriceProduct();
        listProducts.setListOfOther(nameProduct, priceProduct);
        listProducts.setListAll(nameProduct, priceProduct);
        listProducts.setSold(listProducts.getSold() - priceProduct);
        listProducts.setMoneyOther(listProducts.getMoneyOther()+priceProduct);
        listProducts.setMoneyAll(listProducts.getMoneyAll()+priceProduct);
        System.out.println("Purchase was added!\n");
    }

    public void showListOfPurchase() {
        String choice;
        do {
            choice = userInputController.getMenuList();
            switch (choice) {
                case "1":
                    listOfProduct(listProducts.getListOfFood());
                    break;
                case "2":
                    listOfProduct(listProducts.getListOfClothes());
                    break;
                case "3":
                    listOfProduct(listProducts.getListOfEntertainment());
                    break;
                case "4":
                    listOfProduct(listProducts.getListOfOther());
                    break;
                case "5":
                    listOfProduct(listProducts.getListAll());
                    break;
            }
        } while (!choice.equals("6"));
    }

    public void listOfProduct(ArrayList<Product> list) {
        if (list.isEmpty()) {
            System.out.println("The purchase list is empty\n");
        } else {
            double totalSum = 0;
            for (Product product : list) {
                System.out.println(product.getName() + " $" + df.format(product.getPrice()));
                totalSum += product.getPrice();
            }

            System.out.println("Total sum: $" + totalSum + "\n");
        }
    }

    public void getBalance() {
        System.out.println("Balance: $" + df.format(listProducts.getSold()) + "\n");
    }

    public void saveList() {
        try {
            FileSave fileSave = new FileSave();
            fileSave.savePurchases(listProducts);
            fileSave.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadList() {
        try {
            FileLoad fileLoad = new FileLoad();
            listProducts = fileLoad.loadPurchases(listProducts);
            fileLoad.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void analyze() {
        String choice;
        do {
        System.out.println("How do you want to sort?");
        System.out.println("1) Sort all purchases");
        System.out.println("2) Sort by type");
        System.out.println("3) Sort certain type");
        System.out.println("4) Back");
        choice = ScannerUtils.nextLine();
        System.out.println();
            switch (choice) {
                case "1":
                    sort(listProducts.getListAll(),listProducts.getMoneyAll(),"All");
                    break;
                case "2":
                    sortByType();
                    break;
                case "3":
                    sortCertainType();
                    break;
                case "4":
                    break;
            }
        } while (!choice.equals("4"));
    }

    public void sortByType(){
        Map<String,Double> list = new LinkedHashMap<>();
        list.put("Food",listProducts.getMoneyFood());
        list.put("Clothes",listProducts.getMoneyClothes());
        list.put("Entertainment",listProducts.getMoneyEntertainment());
        list.put("Other",listProducts.getMoneyOther());
        LinkedHashMap<String, Double> reverseSortedMap = new LinkedHashMap<>();
        list.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> reverseSortedMap.put(x.getKey(), x.getValue()));

        System.out.println("Types:");
        for (var e : reverseSortedMap.entrySet()){
            System.out.println(e.getKey() + " - $" + df.format(e.getValue()));
        }
        System.out.println("Total sum: $" + listProducts.getMoneyAll() + "\n");



    }
    public void sortCertainType(){
        System.out.println("Choose the type of purchase");
        System.out.println("1) Food");
        System.out.println("2) Clothes");
        System.out.println("3) Entertainment");
        System.out.println("4) Other");
        String choice = ScannerUtils.nextLine();
        System.out.println();
        switch (choice){
            case "1":
                sort(listProducts.getListOfFood(),listProducts.getMoneyFood(),"Food");
                break;
            case "2":
                sort(listProducts.getListOfClothes(),listProducts.getMoneyClothes(),"Entertainment");
                break;
            case "3":
                sort(listProducts.getListOfEntertainment(),listProducts.getMoneyEntertainment(),"Clothes");
                break;
            case "4":
                sort(listProducts.getListOfOther(),listProducts.getMoneyOther(),"Other");
                break;
        }
    }

    public void sort(ArrayList<Product> list, double total, String category){
        if (list.isEmpty()){
            System.out.println("The purchase list is empty!\n");
        }else {
            System.out.println(category +":");
            Product temp;
            boolean sorted = false;
            while (!sorted) {
                sorted = true;
                for (int i = 0; i < list.size()-1; i++) {
                    if (list.get(i).comparePriceTo(list.get(i + 1)) < 0) {
                        temp = list.get(i);
                        list.set(i, list.get(i + 1));
                        list.set(i + 1, temp);
                        sorted = false;
                    }
                }
            }
            sorted = false;
            while (!sorted) {
                sorted = true;
                for (int i = 0; i < list.size()-1; i++) {
                    if (list.get(i).comparePriceTo(list.get(i + 1)) == 0) {
                        if (list.get(i).compareNameTo(list.get(i + 1)) < 0) {
                            temp = list.get(i);
                            list.set(i, list.get(i + 1));
                            list.set(i + 1, temp);
                            sorted = false;
                        }
                    }
                }
            }

            list.forEach(e -> System.out.println(e.getName() + " $" + df.format(e.getPrice())));
            System.out.println("Total: $" + df.format(total)+ "\n");
        }
    }



}
