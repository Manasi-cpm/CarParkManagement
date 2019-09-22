/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carparkingmanagement;

import java.util.Scanner;

public class CarParkingManagement {
       
    //sample input  pABC,pPQR,pGHF,uPQR
    private static SlotOperation slotmanager = new SlotOperation();
    private static int ticketNumber = 5000;

    public static void main(String[] args) {
        slotmanager.initialise();
        System.out.println("Welcome to car park management console");
        System.out.println("Please input your command (Type quit to exit)");
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println(processInput(sc.nextLine()));
        }
    }

    private static String processInput(String input) {
        if (input.toLowerCase().equals("quit")) {
            System.exit(0);
        }
        if (input.endsWith(",")) {
            return "Input is incomplete. Please remove ',' from the end.";
        } else if (input.isEmpty()) {
            return "Empty input.";
        } else {
            String[] inputArray = input.split(",");
            for (String s : inputArray) {
                switch (s.charAt(0)) {
                    case 'p':
                        slotmanager.ParkCar(s.substring(1), ticketNumber);
                        ticketNumber++;
                        break;
                    case 'u':         
                        if(!slotmanager.UnParkCar(s.substring(1)))
                           System.out.println(s.substring(1) +" Car can not found in parking! ");
                        break;
                    case 'c':
                        slotmanager.compact();
                        break;
                }
            }
            return slotmanager.printSlot(); // carParkService.getCurrentParkingOrder();
        }
    }
}
