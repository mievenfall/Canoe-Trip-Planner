/***************************************************************/
/* Evelyn Vu                                                   */
/* Login ID: evu                                               */
/* CS 3310, Spring 2024                                        */
/* Programming Assignment 3                                    */
/* Prog3 class: With an cost matrix text file as input,        */
/*              output the optimal cost/path from post 0 to 5  */
/***************************************************************/


import java.io.File;

public class Prog3 {
    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.out.println("Usage: java Prog3 <filename>");
            return;
        }

        File filename = new File("../input/" + args[0]);

        CanoeTripPlanner trip = new CanoeTripPlanner(filename);
        trip.process();
        trip.printResult();
    }
}