package com.knapsack;

abstract class Controller {

    MainScreen mainScreen;
    Knapsack knapsack;

    void setMainScreen(MainScreen mainScreen) {
        this.mainScreen = mainScreen;
    }

    void setKnapsack(Knapsack knapsack) {
        this.knapsack = knapsack;
    }

    abstract void setup();
}
