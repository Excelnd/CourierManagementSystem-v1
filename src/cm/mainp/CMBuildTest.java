package cm.mainp;

import cm.model.AbstractVehic;
import cm.model.Aircraft;
import cm.model.CourierManagementSystemImp;
import cm.model.Truck;
import cm.model.Van;
import cm.model.interfaces.CourierManagementSystem;
import cm.model.interfaces.Vehic;




public class CMBuildTest
{
    private CourierManagementSystem cms;
    private Vehic[] testVehicles = new Vehic[]
            {
                    new Van("v1", "BMW", "Sienna", 1999, 500.0),
                    new Van("v3", "Volkswagen", "Polo", 2009, 1000.0),
                    new Truck("t1", "Burri", "464", 1992, 2000.0, 3000),
                    new Truck("t2", "Burri", "386", 2005, 2000.0, 3500),
                    new Aircraft("a1", "Etihad", "914", 2003, 1215, 6, 30),
                    new Aircraft("a2", "Etihad", "707", 1979, 1215, 6, 20),
                    new Aircraft("a3", "Lockheed", "M43QC CN", 1970, 1115, 3, 10)
            };

    public CMBuildTest()
    {
        cms = new CourierManagementSystemImp();
    }

    // Tests adding, retrieving and removing LandVehicles & Aircrafts.
    public boolean test1()
    {
        displayTitle("Test1(Add, Get and Remove Vertices)");
        for(int i=0;i<testVehicles.length;i++)
        {
            cms.addVehicle(testVehicles[i]);

            Vehic v = cms.getVehicle(testVehicles[i].getRegNo());
            if(!checkEqual(v, testVehicles[i]))
            {
            System.out.println("Failed to add vechile "+testVehicles[i].getRegNo());
            return false;
            }

        }

    // Remove all Vehicles
        for(int i=0;i<testVehicles.length;i++)
        {
            cms.removeVehicle(testVehicles[i].getRegNo());
            if(cms.getVehicle(testVehicles[i].getRegNo())!=null)
            {
            System.out.println("Failed to remove vehicle "
            +testVehicles[i].getRegNo());
            return false;
            }
        }
        return true;
    }


    // put it into the class
    public boolean test2()
    {
        displayTitle("Test2 ( Scheduling jobs to a Land Vehicle(Van)");
        cms.addVehicle(testVehicles[1]);
        boolean correctlySchedule = true;

        correctlySchedule &= cms.scheduleJob(700, "v2");
        correctlySchedule &= !cms.scheduleJob(500, "v2");
        correctlySchedule &= cms.scheduleJob(100, "v2");
        correctlySchedule &= !cms.scheduleJob(300, "v2");

        if(!correctlySchedule)
            {
                System.out.println("Failed to accurately schedule OR reject one or" +
            " more jobs to a Van");
            }
        cms.removeVehicle("v2");
        return correctlySchedule;

    }

    public boolean test3()
    {
        displayTitle("Test3 (Scheduling jobs to an Aircraft");
        cms.addVehicle(testVehicles[6]);
        boolean correctlySchedule = true;

        correctlySchedule &= cms.scheduleJob(4200, "a3");
        correctlySchedule &= cms.scheduleJob(5100, "a3");
        correctlySchedule &= !cms.scheduleJob(3000, "a3");
        correctlySchedule &= cms.scheduleJob(500, "a3");
        correctlySchedule &= !cms.scheduleJob(300, "a3");

        if(!correctlySchedule)
        {
            System.out.println("Failed to accurately schedule OR reject one or" +
        " more jobs to a Aircraft");
        }
        cms.removeVehicle("a3");
        return correctlySchedule;

    }

    public boolean test4()
    {
        displayTitle("Test4 (Servicing Land Vehicle(Van) and Aircraft) ");

        cms.addVehicle(testVehicles[0]);
        boolean correctlySchedVan = true;

        correctlySchedVan &= cms.scheduleJob(400, "v1");
        correctlySchedVan &= !cms.scheduleJob(400, "v1");

        cms.serviceVehicle("v1");

        correctlySchedVan &= cms.scheduleJob(400, "v1");

        if(!correctlySchedVan)
        {
            System.out.println("Failed to correctly Service Van");
            return false;
        }

        boolean correctlySchedAircraft = true;
        cms.addVehicle(testVehicles[5]);

        correctlySchedAircraft &= cms.scheduleJob(15000.0, "a2");
        correctlySchedAircraft &= !cms.scheduleJob(15000.0, "a2");

        cms.serviceVehicle("a2");

        correctlySchedAircraft &= cms.scheduleJob(15000.0, "a2");

        if(!correctlySchedAircraft)
        {
            System.out.println("Failed to correctly service an Aircraft");
            return false;
        }
        return true;
    }

    public boolean testAll()
    {
        boolean allPass = true;
        if((allPass &= test1()))
            System.out.println("PASSED");
        if((allPass &= test2()))
            System.out.println("PASSED");
        if((allPass &= test3()))
            System.out.println("PASSED");
        if((allPass &= test4()))
            System.out.println("PASSED");

        return allPass;
    }

    // @param v
    // @param vehicle
    private boolean checkEqual(Vehic given, Vehic expected)
    {
        if(given == null)
            return expected == null;
        return given.equals(expected);
    }

    // @param string
    private void displayTitle(String title)
    {
        System.out.println(String.format("%010d%s%015d", 0, title, 0).replace(
                                            "0", "-"));
    }

    public static void main(String args[])
    {
        System.out.println(new CMBuildTest().testAll() ?
            "\nRESULT:\n\tAll Tests Passed!!!"
                : "\nRESULT:\n\tSome Tests Failed!");
    }


}