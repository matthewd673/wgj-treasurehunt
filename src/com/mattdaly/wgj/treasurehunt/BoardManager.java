package com.mattdaly.wgj.treasurehunt;
import java.util.ArrayList;

public class BoardManager {

	static ArrayList<Board> boards = new ArrayList<Board>();
	
	public BoardManager() {
		boards.add(new Board(30, 30, 0));
		boards.get(0).generateBoard();
		boards.get(0).populateBoardEntities();
		boards.add(new Board(30, 30, boards.get(0).y + boards.get(0).h*32));
		boards.get(1).generateBoard();
		boards.get(1).populateBoardEntities();
		
		
	}
	
	public static void update(Entity e) {
		//System.out.println(e.y);
		if(e.y > boards.get(1).y + boards.get(1).h*32- 400) {
			boards.get(0).dePopulateBoardEntities();
			boards.remove(0);
			boards.add(new Board(30, 30, boards.get(0).y + boards.get(0).h*32));//adds new board at ending of old board
			boards.get(1).generateBoard();
			boards.get(1).populateBoardEntities();
			System.out.println("yoo");
		
		}   
			
			
		
		
		//Board game = new Board(400, 31);
	}

}
