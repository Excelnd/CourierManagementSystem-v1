package cm.model;

import cm.model.interfaces.Vehic;

public class Job
{
    private double cost;
    private double distance;
    private String jobID;
    private Vehic vehicle;

    public Job(String jobID, double distance, Vehic vehicle, double cost)
    {
        this.jobID = jobID;
        this.distance = distance;
        this.vehicle = vehicle;
        this.cost = cost;
    }

    public double getCost()
    {
        return cost;
    }

    public Vehic getVehicle()
    {
        return vehicle;
    }

    public String getJobID()
    {
        return jobID;
    }

        public String toString()
        {
            return String.format(
                    "JobID: %s, Distance: %s, Cost: %s, (Vehicle : %s)", jobID,
            distance, cost, vehicle.getRegNo());
        }
}