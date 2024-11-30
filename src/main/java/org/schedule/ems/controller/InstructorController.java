package org.schedule.ems.controller;

import org.schedule.ems.dto.InstructorDto;
import org.schedule.ems.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//crossorigin permisos de servidor a quien vas a dar servicio en este cao en react
//el local host es local:3000
@CrossOrigin( origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/instructores")
public class InstructorController {
    @Autowired
    private InstructorService instructorService;


    //Build Add INSTRUCTOR Rest API

    //@RequestBody Esta anotación le dice a Spring que
    // tome el cuerpo de la solicitud HTTP y lo convierta
    // en un objeto InstructorDto.
    @PostMapping
    public ResponseEntity<InstructorDto> createInstructor(@RequestBody InstructorDto instructorDto) {
        InstructorDto savedInstructor = instructorService.createInstructor(instructorDto);
        // Lógica para crear un instructor
        return new ResponseEntity<>(savedInstructor, HttpStatus.CREATED);
    }

    //Build Get INSTRUCTOR REST API
    // Endpoint para obtener un instructor por su ID
    @GetMapping("{id}")
    //@PathVariable captura valores de una URL dinámica y para pasarlos como parámetros en
    // los métodos del controlador, facilitando el manejo de rutas con valores variables.
    public ResponseEntity<InstructorDto> getInstructorById(@PathVariable("id") Long instructorId) {
        InstructorDto instructorDto = instructorService.getInstructorbyId(instructorId);
        return ResponseEntity.ok(instructorDto);

    }

    // Build Get All Instructores REST API
    @GetMapping()
    public ResponseEntity<List<InstructorDto>> getAllInstructores() {
        List<InstructorDto> instructor = instructorService.getAllInstructores();
        return ResponseEntity.ok(instructor);
    }

    // Build Update Employee Rest API

    @PutMapping("{id}")
    public ResponseEntity<InstructorDto> updateInstructor(@PathVariable("id") Long instructorId,
                                                          @RequestBody InstructorDto updateInstructor) {
        InstructorDto instructorDto = instructorService.updateInstructor(instructorId, updateInstructor);
        return ResponseEntity.ok(instructorDto);
    }

    //Build Delete Instructor REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteInstructor(@PathVariable("id") Long instructorId) {
        instructorService.deleteInstructor(instructorId);
        return ResponseEntity.ok("El instructor fue eliminado correctamente :)!");

    }
    }