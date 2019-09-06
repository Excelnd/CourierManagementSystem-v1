package cm.model;

import cm.model.interfaces.MaintenanceInfo;

public class AirMaintenanceInfo implements MaintenanceInfo
{
    private AirVehic aircraft;
    private int lastSPFlightCount = 0;
    private double lastSPFlightHours = 0;

    private final int SERVICE_INTERVAL_FLIGHT_CNT;
    private final double SERVICE_INTERVAL_FLIGHT_HRS;

    public AirMaintenanceInfo(AirVehic vehicle, double serviceIFH, int serviceIFC)
    {
        this.SERVICE_INTERVAL_FLIGHT_CNT = serviceIFC;
        this.SERVICE_INTERVAL_FLIGHT_HRS = serviceIFH;
        this.aircraft = vehicle;
    }

    public int getLastSPFlightCount()
    {
        return lastSPFlightCount;
    }

    public double getLastSPFlightHours()
    {
        return lastSPFlightHours;
    }

    public int getServiceIntervalFLightCount()
    {
        return SERVICE_INTERVAL_FLIGHT_CNT;
    }

    public double getServiceIntervalFLightHours()
    {
        return SERVICE_INTERVAL_FLIGHT_HRS;
    }

    public AirVehic getVehicle()
    {
        return aircraft;
    }

    @Override
    public void service()
    {
        setLastSPFlightCount(aircraft.getFlightCount());
        setLastSPFlightHours(aircraft.getFlightHours());
    }

    public void setLastSPFlightCount(int lastSPFlightCount)
    {
        this.lastSPFlightCount = lastSPFlightCount;
    }

    public void setLastSPFlightHours(int lastSPFlightHours)
    {
        this.lastSPFlightHours = lastSPFlightHours;
    }



    public void setLastSPFlightHours(double lastSPFlightHours)
    {
        this.lastSPFlightHours = lastSPFlightHours;
    }

    @Override
    public boolean exceedsServicePoint(double distToTravel)
    {
        return(aircraft.estimateFlyingHours(distToTravel)
                + aircraft.getFlightHours() > lastSPFlightHours
                + SERVICE_INTERVAL_FLIGHT_HRS)
            || (AirVehic.FLIGHT_PER_JOB + aircraft.getFlightCount() > lastSPFlightCount
                + SERVICE_INTERVAL_FLIGHT_CNT);

    }

    @Override
    public String toString()
    {
        return String
                .format("Last_Service Point_FlightCount: %s, " +
                        "Last_Service Point_FlightHours: %s, ServiceInterval_FlightCount: %s," +
                        "ServiceInterval_FlightHours: %s",
                        lastSPFlightCount, lastSPFlightHours,
                        SERVICE_INTERVAL_FLIGHT_CNT,
                        SERVICE_INTERVAL_FLIGHT_HRS);
    }


}