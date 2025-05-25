package com.Aditya.Hashing;

import java.util.Scanner;


//Input: arr[] = {10,5,10,15,10,5};
//Output: 10  3
//        5  2
//        15  1
//Explanation: 10 occurs 3 times in the array
//	      5 occurs 2 times in the array
//              15 occurs 1 time in the array
//code on hashing concept of pre-storing and fetching

/*
Unordered Hash map takes O(1) time complexity to store and fetch key-value pairs . In worst case it takes O(n) time complexity but
it is very rarely happens because of collision , if happens then use Ordered Hash Map  which takes O(log n ) time complexity for
storing  and fetching.
  */
//NUMBER HASHING
public class Hash {
    public static void main(String[] args){

    }
    //NUMBER HASHING
    static void numberHash(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] hashArr = new int[n];
        for(int i = 0;i<n;i++){
            hashArr[i] = sc.nextInt();
        }
        //number of query you will enter.
        int query = sc.nextInt();


        int[] arr = new int[13];
        for(int i = 0;i<query;i++){
            int x = sc.nextInt();
            arr[x] = arr[x]+1;
        }

        for(int i  = 0;i<13;i++){
            System.out.print(arr[i] + " ");
        }
    }

    //character Hashing of small alphabet

    static void charHash(){
      Scanner sc = new Scanner(System.in);
      String s = sc.nextLine();

      // The array  given below represents , it's index represents  alphabetical position of that character for 'a' -> 0 for b -> 1 ,etc.
      int[] hash = new int[26];

      //how many times a g h b c appeared
        for(int i = 0;i<s.length();i++){
            //The formula s.charAt(i) - 'a' is used to find the index for that particular character.
            hash[s.charAt(i) - 'a']++;
        }

        int inputNumber = sc.nextInt();
        String output = "";
        for(int i = 0 ;i < inputNumber;i++){
            char c = sc.next().charAt(0);
            output = output+c;
        }

        for(int i = 0;i < inputNumber;i++){
            System.out.println(hash[output.charAt(i) - 'a']);
        }
        sc.close();
    }

    //character hashing for all the letters that are present in the ASCII table
    //here we declare an array with a length that is equal to the number of character present in the ASCII table
    //Then the user provides and input string & we have to check how many times each character provided by the user has appeared .
    //If we check the integer value of a character then it provides it ASCII number , for example the ASCII number of small 'a' is 97
    //So, If I found out a small 'a' in the input string then I will increment the 97th index of the array .
    static void charHashAll(){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        int[] hash = new int[256];

        //how many times aghbc appeared
        for(int i = 0;i<s.length();i++){
            hash[s.charAt(i)]++;
        }

        int inputNumber = sc.nextInt();
        String output = "";
        for(int i = 0 ;i < inputNumber;i++){
            char c = sc.next().charAt(0);
            output = output+c;
        }

        for(int i = 0;i < inputNumber;i++){
            System.out.println(hash[output.charAt(i)]);
        }
        sc.close();
    }

}
