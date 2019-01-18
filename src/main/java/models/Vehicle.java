package models;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.Date;

@Entity
@Table(name = "vehicles")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    //@Size(min = 2, max = 30)
    @Length(min = 2, max = 30)
    private String name;

    @NotBlank
    @Size(min = 2, max = 50)
    private String model;
    @Positive
    @Max(1000000)
    private Float price;

    @Past
    //@Temporal(TemporalType.DATE)
    @Column(name="production_date")
    private Date productionDate;

    @Valid
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="type_id", nullable = false)
    private VehicleType vehicleType;

    @Valid
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="type_door_id", nullable = false)
    private VehicleTypeDoors vehicleTypeDoors;

    @Valid
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="color_id", nullable = false)
    private VehicleColor vehicleColor;

    @Valid
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="area_id", nullable = false)
    private VehicleAreaRental vehicleAreaRental;

    @Valid
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="engine_id", nullable = false)
    private VehicleTypeEngine vehicleTypeEngine;

    @Column(name="created_date", nullable = false)
    private Date createdDate;

    @Column(name="is_broken", nullable = false)
    private boolean broken;


    public Vehicle() {
        this.createdDate = new Date();
        this.vehicleType = new VehicleType();
        this.vehicleTypeDoors=new VehicleTypeDoors();
        this.vehicleColor=new VehicleColor();
        this.vehicleAreaRental=new VehicleAreaRental();
        this.vehicleTypeEngine=new VehicleTypeEngine();
    }
//    VehicleAreaRental vehicleAreaRental,
    public Vehicle(long id, String name, String model, Float price, Date productionDate, VehicleType vehicleType,VehicleTypeDoors vehicleTypeDoors,VehicleColor vehicleColor,VehicleAreaRental vehicleAreaRental, VehicleTypeEngine vehicleTypeEngine, Date creationDate) {
        this.id = id;
        this.name = name;
        this.model = model;
        this.price = price;
        this.productionDate = productionDate;
        this.vehicleType = vehicleType;
        this.vehicleTypeDoors=vehicleTypeDoors;
        this.vehicleColor=vehicleColor;
        this.vehicleAreaRental= vehicleAreaRental;
        this.vehicleTypeEngine=vehicleTypeEngine;
        this.createdDate = creationDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Date getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setCreatedDate(Date creationDate) {
        this.createdDate = creationDate;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public boolean isBroken() {
        return broken;
    }

    public VehicleTypeDoors getVehicleTypeDoors() {
        return vehicleTypeDoors;
    }

    public void setVehicleTypeDoors(VehicleTypeDoors vehicleTypeDoors) {
        this.vehicleTypeDoors = vehicleTypeDoors;
    }

    public void setBroken(boolean broken) {
        this.broken = broken;
    }

    public VehicleColor getVehicleColor() {
        return vehicleColor;
    }

    public void setVehicleColor(VehicleColor vehicleColor) {
        this.vehicleColor = vehicleColor;
    }

    public VehicleAreaRental getVehicleAreaRental() {
        return vehicleAreaRental;
    }

    public void setVehicleAreaRental(VehicleAreaRental vehicleAreaRental) {
        this.vehicleAreaRental = vehicleAreaRental;
    }
    public VehicleTypeEngine getVehicleTypeEngine() {
        return vehicleTypeEngine;
    }

    public void setVehicleTypeEngine(VehicleTypeEngine vehicleTypeEngine) {
        this.vehicleTypeEngine = vehicleTypeEngine;
    }
}
