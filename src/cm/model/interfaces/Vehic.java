package cm.model.interfaces;

public interface Vehic
{
    public double calculateWearAndTear(double distance);
    public abstract String getRegNo();
    public abstract String getMake();
    public abstract double getOdomtr();
    public abstract int getYear();

    // @see MaintenanceInfo#service(double)

    public abstract void service();

    // @see MaintenanceInfo#wouldExceedServicePoint(double, double)

    public abstract boolean canTravel(double distance);
    public abstract double travel(double distance);



}
