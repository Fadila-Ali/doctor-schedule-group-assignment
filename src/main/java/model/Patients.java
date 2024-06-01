package model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Patients {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int patientId;
    private String patientName;
    private String patientAddress;

    public Patients(String patientName, String patientAddress) {
        this.patientName = patientName;
        this.patientAddress = patientAddress;
    }

    public Patients () {}

    @ManyToMany(targetEntity = Doctors.class)
    private Set<Doctors> doctor;

    public Patients(String patientName, String patientAddress, Set<Doctors> doctor) {
        this.patientName = patientName;
        this.patientAddress = patientAddress;
        this.doctor = doctor;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientAddress() {
        return patientAddress;
    }

    public void setPatientAddress(String patientAddress) {
        this.patientAddress = patientAddress;
    }

    public Set<Doctors> getDoctor() {
        return doctor;
    }

    public void setDoctor(Set<Doctors> doctor) {
        this.doctor = doctor;
    }

    @Override
    public String toString() {
        return "Patients{" +
                "patientId=" + patientId +
                ", patientName='" + patientName + '\'' +
                ", patientAddress='" + patientAddress + '\'' +
                ", doctor=" + doctor +
                '}';
    }
}
