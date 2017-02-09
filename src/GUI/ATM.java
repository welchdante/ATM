/**************************************************
 **************************************************
 * Dante Welch
 * ATM Project
 * February 1, 2017
 * Creates an ATM that has verious functions. Users
 * are able to enter amounts and be given an optimal
 * number of bills based on the amount desired.
 * Users can also input the different number of
 * bills that they want and they will be stored.
 * Users can also save and open each ATM as wanted.
 **************************************************
 **************************************************/

package GUI;


import java.io.*;

public class ATM implements Serializable {

    /**************************************************
     * Declaring instance variables
     * @param
     * @return
    **************************************************/

    private int hundreds, fifties, twenties;
    public static boolean suspend;
    private static final long  serialVersionUID = 1L;

    /**************************************************
     * Default constructor that sets the ATM to zero
     * @param
     * @return
     **************************************************/

    public ATM(){
        this.hundreds = 0;
        this.fifties = 0;
        this.twenties = 0;
    }

    /**************************************************
     * Setters and getters for instance variables
     * @param hundreds number of hundreds
     * @return hundreds return number of hundreds
     **************************************************/

    public void setHundreds(int hundreds){
        if(hundreds < 0)
            throw new IllegalArgumentException();
        this.hundreds = hundreds;
    }
    public int getHundreds(){
        return hundreds;
    }

    public void setFifties(int fifties){
        if(fifties < 0)
            throw new IllegalArgumentException();
        this.fifties = fifties;
    }
    public int getFifties(){
        return fifties;
    }

    public void setTwenties(int twenties){
        if(twenties < 0)
            throw new IllegalArgumentException();
        this.twenties = twenties;
    }
    public int getTwenties(){
        return twenties;
    }

    /**************************************************
     * Constructor that initializes the insrance
     * variables with the three parameters
     * @param hundreds num hundreds
     * @param fifties num fifties
     * @param twenties num twenties
     **************************************************/

    public ATM(int hundreds, int fifties, int twenties){

        if(hundreds < 0 || fifties < 0 || twenties < 0)
            throw new IllegalArgumentException();
        this.hundreds = hundreds;
        this.fifties = fifties;
        this.twenties = twenties;
    }

    /**************************************************
     * Constructor that initializes the insrance
     * variables with the other GUI.ATM parameter
     * @param other ATM object
     **************************************************/

    public ATM(ATM other){

        if (!(other instanceof ATM))
            throw new IllegalArgumentException();
        hundreds = other.hundreds;
        fifties = other.fifties;
        twenties = other.twenties;
    }

    /**************************************************
     * Returns true if this GUI.ATM object is exactly
     * the same as the other object
     * @param other ATM object
     * @return true or false
     **************************************************/

    public boolean equals(Object other){

        ATM otherATM = (ATM)other;
        if(this.hundreds == otherATM.hundreds &&
                this.fifties == otherATM.fifties &&
                this.twenties == otherATM.twenties){
            return true;
        }
        else {
            return false;
        }
    }

    /**************************************************
     * Returns true if this GUI.ATM object is exactly
     *  the same as the other ATM
     *  @param other ATM object
     * @return true or false
     **************************************************/

    public boolean equals(ATM other){

        if((this.hundreds == other.hundreds) &&
                (this.fifties == other.fifties) &&
                (this.twenties == other.twenties)){
            return true;
        }
        else {
            return false;
        }
    }

    /**************************************************
     * Returns true if object 1 == object 2
     * @param other1 ATM object
     * @param other2 ATM object
     * @return true or false
     **************************************************/

    public static boolean equals(ATM other1, ATM other2){

        if(!((other1 instanceof ATM) || (other2 instanceof ATM)))
            throw new IllegalArgumentException();
        if(other1.hundreds == other2.hundreds &&
                other1.fifties == other2.fifties &&
                other1.twenties == other2.twenties){
            return true;
        }
        else{
            return false;
        }
    }

