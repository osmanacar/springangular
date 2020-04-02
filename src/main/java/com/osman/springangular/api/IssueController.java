package com.osman.springangular.api;

import com.osman.springangular.dto.IssueDto;
import com.osman.springangular.service.implementation.IssueServiceImplementation;
import com.osman.springangular.util.ApiPaths;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(ApiPaths.IssueCtrl.CTRL)
public class IssueController {
    private final IssueServiceImplementation issueServiceImplementation;

    public IssueController(IssueServiceImplementation issueServiceImplementation) {
        this.issueServiceImplementation = issueServiceImplementation;
    }

    @GetMapping("/{id}")
    public ResponseEntity<IssueDto> getById(@PathVariable(value = "id", required = true) Long id) {
        IssueDto issueDto = issueServiceImplementation.getById(id);
        return ResponseEntity.ok(issueServiceImplementation.save(issueDto));
    }

    @PostMapping
    public ResponseEntity<IssueDto> createProject(@Valid @RequestBody IssueDto issueDto) {
        return ResponseEntity.ok(issueServiceImplementation.save(issueDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<IssueDto> updateProject(@PathVariable(value = "id",required = true) Long id,@Valid @RequestBody IssueDto issueDto){
        return ResponseEntity.ok(issueServiceImplementation.update(id,issueDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable(value = "id",required = true)Long id){
        return ResponseEntity.ok(issueServiceImplementation.delete(id));
    }
}
