package cm.model.interfaces;

public interface MaintenanceInfo
{
    public abstract void service();
    public abstract boolean exceedsServicePoint(double distanceToTravel);

}