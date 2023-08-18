package br.com.codegroup.portfolio.controller;

import br.com.codegroup.portfolio.model.Project;
import br.com.codegroup.portfolio.service.PersonService;
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

@RestController
@RequestMapping("/project")
@CrossOrigin(origins = "http://localhost:4200")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @Autowired
    private PersonService personService;

    @PostMapping
    public ResponseEntity<Project> createProject(@Valid @RequestBody Project project) {
        try {
            Project savedProject = projectService.createProject(project);
            return new ResponseEntity<>(savedProject, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Project> updateProject(@PathVariable("id") Long projectId, @Valid @RequestBody Project project) {
        try {
            project.setId(projectId);
            Project updatedProject = projectService.updateProject(project);
            return new ResponseEntity<>(updatedProject, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteProject(@PathVariable("id") Long projectId) {
        projectService.deleteProject(projectId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("{id}")
    public ResponseEntity<Project> getProjectById(@PathVariable("id") Long projectId) {
        try {
            Project project = projectService.getProjectById(projectId);
            return new ResponseEntity<>(project, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Project>> getAllProjects() {
        try {
            List<Project> projects = projectService.getAllProjects();
            if (projects.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(projects, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
