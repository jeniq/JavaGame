package com.company;

import java.util.Scanner;

/**
 * Created by Женя on 23.04.2016.
 */
public class Controller {

    // Constructor
    Model model;
    View view;

    public Controller(Model model, View view){
        this.model = model;
        this.view = view;
    }

    // The work method
    public void processUser(){
        Scanner sc = new Scanner(System.in);

        view.printMessage(view.GREETING);
        model.setMenuChoice(checkInputValueInMenu(sc));
        switch (model.getMenuChoice()){
            case 0:
                model.setMinValue(0);
                model.setSecretNumber(model.rand());
                model.setMaxValue(model.getRAND_MAX());
                break;
            case 1:
                do{
                    model.setMinValue(checkMinInputValue(sc));
                    model.setMaxValue(checkMaxInputValue(sc));
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
        view.printMessage(view.CHOICE_IN_MENU);
        int inputNumber = sc.nextInt();
        while (inputNumber < 0 || inputNumber > 1){
            view.printMessage(view.WRONG_MENU_CHOICE);
            inputNumber = sc.nextInt();
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
     * Check input minimum value
     * @param sc number entered by user
     * @return minimum integer number
     */
    public int checkMinInputValue(Scanner sc){
        view.printMessage(view.ASK_MIN_VALUE);
        int inputNumber = sc.nextInt();
        while (inputNumber < 0 || inputNumber > 100){
            view.printMessage(view.WRONG_MIN_VALUE);
            inputNumber = sc.nextInt();
        }
        return inputNumber;
    }

    /**
     * Check input maximum value
     * @param sc number entered by user
     * @return maximum integer number
     */
    public int checkMaxInputValue(Scanner sc){
        view.printMessage(view.ASK_MAX_VALUE);
        int inputNumber = sc.nextInt();
        while (inputNumber < 0 || inputNumber > 100){
            view.printMessage(view.WRONG_MAX_VALUE);
            inputNumber = sc.nextInt();
        }
        return inputNumber;
    }

    // Game method
    public void startGame(Scanner sc){
        view.printMessage(view.START_GAME);
        view.printMessageWithRange(model.getMinValue(), model.getMaxValue());
        view.printMessage(view.GUESS_NUMBER);
        int inputNumber = sc.nextInt();
        while (inputNumber != model.getSecretNumber()){
            model.getAttemptHistory().add(inputNumber);
            if (inputNumber < model.getSecretNumber()){
                view.printMessage(view.NEED_LARGER_NUMBER);
            }else{
                view.printMessage(view.NEED_LESS_NUMBER);
            }
            view.printMessageWithHistory(model.getAttemptHistory());
            view.printMessageWithRange(model.getMinValue(), model.getMaxValue());
            inputNumber = sc.nextInt();
        }
        view.printMessage(view.WIN_NUMBER);
        view.printMessageWithStatistic(model.getAttemptHistory(), model.getHistoryLength());
    }
}
