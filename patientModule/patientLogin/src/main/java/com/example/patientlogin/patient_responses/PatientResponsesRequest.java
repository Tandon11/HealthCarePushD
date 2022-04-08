package com.example.patientlogin.patient_responses;

import com.example.patientlogin.questions.Questions;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class PatientResponsesRequest {

    private final List<Long> questions;
    private final List<Boolean> responses;
}
