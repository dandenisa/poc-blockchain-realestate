package com.poc.realestate.demo.model;

public class Address {

    private Long id;
    private String cityName;
    private String countryName;
    private String streetName;
    private String countyName;
    private int floorNr;
    private int apartmentNr;
    private int houseNr;
    private int postalCode;

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCountyName() {
        return countyName;
    }

    public void setCountyName(String countyName) {
        this.countyName = countyName;
    }

    public int getFloorNr() {
        return floorNr;
    }

    public void setFloorNr(int floorNr) {
        this.floorNr = floorNr;
    }

    public int getApartmentNr() {
        return apartmentNr;
    }

    public void setApartmentNr(int apartmentNr) {
        this.apartmentNr = apartmentNr;
    }

    public int getHouseNr() {
        return houseNr;
    }

    public void setHouseNr(int houseNr) {
        this.houseNr = houseNr;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }
}
