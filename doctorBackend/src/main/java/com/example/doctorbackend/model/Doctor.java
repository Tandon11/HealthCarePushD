package com.example.doctorbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;


@Entity
@SequenceGenerator(name= "DOCTOR_SEQUENCE", initialValue=1, allocationSize = 1)
public class Doctor {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DOCTOR_SEQUENCE")
    private Long Id;

    private String fname;
    private String lname;
    private String gender;
    private String highest_qual;
    private String username;
    private String contact_no;
    private String is_Avail;
    private String password;

//    @JsonIgnore
    @OneToMany(mappedBy = "doctor")
    private List<Patient> patient;

    @JsonManagedReference
    public List<Patient> getPatient() {
        return patient;
    }

    public void setPatient(List<Patient> patient) {
        this.patient = patient;
    }

    public Doctor() {
    }

    public Doctor(Long id, String fname, String lname, String gender, String highest_qual, String username, String contact_no, String is_Avail, String password, List<Patient> patient) {
        Id = id;
        this.fname = fname;
        this.lname = lname;
        this.gender = gender;
        this.highest_qual = highest_qual;
        this.username = username;
        this.contact_no = contact_no;
        this.is_Avail = is_Avail;
        this.password = password;
        this.patient = patient;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHighest_qual() {
        return highest_qual;
    }

    public void setHighest_qual(String highest_qual) {
        this.highest_qual = highest_qual;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContact_no() {
        return contact_no;
    }

    public void setContact_no(String contact_no) {
        this.contact_no = contact_no;
    }

    public String getIs_Avail() {
        return is_Avail;
    }

    public void setIs_Avail(String is_Avail) {
        this.is_Avail = is_Avail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "Id=" + Id +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", Gender='" + gender + '\'' +
                ", highest_qual='" + highest_qual + '\'' +
                ", username='" + username + '\'' +
                ", contact_no='" + contact_no + '\'' +
                ", is_Avail='" + is_Avail + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Doctor doctor = (Doctor) o;
        return Objects.equals(Id, doctor.Id) && Objects.equals(fname, doctor.fname) && Objects.equals(lname, doctor.lname) && Objects.equals(gender, doctor.gender) && Objects.equals(highest_qual, doctor.highest_qual) && Objects.equals(username, doctor.username) && Objects.equals(contact_no, doctor.contact_no) && Objects.equals(is_Avail, doctor.is_Avail) && Objects.equals(password, doctor.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, fname, lname, gender, highest_qual, username, contact_no, is_Avail, password);
    }

    public String getRole() {
        return "admin";
    }
}
