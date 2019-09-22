package carparkingmanagement;

import java.util.Arrays;

class SlotOperation {

    private slot slot[];
    private final int slotsize=10;

    public SlotOperation() {
        slot = new slot[slotsize];
    }

    public void initialise(){
        for(int i=0;i<slotsize;i++){
            slot[i]=new slot();
            slot[i].setLicencePlate("");
            slot[i].setTicketNumber(0);
            
        }
    }
    public boolean ParkCar(String carnoplate, int ticktNumber) {
        Boolean slotfound = false;
        for (int i = 0; i < 10; i++) {
                if (slot[i].getLicencePlate().length() == 0) {
                    slot[i].setLicencePlate(carnoplate);
                    slot[i].setTicketNumber(ticktNumber);
                    slotfound = true;
                    return slotfound;
            }
        }
        return false;
    }

    public boolean UnParkCar(String carnoplate) {
        //return 1 if car found and unparked
        //return 0 if car not found
        Boolean slotfound = false;
        Boolean unparkedcar =false;
        for (int i = 0; i < 10; i++) {
            if (slot[i].getLicencePlate().equals(carnoplate)) {
                slotfound = true;
                slot[i].setLicencePlate("");
                slot[i].setTicketNumber(0);
                unparkedcar=true;
            }
        }
        return unparkedcar;        
    }

    public String printSlot() {
        String output[] =new String[10];
        for (int i = 0; i < 10; i++) {
            output[i] = slot[i].licencePlate;
        }
        return Arrays.toString(output);
    }
    
    public void compact(){
        
    }
}
