package com.vmware.NetworkOfGiving.model;

public class Charity {

    private int id;

    private String title;
    private String description;
    private int volunteersNeeded;
    private int volunteers;
    private double moneyNeeded;
    private double moneyDonated;
    private String creatorsUsername;

    public Charity() {

    }

    public Charity(String title, String description, int volunteersNeeded, int volunteers, double moneyNeeded, double moneyDonated, String creatorsUsername, int id) {
        this.title = title;
        this.description = description;
        this.volunteersNeeded = volunteersNeeded;
        this.volunteers = volunteers;
        this.moneyNeeded = moneyNeeded;
        this.moneyDonated = moneyDonated;
        this.creatorsUsername = creatorsUsername;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getVolunteersNeeded() {
        return volunteersNeeded;
    }

    public void setVolunteersNeeded(int volunteersNeeded) {
        this.volunteersNeeded = volunteersNeeded;
    }

    public int getVolunteers() {
        return volunteers;
    }

    public void setVolunteers(int volunteers) {
        this.volunteers = volunteers;
    }

    public double getMoneyNeeded() {
        return moneyNeeded;
    }

    public void setMoneyNeeded(double moneyNeeded) {
        this.moneyNeeded = moneyNeeded;
    }

    public double getMoneyDonated() {
        return moneyDonated;
    }

    public void setMoneyDonated(double moneyDonated) {
        this.moneyDonated = moneyDonated;
    }

    public String getCreatorsUsername() {
        return creatorsUsername;
    }

    public void setCreatorsUsername(String creatorsUsername) {
        this.creatorsUsername = creatorsUsername;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
