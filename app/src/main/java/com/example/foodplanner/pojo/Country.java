package com.example.foodplanner.pojo;

public class Country {
    private String countryName;
    private String countryCode;

    public Country(String countryName, String countryNationality) {
        this.countryName = countryName;
        this.countryCode = countryNationality;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryNationality) {
        this.countryCode = countryNationality;
    }
}
