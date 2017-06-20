public class Cell {
	//Cell class, basically a glorified 'char'
	private char value;

	public Cell() {
		value = ' ';
	}

	public void setValue(char input) {
		value = input;
	}

	public char getValue() {
		return value;
	}
}