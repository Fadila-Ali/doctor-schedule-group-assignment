package model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Specialty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int specialtyId;
    private String specialtyName;

    public Specialty(String specialtyName) {
        this.specialtyName = specialtyName;
    }

    public Specialty() {}

    @OneToMany(targetEntity = Doctors.class, cascade = CascadeType.ALL)
    private Set<Doctors> doctors;

    public int getSpecialtyId() {
        return specialtyId;
    }

    public void setSpecialtyId(int specialtyId) {
        this.specialtyId = specialtyId;
    }

    public Specialty(String specialtyName, Set<Doctors> doctors) {
        this.specialtyName = specialtyName;
        this.doctors = doctors;
    }

    public String getSpecialtyName() {
        return specialtyName;
    }

    public void setSpecialtyName(String specialtyName) {
        this.specialtyName = specialtyName;
    }

    public Set<Doctors> getDoctors() {
        return doctors;
    }

    public void setDoctors(Set<Doctors> doctors) {
        this.doctors = doctors;
    }

    @Override
    public String toString() {
        return "Specialty{" +
                "specialtyId=" + specialtyId +
                ", specialtyName='" + specialtyName + '\'' +
                ", doctors=" + doctors +
                '}';
    }
}
