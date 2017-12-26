package newgame.states;

public class StateManager {
	private static State currentState;

	public static State runState(State state) {
		// Changes the current state and returns the previous current state before the change.

		State oldState = currentState;
		currentState = state;
		return oldState;
	}

	public static State getCurrentState() {
		return currentState;
	}
}
