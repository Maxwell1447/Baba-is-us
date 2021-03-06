package com.babachene.cliserv;

/**
 * Event that represents an input from a user. e.g. <code>moveLeft(user)</code>
 * <br> InputEvents have an eventType (move left, move right, z resquest, ...)
 * all types are a static field of this class (e.g. InputEvent.MOVE_UP)
 * @author jeremy
 *
 */
public class InputEvent extends Event {
	
	private static final long serialVersionUID = -7459899296974359597L;
	
	public final byte eventType;
	
	public InputEvent(byte type, int player) {
		super(20);
		eventType = type;
		setPlayer(player);
	}
	
	public static final byte
		MOVE_LEFT=0,
		MOVE_RIGHT=1,
		MOVE_UP=2,
		MOVE_DOWN=3,
		
		Z_REQUEST=4,
		Z_REQUEST_STOP=5,
		
		RESET_REQUEST=6,
		RESET_REQUEST_STOP=7,
		
		WAIT=8;
	
}
