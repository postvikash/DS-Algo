/**
 * You are given a matrix of dimensions m*n where each cell in the matrix can
 * have values 0,1 or 2 which has the following meaning: 0:empty cell. 1:cells
 * have fresh oranges. 2:cells have rotten oranges. So we have to determine what
 * is the minimum time required so that all the oranges will be rotten,assuming
 * it takes one second to rot the immediate neighbors. A rotten orange at index
 * [i,j] can rot other fresh orange at indexes [i+1,j] ,[i,j+1] ,[i-1,j],[i,j-1].
 * If it is impossible to rot every orange then simply return -1
 * 
 * Author : Vikash Kumar
 * Date   : 20th July, 2017
 */

import java.util.LinkedList;

public class RottenOranges {
	
	public static void main(String[] args) {
		System.out.println("Program Begins");
		LinkedList<Coordinate> ll = new LinkedList<Coordinate>(); 
		int[][] arr= { 	{2, 1, 0, 2, 1},
                		{0, 0, 1, 2, 1},
                		{1, 0, 0, 2, 1}};
		int totalTime = 1;
		int freshOranges = 0;
		for(int i=0;i<3;i++)
			for(int j=0;j<5;j++) {
				if(arr[i][j] == 2)
					ll.add(new Coordinate(i,j));
				else if( arr[i][j] == 1)
					freshOranges++;
			}
		ll.add(null);
		System.out.println("Number of fresh mangoes : "+freshOranges);
		System.out.println("Coordinates of rotten mangoes : "+ll);
		while(!ll.isEmpty() && freshOranges > 0) {
			Coordinate obj = ll.removeFirst();
			if(obj == null && ll.size() == 0)
				break;
			if(obj == null) {
				totalTime++;
				ll.add(null);
			}
			else {
				System.out.println(obj.i+" "+obj.j);
				if(obj.i-1 >=0 && arr[obj.i-1][obj.j] == 1){
					ll.add(new Coordinate(obj.i-1,obj.j));
					arr[obj.i-1][obj.j] = 2;
					freshOranges--;
				}
				if(obj.i+1 <=2 && arr[obj.i+1][obj.j] == 1){
					ll.add(new Coordinate(obj.i+1,obj.j));
					arr[obj.i+1][obj.j] = 2;
					freshOranges--;
				}
				if(obj.j-1 >=0 && arr[obj.i][obj.j-1] == 1){
					ll.add(new Coordinate(obj.i,obj.j-1));
					arr[obj.i][obj.j-1] = 2;
					freshOranges--;
				}
				if(obj.j+1 <=4 && arr[obj.i][obj.j+1] == 1){
					ll.add(new Coordinate(obj.i,obj.j+1));
					arr[obj.i][obj.j+1] = 2;
					freshOranges--;
				}
					
			}
		}
		
		if(freshOranges > 0)
			System.out.println("-1");
		else
			System.out.println("Answer is : "+totalTime);
		
	}

}

class Coordinate {
	public int i;
	public int j;
	
	public Coordinate(int i, int j) {
		this.i = i;
		this.j = j;
	}
	
	public String toString() {
		return "("+Integer.toString(this.i)+" ,"+Integer.toString(this.j)+")";
	}
}
