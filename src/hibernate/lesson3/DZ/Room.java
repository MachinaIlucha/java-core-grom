package hibernate.lesson3.DZ;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ROOMS")
public class Room {

    private long ROOM_ID;
    private int NUMBEROFGUESTS;
    private double PRICE;
    private int BREAKFASTINCLUDED;
    private int PETSALLOWED;
    private Date DATEAVAILABLEFROM;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="HOTEL_ID")
    private Hotel hotel;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PR_SEQ")
    @Column(name = "ROOM_ID")
    public long getROOM_ID() {
        return ROOM_ID;
    }

    public void setROOM_ID(long ROOM_ID) {
        this.ROOM_ID = ROOM_ID;
    }

    @Column(name = "NUMBEROFGUESTS")
    public int getNUMBEROFGUESTS() {
        return NUMBEROFGUESTS;
    }

    public void setNUMBEROFGUESTS(int NUMBEROFGUESTS) {
        this.NUMBEROFGUESTS = NUMBEROFGUESTS;
    }

    @Column(name = "PRICE")
    public double getPRICE() {
        return PRICE;
    }

    public void setPRICE(double PRICE) {
        this.PRICE = PRICE;
    }

    @Column(name = "BREAKFASTINCLUDED")
    public int getBREAKFASTINCLUDED() {
        return BREAKFASTINCLUDED;
    }

    public void setBREAKFASTINCLUDED(int BREAKFASTINCLUDED) {
        this.BREAKFASTINCLUDED = BREAKFASTINCLUDED;
    }

    @Column(name = "PETSALLOWED")
    public int getPETSALLOWED() {
        return PETSALLOWED;
    }

    public void setPETSALLOWED(int PETSALLOWED) {
        this.PETSALLOWED = PETSALLOWED;
    }

    @Column(name = "DATEAVAILABLEFROM")
    public Date getDATEAVAILABLEFROM() {
        return DATEAVAILABLEFROM;
    }

    public void setDATEAVAILABLEFROM(Date DATEAVAILABLEFROM) {
        this.DATEAVAILABLEFROM = DATEAVAILABLEFROM;
    }

    @Column(name = "HOTEL_ID")
    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
}
