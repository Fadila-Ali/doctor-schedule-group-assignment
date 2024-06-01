package model;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
public class DoctorSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int scheduleId;
    private String scheduleType;
    @Column(columnDefinition = "TIMESTAMP(0)")
    private Timestamp timestamp;

    public DoctorSchedule(String scheduleType, Timestamp timestamp) {
        this.scheduleType = scheduleType;
        this.timestamp = timestamp;
    }

    public DoctorSchedule() {}

    public int getScheduleId() {
        return scheduleId;
    }

    public String getScheduleType() {
        return scheduleType;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }

    public void setScheduleType(String scheduleType) {
        this.scheduleType = scheduleType;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "DoctorSchedule{" +
                "scheduleId=" + scheduleId +
                ", scheduleType='" + scheduleType + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
