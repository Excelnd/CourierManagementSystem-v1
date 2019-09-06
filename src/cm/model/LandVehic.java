package cm.model;

import cm.model.interfaces.MaintenanceInfo;

public abstract  class LandVehic extends AbstractVehic
{
    private double odomtr = 0.0;
    private MaintenanceInfo landMInfo;

    public LandVehic(String regNo, String make, String model, int year,
                     double serviceInterval)
    {
        super(regNo, make, model, year);

        landMInfo = new LandMaintenanceInfo(this, serviceInterval);
    }

    @Override
    public boolean canTravel(double distance)
    {
        return !landMInfo.exceedsServicePoint(distance);
    }

    @Override
    public void service()
    {
        landMInfo.service();
    }

    @Override
    public String toString()
    {
        return super.toString()
                + String.format(", Current_OdoMeter: %s km, %s",
                odomtr, landMInfo);
    }

    public double travel(double distance)
    {
        double wearAndTear = calculateWearAndTear(distance);
        odomtr += distance;
        return wearAndTear;
    }

}