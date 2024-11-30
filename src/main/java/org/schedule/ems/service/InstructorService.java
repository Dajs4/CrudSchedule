package org.schedule.ems.service;


import org.schedule.ems.dto.InstructorDto;

import java.util.List;

public interface InstructorService {
    InstructorDto createInstructor(InstructorDto instructorDto);

    InstructorDto getInstructorbyId(Long instructorId);

    List<InstructorDto> getAllInstructores();

    InstructorDto updateInstructor(Long instructorId, InstructorDto updateInstructor);

    void deleteInstructor(Long instructorId);

}

