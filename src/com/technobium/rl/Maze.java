package com.technobium.rl;
/**
 Maze
 The program will create a maze for Q learning to solve
 Author: Mareks Zeile
 Collaborator(s):
 Collaboration:
 Date: 4/12/22
 On My Honor, I confirm that I followed all collaboration policy guidelines, and that the work I am submitting is my own: MZ
 **/
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Maze {
    //create a random maze

    //instance data
    //random to create the destination, clear path, and roadblocks
    private Random r;
    //ints for width and height of the map
    int width;
    int height;

    //default constructor
    public Maze(){
        r = new Random();
        width = 5;
        height = 5;
    }

    //method to create the maze and send it to a file
    public void buildMaze(){
        //random place to put the final destination
        int destination = r.nextInt(25);
        // \n is new line character

        //set the spaces to clear or blocked
        //int to keep number of characters added
        int spacesAdded = 0;
        //string to store the characters
        String s = new String();
        //int to store random used to choose if path is clear or blocked
        int clearOrBlocked;
        for(int i = 0; i< 25; i++){
            if(spacesAdded % 5 == 0 && spacesAdded != 0){
                s += "\n";
            }
            clearOrBlocked = r.nextInt(3);
            //check if it is at the destination
            if(i == destination){
                s+= "F";
                spacesAdded += 1;
            }else if(clearOrBlocked == 0 || clearOrBlocked == 1){
                s += "0";
                spacesAdded += 1;
            }else{
                s += "X";
                spacesAdded += 1;
            }
        }
        //add the string to the file
        try {
            FileWriter myWriter = new FileWriter("src/Maze.txt");
            myWriter.write(s);
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}
