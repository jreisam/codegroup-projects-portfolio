package br.com.codegroup.portfolio.controller;

import br.com.codegroup.portfolio.model.Project;
import br.com.codegroup.portfolio.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author João Robson 12/08/2023
 */
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    //    @Autowired
// TODO: DOING    private PersonService personService;
    @GetMapping
    public ResponseEntity<List<Project>> findAll() {
        List<Project> response = projectService.findAll();
        return ResponseEntity.status(HttpStatus.OK)
                .body(response);
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody Project project) {
        projectService.save(project);

        return ResponseEntity.status(HttpStatus.CREATED)
                .build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> save(@PathVariable("Id") Long id, @Valid @RequestBody Project project) {
        projectService.update(id, project);

        return ResponseEntity.status(HttpStatus.CREATED)
                .build();
    }
}
