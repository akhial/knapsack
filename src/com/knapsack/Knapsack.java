package com.knapsack;

import java.util.ArrayList;
import java.util.List;

class Knapsack {

    private int w;
    private int n;
    private ArrayList<Item> items = new ArrayList<>();

    Knapsack() {

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
            items.add(new Item(i + 1, 0, 0));
        }
    }

    Solution solve() {
        int NB_ITEMS = items.size();

        // we use a matrix to store the max value at each n-th item
        int[][] matrix = new int[NB_ITEMS + 1][w + 1];

        // first line is initialized to 0
        for(int i = 0; i <= w; i++)
            matrix[0][i] = 0;

        // we iterate on items
        for(int i = 1; i <= NB_ITEMS; i++) {
            // we iterate on each capacity
            for(int j = 0; j <= w; j++) {
                if(j < items.get(i - 1).getWeight())
                    matrix[i][j] = matrix[i - 1][j];
                else
                    // we maximize value at this rank in the matrix
                    matrix[i][j] = Math.max(matrix[i - 1][j], matrix[i - 1][j - items.get(i - 1).getWeight()]
                            + items.get(i - 1).getValue());
            }
        }

        int res = matrix[NB_ITEMS][w];
        int currentW = w;
        List<Item> itemsSolution = new ArrayList<>();

        for(int i = NB_ITEMS; i > 0 && res > 0; i--) {
            if(res != matrix[i - 1][currentW]) {
                itemsSolution.add(items.get(i - 1));
                // we remove items value and weight
                res -= items.get(i - 1).getValue();
                currentW -= items.get(i - 1).getWeight();
            }
        }

        return new Solution(itemsSolution, matrix[NB_ITEMS][w]);
    }
}
