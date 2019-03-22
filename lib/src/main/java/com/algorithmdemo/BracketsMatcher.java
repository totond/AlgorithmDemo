package com.algorithmdemo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 * 2016欢聚时代秋招Android笔试题：
 * 6种括号匹配'(',')','{','}','[',']'
 */
public class BracketsMatcher {
    public static Boolean barcketMatch(String str){
        if (str.length() % 2 != 0){
            return false;
        }
        Stack<Character> leftStack = new Stack<>();
        char tempChar;
        for (int i = 0; i < str.length(); i++){
            tempChar = str.charAt(i);
            if (!checkBrackets(tempChar)){
                return false;
            }
            //把左边的括号都入栈，遇到右边的括号就出栈，进行匹配
            if (isLeftBracket(tempChar)){
                leftStack.push(tempChar);
            }else {
                //如果遇到右括号时候栈是空的，或者出栈的左括号不匹配，返回false
                if (leftStack.empty() || !checkBracketMatch(leftStack.pop(),tempChar)){
                    return false;
                }
            }
        }
        return true;
    }

    public static Boolean isLeftBracket(Character character){
        if (character.equals('(') || character.equals('{') || character.equals('[') ){
            return true;
        }else {
            return false;
        }
    }

    public static Boolean checkBracketMatch(Character a, Character b){
        if (a.equals('(') && b.equals(')')){
            return true;
        }

        if (a.equals('{') && b.equals('}')){
            return true;
        }

        if (a.equals('[') && b.equals(']')){
            return true;
        }
        return false;
    }

    public static Boolean checkBrackets(Character character){
        if (character.equals('(') || character.equals(')') || character.equals('{') ||
                character.equals('}') || character.equals('[') || character.equals(']') ){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String str = "";
        while (scanner.hasNext()){
            str = scanner.nextLine();
            System.out.println(barcketMatch(str));
        }
    }
}
