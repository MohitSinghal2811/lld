package Singleton.src.main.java;

import java.io.Serializable;

public class Singleton implements Serializable, Cloneable {
	private volatile static Singleton instance = null;

	private Singleton() {
		if(instance != null) {
			throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
		}
	}

	public static Singleton getInstance() {
		if(instance == null) {
			synchronized (Singleton.class) {
				if(instance == null) {
					instance = new Singleton();
				}
			}
		}
		return instance;
	}

	protected Object readResolve() {
		return instance;
	}

	protected Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}

	public void someBusinessLogic() {
		// ...
	}

}
