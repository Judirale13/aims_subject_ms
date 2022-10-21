package co.edu.unal.aims.subject_ms.controller;

import co.edu.unal.aims.subject_ms.model.Subjects;
import co.edu.unal.aims.subject_ms.model.ClassGroups;
import co.edu.unal.aims.subject_ms.service.ClassGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value="/group")
public class ClassGroupController {

    private final ClassGroupService classGroupService;
    @Autowired
    public ClassGroupController(ClassGroupService classGroupService) {
        this.classGroupService = classGroupService;
    }

    

    @GetMapping("/{classGroupId}")
    public ResponseEntity <ClassGroups> getEnrollment(@PathVariable("classGroupId") UUID classGroupId){
        //List<ClassGroups> classGroups = new ArrayList<>();
        ClassGroups classGroups=classGroupService.buscarPorClassGroupId(classGroupId);
        if (classGroups == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(classGroups);
    }




}