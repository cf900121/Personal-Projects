package com.company;

public class Room {

    private String name;
    private String fullName;
    private String status;

    //***********************************//

    public Room() {
    }

    public Room(String name) {
        this.name = name;
        this.status = "No work has been done on this room";
    }

    // this constructor is to add the function of checking what abbreviations mean with the use of a full name attribute
    public Room(String name, String fullName, String status) {
        this.name = name;
        this.fullName = fullName;
        this.status = status;
    }

    //***********************************//

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status + "\n";
    }

    public void setStatus(String status) {
        this.status = status;
    }

    //***********************************//

    public void clean(){
        System.out.println("The room has been cleaned");
        setStatus("Cleaned");
    }

    public void furnitureOut(){
        System.out.println("The furniture has been moved out");
        setStatus("Furniture Out");
    }

    public void furnitureIn(){
        System.out.println("The furniture has been moved in");
        setStatus("This room is complete");
    }

    public void scrub(){
        System.out.println("The room has been scrubbed");
        setStatus("Scrubbed");
    }

    public void wax(int coats){
        System.out.println("The room has been waxed");
        setStatus(coats + " coats of wax");
    }

    //***********************************//

    public boolean anyWorkDone(){
        if(status.equals("No work has been done on this room"))
            return false;
        return true;
    }

    public boolean roomComplete(){
        if(status.equals("This room is complete"))
            return true;
        return false;
    }

}
