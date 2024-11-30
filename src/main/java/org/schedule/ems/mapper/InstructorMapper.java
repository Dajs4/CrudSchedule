package org.schedule.ems.mapper;

import org.schedule.ems.dto.InstructorDto;
import org.schedule.ems.entity.Instructor;


public class InstructorMapper {

    public static InstructorDto mapToInstructorDto(Instructor instructor){
        return new InstructorDto(
                instructor.getId(),
                instructor.getFirstName(),
                instructor.getLastName(),
                instructor.getTipoContrato()
        );
    }

    public static Instructor mapToInstructor(InstructorDto instructorDto){
        return new Instructor(
                instructorDto.getId(),
                instructorDto.getFirstName(),
                instructorDto.getLastName(),
                instructorDto.getTipoContrato()
        );
    }


}
