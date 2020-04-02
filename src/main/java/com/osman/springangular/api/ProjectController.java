package com.osman.springangular.api;

import com.osman.springangular.dto.ProjectDto;
import com.osman.springangular.service.implementation.ProjectServiceImplementation;
import com.osman.springangular.util.ApiPaths;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(ApiPaths.ProjectCtrl.CRTL)
public class ProjectController {
    /*
    Http metodlari:  GET,POST,PUT,DELETE
     */

    private final ProjectServiceImplementation projectServiceImplementation;

    public ProjectController(ProjectServiceImplementation projectServiceImplementation) {
        this.projectServiceImplementation = projectServiceImplementation;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectDto> getById(@PathVariable(value = "id", required = true) Long id) {
        ProjectDto projectDto = projectServiceImplementation.getById(id);
        return ResponseEntity.ok(projectDto);
    }

    @PostMapping
    public ResponseEntity<ProjectDto> createProject(@Valid @RequestBody ProjectDto project) {
        return ResponseEntity.ok(projectServiceImplementation.save(project));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProjectDto> updateProject(@PathVariable(value = "id", required = true) Long id, @Valid @RequestBody ProjectDto project) {
        return ResponseEntity.ok(projectServiceImplementation.update(id, project));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable(value = "id", required = true) Long id) {
        return ResponseEntity.ok(projectServiceImplementation.delete(id));
    }
}
