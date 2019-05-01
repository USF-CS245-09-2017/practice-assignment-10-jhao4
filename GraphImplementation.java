import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class GraphImplementation implements Graph
{
	public int [][] matrix;

	public GraphImplementation(int vertices) //constructor
	{

		matrix = new int[vertices][vertices]; //initialize the array

	} //GraphImplmentation

	public void addEdge(int v1, int v2)
	{

		matrix[v1][v2] = 1; //adds the edge to the matrix

	} //addEdge

	public List<Integer> topologicalSort()
	{
		int[] incidents = new int[matrix.length];

		int a = 0;

		while(a < matrix.length) //sets all the values inside the array as 0
		{

			incidents[a] = 0;

			a++;

		} //while

		for(int i = 0; i < matrix.length; i++)
		{

			for(int j = 0; j < matrix.length; j++)
			{

				incidents[i] += matrix[j][i];

			} //for

		} //for

		List<Integer> sorted = new ArrayList<>();

		int vertex = 0;

		while((vertex = zero(incidents)) >= 0)
		{

			sorted.add(vertex);

			int i = 0;

			while(i < matrix.length)
			{

				if(matrix[vertex][i] > 0)
				{

					incidents[i]--;

				} //if

				i++;

			} //while

		} //while

		return sorted;

	} //topologicalSort

	public int zero(int[] incidents)
	{

		return zero(incidents, 0);

	} //zero

	public int zero(int [] incidents, int n)
	{
		if(n >= incidents.length)
		{

			return -1;

		} //if

		else if(incidents[n] == 0)
		{

			incidents[n] = -1;

			return n;

		} //else if

		else
		{

			return zero(incidents, n + 1);

		} //else

	} //zero

	public int[] neighbors(int vertex)
	{
		int edges = 0;

		for(int i = 0; i < matrix.length; i++)
		{

			if(i > 0)
			{

				edges++;

			} //if

		} //for

		int[] neighbors = new int[edges];

		int i = 0;

		int j = 0;

		while(i < matrix.length)
		{

			if(matrix[vertex][i] > 0)
			{

				neighbors[j++] = i;

			} //if

			i++;

		} //while

		return neighbors;

	} //neighbors

} //class graphimplementation




