package cm.model;

import java.util.ArrayList;
import java.util.List;

import cm.model.interfaces.CourierManagementSystem;
import cm.model.interfaces.Vehic;


public class CourierManagementSystemImp implements CourierManagementSystem
{
    private List<Job> jobs = new ArrayList<Job>();
    private List<Vehic> vehics = new ArrayList<Vehic>();

    @Override
    public boolean addVehicle(Vehic v)
    {
        return vehics.add(v);
    }

    @Override
    public boolean removeVehicle(String vehicleRegNo)
    {
        Vehic v = getVehicle(vehicleRegNo);
        return vehics.remove(v);
    }

    @Override
    public void displayAllJobs()
    {
        for(Job j: jobs) {
            System.out.println(j);
        }
    }

    @Override
    public void displayAllVehicles()
    {
        for(Vehic v: vehics)
        {
            System.out.println(v);
        }
    }


    @Override
    public void displayJobInfo(String jobID)
    {
        Job j = getJob(jobID);
        if(j != null)
            System.out.println(j);

    }

    @Override
    public void displayVehicleInfo(String regNo)
    {
        Vehic v = getVehicle(regNo);
        if(v != null)
            System.out.println(v);
    }

    @Override
    public Job getJob(String jobID)
    {
        for(Job j : jobs)
        {
            if(j.getJobID().equals(jobID))
                return j;
        }
        return null;
    }


    @Override
    public void serviceVehicle(String regNo)
    {
        Vehic toService = getVehicle(regNo);
        if(toService != null)
            toService.service();
    }

    @Override
    public Vehic getVehicle(String regNo)
    {
        for(Vehic v: vehics)
        {
            if(v.getRegNo().equals(regNo))
                return v;
        }
        return null;
    }

    @Override
    public boolean scheduleJob(double distance, String regNo)
    {
        Vehic vehicleToAssign = getVehicle(regNo);
        if(vehicleToAssign == null || !vehicleToAssign.canTravel(distance))
            return false;

        String jobID = "job" + jobs.size();
        jobs.add(new Job(jobID, distance, vehicleToAssign,
                vehicleToAssign.calculateWearAndTear(distance)));
        vehicleToAssign.travel(distance);
        return true;
    }

}