package org.example.controller;

import org.example.controller.utils.ScannerUtils;

public class StdinController implements UserInputController {
    @Override
    public String getNameProduct() {
        System.out.println("Enter purchase name:");
        return ScannerUtils.nextLine();
    }

    @Override
    public double getPriceProduct() {
        System.out.println("Enter its price:");
        return ScannerUtils.nextDouble();
    }

    @Override
    public double getIncome() {
        System.out.println("Enter income:");
        return ScannerUtils.nextDouble();
    }

    @Override
    public String getMenuProduct() {
        System.out.println("Choose the type of purchase");
        System.out.println("1) Food");
        System.out.println("2) Clothes");
        System.out.println("3) Entertainment");
        System.out.println("4) Other");
        System.out.println("5) Back");
        String choice = ScannerUtils.nextLine();
        System.out.println();
        return choice;
    }

    @Override
    public String getMenuList() {
        System.out.println("Choose the type of purchase");
        System.out.println("1) Food");
        System.out.println("2) Clothes");
        System.out.println("3) Entertainment");
        System.out.println("4) Other");
        System.out.println("5) All");
        System.out.println("6) Back");
        String choice = ScannerUtils.nextLine();
        System.out.println();
        return choice;
    }

    @Override
    public String getMenu() {
        System.out.println("Choose your action:");
        System.out.println("1) Add income");
        System.out.println("2) Add purchase");
        System.out.println("3) Show list of purchases");
        System.out.println("4) Balance");
        System.out.println("5) Save");
        System.out.println("6) Load");
        System.out.println("7) Analyze (Sort)");
        System.out.println("0) Exit");
        String choice = ScannerUtils.nextLine();
        System.out.println();
        return choice;
    }
}
