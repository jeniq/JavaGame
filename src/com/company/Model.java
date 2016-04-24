package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Женя on 23.04.2016.
 */
public class Model {
    private int menuChoice;
    private int secretNumber;
    private int minValue;
    private int maxValue;
    private int RAND_MAX;
    private List<Integer> attemptHistory;

    // Constructor

    public Model(){
        setAttemptHistory(new ArrayList<>());
    }

    // The program logic

    /**
     * Generate random number in the range 0 - 100
     * @return random integer number
     */
    public int rand(){
        RAND_MAX = 1 + (int)(Math.random()*(100)); // generate maximum value of the range from 1 - 100
        return (int)(Math.random()*(RAND_MAX + 1));
    }

    /**
     * Generate random value in range from minimum to maximum values entered by user
     * @param min minimum value of the range
     * @param max maximum value of the range
     * @return random integer number
     */
    public int rand(int min, int max){
        return min + (int)(Math.random()*((max - min) + 1));
    }

    /**
     * Attempt's size
     * @return history length of user's attempts
     */
    public int getHistoryLength(){
        return attemptHistory.size();
    }

    public int getSecretNumber() {
        return secretNumber;
    }

    public void setSecretNumber(int secretNumber) {
        this.secretNumber = secretNumber;
    }

    public int getMenuChoice() {
        return menuChoice;
    }

    public void setMenuChoice(int menuChoice) {
        this.menuChoice = menuChoice;
    }

    public int getMinValue() {
        return minValue;
    }

    public void setMinValue(int minValue) {
        this.minValue = minValue;
    }

    public int getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }

    public List<Integer> getAttemptHistory() {
        return attemptHistory;
    }

    public void setAttemptHistory(List<Integer> attemptHistory) {
        this.attemptHistory = attemptHistory;
    }

    public int getRAND_MAX() {
        return RAND_MAX;
    }

    public void setRAND_MAX(int MAX_RAND) {
        this.RAND_MAX = MAX_RAND;
    }
}
