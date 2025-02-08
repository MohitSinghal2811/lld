package TextEditor1;

public class TextEditorClient {
	public static void main(String[] args){
		TextEditor textEditor = new TextEditor("Hello World");
		HistoryManager historyManager = new HistoryManager();
		System.out.println(textEditor.getContent());
		textEditor.write("Hello");
		historyManager.save(textEditor);
		System.out.println(textEditor.getContent());
		textEditor.write("Hello World");
		historyManager.undo(textEditor);
		System.out.println(textEditor.getContent());
		textEditor.write("Hello Java");
		historyManager.redo(textEditor);
		System.out.println(textEditor.getContent());
	}
}
