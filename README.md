# Canoe Trip Planner
CS 3310 - Design and Analysis of Algorithms: Program Assignment 3

This program output the optimal costs for all posts and optimal path from first post to last post.

## Description

This program accepts the name of a file on the command line. The first line of the file will contain an integer n, giving the number of posts along the river. The remaining n − 1 lines of the file will contain the integers of the cost matrix, delimited by white space, omitting the unnecessary entries.

The program will then compute and print the optimal cost matrix: i.e. the optimal cost between any two posts (i, j) for all values 0 ≤ i < j ≤ n − 1. Additionally, the program will print the actual sequence of rentals to be used for the route between posts 0 and n − 1 (not just its optimal cost).

An example of an input file is as follows:
```
6
10 50  5 12 27 
   23 16 38 44
      30 15 33
         33 43
            12
```

The output should look (something) like:
```
Optimal cost from post 0 to post 1: 10
Optimal cost from post 0 to post 2: 33
Optimal cost from post 0 to post 3: 5
Optimal cost from post 0 to post 4: 12
Optimal cost from post 0 to post 5: 24
Optimal cost from post 1 to post 2: 23
Optimal cost from post 1 to post 3: 16
Optimal cost from post 1 to post 4: 38
Optimal cost from post 1 to post 5: 44
Optimal cost from post 2 to post 3: 30
Optimal cost from post 2 to post 4: 15
Optimal cost from post 2 to post 5: 27
Optimal cost from post 3 to post 4: 33
Optimal cost from post 3 to post 5: 43
Optimal cost from post 4 to post 5: 12

Optimal cost matrix:
                0       1       2       3       4       5

        0       -       10      33      5       12      24
        1       -       -       23      16      38      44
        2       -       -       -       30      15      27
        3       -       -       -       -       33      43
        4       -       -       -       -       -       12
        5       -       -       -       -       -       -

Optimal sequence of rentals between post 0 and 5: Post 0 -> Post 4 -> Post 5
```

## Project Hierarchy
```
.
├── input
│   ├── inputA
│   ├── inputB
│   └── inputC
├── output
│   └── SampleOutput.txt
├── prompt
│   ├── grade3.pdf
│   └── prog3.pdf
├── src
│   ├── CanoeTripPlanner.java
│   └── Prog3.java
├── README.md
├── ANALYSIS.md
└── .gitignore
```

## Usage
To use the program:

- Add your input file to `/input` folder
- Navigate to the /src directory by `cd src`
- Run `javac Prog3.java` and `java Prog3 <YOUR_INPUT_FILE>` (or `java Prog2 inputA`/`java Prog2 inputB`/`java Prog2 inputC` for the sample input file)
- The program will output optimal costs for all posts and optimal path from first post to last post
