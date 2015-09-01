package algorithms.demo;
import algorithms.mazeGenerators.DfsMaze3dGenerator;
import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Maze3dGenerator;
import algorithms.mazeGenerators.Position;
import algorithms.search.Astar;
import algorithms.search.Bfs;
import algorithms.search.MazeAirDistance;
import algorithms.search.MazeManhattanDistance;
import algorithms.search.Searcher;

/**
 * @author Lital Zigron
 *  @version 1.0
 * @since   2015-08-23
 * This program implements maze game. the game is 3 dimensional array. we generate the maze using simple random algorithm and dfs algorithms.
 * we slove the maze using A STAR algorithm and BFS (best first search) algorithm. 
 * The Class Demo.
 */
public class Demo {
	
	
	/**
	 * Run.
	 * Creates a new 3D maze, and solves it using both A star and BFS.
	 * Prints the Amount of evaluated nodes for ASTAR and for BFS.
	 */
	public static void run(){
		// Creates a new 3D maze using DFS algorithm, size (5,5,3), and prints it.
		Maze3dGenerator maze3dGenerator = new DfsMaze3dGenerator();
		Maze3d maze = maze3dGenerator.generate(5,5,3);
		maze.printMaze();
		
		// Solving the maze using BFS
		System.out.println("Solving the maze using BFS: ");
		Searcher<Position> searcherBFS= new Bfs<Position>(); 
		System.out.println(searcherBFS.search(new SearchableMaze3d(maze)));
		
		System.out.println("Solving the maze using A star and HeuristicManhattanDistance: ");
		Searcher<Position> searcherAStarM= new Astar<Position>(new MazeManhattanDistance()); 
		System.out.println(searcherAStarM.search(new SearchableMaze3d(maze)));
		System.out.println("Solving the maze using A star and HeuristicAirDistance: ");
		Searcher<Position> searcherAStarA= new Astar<Position>(new MazeAirDistance()); 
		System.out.println(searcherAStarA.search(new SearchableMaze3d(maze)));
		
		System.out.println("Amount of evaluated nodes for BFS Search algoritm: "+ searcherBFS.getNumberOfNodesEvaluated());
		System.out.println("Amount of evaluated nodes for ASTAR Search algoritm using HeuristicManhattanDistance: "+ searcherAStarM.getNumberOfNodesEvaluated());
		System.out.println("Amount of evaluated nodes for ASTAR Search algoritm using HeuristicAirDistance: "+ searcherAStarA.getNumberOfNodesEvaluated());
	}
	public static void main(String[] args) {
		run();
	}
	
}

