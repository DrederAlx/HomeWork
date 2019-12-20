package PatternsHW.listener;

import java.util.ArrayList;

public class Sensor {
    int temperature = 0;
    private ArrayList<Listener> listeners = new ArrayList<>();

    public void addListener (Listener listener) {
        listeners.add(listener);
    }

    public void deleteListener (Listener listener) {
        listeners.remove(listener);
    }

    public void notifyListeners (int temp) {
        for (Listener listener : listeners) {
            listener.tempChanged(temp);
        }
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public void increaseTemperature () {
        temperature++;
        notifyListeners(temperature);
    }
}


