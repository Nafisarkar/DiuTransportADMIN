package com.example.diutransport;

public class BusTimeTable {
    String BusNumber ;
    String BusType ;
    String DepartureTime ;
    String BusRoute ;

    public BusTimeTable() {

    }
    public BusTimeTable(String busNumber, String busType, String departureTime, String busRoute) {
        BusNumber = busNumber;
        BusType = busType;
        DepartureTime = departureTime;
        BusRoute = busRoute;
    }


    public String getBusNumber() {
        return BusNumber;
    }

    public void setBusNumber(String busNumber) {
        BusNumber = busNumber;
    }

    public String getBusType() {
        return BusType;
    }

    public void setBusType(String busType) {
        BusType = busType;
    }

    public String getDepartureTime() {
        return DepartureTime;
    }

    public void setDepartureTime(String departureTime) {
        DepartureTime = departureTime;
    }


    public String getBusRoute() {
        return BusRoute;
    }

    public void setBusRoute(String busRoute) {
        BusRoute = busRoute;
    }
}
