package com.kodilla.good.patterns.flyaway;

import java.util.Objects;

public class Airport {
    private final String airportName;
    private int visited;
    private StringBuilder route = new StringBuilder();

    public Airport(String airportName) {
        this.airportName = airportName;
        this.visited=0;
    }

    public String getAirportName() {
        return airportName;
    }

    public int getVisited() {
        return visited;
    }

    public void setVisited(String airport) {
        this.visited = 1;
        this.route=new StringBuilder(airport).append(" > ").append(this.airportName);
    }

    public void setChecked() {
        this.visited = 2;
    }

    public StringBuilder getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route=new StringBuilder(route);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airport airport = (Airport) o;
        return airportName.equals(airport.airportName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(airportName);
    }
}
