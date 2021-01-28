package com.kodilla.good.patterns.flyaway;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class FlightFinder {

    private static Set prepareFlights() {
        Set<Flight> flights = new HashSet<>();
        flights.add(new Flight("Kraków","Warszawa"));
        flights.add(new Flight("Warszawa","Gdańsk"));
        flights.add(new Flight("Gdańsk","Szczecin"));
        flights.add(new Flight("Szczecin","Kraków"));
        flights.add(new Flight("Szczecin","Warszawa"));
        flights.add(new Flight("Radom","Warszawa"));
        flights.add(new Flight("Warszawa","Radom"));
        flights.add(new Flight("Warszawa","Poznań"));
        flights.add(new Flight("Warszawa","Kraków"));
        flights.add(new Flight("Gdańsk","Warszawa"));
        flights.add(new Flight("Szczecin","Gdańsk"));
        flights.add(new Flight("Poznań","Warszawa"));
        flights.add(new Flight("Kraków","Poznań"));
        flights.add(new Flight("Katowice","Warszawa"));

        return flights;
    }

    private static Set<Airport> prepareAirports(Set<Flight> flights) {
        Flight flight;
        Iterator<Flight> flightIter = flights.iterator();
        Set<Airport> airports = new HashSet<>();

        while(flightIter.hasNext()) {
            flight=flightIter.next();
            airports.add(new Airport(flight.getArrivalAirport()));
            airports.add(new Airport(flight.getDepartureAirport()));
        }
        return airports;
    }

    public static String findFlightsFrom(String departureAirport) {
        Set<Flight> flights = (HashSet<Flight>) prepareFlights();
        StringBuffer sb = new StringBuffer();
        sb.append("Available flights from ").append(departureAirport).append(" to: ");
        if (flights.stream().filter(e -> departureAirport.equals(e.getDepartureAirport())).count() == 0) {
            return sb.append("none").toString();
        }
        return sb.append(flights.stream()
                .filter(e -> departureAirport.equals(e.getDepartureAirport()))
                .map(e -> new StringBuffer(e.getArrivalAirport()))
                .collect(Collectors.joining(", ")))
                .toString();

    }

    public static String findFlightsTo(String arrivalAirport)  {
        HashSet<Flight>flights = (HashSet<Flight>) prepareFlights();
        StringBuilder sb = new StringBuilder();
        sb.append("Available flights to ").append(arrivalAirport).append(" from: ");
        if (flights.stream().filter(e -> arrivalAirport.equals(e.getArrivalAirport())).count() == 0) {
            return sb.append("none").toString();
        }
        return sb.append(flights.stream()
                .filter(e -> arrivalAirport.equals(e.getArrivalAirport()))
                .map(e -> new StringBuffer(e.getDepartureAirport()))
                .collect(Collectors.joining(", ")))
                .toString();
    }

    public static String findFlights(Flight flight) {

        int checked;
        HashSet<Flight> flights = (HashSet<Flight>) prepareFlights();
        HashSet<Airport> airports = (HashSet<Airport>) prepareAirports(flights);

        if(getAirport(airports,flight.getArrivalAirport()).isEmpty()) {
            return "Unfortunately we don't cooperate with " + flight.getArrivalAirport();
        }
        if(getAirport(airports,flight.getDepartureAirport()).isEmpty()) {
            return "Unfortunately we don't cooperate with " + flight.getDepartureAirport();
        }
        if (!airports.contains(getAirport(airports,flight.getArrivalAirport()).get())) {
            return "Unfortunately it's not possible to reach " + flight.getArrivalAirport();
        }
        if (!airports.contains(getAirport(airports,flight.getDepartureAirport()).get())) {
            return "Unfortunately it's not possible to travel from " + flight.getDepartureAirport();
        }
        if (flights.contains(flight)) {
            return "Direct connection available between " + flight.getDepartureAirport() + " and " + flight.getArrivalAirport();
        }

        checked=0;
        Optional<Airport> currentAirport = getAirport(airports, flight.getDepartureAirport());
        if (currentAirport.isPresent()) {
            Airport currAirport = currentAirport.get();
            currAirport.setVisited("start");
            currAirport.setRoute(flight.getDepartureAirport());
            // System.out.println("Startujemy z "+currAirport.getAirportName());
            while (existNotChecked(airports) && checked == 0) {
                Iterator<Airport> airportsIter = airports.iterator();
                checked = 1;
                while (airportsIter.hasNext()) {
                    currAirport = airportsIter.next();
                    // System.out.println("Sprawdzam " + currAirport.getAirportName());
                    if (currAirport.getVisited() == 1) {
                        if (flight.getArrivalAirport().equals(currAirport.getAirportName())) {
                            return "Inderict connection between " + flight.getDepartureAirport() + " and " + flight.getArrivalAirport() + " available:\n" + currAirport.getRoute().toString();
                        }
                        visitAirports(airports, flights, currAirport);
                        currAirport.setChecked();
                        checked = 0;
                        //     System.out.println("Zmiana checked na 1, bo trafilismy na "+currAirport.getAirportName());
                    }
                }
            }
            return "Unfortunately it's not possible to travel from " + flight.getDepartureAirport() + " to " + flight.getArrivalAirport();
        }
        return "";
    }

    public static void visitAirports(HashSet<Airport> airports, HashSet<Flight> flights, Airport airport) {
        flights.stream()
                .filter(e -> airport.getAirportName().equals(e.getDepartureAirport()))
                .filter(e -> getAirport(airports, e.getArrivalAirport()).get().getVisited()==0)
                .forEach(e -> getAirport(airports, e.getArrivalAirport()).get().setVisited(airport.getRoute().toString()));
    }

    public static Optional<Airport>  getAirport(HashSet<Airport> airports, String airportName) {
        return airports.stream()
                .filter(e -> airportName.equals(e.getAirportName()))
                .findAny();


//        Iterator<Airport> airportsIter = airports.iterator();
//        Airport airport;
//        while (airportsIter.hasNext()) {
//            airport=airportsIter.next();
//            if (airportName.equals(airport.getAirportName())) {
//                return airportsIter.next();
//            }
//        }
    }

    public static boolean existNotChecked(HashSet<Airport> airports) {
        Iterator<Airport> airportsIter = airports.iterator();
        while (airportsIter.hasNext()) {
            if (airportsIter.next().getVisited() < 2) {
                return true;
            }
        }
        return false;
    }

    public static void main(String args[]) {
        System.out.println(FlightFinder.findFlightsFrom("Warszawa"));
        System.out.println(FlightFinder.findFlightsTo("Szczecin"));
        System.out.println(FlightFinder.findFlightsFrom("Katowice"));



//        System.out.println(FlightFinder.findFlights(new Flight("Gdańsk","Kraków")));
//        System.out.println(FlightFinder.findFlights(new Flight("Warszawa","Poznań")));
        System.out.println(FlightFinder.findFlights(new Flight("Katowice","Szczecin")));
        System.out.println(FlightFinder.findFlights(new Flight("Szczecin","Katowice")));
//        System.out.println(FlightFinder.findFlights(new Flight("Poznań","Katowice")));

    }
}
