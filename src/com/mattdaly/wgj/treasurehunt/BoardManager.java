package com.mattdaly.wgj.treasurehunt;
import java.util.ArrayList;

public class BoardManager {

	static ArrayList<Board> boards = new ArrayList<Board>();
	
	public BoardManager() {
		
		//creates first two boards
		boards.add(new Board(30, 30, 0));//first board starts at y = 0
		boards.get(0).generateBoard();
		boards.get(0).populateBoardEntities();
		boards.add(new Board(30, 30, boards.get(0).y + boards.get(0).h*32)); //second board starts at end of first board
		boards.get(1).generateBoard();
		boards.get(1).populateBoardEntities();
		
		
	}
	
	public static void update(Entity e) {
		
		if(e.y > boards.get(1).y + boards.get(1).h*32- 400) {
			boards.get(0).dePopulateBoardEntities();//de-Populates old boards off screen 
			boards.remove(0);//removes old board for boards list
			
			boards.add(new Board(30, 30, boards.get(0).y + boards.get(0).h*32));//adds new board at ending of old board
			boards.get(1).generateBoard();
			boards.get(1).populateBoardEntities();
			//System.out.println("yoo");
		
		}   
			
	}

}
