package cm.model;

import cm.model.interfaces.MaintenanceInfo;

public class LandMaintenanceInfo implements MaintenanceInfo
{
    private double lastServicePoint = 0.0;
    private final double SERVICE_INTERVAL;
    private LandVehic landVehic;

    public LandMaintenanceInfo(LandVehic vehic, double serviceInterval)
    {
        SERVICE_INTERVAL = serviceInterval;
        this.landVehic = vehic;
    }

    public double getLastServicePoint()
    {
        return lastServicePoint;
    }

    public double getNextServicePoint()
    {
        return lastServicePoint + SERVICE_INTERVAL;
    }

    public double getServiceInterval()
    {
        return SERVICE_INTERVAL;
    }

    public LandVehic getVehic()
    {
        return landVehic;
    }

    @Override
    public void service()
    {
        lastServicePoint = landVehic.getOdomtr();
    }

    @Override
    public String toString()
    {
        return String.format("Last_Service_Point: %s, Service_Interval: %s",
                lastServicePoint, SERVICE_INTERVAL);
    }

    @Override
    public boolean exceedsServicePoint(double distanceToTravel)
    {
        return(landVehic.getOdomtr() + distanceToTravel) > getNextServicePoint();
    }

}

