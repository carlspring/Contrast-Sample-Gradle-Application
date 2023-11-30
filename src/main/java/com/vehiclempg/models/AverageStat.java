package com.vehiclempg.models;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "AverageStat")
public class AverageStat {

    private String make;

    private float average;

    private int year;

    /**
     * Average stat class represents a result from Mongo Aggregation
     *
     * @param average computed average
     * @param make    make of the vehicle
     * @param year    year of the vehicle
     */
    public AverageStat(String make, int year, float average) {
        this.average = average;
        this.make = make;
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public float getAverage() {
        return average;
    }

    public void setAverage(float average) {
        this.average = average;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
