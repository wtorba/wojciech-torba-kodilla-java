package com.kodilla.testing.weather.stub;

import java.util.*;

public class WeatherForecast {
    private Temperatures temperatures;

    public WeatherForecast(Temperatures temperatures) {
        this.temperatures = temperatures;
    }

    public Map<String, Double> calculateForecast() {
        Map<String, Double> resultMap = new HashMap<>();

        for (Map.Entry<String, Double> temperature :
                temperatures.getTemperatures().entrySet()) {

            // adding 1 celsius degree to current value
            // as a temporary weather forecast
            resultMap.put(temperature.getKey(), temperature.getValue() + 1.0); // [1]
        }
        return resultMap;
    }

    public Double calculateAvg() {
        double sum = 0.0;
        if (temperatures.getTemperatures().size() > 0) {
            for (double temperature : temperatures.getTemperatures().values()) {
                sum += temperature;
            }
            return sum / temperatures.getTemperatures().size();
        }
        return null;
    }

    public Double calculateMed() {
        int size = temperatures.getTemperatures().size();
        List<Double> sortedTemperatures = new ArrayList<>(temperatures.getTemperatures().values());
        Collections.sort(sortedTemperatures);

        if (size == 0) {
            return null;
        } else if (size % 2 == 1) {
            return sortedTemperatures.get(size / 2);
        }
        return (sortedTemperatures.get(size / 2) + sortedTemperatures.get(size / 2 - 1)) / 2;
    }
}