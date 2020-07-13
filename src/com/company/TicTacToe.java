package com.company;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {

        char[][] gameBoard = {
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}};

        printGameBoard(gameBoard);  //Game board print

        // Scanner for catch entered position by user
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your placement (1 - 9)");

        int playerPosition = scanner.nextInt();  // position of entered by user



        placePiece(gameBoard,playerPosition,"user");

        Random random = new Random();   //Random till
        int cpuPosition = random.nextInt(9) + 1;  //position in array start from 0. Position changed form 1 to 9.
        placePiece(gameBoard,cpuPosition,"cpu");

        printGameBoard(gameBoard);  //Game Board print each time is entered a number position(update a clipBoard)

    }

    public static void printGameBoard(char[][] gameBoard) {

        for (char[] row : gameBoard) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }// Enhanced loop  iterating throw gameBoard Array.
    } //methode printed Board

    public static void placePiece(char[][] gameBoard,int pos,String user){

        char symbol = ' ';

        if (user.equals("player"))
            symbol = 'X';
        else if (user.equals("cpu"))
            symbol = '0';

        switch(pos){
            case 1:
                gameBoard [0][0] = symbol;
                break;
            case 2:
                gameBoard [0][2] = symbol;
                break;
            case 3:
                gameBoard [0][4] = symbol;
                break;
            case 4:
                gameBoard [1][0] = symbol;
                break;
            case 5:
                gameBoard [1][2] = symbol;
                break;
            case 6:
                gameBoard [1][4] = symbol;
                break;
            case 7:
                gameBoard [2][0] = symbol;
                break;
            case 8:
                gameBoard [2][2] = symbol;
                break;
            case 9:
                gameBoard [2][4] = symbol;
                break;
            default:
                break;

        }

    }
}
