package TextEditor1;

import java.util.Stack;

// History / Caretaker class :- Manages mementos 

public class HistoryManager {
	private final Stack<EditorMemento> undoStack = new Stack<EditorMemento>();
	private final Stack<EditorMemento> redoStack = new Stack<EditorMemento>();


	public void save(TextEditor textEditor) {
		undoStack.push(textEditor.save());
		redoStack.clear();
	}

	public void undo(TextEditor textEditor){
		if(!undoStack.isEmpty()){
			redoStack.push(textEditor.save());
			textEditor.restore(undoStack.pop());
		}
	}

	public void redo(TextEditor textEditor){
		if(!redoStack.isEmpty()){
			undoStack.push(textEditor.save());
			textEditor.restore(redoStack.pop());
		}
	}
}