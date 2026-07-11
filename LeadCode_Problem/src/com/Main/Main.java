package com.Main;

import Function.Reverse;
import Graph.Problem_1061_DSU;
import Graph.Problem_1091;
import Graph.Problem_1443;
import Graph.Problem_1466;
import Graph.Problem_1519;
import Graph.Problem_1557;
import Graph.Problem_1579_DSU;
import Graph.Problem_1615;
import Graph.Problem_1857;
import Graph.Problem_1857_DSU;
import Graph.Problem_1926;
import Graph.Problem_2316;
import Graph.Problem_2359;
import Graph.Problem_2421_Good_Path;
import Graph.Problem_2492;
import Graph.Problem_399;
import Graph.Problem_787;
import Graph.Problem_797;
import Graph.Problem_834;
import Graph.Problem_841;
import Graph.Problem_886;
import Graph.Problem_947;
import Graph.Algoritham.DFS_Cycle_Detection;
import Graph.Algoritham.Dijkstra;
import Graph.Algoritham.Kruskal_Algorithm;
import Graph.Algoritham.Topological_Sort_BFS;
import Mattrix.Game_of_Life;
import Mattrix.Maximum_Side_Length_of_a_Square;
import Mattrix.Set_Matrix_Zeroes;
import Mattrix.Spiral_Matrix;
import Problem.Binary_Watch;
import Problem.Can_Convert_String_in_K_Moves;
import Problem.Count_Binary_Substrings;
import Problem.Count_the_Number_of_Substrings_With_Dominant_Ones;
import Problem.Equal_Sum_Grid_Partition_I;
import Problem.Equal_Sum_Grid_Partition_II;
import Problem.Get_Biggest_Three_Rhombus_Sums_in_a_Grid;
import Problem.Longest_Balanced_Subarray_I;
import Problem.Longest_Balanced_Substring_I;
import Problem.Minimum_Cost_to_Convert_String;
import Problem.Minimum_Deletions_to_Make_String_Balanced;
import Problem.Minimum_Removals_to_Balance_Array;
import Problem.Partition_List;
import Problem.Problem_133;
import Problem.Problem_1922;
import Problem.Problem_199;
import Problem.Problem_2075;
import Problem.Problem_2101;
import Problem.Problem_221;
import Problem.Problem_2751;
import Problem.Problem_2840;
import Problem.Problem_3474;
import Problem.Problem_3653;
import Problem.Problem_3655;
import Problem.Problem_3740;
import Problem.Problem_3741;
import Problem.Problem_735;
import Problem.Problem_802;
import Problem.Spiral_Matrix_II;
import Problem.Spiral_Matrix_III;
import Problem.Spiral_Matrix_IV;

public class Main {

	public static void main(String[] args)
	{

		//////////////////Importent Problem
		// Problem_2421_Good_Path p2421=new Problem_2421_Good_Path();

		// Dijkstra dijkstra=new Dijkstra();
		// Topological_Sort_BFS tsb=new Topological_Sort_BFS();
		// DFS_Cycle_Detection dcd=new DFS_Cycle_Detection();
		Kruskal_Algorithm ksa=new Kruskal_Algorithm();

		//---------------------------------------------------------------------------
		// Reverse rvr=new Reverse();


		//Maximum_Side_Length_of_a_Square msl=new Maximum_Side_Length_of_a_Square();
		//Set_Matrix_Zeroes smz=new Set_Matrix_Zeroes();
		//Game_of_Life gol=new Game_of_Life();
		//Spiral_Matrix sm=new Spiral_Matrix();
		//Spiral_Matrix_II sm=new Spiral_Matrix_II();

		//Spiral_Matrix_III sm=new Spiral_Matrix_III();
		//Spiral_Matrix_IV sm=new Spiral_Matrix_IV();

		// Minimum_Cost_to_Convert_String mctc=new Minimum_Cost_to_Convert_String();

		// Can_Convert_String_in_K_Moves  cc=new Can_Convert_String_in_K_Moves();
		// Minimum_Removals_to_Balance_Array mrt=new Minimum_Removals_to_Balance_Array();
		// Minimum_Deletions_to_Make_String_Balanced mdtm=new Minimum_Deletions_to_Make_String_Balanced();
		// Longest_Balanced_Subarray_I lb=new Longest_Balanced_Subarray_I();
		// Longest_Balanced_Substring_I lbs=new Longest_Balanced_Substring_I();
		// Binary_Watch bw=new Binary_Watch();
		// Count_Binary_Substrings cbs=new Count_Binary_Substrings();
		// Count_the_Number_of_Substrings_With_Dominant_Ones ct=new Count_the_Number_of_Substrings_With_Dominant_Ones();
		// Get_Biggest_Three_Rhombus_Sums_in_a_Grid gbt=new Get_Biggest_Three_Rhombus_Sums_in_a_Grid();
		// Equal_Sum_Grid_Partition_I  eqs=new Equal_Sum_Grid_Partition_I();
		// Partition_List pl=new Partition_List();
		// Equal_Sum_Grid_Partition_II  eqs=new Equal_Sum_Grid_Partition_II ();
		// Problem_2840 p2840=new Problem_2840();
		// Problem_3474 p=new Problem_3474();
		// Problem_2751 p27=new Problem_2751();
		// Problem_735 pro=new Problem_735();
		// Problem_2075 p2=new Problem_2075();
		// Problem_3653 p3653=new Problem_3653();
		// Problem_3740 p3740=new Problem_3740();
		// Problem_3741 p3741=new Problem_3741();
		// Problem_1922 p1922=new Problem_1922();
		// Problem_3655 p3655=new Problem_3655(); // using squre root decomsiton.
		// Problem_221 p221=new Problem_221();
		// Problem_199 p199=new Problem_199();
		// Problem_947 p947=new Problem_947();
		// Problem_1926 pro=new Problem_1926();
		// Problem_841 p841=new Problem_841();
		// Problem_886 p866=new Problem_886();
		// Problem_834 p834=new Problem_834();
		// Problem_797 p797=new Problem_797();
		// Problem_1443 p1443=new Problem_1443();
		// Problem_1519 p1519=new Problem_1519();
		// Problem_1061_DSU p1061=new Problem_1061_DSU();
		// Problem_2359 p2359=new Problem_2359();
		// Problem_2492 p2492=new Problem_2492();
		// Problem_787  p787=new Problem_787();
		// Problem_1466 p1466=new Problem_1466();
		// Problem_2316 p2316=new Problem_2316();
		// Problem_133 p133=new Problem_133();
		// Problem_1857 p1857=new Problem_1857();
		// Problem_1857_DSU p1857=new Problem_1857_DSU();
		// Problem_1579_DSU p1579=new Problem_1579_DSU();
		// Problem_1557 p1557=new Problem_1557();
		// Problem_399 p399=new Problem_399();
		// Problem_1091 p1091=new Problem_1091();
		// Problem_2101 p2101=new Problem_2101(); ////  Detonate the Maximum Bombs
		// Problem_802 p802=new Problem_802();
		// Problem_1615 p1615=new Problem_1615();
	}
}
