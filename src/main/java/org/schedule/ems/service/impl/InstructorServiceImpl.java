package org.schedule.ems.service.impl;

import lombok.NoArgsConstructor;
import org.schedule.ems.dto.InstructorDto;
import org.schedule.ems.entity.Instructor;
import org.schedule.ems.exception.ResourceNotFoundException;
import org.schedule.ems.mapper.InstructorMapper;
import org.schedule.ems.repository.InstructorRepository;
import org.schedule.ems.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@NoArgsConstructor
public class InstructorServiceImpl implements InstructorService {

    @Autowired
    private InstructorRepository instructorRepository;

    @Override
    public InstructorDto createInstructor(InstructorDto instructorDto) {

        Instructor instructor = InstructorMapper.mapToInstructor(instructorDto);
        Instructor savedInstructor = instructorRepository.save(instructor);
        return InstructorMapper.mapToInstructorDto(savedInstructor);
    }

    @Override
    public InstructorDto getInstructorbyId(Long instructorId) {
        Instructor instructor = instructorRepository.findById(instructorId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("El instructor con el id"+ instructorId + "no existe"));

        return InstructorMapper.mapToInstructorDto(instructor);
    }

    @Override
    public List<InstructorDto> getAllInstructores() {
            List<Instructor> instructor = instructorRepository.findAll();
            return instructor.stream()
                    .map(entity -> InstructorMapper.mapToInstructorDto(entity))
                    .collect(Collectors.toList());
        }

    @Override
    public InstructorDto updateInstructor(Long instructorId, InstructorDto updateInstructor) {

        Instructor instructor = instructorRepository.findById(instructorId).orElseThrow(
                () -> new ResourceNotFoundException("El instructor con el id" + instructorId + "no existe")
        );

        instructor.setFirstName(updateInstructor.getFirstName());
        instructor.setLastName(updateInstructor.getLastName());

        Instructor updateInstructorObj = instructorRepository.save(instructor);

        return InstructorMapper.mapToInstructorDto(updateInstructorObj);
    }

    @Override
    public void deleteInstructor(Long instructorId) {
        Instructor instructor = instructorRepository.findById(instructorId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("El instructor con el id"+ instructorId + "no existe")
                );

        instructorRepository.deleteById(instructorId);

    }

}
