package cm.model;
import cm.model.interfaces.MaintenanceInfo;

public abstract class AirVehic extends AbstractVehic
{
    public static final int FLIGHT_PER_JOB = 1;

    private int flightCnt = 0;
    private double flightHours = 0.0;
    private double avgSpeed = 0;
    private MaintenanceInfo airMInfo;

    public AirVehic(String regNo, String make, String model, int year,
                    double avgSpeed, int sFlightCountInterval,
                    double sFlightHoursInterval)
    {
        super(regNo, make, model, year);
        this.setAvgSpeed(avgSpeed);

        airMInfo = new AirMaintenanceInfo(this,
                sFlightHoursInterval, sFlightCountInterval);
    }

    @Override
    public boolean canTravel(double distance)
    {
        return !airMInfo.exceedsServicePoint(distance);
    }

    @Override
    public void service()
    {
        airMInfo.service();
    }

    @Override
    public double travel(double distance)
    {
        flightHours += estimateFlyingHours(distance);
        flightCnt += FLIGHT_PER_JOB;
        return calculateWearAndTear(distance);
    }

    public double estimateFlyingHours(double distance)
    {
        return distance / avgSpeed;
    }

    public int getFlightCount()
    {
        return flightCnt;
    }

    double getFlightHours()
    {
        return flightHours;
    }

    public void setAvgSpeed(double avgSpeed)
    {
        this.avgSpeed = avgSpeed;
    }

    @Override
    public String toString()
    {
        return super.toString()
                + String.format(
                        ", Av_Speed: %s, FlightCount: %s,FlightHours: %s, %s",
                avgSpeed, flightCnt, flightHours, airMInfo);

    }

    public double getAvgSpeed()
    {
        return avgSpeed;
    }
}