package com.example.patientlogin.patient_progress;

import com.example.patientlogin.appuser.AppUser;
import com.example.patientlogin.section.Section;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
public class PatientProgress {

    @Id
    @Column(name = "pat_id", nullable = false)
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "pat_id")
    private AppUser appUser;

//    @Column
//    private Long pat_id;

//    @OneToOne
//    @JoinColumn(name = "id")
//    private AppUser appUser;

    @ManyToOne(cascade = CascadeType.ALL)
    private Section section;



}
