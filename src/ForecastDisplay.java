//import java.util.logging.Logger;

public class ForecastDisplay implements Observer, DisplayElement {

    //Logger logger = Logger.getLogger(getClass().getName());
    private float currentPressure = 1000.00f;
    private float lastPressure;
    // private Subject weatherData;

    public ForecastDisplay(Subject weatherData) {
        // this.weatherData = weatherData;
        weatherData.registerObsever(this);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        lastPressure = currentPressure;
        currentPressure = pressure;

        display();
    }

    @Override
    public void display() {

        // logger.info("Forecast: ");
        System.out.print("Forecast: ");
        if (currentPressure > lastPressure) {
            System.out.println("Improving weather on the way!");
        } else if (currentPressure == lastPressure) {
            System.out.println("More of the same");
        } else if (currentPressure < lastPressure) {
            System.out.println("Watch out for cooler, rainy weather");
        }
    }

}
