/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.marcel.web.mavenjsfcdi;

/**
 *
 * @author Marcel
 */
public class Car {

    private String randomMode;
    private int randomYear;
    private String randomManufacturer;
    private String randomColor;
    
   
    public Car(String randomMode, int randomYear, String randomManufacturer, String randomColor) {
        this.randomMode = randomMode;
        this.randomYear = randomYear;
        this.randomManufacturer = randomManufacturer;
        this.randomColor = randomColor;
    }

    public String getRandomMode() {
        return randomMode;
    }

    public void setRandomMode(String randomMode) {
        this.randomMode = randomMode;
    }

    public int getRandomYear() {
        return randomYear;
    }

    public void setRandomYear(int randomYear) {
        this.randomYear = randomYear;
    }

    public String getRandomManufacturer() {
        return randomManufacturer;
    }

    public void setRandomManufacturer(String randomManufacturer) {
        this.randomManufacturer = randomManufacturer;
    }

    public String getRandomColor() {
        return randomColor;
    }

    public void setRandomColor(String randomColor) {
        this.randomColor = randomColor;
    }
    
    
    
}
