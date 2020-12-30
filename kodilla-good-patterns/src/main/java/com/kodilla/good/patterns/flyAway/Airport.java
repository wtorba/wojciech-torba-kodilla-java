package com.kodilla.good.patterns.flyAway;

import java.util.Objects;

public class Airport {
    private final String airportName;
    private int visited;
    private StringBuffer route = new StringBuffer();

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
        this.route=new StringBuffer(airport).append(" > ").append(this.airportName);
    }

    public void setChecked() {
        this.visited = 2;
    }

    public StringBuffer getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route=new StringBuffer(route);
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
