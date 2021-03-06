
package com.noone.coronatracker;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data implements Serializable
{

    @SerializedName("source")
    @Expose
    private String source;
    @SerializedName("lastRefreshed")
    @Expose
    private String lastRefreshed;
    @SerializedName("total")
    @Expose
    private Total total;
    @SerializedName("statewise")
    @Expose
    private List<Statewise> statewise = null;
    private final static long serialVersionUID = 2312993683223092417L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Data() {
    }

    /**
     * 
     * @param lastRefreshed
     * @param total
     * @param source
     * @param statewise
     */
    public Data(String source, String lastRefreshed, Total total, List<Statewise> statewise) {
        super();
        this.source = source;
        this.lastRefreshed = lastRefreshed;
        this.total = total;
        this.statewise = statewise;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getLastRefreshed() {
        return lastRefreshed;
    }

    public void setLastRefreshed(String lastRefreshed) {
        this.lastRefreshed = lastRefreshed;
    }

    public Total getTotal() {
        return total;
    }

    public void setTotal(Total total) {
        this.total = total;
    }

    public List<Statewise> getStatewise() {
        return statewise;
    }

    public void setStatewise(List<Statewise> statewise) {
        this.statewise = statewise;
    }

}
