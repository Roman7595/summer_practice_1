package org.example.practice.controller;

import org.example.practice.DTO.AutoDTO;
import org.example.practice.DTO.toAdd.AutoToAddDTO;
import org.example.practice.services.interfaces.AutoDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/autos")
public class AutoController {
        @Autowired
        AutoDomainService autoDomainService;

        @PostMapping("/")
        AutoDTO addAuto(@RequestBody AutoToAddDTO auto){
                return autoDomainService.addAuto(auto);
        }
        @GetMapping("/")
        List<AutoDTO> getAll(){
                return autoDomainService.getAll();
        }

        @GetMapping("/{id}")
        AutoDTO one(@PathVariable Integer id){
                return autoDomainService.getById(id);
        }


}
