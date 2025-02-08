package TextEditor1;

// Originator class :- Class for which the state needs to be stored or restored.

public class TextEditor {
	
	private String content;

	public TextEditor(String content) {
		this.content = content;
	}

	public void write(String content){
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	public EditorMemento save(){
		return new EditorMemento(content);
	}
	
	public void restore(EditorMemento editorMemento){
		this.content = editorMemento.getState();
	}

}
