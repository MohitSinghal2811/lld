package WeatherStation;

public class Client {
	public static void main(String[] args){
		WeatherStation weatherStation = new WeatherStation();
		Display display = new Display();
		Mobile mobile = new Mobile();
		weatherStation.attach(display);
		weatherStation.attach(mobile);
		weatherStation.setTemperature(30);
	}
}
