package com.company.controller;

import com.company.GlobalConstants;
import com.company.view.View;
import com.company.model.Model;

import java.util.Scanner;

/**
 * Created by Женя on 23.04.2016.
 */
public class Controller {
    Model model;
    View view;

    // Constructor
    public Controller(Model model, View view){
        this.model = model;
        this.view = view;
    }

    // The work method
    public void processUser(){
        Scanner sc = new Scanner(System.in);

        view.printMessage(view.GREETING);
        model.setMenuChoice(checkInputValueInMenu(sc));
        model.setMinValue(GlobalConstants.MIN_VALUE); // set primary minimum value
        model.setMaxValue(GlobalConstants.MAX_VALUE); // set primary maximum value
        switch (model.getMenuChoice()){
            case 0:
                model.setSecretNumber(model.rand());
                model.setMaxValue(model.getRAND_MAX());
                break;
            case 1:
                do{
                    view.printMessage(view.ASK_MIN_BARRIER_VALUE);
                    model.setMinValue(checkInputUserValue(sc));
                    view.printMessage(view.ASK_MAX_BARRIER_VALUE);
                    model.setMaxValue(checkInputUserValue(sc));
                }while (!rightInputValue(model.getMinValue(), model.getMaxValue()));
                model.setSecretNumber(model.rand(model.getMinValue(), model.getMaxValue()));
                break;
        }
        startGame(sc);
    }

    /**
     * Check input value in menu
     * @param sc input value entered by user
     * @return number of user's choice
     */
    public int checkInputValueInMenu(Scanner sc){
        int inputNumber = 0;
        view.printMessage(view.CHOICE_IN_MENU);
        while (true){
            // check int - value
            while (!sc.hasNextInt()){
                view.printMessage(view.WRONG_MENU_CHOICE);
                sc.next();
            }
            // check value in diapason
            if ((inputNumber = sc.nextInt()) < 0 || inputNumber > 1){
                view.printMessage(view.WRONG_MENU_CHOICE);
                continue;
            }
            break;
        }
        return inputNumber;
    }

    /**
     * Check minimum and maximum values on the correct meaning
     * @param min minimum value of the range
     * @param max maximum value of the range
     * @return true in case correct value
     */
    public boolean rightInputValue(int min, int max){
        if (min < max){
            return true;
        }
        return false;
    }

    /**
     * Check input barrier value
     * @param sc number entered by user
     * @return integer number
     */
    public int checkInputUserValue(Scanner sc){
        int inputNumber = 0;
        while (true) {
            while (!sc.hasNextInt()) {
                view.printMessage(view.WRONG_INT_DATA);
                sc.next();
            }
            if ((inputNumber = sc.nextInt()) < model.getMinValue() || inputNumber > model.getMaxValue()) {
                view.printMessage(view.WRONG_BARRIER_VALUE);
                continue;
            }
            break;
        }
        return inputNumber;
    }

    // Game method
    public void startGame(Scanner sc){
        int userNumber = 0;
        view.printMessage(view.START_GAME);
        view.printMessageWithRange(model.getMinValue(), model.getMaxValue());
        view.printMessage(view.GUESS_NUMBER);
        while (!model.isEquals(userNumber = checkInputUserValue(sc))){
            model.getAttemptHistory().add(userNumber);
            view.printMessageWithHistory(model.getAttemptHistory());
            view.printMessageWithRange(model.getMinValue(), model.getMaxValue());
            }
        view.printMessage(view.WIN_NUMBER);
        view.printMessageWithStatistic(model.getAttemptHistory(), model.getHistoryLength());
        }
}