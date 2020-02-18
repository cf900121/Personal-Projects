package com.company;

import java.io.*;
import java.util.*;
import java.util.ArrayList;

public class Main {

    private static Scanner kb = new Scanner(System.in);
    private static ArrayList<Room> building = new ArrayList<Room>();

    //***********************************//

    public static void main(String[] args)throws Exception{

        createList();
        mainMenu();

    }

    public static void mainMenu(){
        System.out.println("***********************************");
        System.out.println("0 - List All Rooms");
        System.out.println("1 - List Completed Rooms");
        System.out.println("2 - List Uncompleted Rooms");
        System.out.println("3 - List In Progress Rooms");
        System.out.println("4 - Check Room Status");
        System.out.println("5 - Change Room Status");
        System.out.println("***********************************");

        int choice = kb.nextInt();

        switch(choice){
            case 0:
                listAllRooms();
                mainMenu();
                break;
            case 1:
                listComplete();
                mainMenu();
                break;
            case 2:
                listIncomplete();
                mainMenu();
                break;
            case 3:
                listInProgress();
                mainMenu();
                break;
            case 4:
                checkStatus();
                mainMenu();
                break;
            case 5:
                changeStatus();
                mainMenu();
                break;

        }
    }

    //***********************************//

    public static void listAllRooms(){
        System.out.println("All rooms in this building: ");
        for(int i = 0; i < building.size(); i++){
            if(i % 9 == 0)
                System.out.println();
            System.out.print(building.get(i).getName() + " - ");
        }
        System.out.println("\n");
    }

    public static void listComplete(){
        System.out.println("Completed Rooms: ");
        for(int i = 0; i < building.size(); i++){
            if(i % 9 == 0)
                System.out.println();
            if(building.get(i).roomComplete())
                System.out.print(building.get(i).getName() + " - ");
            else
                System.out.print("    - ");
        }
        System.out.println("\n");
    }

    public static void listIncomplete(){
        System.out.println("Uncompleted Rooms: ");
        for(int i = 0; i < building.size(); i++){
            if(i % 9 == 0)
                System.out.println();
            if(building.get(i).roomComplete() == false)
                System.out.print(building.get(i).getName() + " - ");
            else
                System.out.print("    - ");
        }
        System.out.println("\n");
    }

    public static void listInProgress(){
        System.out.println("In Progress Rooms: ");
        for(int i = 0; i < building.size(); i++){
            if(i % 9 == 0)
                System.out.println();
            if(building.get(i).roomComplete() == false && building.get(i).anyWorkDone() == true)
                System.out.print(building.get(i).getName() + " - ");
            else
                System.out.print("    - ");
        }
        System.out.println("\n");
    }

    public static void checkStatus(){

        kb.nextLine(); // I'm not sure what is making me require this. Check it out later

        Room room = new Room();
        boolean validate = false;

        while (validate == false) {
            System.out.println("What room would you like to check?");
            String roomName = kb.nextLine();
            room = findRoom(roomName);
            if(room != null)
                validate = true;
            else
                System.out.println("This room does not exist.");
        }

        System.out.println(room.getName() + " Status: " + room.getStatus());
    }

    public static void changeStatus(){

        kb.nextLine(); // I'm not sure what is making me require this. Check it out later

        Room room = new Room();
        boolean validate = false;

        while (validate == false) {
            System.out.println("What room would you like to change?");
            String roomName = kb.nextLine();
            room = findRoom(roomName);
            if(room != null)
                validate = true;
            else
                System.out.println("This room does not exist.");
        }

        System.out.println("What would you like to change?");
        System.out.println("0 - Clean");
        System.out.println("1 - Move furniture out");
        System.out.println("2 - Scrub");
        System.out.println("3 - Wax");
        System.out.println("4 - Move Furniture in");
        int change = kb.nextInt();

        switch(change){
            case 0:
                room.clean();
                System.out.println(room.getName() + " Status: " + room.getStatus());
                break;
            case 1:
                room.furnitureOut();
                System.out.println(room.getName() + " Status: " + room.getStatus());
                break;
            case 2:
                room.scrub();
                System.out.println(room.getName() + " Status: " + room.getStatus());
                break;
            case 3:
                System.out.println("Which coat? (1,2,3)");
                int coat = kb.nextInt();
                room.wax(coat);
                System.out.println(room.getName() + " Status: " + room.getStatus());
                break;
            case 4:
                room.furnitureIn();
                System.out.println(room.getName() + " Status: " + room.getStatus());
                break;

        }
    }

    //***********************************//

    public static Room findRoom(String roomName){
        for(int i = 0; i < building.size(); i++){
            if(building.get(i).getName().equalsIgnoreCase(roomName))
                return building.get(i);
        }
        return null;
    }

    public static void createList()throws Exception{
        Scanner stdln = new Scanner(new File("MiddleSchoolRooms.txt"));

        for(int i = 0; stdln.hasNextLine(); i++){
            building.add(new Room(stdln.nextLine()));
        }
        stdln.close();
    }

}
