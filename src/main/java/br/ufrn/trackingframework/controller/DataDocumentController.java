package br.ufrn.trackingframework.controller;

import br.ufrn.trackingframework.Model.DataDocument;
import br.ufrn.trackingframework.service.AbstractService;
import br.ufrn.trackingframework.service.DataDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("documents")
public class DataDocumentController extends AbstractController<DataDocument, String>{

    @Autowired
    private DataDocumentService service;

    @Override
    protected AbstractService service() {
        return this.service;
    }

}
