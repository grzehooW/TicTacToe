package com.company;


import java.sql.Array;
import java.util.*;

public class TicTacToe {

    static ArrayList<Integer> playerPosition = new ArrayList<>(); //Array list for player position.
    static ArrayList<Integer> cpuPosition = new ArrayList<>();  //Array list for cpu position.


    public static void main(String[] args) {

        char[][] gameBoard = {
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}};

        printGameBoard(gameBoard);  //Game board print


        while (true) {
            // Scanner for catch entered position by user
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter your placement (1 - 9)");

            int playerPosition = scanner.nextInt();  // position of entered by user


            placePiece(gameBoard, playerPosition, "player");


            Random random = new Random();   //Random
            int cpuPosition = random.nextInt(9) + 1;  //position in array start from 0. Position changed form 1 to 9.
            placePiece(gameBoard, cpuPosition, "cpu");

            printGameBoard(gameBoard);  //Game Board print each time is entered a number position(update a clipBoard)

            String winingString = winnerCheck();
            System.out.println(winingString);
        }

    }


    public static void printGameBoard(char[][] gameBoard) {

        for (char[] row : gameBoard) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }// Enhanced loop  iterating throw gameBoard Array.
    } //method printed Board

    public static void placePiece(char[][] gameBoard, int pos, String user) {

        char symbol = ' ';

        if (user.equals("player")) {
            symbol = 'X';
            playerPosition.add(pos);
        } else if (user.equals("cpu")) {
            symbol = '0';
            cpuPosition.add(pos);
        }

        switch (pos) {
            case 1:
                gameBoard[0][0] = symbol;
                break;
            case 2:
                gameBoard[0][2] = symbol;
                break;
            case 3:
                gameBoard[0][4] = symbol;
                break;
            case 4:
                gameBoard[2][0] = symbol;
                break;
            case 5:
                gameBoard[2][2] = symbol;
                break;
            case 6:
                gameBoard[2][4] = symbol;
                break;
            case 7:
                gameBoard[4][0] = symbol;
                break;
            case 8:
                gameBoard[4][2] = symbol;
                break;
            case 9:
                gameBoard[4][4] = symbol;
                break;
            default:
                break;

        }//switch case place X or O in to a board
    }

    public static String winnerCheck() {

        // List o possible winning combinations regular array

        List topRow = Arrays.asList(1, 2, 3);
        List midRow = Arrays.asList(4, 5, 6);
        List botRow = Arrays.asList(7, 8, 9);
        List leftCol = Arrays.asList(1, 4, 7);
        List midCol = Arrays.asList(2, 5, 8);
        List rigCol = Arrays.asList(3, 6, 9);
        List cross1 = Arrays.asList(1, 5, 9);
        List cross2 = Arrays.asList(3, 5, 7);

        //List checking winnig combination

        List<List> winning = new ArrayList<>();
        winning.add(topRow);
        winning.add(midRow);
        winning.add(botRow);
        winning.add(leftCol);
        winning.add(midCol);
        winning.add(rigCol);
        winning.add(cross1);
        winning.add(cross2);

        for (List l : winning) {
            if (playerPosition.containsAll(l)) {
                return "Player Wins";
            } else if (cpuPosition.containsAll(l)) {
                return "CPU Wins";
            } else if (playerPosition.size() + cpuPosition.size() == 9)
                return "CAT";
        }

        return "";
    }
}
