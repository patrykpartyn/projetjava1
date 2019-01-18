package models;


import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Positive;
import java.util.Date;


@Entity
@Table(name="workers")
public class Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    @Length(min=2,max=20)
    private String firstName;

    @NotBlank
    @Length(min=2,max=20)
    private String lastName;

    @Positive
    @Max(50000)
    private Float salary;

    @Past
    @Column(name="employment_date")
    private Date employmentDate ;

    @Valid
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="type_id", nullable = false)
    private WorkerType workerType;

    @Valid
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="area_id", nullable = false)
    private WorkerWorkArea workerWorkArea;

    public Worker(){
        this.employmentDate=new Date();
        this.workerType=new WorkerType();
        this.workerWorkArea=new WorkerWorkArea();
    }

    public Worker(long id,String firstName,String lastName,Float salary,Date employmentDate,WorkerType workerType,WorkerWorkArea workerWorkArea){
        this.id=id;
        this.firstName=firstName;
        this.lastName=lastName;
        this.salary=salary;
        this.employmentDate=employmentDate;
        this.workerType=workerType;
        this.workerWorkArea=workerWorkArea;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    public Date getEmploymentDate() {
        return employmentDate;
    }

    public void setEmploymentDate(Date employmentDate) {
        this.employmentDate = employmentDate;
    }
    public WorkerType getWorkerType() {
        return workerType;
    }

    public void setWorkerType(WorkerType workerType) {
        this.workerType = workerType;
    }

    public WorkerWorkArea getWorkerWorkArea() {
        return workerWorkArea;
    }

    public void setWorkerWorkArea(WorkerWorkArea workerWorkArea) {
        this.workerWorkArea = workerWorkArea;
    }
}
