package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightFinder {

    public boolean findFlight(Flight flight) throws RouteNotFoundException {
        Boolean result = null;
        Map<String, Boolean> flights = new HashMap<>();
        flights.put("Warszawa-Okęcie", true);
        flights.put("Kraków-Balice", true);
        flights.put("Modlin", false);
        flights.put("Rzeszow-Jesionka", false);
        flights.put("Katowice-Pyrzowice", true);
        flights.put("Gdańsk-Lecha Wałęsy", false);

        if (!(flights.containsKey(flight.getArrivalAirport())))
            throw new RouteNotFoundException("Exception! List of airports out of date or wrong airport name.");

        for (Map.Entry<String, Boolean> entry : flights.entrySet()) {
            if (entry.getKey() == flight.getArrivalAirport()) result = entry.getValue();
        }
        return result;
    }

    public static void main(String args[]) {
        Flight flight = new Flight("Okęcie", "CPL-Branaów");
       // Flight flight = new Flight("Okęcie", "Modlin");
       // Flight flight = new Flight("Okęcie", "Kraków-Balice");
        String possibleOrNot = "";
        String message;

        FlightFinder flightFinder = new FlightFinder();
        try {
            if (!(flightFinder.findFlight(flight))) possibleOrNot = " not";
            message = "Flight to " + flight.getArrivalAirport() + possibleOrNot + " possible";
        } catch (RouteNotFoundException e) {
            message = e.getMessage();
        }
        System.out.println(message);
    }
}
