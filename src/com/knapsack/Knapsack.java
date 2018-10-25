package com.knapsack;

import java.util.ArrayList;

class Knapsack {

    private int w;
    private int n;
    private ArrayList<Item> items = new ArrayList<>();

    Knapsack() {
        items.add(new Item(12, 21));
    }

    void setW(int w) {
        this.w = w;
    }

    void setN(int n) {
        this.n = n;
    }

    int getW() {
        return w;
    }

    int getN() {
        return n;
    }

    Item getItem(int i) {
        return items.get(i);
    }

    void setup() {
        for(int i = 0; i < n; i++) {
            items.add(new Item(0, 0));
        }
    }
}
