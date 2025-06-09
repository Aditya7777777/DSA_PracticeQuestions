package com.Aditya.Array;

import java.util.ArrayList;
import java.util.List;

//This is the only optimal Solution for this particular Question.

public class SpiralMatrix {
    public static void main(String[] args){
       int[][]matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
       for(int e : spiralOrder(matrix)){
           System.out.print(e + " ");
       }

    }

    static List<Integer> spiralOrder(int[][] matrix){
        int n = matrix.length;
        int m = matrix[0].length;

        List<Integer> list = new ArrayList<>();
        int left = 0,right = matrix[0].length-1;
        int top = 0,bottom = matrix.length-1;


        while(top <= bottom && left <= right) {
            //Left --> Right
            for (int i = left; i <= right; i++) {
                list.add(matrix[top][i]);
            }
            top++;

            //Top ---> Bottom
            //here in the for loop itself the top and the bottom is checked
            //How?
            //If the matrix is of 1xM then there is no need to go top to bottom, because there is no elements to add
            // After the execution of the above given for loop happens then top gets incremented
            //When top gets incremented then top becomes greater than bottom , and hence the for loop  from top --> bottom will not get executed.
            for (int i = top; i <= bottom; i++) {
                list.add(matrix[i][right]);
            }
            right--;

            //Right --> Left
            if(top <= bottom) {
                for (int i = right; i >= left; i--) {
                    list.add(matrix[bottom][i]);
                }
                bottom--;
            }

            //Bottom --> Top
                if(left <= right) {
                    for (int i = bottom; i >= top; i--) {
                        list.add(matrix[i][left]);
                    }
                    left++;
                }

        }

        return list;
    }
}
