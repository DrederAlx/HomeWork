package PatternsHW.listener;

public class Main {
    public static void main(String[] args) {

        Sensor sensor = new Sensor();

        Listener green = new Listener() {
            boolean reacted = false;
            @Override
            public void tempChanged(int temp) {
                if (temp >= 100 && temp < 300 && !reacted) {
                    System.out.println("Green Alarm температура = " + temp);
                    reacted = true;
                }
                else if (temp < 100) reacted = false;
            }
        };

        Listener yellow = new Listener() {
            boolean reacted = false;
            @Override
            public void tempChanged(int temp) {
                if (temp >= 300 && temp < 600 && !reacted) {
                    System.out.println("Yellow Alarm температура = " + temp);
                    reacted = true;
                }
                else if (temp < 300) reacted = false;
            }
        };

        Listener red = new Listener() {
            boolean reacted = false;
            @Override
            public void tempChanged(int temp) {
                if (temp >= 600 && !reacted) {
                    System.out.println("Red Alarm температура = " + temp);
                    reacted = true;
                }
                else if (temp < 600) reacted = false;
            }
        };

        sensor.addListener(green);
        sensor.addListener(yellow);
        sensor.addListener(red);

        while (sensor.getTemperature() < 700){
            sensor.increaseTemperature();
        }
    }
}
