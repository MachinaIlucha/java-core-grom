package hibernate.lesson3.DZ;

import javax.persistence.*;

@Entity
@Table(name = "HOTELS")
public class Hotel {

    private long HOTEL_ID;
    private String NAMEOFHOTEL;
    private String COUNTRY;
    private String CITY;
    private String STREET;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PR_SEQ")
    @Column(name = "HOTEL_ID")
    public long getHOTEL_ID() {
        return HOTEL_ID;
    }

    public void setHOTEL_ID(long HOTEL_ID) {
        this.HOTEL_ID = HOTEL_ID;
    }

    @Column(name = "NAMEOFHOTEL")
    public String getNAMEOFHOTEL() {
        return NAMEOFHOTEL;
    }

    public void setNAMEOFHOTEL(String NAMEOFHOTEL) {
        this.NAMEOFHOTEL = NAMEOFHOTEL;
    }

    @Column(name = "COUNTRY")
    public String getCOUNTRY() {
        return COUNTRY;
    }

    public void setCOUNTRY(String COUNTRY) {
        this.COUNTRY = COUNTRY;
    }

    @Column(name = "CITY")
    public String getCITY() {
        return CITY;
    }

    public void setCITY(String CITY) {
        this.CITY = CITY;
    }

    @Column(name = "STREET")
    public String getSTREET() {
        return STREET;
    }

    public void setSTREET(String STREET) {
        this.STREET = STREET;
    }
}
