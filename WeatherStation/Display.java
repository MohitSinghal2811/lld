package WeatherStation;

public class Display implements Observer {

	@Override
	public void update(float temperature) {
		System.out.println("Display Temperature: " + temperature);
	}
	
}
