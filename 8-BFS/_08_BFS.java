import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class _08_BFS {

	int[][] mat;
	int[] color;
	int[] distance;
	int[] father;
	int V; //numberOfVertecies
	
	public _08_BFS(int[][] matrix)
	{
		mat = matrix;
		V = mat.length;
		color = new int[V];
		distance = new int[V];
		father = new int[V];
	}

	private void Run_BFS(int s) {
		Queue<Integer> q = new LinkedList<>();
		
		Initialize();
		
		q.add(s);
		color[s] = 1;
		distance[s] = 0;
		father[s] = -1;
		
		int v;
		while (q.isEmpty() == false)
		{
			v = q.poll();
			for (int u = 0; u < V; u++)
			{
				if (color[u] == 0 && mat[v][u] == 1)
				{
					color[u] = 1;
					distance[u] = distance[v]+1;
					father[u] = v;
					q.add(u);
				}
			}
			color[v] = 2;
		}
	}

	private void Initialize() {
		for (int v = 0; v < V; v++) {
			color[v] = 0;
			distance[v] = 0;
			father[v] = -1;
		}	
	}

	public boolean IsConnected()
	{
		for (int v = 0; v < V; v++)
		{
			if (color[v] == 0)
				return false;
		}
		return true;
	}

	public boolean IsTherePathBetween_v_and_u(int v, int u)
	{
		Run_BFS(v);
		if (color[u] == 2)
			return true;
		return false;
	}
	
	//after checking IsTherePathBetween_v_and_u
	public ArrayList<Integer> GetPathBetween_v_and_u(int v, int u)
	{
		ArrayList<Integer> path = new ArrayList<Integer>();
		
		int vertex = u;
		while(father[vertex] != -1)
		{
			path.add(vertex);
			vertex = father[vertex];
		}
		path.add(vertex);
		
		//reverse the list
		int temp;
		for (int i = 0; i < path.size()/2; i++) {
			temp = path.get(i);
			path.set(i, path.get(path.size()-1-i));
			path.set(path.size()-1-i, temp);
		}
		
		return path;
	}
	
	public static void main(String[] args) {
		 int[][] graph = {{0,0,0,1,0,0},
				          {0,0,0,1,1,1},
				          {0,0,0,1,1,1},
				          {1,1,1,0,0,0},
				          {0,1,1,0,0,0},
				          {0,1,1,0,0,0}};
		 
		 _08_BFS bfs = new _08_BFS(graph);
		 System.out.println(bfs.IsTherePathBetween_v_and_u(5,0));
		 System.out.println(bfs.GetPathBetween_v_and_u(5, 0));
	}
}
