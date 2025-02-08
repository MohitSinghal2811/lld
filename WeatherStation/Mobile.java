package WeatherStation;

public class Mobile implements Observer{

	@Override
	public void update(float temperature) {
		System.out.println("Mobile Temperature: " + temperature);
	}
	
}
