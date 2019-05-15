package Medium;
import java.util.*;

public class MatrixPath {
	
	public int[][] findPath(int[][] matrix){
		int m = matrix.length;
	 
		int[][] result = new int[m][m];
	 
		ArrayList<int[]> temp = new ArrayList<int[]>();
		ArrayList<int[]> list = new ArrayList<int[]>();
	 
		dfs(matrix, 0, 0, temp, list);
	 
	 
		for(int i=0; i<list.size(); i++)
			result[list.get(i)[0]][list.get(i)[1]]=1;
	 
		result[0][0]=1;
	 
		return result;
	}
	 
	public void dfs(int[][] matrix, int i, int j, ArrayList<int[]> temp,  ArrayList<int[]> list)
	{
	 
		int m = matrix.length;
	 
		if(i == m-1 && j == m-1)
		{
			list.clear();
			list.addAll(temp);
			return;
		}
	 
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
	 
		for(int k = 0; k < 4; k++)
		{
			int x = i + dx[k];
			int y = j + dy[k];
	 
			if(x >= 0 && y >= 0 && x <= m-1 && y <= m-1 && matrix[x][y] ==1)
			{
				temp.add(new int[]{x,y});
				int prev = matrix[x][y];
				matrix[x][y]=0;
	 
				dfs(matrix, x, y, temp, list);
	 
				matrix[x][y] = prev;
				temp.remove(temp.size()-1);
			}
		}		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
