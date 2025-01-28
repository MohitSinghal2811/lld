package wc.src.main.java.counter;

public abstract class Constants {
	public static final String[] ALLOWED_FLAGS = {
		ByteCounterStrategy.flagname,
		LineCounterStrategy.flagname,
		WordCounterStrategy.flagname,
		CharacterCounterStrategy.flagname
	};

	public static final String[] DEFAULT_FLAGS = {
		ByteCounterStrategy.flagname,
		LineCounterStrategy.flagname,
		WordCounterStrategy.flagname,
	};
}
