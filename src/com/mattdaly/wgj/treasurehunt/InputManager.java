package com.mattdaly.wgj.treasurehunt;

import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.awt.event.KeyEvent;

public class InputManager implements KeyListener {
	
	ArrayList<Character> pressedChars = new ArrayList<Character>();
	
	//use this method for checking key events
	public boolean isKeyPressed(char c)
	{
		return pressedChars.contains(c);
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		char keyChar = e.getKeyChar();
		//add to pressedChars list if it isn't already in there
		if(!pressedChars.contains(keyChar))
			pressedChars.add(keyChar);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		char keyChar = e.getKeyChar();
		//remove from pressedChars list, if it is in the list
		if(pressedChars.contains(keyChar))
			pressedChars.remove(pressedChars.indexOf(keyChar)); //if you don't use indexof it will try to remove at index based on char code
	}
	
}
