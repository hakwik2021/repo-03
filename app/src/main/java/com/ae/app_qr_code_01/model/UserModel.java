package com.ae.app_qr_code_01.model;



/*
User Model

 */
public class UserModel {
    // User data
    private String firstName;
    private String lastName;
    private String address;
    private String mobileNumber;

    // Standard questions for COVID tracing
    private String temperature;
    private boolean hasSoreThroat;
    private boolean hasBodyPain;
    private boolean hasDiffBreathing;
    private boolean hasCough;
    private boolean hasRunnyNose;
    private boolean hasFever;
    private boolean hasContactWithSick;
    private boolean hasTraveled;

    // Constructor for <User data>
    public UserModel(String firstName, String lastName, String address, String mobileNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.mobileNumber = mobileNumber;
    }

    // Getter and setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public boolean isHasSoreThroat() {
        return hasSoreThroat;
    }

    public void setHasSoreThroat(boolean hasSoreThroat) {
        this.hasSoreThroat = hasSoreThroat;
    }

    public boolean isHasBodyPain() {
        return hasBodyPain;
    }

    public void setHasBodyPain(boolean hasBodyPain) {
        this.hasBodyPain = hasBodyPain;
    }

    public boolean isHasDiffBreathing() {
        return hasDiffBreathing;
    }

    public void setHasDiffBreathing(boolean hasDiffBreathing) {
        this.hasDiffBreathing = hasDiffBreathing;
    }

    public boolean isHasCough() {
        return hasCough;
    }

    public void setHasCough(boolean hasCough) {
        this.hasCough = hasCough;
    }

    public boolean isHasRunnyNose() {
        return hasRunnyNose;
    }

    public void setHasRunnyNose(boolean hasRunnyNose) {
        this.hasRunnyNose = hasRunnyNose;
    }

    public boolean isHasFever() {
        return hasFever;
    }

    public void setHasFever(boolean hasFever) {
        this.hasFever = hasFever;
    }

    public boolean isHasContactWithSick() {
        return hasContactWithSick;
    }

    public void setHasContactWithSick(boolean hasContactWithSick) {
        this.hasContactWithSick = hasContactWithSick;
    }

    public boolean isHasTraveled() {
        return hasTraveled;
    }

    public void setHasTraveled(boolean hasTraveled) {
        this.hasTraveled = hasTraveled;
    }
}
