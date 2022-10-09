package br.ufrn.trackingframework.controller;

import br.ufrn.trackingframework.Model.DataEntity;
import br.ufrn.trackingframework.service.AbstractService;
import br.ufrn.trackingframework.service.DataEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController()
@RequestMapping("dataentities")
public class DataEntityController extends AbstractController<DataEntity, String>{

    @Autowired
    DataEntityService service;

    @Override
    protected AbstractService<DataEntity, String> service() {
        return this.service;
    }

}
