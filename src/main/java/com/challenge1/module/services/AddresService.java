package com.challenge1.module.services;

import com.challenge1.module.exception.LobException;
import com.challenge1.module.model.CheckAddress;
import com.lob.api.ApiException;
import org.openapitools.client.model.Suggestions;

import java.util.List;

public interface AddresService {
    List<Suggestions> getLobInformation(CheckAddress checkAddress) throws ApiException;
}
