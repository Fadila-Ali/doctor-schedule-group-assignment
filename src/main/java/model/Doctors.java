package model;


import jakarta.persistence.*;

@Entity
public class Doctors {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int doctorId;
    private String doctorName;
    @ManyToOne
    private Hospital hospitalName;
    @OneToOne
            (cascade = CascadeType.ALL)
    private DoctorSchedule doctorSchedule;

    public Doctors( String doctorName) {
        this.doctorName = doctorName;
    }

    public Doctors() {}

    public Doctors(Hospital hospitalName, DoctorSchedule doctorSchedule, String doctorName) {
        this.hospitalName = hospitalName;
        this.doctorSchedule = doctorSchedule;
        this.doctorName = doctorName;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public Hospital getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(Hospital hospitalName) {
        this.hospitalName = hospitalName;
    }

    public DoctorSchedule getDoctorSchedule() {
        return doctorSchedule;
    }

    public void setDoctorSchedule(DoctorSchedule doctorSchedule) {
        this.doctorSchedule = doctorSchedule;
    }

    @Override
    public String toString() {
        return "Doctors{" +
                "doctorId=" + doctorId +
                ", doctorName='" + doctorName + '\'' +
                ", hospitalName=" + hospitalName +
                ", doctorSchedule=" + doctorSchedule +
                '}';
    }
}
