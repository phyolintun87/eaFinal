package mum.ea.controller;


import mum.ea.controller.abstracts.CrudController;
import mum.ea.domain.Material;
import mum.ea.model.EaResult;
import mum.ea.model.EaResultData;
import mum.ea.service.MaterialService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/material")
public class MaterialController extends CrudController<Material, MaterialService> {
 
}
