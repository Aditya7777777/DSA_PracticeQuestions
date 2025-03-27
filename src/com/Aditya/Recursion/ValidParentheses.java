package com.Aditya.Recursion;

class Stack {
    private char[] arr;
    private int capacity;
    private  int top;

    //Constructor to initialize the Stack
    public Stack(int size) {
        arr = new char[size];
        capacity = size;
        top = -1;
    }

    //method to push the element in the stack
    public void push(char value) {
        if (top == capacity - 1) {
            System.out.println("Stack Overflow");
        }

        arr[++top] = value;
    }

    //method to pop the element from the stack
    public int pop() {
        if (top == -1) {
            System.out.println("Stack is empty");
            return -1;
        }

        return arr[top--];
    }

    public int peek() {
        if (top == -1) {
            System.out.println("There are no element left in the stack");

        }
        return arr[top];
    }

}//end of stack

public  class ValidParentheses{
    public static void main(String[] args){
        String s = "([{]})";
        Stack st = new Stack(s.length()/2+1);

        System.out.println("Is the given string a valid  parentheses or not ? : ");
        if(validOrNot(s,st)){
            System.out.println("This is a valid parentheses . Output:  true ");
        }else {
            System.out.println("This is not a valid parentheses. Output:  false" );
        }
    }

    //method to check if the given string is a valid parentheses or not
    static boolean validOrNot(String s, Stack st){
        for(int i = 0 ;i < s.length();i++){
            if(s.charAt(i) == '[' || s.charAt(i) == '{' || s.charAt(i) == '('){
                st.push(s.charAt(i));
            }

            if(s.charAt(i) == ']' || s.charAt(i) == '}' || s.charAt(i) == ')'){
                switch(s.charAt(i)){
                    case ']':
                        if(st.peek() == '[') {
                            st.pop();
                        }else{
                            return false;
                        }
                        break;
                    case ')':
                        if(st.peek() == '('){
                            st.pop();
                        }else{
                            return false;
                        }
                        break;

                    case '}':
                        if(st.peek() == '{'){
                            st.pop();
                        }else {
                            return false;
                        }
                        break;

                    default :
                        break;

                }//end of switch

            }//end of if
        }//end of for loop
        return true;
    }//end of method


}
