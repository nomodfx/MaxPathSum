//Richard Rivas
import java.io.*;
import java.util.*;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;

public class Project4{
	
static int subArrRow;
static int subArrCol;
static int matrix[][];
static int path[][];
static int rightPath = -1;
static int row;
static int col;

//Function finds the longest path from any starting position on matrix
//fills entries into possible downward or adjacent cells subproblems
public static void LongestPath(){
	for(int i = row - 2; i >= 0; i--){
		for(int j = col - 2;j >= 0;j--){
			path[i][j] = 1;
			
			if(matrix[i][j + 1] < matrix[i][j]){
				path[i][j] += path[i][j + 1];
			}
			if(matrix[i + 1][j] < matrix[i][j]){
				path[i][j] = Math.max(path[i][j], 1 + path[i + 1][j]);
			}
			if(path[i][j] > rightPath){
				rightPath = path[i][j];
				subArrRow = i;
				subArrCol = j;
			}
		}
	}
}

//Function checks if the entry and stores value into row and column through subproblems
//If adjacent cell contains a value smaller than origin entry path will then move right, n - 1
//Else continues to move downards. 
public static void adjacentLongPath(){
	path[row - 1][col - 1] = 1;
	
	//finds path horizontally and breaks steps into individual subarrays
	for(int i = row - 2;i >= 0;i--){
		if(matrix[i][col - 1] > matrix[i + 1][col - 1]){
			path[i][col - 1] = 1 + path[i + 1][col - 1];
		}
		if(path[i][col - 1] > rightPath){
			rightPath = path[i][col - 1];
			subArrRow = i;
			subArrCol = col - 1;
		}
		else{
			path[i][col - 1] = 1;
		}
	}

	//finds path vertically and breaks path into individual subarrays
	for(int j = col - 2;j >= 0;j--){
		if(matrix[row - 1][j] > matrix[row - 1][j + 1]){
			path[row - 1][j] = 1 + path[row - 1][j + 1];
		}
		if(path[row - 1][j] > rightPath){
			rightPath = path[row - 1][j];
			subArrRow = row - 1;
			subArrCol = j;

		}
		else{
			path[row - 1][j] = 1;
		}
	}
}

//Driver function reads integer data from input4.txt
//Fills in the 2D matrix with read values at any location
//and counts the number of entries in longest path after paths have been found
public static void main(String[] args) throws IOException{
	Scanner read = new Scanner(new File("input4.txt"));
	row = read.nextInt();
	col = read.nextInt();
	matrix = new int[row][col];
	path = new int[row][col];
	
	for(int i = 0;i < row; i++){
		for(int j = 0;j < col ; j++){
			matrix[i][j] = read.nextInt();
		}
	}
	adjacentLongPath();
	LongestPath(); 
	System.out.println(rightPath);
	
	}
}