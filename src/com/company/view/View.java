package com.company.view;

import javax.xml.transform.sax.SAXSource;
import java.util.List;

/**
 * Created by Женя on 23.04.2016.
 */
public class View {
    // Text's constants
    public static final String GREETING = "Welcome to the game. " +
                                            "You should guess the number. For the first you need choice the range.";
    public static final String CHOICE_IN_MENU = "Do you want to enter range? 0 - no, 1 - yes : ";
    public static final String WRONG_MENU_CHOICE = "You entered wrong value! Please, enter 0 or 1.";
    public static final String START_GAME = "Let's start the game!";
    public static final String GUESS_NUMBER = "Enter possible number: ";
    public static final String WIN_NUMBER = "Congratulation! You are guessed right number!";
    public static final String ATTEMPT_HISTORY = "Your input history: ";
    public static final String ATTEMPT_SCORE = "\nYour attempts to win: ";
    public static final String RANGE = "Range is from ";
    public static final String ASK_MIN_BARRIER_VALUE = "Enter minimum value (0 - 100):";
    public static final String ASK_MAX_BARRIER_VALUE = "Enter maximum value (0 - 100):";
    public static final String WRONG_INT_DATA = "Entered value is not integer, please, write correct number:";
    public static final String WRONG_BARRIER_VALUE = "Entered value is out of range, try again:";

    public void printMessage(String message){
        System.out.println(message);
    }

    public void printMessageWithHistory(List<Integer> history){
        System.out.println(ATTEMPT_HISTORY + history.toString());
    }

    public void printMessageWithRange(int min, int max){
        System.out.println(RANGE + min + " to " + max);
    }

    public void printMessageWithStatistic(List<Integer> history, int historySize){
        System.out.println(ATTEMPT_HISTORY + history.toString().replace("[","").replace("]","") +
                ATTEMPT_SCORE + (historySize + 1));
    }
}
