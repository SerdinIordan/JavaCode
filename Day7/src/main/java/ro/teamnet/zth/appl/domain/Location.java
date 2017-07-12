package ro.teamnet.zth.appl.domain;

import ro.teamnet.zth.api.annotations.Column;
import ro.teamnet.zth.api.annotations.Id;
import ro.teamnet.zth.api.annotations.Table;

/**
 * Created by Iordan.Serdin on 7/12/2017.
 */
@Table(name="Locations")
public class Location {
    @Id(name="LOCATION_ID")
    private Long id;
    @Column(name="STREET_ADRESS")
    private String streetAdress;
    @Column(name="POSTAL_CODE")
    private String postalCode;
    @Column(name="CITY")
    private String city;
    @Column(name="STATE_PROVINCE")
    String stateProvince;

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreetAdress() {
        return streetAdress;
    }

    public void setStreetAdress(String streetAdress) {
        this.streetAdress = streetAdress;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStateProvince() {
        return stateProvince;
    }

    public void setStateProvince(String stateProvince) {
        this.stateProvince = stateProvince;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", streetAdress='" + streetAdress + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", city='" + city + '\'' +
                ", stateProvince='" + stateProvince + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Location location = (Location) o;

        if (id != location.id) return false;
        if (streetAdress != null ? !streetAdress.equals(location.streetAdress) : location.streetAdress != null)
            return false;
        if (postalCode != null ? !postalCode.equals(location.postalCode) : location.postalCode != null) return false;
        if (city != null ? !city.equals(location.city) : location.city != null) return false;
        return stateProvince != null ? stateProvince.equals(location.stateProvince) : location.stateProvince == null;
    }


}
