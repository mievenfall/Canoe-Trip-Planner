/***************************************************************/
/* Evelyn Vu                                                   */
/* Login ID: evu                                               */
/* CS 3310, Spring 2024                                        */
/* Programming Assignment 3                                    */
/* CanoeTripPlanner class: functions to find optimal cost/path */
/*                        for a canoe trip with multiple posts */  
/***************************************************************/

import java.io.*;
import java.util.*;

public class CanoeTripPlanner {
    private File filename;
    private int[][] costMatrix;
    private int[][] optimalCosts;
    
    // Constructor
    CanoeTripPlanner(File filename) {
        this.filename = filename;
        this.costMatrix = null;
        this.optimalCosts = null;
    }


    /**************************************************************/
    /* Method: readCostMatrix                                     */
    /* Purpose: Read input file and create the cost matrix        */
    /**************************************************************/

    private void readCostMatrix() throws IOException {
        Scanner scanner = new Scanner(new FileReader(filename));
      
        int n = scanner.nextInt();
        costMatrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n && scanner.hasNextInt(); j++) {
                costMatrix[i][j] = scanner.nextInt();
            }
        }
        scanner.close();
    }


    /**************************************************************/
    /* Method: computeOptimalCosts                                */
    /* Purpose: calculate the optimal cost from 0 to each post    */
    /**************************************************************/

    private void computeOptimalCosts() {
        int n = costMatrix.length;
        optimalCosts = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                optimalCosts[i][j] = costMatrix[i][j];
            }
        }
        
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i < n - len; i++) {
                int j = i + len;
                for (int k = i + 1; k < j; k++) {
                    int cost = optimalCosts[i][k] + optimalCosts[k][j];
                    optimalCosts[i][j] = Math.min(optimalCosts[i][j], cost);
                }
            }
        }
    }


    /**************************************************************/
    /* Method: process                                            */
    /* Purpose: Read input file and calculate the optimal cost    */
    /**************************************************************/

    void process() {
        try {
            readCostMatrix();
            computeOptimalCosts();
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }


    /**************************************************************/
    /* Method: printOptimalCost                                   */
    /* Purpose: Print the result of optimal cost from every posts */
    /**************************************************************/

    private void printOptimalCosts() {
        int n = optimalCosts.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                System.out.println("Optimal cost from post " + i + " to post " + j + ": " + optimalCosts[i][j]);
            }
        }        
        System.out.println();
    }


    private void printOptimalCostMatrix() {
        int n = optimalCosts.length;
        System.out.println("Optimal cost matrix:");
        System.out.print("\t ");

        for (int i = 0; i < n; i++) {
            System.out.print("\t"+i);
        }
        System.out.println();
        System.out.println();

        for (int i = 0; i < n; i++) {
            System.out.print("\t"+i);
            for (int j = 0; j < n; j++) {
                if (i < j) {
                    System.out.print("\t"+optimalCosts[i][j]);
                } else {
                    System.out.print("\t-");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    /**************************************************************/
    /* Method: printOptimalSequence                                */
    /* Purpose: Print the result of optimal sequence              */
    /*          from post 0 to 5                                  */
    /**************************************************************/
    
    private void printOptimalSequence() {
        int n = optimalCosts.length;
        List<Integer> path = new ArrayList<>();
        int start = 0;
        int end = n - 1;

        // Trace back the path
        while (start < end) {
            path.add(start);
            int next = start + 1;
            for (int k = start + 1; k <= end; k++) {
                if (optimalCosts[start][end] == optimalCosts[start][k] + optimalCosts[k][end]) {
                    next = k;
                    break;
                }
            }
            start = next; // move to the next post in the path
        }
        path.add(end);

        System.out.print("Optimal sequence of rentals between post 0 and " + end + ": ");
        for (int i = 0; i < path.size(); i++) {
            if (i > 0) System.out.print(" -> ");
            System.out.print("Post " + path.get(i));
        }
    }


    /**************************************************************/
    /* Method: printResult                                        */
    /* Purpose: Print the result in proper format                 */
    /**************************************************************/

    void printResult() {
        printOptimalCosts();
        printOptimalCostMatrix();
        printOptimalSequence();
        System.out.print("\n\n");
    }
}
