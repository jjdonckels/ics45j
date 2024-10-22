package labs.lab3;

/**
 * Represents the height of a terrain at different points in a square
 */
public class Terrain {
	
	private double[][] heights;
	
	
	/**
	 * Constructor
	 * 
	 * @param heights	heights of the terrain at different points in a square
	 */
	public Terrain(double[][] heights) {
		this.heights = new double[heights.length][heights[0].length];
		for (int i = 0; i < heights.length; i++)
		{
			for (int j = 0; j < heights[0].length; j++)
			{
				this.heights[i][j] = heights[i][j];
			}
		}
		
		// print 2d array of heights
//		for (int i = 0; i < this.heights.length; ++i)
//		{
//			for (int j = 0; j < this.heights[0].length; ++j)
//			{
//				System.out.print(this.heights[i][j] + " ");
//			}
//			System.out.println();
//		}
	}

	
	/**
	 * Returns a flood map, showing which of the points in the terrain would be flooded
	 * if the water level was the given value. A point is flooded if the water level
	 * is > the height of the terrain.
	 * 
	 * In the flood map, each flooded point is represented by a * and each non-flooded
	 * point is represented by a -.
	 * 
	 * @param waterLevel	the water level
	 * 
	 * @return	the flood map
	 */
	public char[][] getFloodMap(double waterLevel) {
		char[][] map = new char[heights.length][heights[0].length];
		
		for (int i = 0; i < heights.length; ++i)
		{
			for (int j = 0; j < heights[0].length; ++j)
			{
				if (waterLevel > heights[i][j])
					map[i][j] = '*';
				else 
					map[i][j] = '-';
			}
		}
		
		return map;
	}
}
