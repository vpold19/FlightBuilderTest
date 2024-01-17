package com.gridnine.testing.TestFlights;
import com.gridnine.testing.TestFlights.model.Flight;
import com.gridnine.testing.TestFlights.service.FlightServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Flight> allFlights = FlightBuilder.createFlights();
        FlightServiceImpl flightService = new FlightServiceImpl();
        flightService.departureToTheCurrentTime(allFlights);
        flightService.segmentsWithArrivalDateEarlierThanDepartureDate(allFlights);
        flightService.flightsWhereTotalTimeSpentOnGroundTwoHours(allFlights);
    }
}
