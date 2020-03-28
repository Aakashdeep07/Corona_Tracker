
package com.noone.coronatracker;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Total implements Serializable
{

    @SerializedName("confirmed")
    @Expose
    private Integer confirmed;
    @SerializedName("recovered")
    @Expose
    private Integer recovered;
    @SerializedName("deaths")
    @Expose
    private Integer deaths;
    @SerializedName("active")
    @Expose
    private Integer active;
    private final static long serialVersionUID = -6358474652002584754L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Total() {
    }

    /**
     * 
     * @param recovered
     * @param active
     * @param confirmed
     * @param deaths
     */
    public Total(Integer confirmed, Integer recovered, Integer deaths, Integer active) {
        super();
        this.confirmed = confirmed;
        this.recovered = recovered;
        this.deaths = deaths;
        this.active = active;
    }

    public Integer getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(Integer confirmed) {
        this.confirmed = confirmed;
    }

    public Integer getRecovered() {
        return recovered;
    }

    public void setRecovered(Integer recovered) {
        this.recovered = recovered;
    }

    public Integer getDeaths() {
        return deaths;
    }

    public void setDeaths(Integer deaths) {
        this.deaths = deaths;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

}
