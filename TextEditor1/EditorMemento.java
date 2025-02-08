package TextEditor1;


// Memento class stores the internal state of the editor ( snapshots of the editor)
public class EditorMemento {
	private final String state;
	// If we had more fields like heading, code snipper here we could have them here.

	public EditorMemento(String state) {
		this.state = state;
	}

	public String getState() {
		return state;
	}


}
