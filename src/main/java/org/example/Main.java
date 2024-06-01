package org.example;

import model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        Hospital hospital1 = new Hospital("St. John", "21 West side Queens, NY");
        Hospital hospital2 = new Hospital("Marie Memorial", "100 GreensBoro, NC");

        session.persist(hospital1);
        session.persist(hospital2);

        Timestamp timestamp1 = Timestamp.valueOf("2024-06-01 09:00:00");
        Timestamp timestamp2 = Timestamp.valueOf("2024-07-21 09:30:00");
        Timestamp timestamp3 = Timestamp.valueOf("2024-06-11 10:00:00");
        Timestamp timestamp4 = Timestamp.valueOf("2024-06-21 11:30:00");

        DoctorSchedule doctorSchedule1 = new DoctorSchedule("Annual visit", timestamp1);
        DoctorSchedule doctorSchedule2 = new DoctorSchedule("Xray", timestamp2);
        DoctorSchedule doctorSchedule3 = new DoctorSchedule("Annual visit", timestamp4);
        DoctorSchedule doctorSchedule4 = new DoctorSchedule("Surgery", timestamp3);

        session.persist(doctorSchedule1);
        session.persist(doctorSchedule2);
        session.persist(doctorSchedule3);
        session.persist(doctorSchedule4);

        Doctors doctor1 = new Doctors(hospital1, doctorSchedule2, "Mike");
        Doctors doctor2 = new Doctors(hospital2, doctorSchedule1, "Diane");
        Doctors doctor3 = new Doctors(hospital2, doctorSchedule4,"John");
        Doctors doctor4 = new Doctors(hospital1, doctorSchedule3,"Alex");
        Doctors doctor5 = new Doctors("Jane");

        session.persist(doctor1);
        session.persist(doctor2);
        session.persist(doctor3);
        session.persist(doctor4);
        session.persist(doctor5);

        Set<Doctors> doctorsSet1 = new HashSet<>();
        doctorsSet1.add(doctor1);
        doctorsSet1.add(doctor2);

        Set<Doctors> doctorsSet2 = new HashSet<>();
        doctorsSet2.add(doctor3);
        doctorsSet2.add(doctor4);
        doctorsSet2.add(doctor5);

        Specialty specialty1 = new Specialty("OBGYN", doctorsSet1);
        Specialty specialty2 = new Specialty("Cardiology", doctorsSet2);

        session.persist(specialty1);
        session.persist(specialty2);

        Set<Doctors> setDoctors1 = new HashSet<>();
        setDoctors1.add(doctor1);
        setDoctors1.add(doctor3);

        Set<Doctors> setDoctors2 = new HashSet<>();
        setDoctors2.add(doctor4);
        setDoctors2.add(doctor5);
        setDoctors2.add(doctor2);

        Patients patients1 = new Patients("Luis", "45 Eastside, New York, NY", setDoctors2);
        Patients patients2 = new Patients("Omar", "90 Eastern, New York, NY", setDoctors1);
        Patients patients3 = new Patients("Pete", "42 Brownsville Bronx, NY", setDoctors2);
        Patients patients4 = new Patients("Lauren", "77 Atlantic avenue, NY", setDoctors1);

        session.persist(patients1);
        session.persist(patients2);
        session.persist(patients3);
        session.persist(patients4);

        transaction.commit();

    }
}