package com.gridnine.testing.TestFlights.service;

import com.gridnine.testing.TestFlights.model.Flight;

import java.util.List;

public interface FlightService {
List<Flight>departureToTheCurrentTime(List<Flight> flights);
List<Flight>segmentsWithArrivalDateEarlierThanDepartureDate(List<Flight> flights);
List<Flight>flightsWhereTotalTimeSpentOnGroundTwoHours(List<Flight> flights);
}
