package main.states;

/**
 * Permet de changer d'état ou de renvoyer l'état actuel
 * @author Octikoros
 *
 */
public class StateManager {

		// Initialisation de l'état de départ du programme à null
		private static State currentState = null;
		
		/**
		 * Indique le type d'état dans lequel le programme devrait se trouver
		 * @param state : l'état dans lequel le programme devrait se trouver
		 */
		public static void setState(State state) {
			currentState = state;
		}
		
		/**
		 * @return l'état actuel du programme
		 */
		public static State getState() {
			return currentState;
		}
}