    /**************************************************
     * Returns 1 if this object is > other, 0 if this
     * == other or -1 if this is < other
     * @param other ATM object
     * @return -1, 0,1
     **************************************************/

    public int compareTo(ATM other){

        if(!(other instanceof ATM))
            throw new IllegalArgumentException();

        ATM otherATM = (ATM)other;

        if((this.hundreds*100 + this.fifties*50 + this.twenties*20) >
                (other.hundreds*100 + other.fifties*50 + other.twenties*20)){
            return 1;
        }
        if((this.hundreds*100 + this.fifties*50 + this.twenties*20) <
                (other.hundreds*100 + other.fifties*50 + other.twenties*20)) {
            return -1;
        }
        else{
            return 0;
        }
    }

    /**************************************************
     * Returns other1 if other1 > other2, returns -1 if
     * other1 < other2 or returns 0 if other1 == other2
     * @param other1 ATM object
     * @param other2 ATM object
     * @return 1,0,-1
     **************************************************/

    public static int compareTo(ATM other1, ATM other2){

        if(!((other1 instanceof ATM) || (other2 instanceof ATM)))
            throw new IllegalArgumentException();
        int other1value = other1.hundreds*100 + other1.fifties*50 +other1.twenties*20;
        int other2value = other2.hundreds*100 + other2.fifties*50 +other2.twenties*20;
        if(other1value > other2value){
            return 1;
        }
        else if(other1value < other2value){
            return -1;
        }
        else{
            return 0;
        }
    }

    /**************************************************
     * Adds the parameters to the this.ATM object
     * @param hundreds
     * @param fifties
     * @param twenties
     **************************************************/

    public void putIn(int hundreds, int fifties, int twenties){

        if(hundreds < 0 || fifties < 0 || twenties < 0)
            throw new IllegalArgumentException();
        if(suspend == false){
            this.hundreds += hundreds;
            this.fifties += fifties;
            this.twenties += twenties;
        }
    }

    /**************************************************
     * Adds GUI.ATM other to the "this" GUI.ATM object
     * @param other ATM object
     **************************************************/

    public void putIn(ATM other){

        if(!(other instanceof ATM))
            throw new IllegalArgumentException();

        if(suspend == false){
            this.hundreds += other.hundreds;
            this.fifties += other.fifties;
            this.twenties += other.twenties;
        }
    }

    /**************************************************
     * Subtracts the parameters from the this.ATM object
     * @param hundreds num hundreds
     * @param fifties num fifties
     * @param twenties num twenties
     **************************************************/

    public void takeOut(int hundreds, int fifties, int twenties){

        if(hundreds < 0 || fifties < 0 || twenties < 0)
            throw new IllegalArgumentException();

        if(suspend == false) {
            this.hundreds -= hundreds;
            this.fifties -= fifties;
            this.twenties -= twenties;
        }
    }

    /**************************************************
     * Subtracts GUI.ATM other to the "this" GUI.ATM object
     * @param other ATM object
     **************************************************/

    public void takeOut(ATM other){

        if(!(other instanceof ATM))
            throw new IllegalArgumentException();

        if(suspend == false) {
            this.hundreds -= other.hundreds;
            this.fifties -= other.fifties;
            this.twenties -= other.twenties;
        }
    }

    /**************************************************
     * Optimizes the number of hundreds, fifties,
     * and twenties for a requested amount
     * @param amount what you want to pull out
     * @return optimalATM || null perfect amount of bills
     **************************************************/

