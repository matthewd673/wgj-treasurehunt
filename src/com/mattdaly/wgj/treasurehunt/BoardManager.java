package com.mattdaly.wgj.treasurehunt;
import java.util.ArrayList;
import java.util.Hashtable;

public class BoardManager {

	static ArrayList<Board> boards = new ArrayList<Board>();
	
	static Hashtable<String, Board> boardTable = new Hashtable<String, Board>();
	
	public BoardManager() {
		createBoard(0, 0);
	}
	
	public void createBoard(int x, int y) {
		Board board = new Board(30, 30, y * 30 * 32);
		board.generateBoard();
		board.populateBoardEntities();
		boardTable.put(x + "," + y, board);
	}
	
	public Board getCurrentBoard(String hash) {
		return boardTable.get(hash);
	}
	
	

}
