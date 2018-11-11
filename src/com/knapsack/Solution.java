package com.knapsack;

import java.util.List;

class Solution {
    // list of items to put in the bag to have the maximal value
    private List<Item> items;
    // maximal value possible
    private int value;

    Solution(List<Item> items, int value) {
        this.items = items;
        this.value = value;
    }

    List<Item> getItems() {
        return items;
    }

    int getValue() {
        return value;
    }

    private String printItems() {
        StringBuilder sb = new StringBuilder();
        for(Item i : items) {
            sb.append(i.getId());
            sb.append(" ");
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return "The items are " + printItems() + " for a total value of " + value + ".";
    }
}
