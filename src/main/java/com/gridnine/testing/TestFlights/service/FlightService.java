package com.gridnine.testing.TestFlights.service;

import com.gridnine.testing.TestFlights.model.Flight;

import java.util.List;

public interface FlightService {
List<Flight>DepartureToTheCurrentTime(List<Flight> flights);
List<Flight>SegmentsWithArrivalDateEarlierThanDepartureDate(List<Flight> flights);
List<Flight>FlightsWhereTotalTimeSpentOnGroundTwoHours(List<Flight> flights);
}
