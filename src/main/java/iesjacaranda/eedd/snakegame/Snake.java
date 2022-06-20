package iesjacaranda.eedd.snakegame;

import java.util.LinkedList;
import java.util.List;

public class Snake {

	private LinkedList<Cell> snakePartList
		= new LinkedList<>();
	private Cell head;

	public Snake(Cell initPos)
	{
		head = initPos;
		snakePartList.add(head);
		head.setCellType(CellType.SNAKE_NODE);
	}

	public void grow() { snakePartList.add(head); }

	public void move(Cell nextCell)
	{
		System.out.println("Snake is moving to "
						+ nextCell.getRow() + " "
						+ nextCell.getCol());
		Cell tail = snakePartList.removeLast();
		tail.setCellType(CellType.EMPTY);

		head = nextCell;
		head.setCellType(CellType.SNAKE_NODE);
		snakePartList.addFirst(head);
	}

	public boolean checkCrash(Cell nextCell)
	{
		System.out.println("Going to check for Crash");
		for (Cell cell : snakePartList) {
			if (cell == nextCell) {
				return true;
			}
		}

		return false;
	}

	public List<Cell> getSnakePartList()
	{
		return snakePartList;
	}

	public void setSnakePartList(List<Cell> snakePartList)
	{
		this.snakePartList = (LinkedList<Cell>) snakePartList;
	}

	public Cell getHead() { return head; }

	public void setHead(Cell head) { this.head = head; }
}
