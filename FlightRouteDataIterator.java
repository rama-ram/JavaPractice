package org.example;

import java.util.*;

public class FlightRouteDataIterator implements Iterator<FlightRoute[]>{

    public Iterator<FlightRoute> iterator ;
    public FlightRouteDataIterator(){
        createFlightData();
    }
    private void createFlightData(){
        List<FlightRoute> personList = Arrays.asList(
                new FlightRoute("Mumbai","Chennai", "12-06-2025")
//                new FlightRoute("Chennai","Mumbai", "12-10-2025")

        );
        iterator = personList.iterator();
    }
    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }
    @Override
    public FlightRoute[] next() {
        return new FlightRoute[]{ iterator.next() };
    }



}