import java.util.io.*;
import java.util.*;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;

public class Project4{
	public static int longestPath(int matrix[][]){
		int res = -1;
		int row = 4;
		int col = 6;
		
		for(int i = 0; i < col; i++){
			res = max(rest, matrix[0][i]);
		}
		
		for(int i = 0; i < row; i++){
			res = -1;
			
			for(int j = 0; j < col; j++){
				if(j > 0 && j < col - 1){
					matrix[i][j] += max(matrix[i-1][j], max(matrix[i - 1][j - 1], matrix[i - 1][j + 1]);
				}
				else if(j > 0){
					matrix[i][j] += max(matrix[i-1][j], matrix[i - 1][j - 1]);
				}
				else if(j < col - 1)
					matrix[i][j] += max(matrix[i - 1][j], matrix[i - 1][j + 1]);
				
				res = max(matrix[i][j], res);
			}
		}
		return res;
	}
	public static void main(String[] args) throws IOException{
		Scanner read = new Scanner(new File("input4.txt"));
		
	}
}