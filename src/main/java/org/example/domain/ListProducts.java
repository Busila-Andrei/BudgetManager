package org.example.domain;

import java.util.ArrayList;

public class ListProducts {
    private double sold = 0;

    private double moneyFood = 0;
    private double moneyClothes = 0;
    private double moneyEntertainment = 0;
    private double moneyOther = 0;
    private double moneyAll;

    private final ArrayList<Product> listOfFood = new ArrayList<>();
    private final ArrayList<Product> listOfClothes = new ArrayList<>();
    private final ArrayList<Product> listOfEntertainment = new ArrayList<>();
    private final ArrayList<Product> listOfOther = new ArrayList<>();
    private final ArrayList<Product> listAll = new ArrayList<>();

    public double getSold() {
        return sold; }

    public void setSold(double sold) {
        this.sold = sold;
    }

    public ArrayList<Product> getListOfFood() {
        return listOfFood;
    }

    public ArrayList<Product> getListOfClothes() {
        return listOfClothes;
    }

    public ArrayList<Product> getListOfEntertainment() {
        return listOfEntertainment;
    }

    public ArrayList<Product> getListOfOther() {
        return listOfOther;
    }

    public ArrayList<Product> getListAll() {
        return listAll;
    }

    public void setListOfFood(String nameProduct, double priceProduct) {
        listOfFood.add(new Product(nameProduct, priceProduct));
    }

    public void setListOfClothes(String nameProduct, double priceProduct) {
        listOfClothes.add(new Product(nameProduct, priceProduct));
    }

    public void setListOfEntertainment(String nameProduct, double priceProduct) {
        listOfEntertainment.add(new Product(nameProduct, priceProduct));
    }

    public void setListOfOther(String nameProduct, double priceProduct) {
        listOfOther.add(new Product(nameProduct, priceProduct));
    }

    public void setListAll(String nameProduct, double priceProduct) {
        listAll.add(new Product(nameProduct, priceProduct));
    }

    public double getMoneyFood() {
        return moneyFood;
    }

    public void setMoneyFood(double moneyFood) {
        this.moneyFood = moneyFood;
    }

    public double getMoneyClothes() {
        return moneyClothes;
    }

    public void setMoneyClothes(double moneyClothes) {
        this.moneyClothes = moneyClothes;
    }

    public double getMoneyEntertainment() {
        return moneyEntertainment;
    }

    public void setMoneyEntertainment(double moneyEntertainment) {
        this.moneyEntertainment = moneyEntertainment;
    }

    public double getMoneyOther() {
        return moneyOther;
    }

    public void setMoneyOther(double moneyOther) {
        this.moneyOther = moneyOther;
    }

    public double getMoneyAll() {
        return moneyAll;
    }

    public void setMoneyAll(double moneyAll) {
        this.moneyAll = moneyAll;
    }
}
