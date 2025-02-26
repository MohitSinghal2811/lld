package WeatherStation;

import java.util.ArrayList;
import java.util.List;

public class WeatherStation implements Subject {

	private List<Observer> observers;
	private float temperature;


	public WeatherStation() {
		observers = new ArrayList<Observer>();
	}

	public void setTemperature(float temperature){
		this.temperature = temperature;
		notifyObservers();
	}

	@Override
	public void attach(Observer observer) {
		observers.add(observer);
	}

	@Override
	public void detach(Observer observer) {
		observers.remove(observer);
	}

	@Override
	public void notifyObservers() {
		for(Observer observer : observers) {
			observer.update(temperature);
		}
	}
	
}
