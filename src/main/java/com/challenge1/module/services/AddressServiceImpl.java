package com.challenge1.module.services;

import com.challenge1.module.configuration.LobConfig;
import com.challenge1.module.exception.LobException;
import com.challenge1.module.factory.UsAutocompletionFactory;
import com.challenge1.module.model.CheckAddress;
import com.lob.api.ApiClient;
import com.lob.api.ApiException;
import com.lob.api.Configuration;

import com.lob.api.auth.HttpBasicAuth;
import com.lob.api.client.UsAutocompletionsApi;
import org.openapitools.client.model.Suggestions;
import org.openapitools.client.model.UsAutocompletions;
import org.openapitools.client.model.UsAutocompletionsWritable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddresService{

    // We need to access to the lob-api-key
    @Autowired
    private LobConfig lobConfig;

    // need to throws ApiException as this extends for Exception
    @Override
    public List<Suggestions> getLobInformation(CheckAddress checkAddress) throws ApiException {
        ApiClient lobClient = Configuration.getDefaultApiClient();
        HttpBasicAuth basicAuth = (HttpBasicAuth) lobClient.getAuthentication("basicAuth");
        basicAuth.setUsername(lobConfig.getApikey());
        UsAutocompletionsApi apiInstance = new UsAutocompletionsApi(lobClient);
        UsAutocompletionsWritable autoCompletionWritable = null;
        autoCompletionWritable = UsAutocompletionFactory.CreateUsAutoCompletionWriteable(checkAddress);
        UsAutocompletions usAutocompletion = apiInstance.autocomplete(autoCompletionWritable);
        return  usAutocompletion.getSuggestions();
    }


}
