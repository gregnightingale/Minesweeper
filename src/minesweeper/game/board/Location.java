package minesweeper.game.board;

import java.util.Enumeration;
import java.util.Vector;

import commons.IntegerCoordinate;

public class Location { // wrapper class

	private IntegerCoordinate coordinate;
	private Contents contains;
	private State currentState; // current state object
	private Board board;
	private ProbeData probeData = null;
	private Vector<LocationListener> listeners = new Vector<LocationListener>();

	private enum Contents {
		NOTHING, BOMB
	};

	public Location(Board board, IntegerCoordinate coord) throws Exception {
		this.board = board;
		this.coordinate = coord;
		currentState = BlankState.instance();
		contains = Contents.NOTHING;
		register(board);
	}

	public IntegerCoordinate getCoordinate() {
		return coordinate;
	}

	void setCurrent(State s) {
		currentState = s;
		notifyObservers();
	}

	public boolean isMarked() {
		return currentState instanceof MarkedState;
	}
	
	public void probe() {
		currentState.probeAndClear(this);
	} // the "wrapper" delegates to the "wrappee"

	public void mark() {
		currentState.changeToMarkedState(this);
	}
	
	public void unmark() {
		currentState.changeToBlankState(this);
	}

	public void question() {
		currentState.changeToQuestionedState(this);
	}

	public boolean isBomb() {
		return (contains == Contents.BOMB);
	}

	Location setBomb() {
		this.contains = Contents.BOMB;
		return this;
	}

	@Override
	public String toString() {
		return currentState.getTextRepresentation(this);
	}

	public ProbeData getProbeData() {
		return probeData;
	}

	public void setProbeData(ProbeData probeData) {
		this.probeData = probeData;
	}

	public State getCurrentState() {
		return currentState;
	}

	public void register(LocationListener l) {
		listeners.addElement(l);
	}

	private void notifyObservers() {
		for (Enumeration<LocationListener> e = listeners.elements(); e
				.hasMoreElements();) {
			((LocationListener) e.nextElement()).onStateChanged(this, currentState);
		}
	}

	public Board getBoard() {
		return board;
	}

}
