package com.simra.app.csvimporter.model;

import com.opencsv.bean.CsvBindByName;

/**
 * The type Ride csv.
 */
public class RideCSV extends ApplicationFileVersion {

    @CsvBindByName
    private String lat;

    @CsvBindByName
    private String lon;

    @CsvBindByName
    private String X;

    @CsvBindByName
    private String Y;

    @CsvBindByName
    private String Z;

    @CsvBindByName
    private long timeStamp;

    @CsvBindByName
    private String acc;

    @CsvBindByName
    private String a;

    @CsvBindByName
    private String b;

    @CsvBindByName
    private String c;


    /**
     * Gets lat.
     *
     * @return the lat
     */
    public String getLat() {
        return lat;
    }

    /**
     * Sets lat.
     *
     * @param lat the lat
     */
    public void setLat(String lat) {
        this.lat = lat;
    }

    /**
     * Gets lon.
     *
     * @return the lon
     */
    public String getLon() {
        return lon;
    }

    /**
     * Sets lon.
     *
     * @param lon the lon
     */
    public void setLon(String lon) {
        this.lon = lon;
    }

    /**
     * Gets x.
     *
     * @return the x
     */
    public String getX() {
        return X;
    }

    /**
     * Sets x.
     *
     * @param x the x
     */
    public void setX(String x) {
        X = x;
    }

    /**
     * Gets y.
     *
     * @return the y
     */
    public String getY() {
        return Y;
    }

    /**
     * Sets y.
     *
     * @param y the y
     */
    public void setY(String y) {
        Y = y;
    }

    /**
     * Gets z.
     *
     * @return the z
     */
    public String getZ() {
        return Z;
    }

    /**
     * Sets z.
     *
     * @param z the z
     */
    public void setZ(String z) {
        Z = z;
    }

    /**
     * Gets time stamp.
     *
     * @return the time stamp
     */
    public long getTimeStamp() {
        return timeStamp;
    }

    /**
     * Sets time stamp.
     *
     * @param timeStamp the time stamp
     */
    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    /**
     * Gets acc.
     *
     * @return the acc
     */
    public String getAcc() {
        return acc;
    }

    /**
     * Sets acc.
     *
     * @param acc the acc
     */
    public void setAcc(String acc) {
        this.acc = acc;
    }

    /**
     * Gets a.
     *
     * @return the a
     */
    public String getA() {
        return a;
    }

    /**
     * Sets a.
     *
     * @param a the a
     */
    public void setA(String a) {
        this.a = a;
    }

    /**
     * Gets b.
     *
     * @return the b
     */
    public String getB() {
        return b;
    }

    /**
     * Sets b.
     *
     * @param b the b
     */
    public void setB(String b) {
        this.b = b;
    }

    /**
     * Gets c.
     *
     * @return the c
     */
    public String getC() {
        return c;
    }

    /**
     * Sets c.
     *
     * @param c the c
     */
    public void setC(String c) {
        this.c = c;
    }

    public String toString() {
        return String.format("lat: %s lon: %s X:%s Y:%s Z:%s timeStamp:%s acc:%s a:%s b:%s c:%s",
                this.lat, this.lon, this.X, this.Y, this.Z, this.timeStamp, this.acc, this.a,
                this.b, this.c);
    }
}
