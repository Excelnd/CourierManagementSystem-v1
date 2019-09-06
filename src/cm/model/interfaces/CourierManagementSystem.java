package cm.model.interfaces;

import cm.model.Job;

public interface CourierManagementSystem
{
    public abstract boolean addVehicle(Vehic v);
    public abstract void displayAllJobs();
    public abstract boolean removeVehicle(String vehicleRegNo);
    public abstract void displayAllVehicles();
    public abstract void displayJobInfo(String jobID);
    public abstract void displayVehicleInfo(String regNo);
    public abstract Job getJob(String jobID);
    public abstract void serviceVehicle(String regNo);
    public abstract Vehic getVehicle(String regNo);
    public abstract boolean scheduleJob(double distance, String regNo);
}