    public ATM takeOut(double amount){

        if(amount < 0)
            throw new IllegalArgumentException();
        if(suspend == false) {
            int neededHundreds = 0;

            int availableTwenties = this.twenties;
            int availableFifties = this.fifties;
            int availableHundreds = this.hundreds;

            int neededFifties = (amount % 20 == 10 && amount >= 50) ? 1 : 0;

            availableFifties -= neededFifties;

            int neededTwenties = ((int) amount - neededFifties * 50) / 20;

            if (amount % 10 != 0 || amount < 0) {
                return null;
            }

            while (availableHundreds > 0 && neededTwenties >= 5) {
                neededTwenties -= 5;
                neededHundreds++;
                availableHundreds--;
            }

            while (availableFifties > 1 && neededTwenties >= 5) {
                neededTwenties -= 5;
                availableFifties -= 2;
                neededFifties += 2;
            }

            if (availableFifties < 0 || neededTwenties > availableTwenties
                    || amount < 50 && amount % 20 != 0) {
                return null;
            }
            if (neededHundreds < 0 || neededFifties < 0 || neededTwenties < 0) {
                return null;
            }
            else{
                takeOut(neededHundreds, neededFifties, neededTwenties);
                ATM optimalATM = new ATM(neededHundreds, neededFifties, neededTwenties);
                return optimalATM;
            }
        }
        else{
            return null;
        }
    }

    /**************************************************
     * Returns a string that represents an GUI.ATM
     * @return formatted string
     **************************************************/

    public String toString(){
        if(this.hundreds == 1 && this.fifties == 1 && this.twenties == 1){
            return this.hundreds +" hundred dollar bill, "
                    +this.fifties +" fifty dollar bill "
                    +this.twenties +"twenty dollar bill.";
        }
        else if(this.hundreds == 1 && this.fifties == 1){
            return this.hundreds +" hundred dollar bill, "
                    +this.fifties +" fifty dollar bill "
                    +this.twenties +"twenty dollar bills.";
        }
        else if(this.hundreds == 1 && this.twenties == 1){
            return this.hundreds +" hundred dollar bill, "
                    +this.fifties +" fifty dollar bills "
                    +this.twenties +"twenty dollar bill.";
        }
        else if(this.hundreds == 1){
            return this.hundreds +" hundred dollar bill, "
                    +this.fifties +" fifty dollar bills "
                    +this.twenties +"twenty dollar bills.";
        }
        else if(this.fifties == 1 && this.twenties == 1){
            return this.hundreds +" hundred dollar bills, "
                    +this.fifties +" fifty dollar bill "
                    +this.twenties +"twenty dollar bill.";
        }
        else if(this.fifties == 1){
            return this.hundreds +" hundred dollar bill, "
                    +this.fifties +" fifty dollar bills "
                    +this.twenties +"twenty dollar bill.";
        }
        else if(this.twenties == 1){
            return this.hundreds +" hundred dollar bill, "
                    +this.fifties +" fifty dollar bill "
                    +this.twenties +"twenty dollar billS.";
        }
        else{
            return this.hundreds +" hundred dollar bills, "
                    +this.fifties +" fifty dollar bills "
                    +this.twenties +"twenty dollar bills.";
        }
    }

    /**************************************************
     * Serializes an GUI.ATM object and saves it to a file
     * @param filename name of the file
     **************************************************/

    public void save(String filename){

        ATM saveATM = new ATM(this.hundreds,
                this.fifties, this.twenties);

        try{
            FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(saveATM);
            oos.close();
            fos.close();
            System.out.println("Serialiazed data is saved");
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println("Failed to load save.");
        }
    }

    /**************************************************
     * Deserializes the GUI.ATM object from the file
     * and loads
     * @param filename name of the file
     **************************************************/

    public void load(String filename){

        try{
            FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream ois = new ObjectInputStream(fis);
            ATM temp = (ATM) ois.readObject();
            this.hundreds = temp.getHundreds();
            this.fifties = temp.getFifties();
            this.twenties = temp.getTwenties();
            ois.close();
            fis.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    /**************************************************
     * Turns off or on any take out or put in methods
     * on an GUI.ATM
     * @param on either on or off
     **************************************************/

    public static void suspend(Boolean on){

        suspend = on;
    }

    public static void main(String[] args){

    }

}