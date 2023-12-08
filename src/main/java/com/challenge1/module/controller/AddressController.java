package com.challenge1.module.controller;

import com.challenge1.module.exception.InternalLobError;
import com.challenge1.module.model.CheckAddress;
import com.challenge1.module.services.AddresService;
import com.lob.api.ApiException;
import org.openapitools.client.model.LobError;
import org.openapitools.client.model.Suggestions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address/")
public class AddressController {

    @Autowired
    private AddresService addresService;

    @PostMapping
    public ResponseEntity<?> getAddress(@RequestBody CheckAddress checkAddress){
        try {
            //  We are returning only the list of Suggestions
            List<Suggestions> mySugestions = addresService.getLobInformation(checkAddress);
            return  ResponseEntity.ok(mySugestions);
        } catch (ApiException e) {
            InternalLobError internalLobError=new InternalLobError(e.getMessage(),e.getCode());
            return ResponseEntity.status(500).body(internalLobError);
        }
    }

}
