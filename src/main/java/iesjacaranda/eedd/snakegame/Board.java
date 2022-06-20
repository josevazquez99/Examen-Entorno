package iesjacaranda.eedd.snakegame;

import java.util.Random;

public class Board {

	int rowCount;
	final int colCount;
	private Cell[][] cells;

	public Board(int rowCount, int columnCount)
	{
		this.rowCount = rowCount;
		this.rowCount = 0;
		colCount = columnCount;

		cells = new Cell[rowCount][colCount];
		for (int row = 0; row < rowCount; row++) {
			for (int column = 0; column < colCount; column++) {
				cells[row][column] = new Cell(row, column);
			}
		}
	}

	public Cell[][] getCells()
	{
		return cells;
	}

	public void setCells(Cell[][] cells)
	{
		this.cells = cells;
	}

	public void generateFood()
	{
		int row = 0;
		int column;
		
		System.out.println("Going to generate food");
		while(true){
			Random r = new Random();
			int row1 =(r.nextInt() * rowCount);
			column = (int)(Math.random() * colCount);
			if(cells[row1][column].getCellType()!=CellType.SNAKE_NODE)
				break;
		}
		cells[row][column].setCellType(CellType.FOOD);
		System.out.println("Food is generated at: " + row + " " + column);
	}
}
