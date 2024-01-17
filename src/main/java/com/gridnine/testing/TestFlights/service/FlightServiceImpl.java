package com.gridnine.testing.TestFlights.service;

import com.gridnine.testing.TestFlights.model.Flight;
import com.gridnine.testing.TestFlights.model.Segment;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class FlightServiceImpl implements FlightService {
    @Override
    public List<Flight> departureToTheCurrentTime(List<Flight> flights) {
        List<Flight> filterOfFlights = flights.stream()
                .filter(flight -> flight.getSegments().stream()
                        .anyMatch(segment -> segment.getDepartureDate().isBefore(LocalDateTime.now())))
                .toList();
        System.out.println("Рейсы, вылетающие до текущего момента времени: ");
        for (Flight flight : filterOfFlights) {
            System.out.println(flight);
        }
        return filterOfFlights;
    }

    @Override
    public List<Flight> segmentsWithArrivalDateEarlierThanDepartureDate(List<Flight> flights) {
        List<Flight> filterOfFlights = new ArrayList<>();
        for (Flight flight : flights) {
            List<Segment> segments = flight.getSegments();
            if (segments.stream().anyMatch(segment -> segment.getDepartureDate().isAfter(segment.getArrivalDate()))) {
                filterOfFlights.add(flight);
            }
        }
        System.out.println("Все рейсы с датой прилета до времени прибытия:");
        for (Flight flight : filterOfFlights) {
            System.out.println(flight);
        }
        return filterOfFlights;
    }

    @Override
    public List<Flight> flightsWhereTotalTimeSpentOnGroundTwoHours(List<Flight> flights) {
        List<Flight> filterOfFlights = new ArrayList<>();
        for (Flight flight : flights) {
            List<Segment> segments = flight.getSegments();
            long totalTimeOnGround = 0;
            for (int i = 0; i < segments.size() - 1; i++) {
                LocalDateTime arrivalTime = segments.get(i).getArrivalDate();
                LocalDateTime nextDepartureTime = segments.get(i + 1).getDepartureDate();
                long groundTime = arrivalTime.until(nextDepartureTime, ChronoUnit.HOURS);
                totalTimeOnGround += groundTime;
            }
            if (totalTimeOnGround > 2) {
                filterOfFlights.add(flight);
            }
        }
        System.out.println("Все рейсы с общим временем ожидания более 2 часов:");
        for (Flight flight : filterOfFlights) {
            System.out.println(flight);
        }
            return filterOfFlights;
        }
    }