package com.step.template.main.util;

/**
 * @author liyd
 * @date 2023年02月24日 10:38
 */
import java.util.Scanner;
public class MazeChase {
    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);
        // Create a 2D array to represent the maze
        int[][] maze = {
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 1, 1, 1, 1, 1, 1, 0, 1},
                {1, 0, 1, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 1, 0, 1, 1, 1, 1, 0, 1},
                {1, 0, 1, 0, 1, 0, 0, 0, 0, 1},
                {1, 0, 1, 0, 1, 0, 1, 1, 0, 1},
                {1, 0, 1, 0, 1, 0, 1, 0, 0, 1},
                {1, 0, 1, 0, 1, 0, 1, 0, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
        };
        // Create variables to store the player's position
        int playerX = 1;
        int playerY = 1;
        // Create a variable to store the monster's position
        int monsterX = 8;
        int monsterY = 8;
        // Create a variable to store the player's input
        String input;
        // Create a variable to store whether the player has won or lost
        boolean won = false;
        // Print the initial maze
        printMaze(maze, playerX, playerY, monsterX, monsterY);
        // Start the game loop
        while (true) {
            // Get the player's input
            System.out.print("Enter a direction (up, down, left, right): ");
            input = scanner.nextLine();
            // Move the player
            if (input.equals("up")) {
                playerY--;
            } else if (input.equals("down")) {
                playerY++;
            } else if (input.equals("left")) {
                playerX--;
            } else if (input.equals("right")) {
                playerX++;
            }
            // Move the monster
            if (playerX > monsterX) {
                monsterX++;
            } else if (playerX < monsterX) {
                monsterX--;
            } else if (playerY > monsterY) {
                monsterY++;
            } else if (playerY < monsterY) {
                monsterY--;
            }
            // Check if the player has won or lost
            if (playerX == 8 && playerY == 8) {
                won = true;
                break;
            } else if (playerX == monsterX && playerY == monsterY) {
                break;
            }
            // Print the updated maze
            printMaze(maze, playerX, playerY, monsterX, monsterY);
        }
        // Print a message based on whether the player won or lost
        if (won) {
            System.out.println("You won!");
        } else {
            System.out.println("You lost!");
        }
    }
    // Prints the maze with the player and monster
    public static void printMaze(int[][] maze, int playerX, int playerY, int monsterX, int monsterY) {
        for (int y = 0; y < maze.length; y++) {
            for (int x = 0; x < maze[y].length; x++) {
                if (x == playerX && y == playerY) {
                    System.out.print("P ");
                } else if (x == monsterX && y == monsterY) {
                    System.out.print("M ");
                } else {
                    System.out.print(maze[y][x] + " ");
                }
            }
            System.out.println();
        }
    }
}
