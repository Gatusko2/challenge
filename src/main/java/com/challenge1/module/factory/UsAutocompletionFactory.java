package com.challenge1.module.factory;

import com.challenge1.module.exception.LobException;
import com.challenge1.module.model.CheckAddress;
import org.openapitools.client.model.UsAutocompletionsWritable;
import org.springframework.context.annotation.Bean;

// A simple factory
public final class UsAutocompletionFactory {
    public static UsAutocompletionsWritable CreateUsAutoCompletionWriteable(CheckAddress checkAddress) throws LobException {
        UsAutocompletionsWritable autoCompletionWritable = new UsAutocompletionsWritable();
        if(checkAddress.getAddress()==null || checkAddress.getAddress().equals("")){
            throw new LobException("Invalid Address");
        }
        // This should be a valid addres
        autoCompletionWritable.setAddressPrefix(checkAddress.getAddress());
        if(checkAddress.getCity()!=null){
            autoCompletionWritable.setCity(checkAddress.getCity());
        }
        if(checkAddress.getState()!=null){
            autoCompletionWritable.setState(checkAddress.getState());
        }
        if(checkAddress.getZipCode()!=null){
            autoCompletionWritable.setZipCode(checkAddress.getZipCode());
        }
        return  autoCompletionWritable;
    }
}
