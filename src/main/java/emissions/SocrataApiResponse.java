package emissions;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * Class to represent the JSON objects received from the Socrata Open Data API.
 *
 * Created by pp on 22.09.17.
 */
public class SocrataApiResponse {

    private String department;
    @JsonProperty("source_type")
    private String sourceType;
    @JsonProperty("fiscal_year")
    private int fiscalYear;
    private String quarter;
    @JsonProperty("emissions_mtco2e")
    private double emissions;
    private double consumption;
    @JsonProperty("consumption_units")
    private String consumptionUnits;

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    public int getFiscalYear() {
        return fiscalYear;
    }

    public void setFiscalYear(int fiscalYear) {
        this.fiscalYear = fiscalYear;
    }

    public String getQuarter() {
        return quarter;
    }

    public void setQuarter(String quarter) {
        this.quarter = quarter;
    }

    public double getEmissions() {
        return emissions;
    }

    public void setEmissions(double emissions) {
        this.emissions = emissions;
    }

    public double getConsumption() {
        return consumption;
    }

    public void setConsumption(double consumption) {
        this.consumption = consumption;
    }

    public String getConsumptionUnits() {
        return consumptionUnits;
    }

    public void setConsumptionUnits(String consumptionUnits) {
        this.consumptionUnits = consumptionUnits;
    }

    @Override
    public String toString() {
        return "SocrataApiResponse{" +
                "department='" + department + '\'' +
                ", sourceType='" + sourceType + '\'' +
                ", fiscalYear=" + fiscalYear +
                ", quarter='" + quarter + '\'' +
                ", getEmissions=" + emissions +
                ", consumption=" + consumption +
                ", consumptionUnits='" + consumptionUnits + '\'' +
                '}';
    }
}
