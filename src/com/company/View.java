package com.company;

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
    public static final String ASK_MIN_VALUE = "Please enter minimum possible value (should be in range 1 - 99): ";
    public static final String ASK_MAX_VALUE = "Please enter maximum possible value (should be in range 1 - 99): ";
    public static final String WRONG_MAX_VALUE = "Please enter maximum value less than 100: ";
    public static final String WRONG_MIN_VALUE = "Please enter minimum value more than 0:";
    public static final String START_GAME = "Let's start the game!";
    public static final String GUESS_NUMBER = "Enter possible number: ";
    public static final String NEED_LARGER_NUMBER = "Good attempt. Try larger number!";
    public static final String NEED_LESS_NUMBER = "Good attempt. Try lower number!";
    public static final String WIN_NUMBER = "Congratulation! You are guessed right number!";
    public static final String ATTEMPT_HISTORY = "Your input history: ";
    public static final String ATTEMPT_SCORE = "\nYour attempts to win: ";
    public static final String RANGE = "Range is from ";
    public static final String OUT_OF_RANGE = "Your number is out of range. Please, enter number from range.";

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
        System.out.println(ATTEMPT_HISTORY + history + ATTEMPT_SCORE + (historySize + 1));
    }
}
