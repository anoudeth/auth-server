package com.noh.authserver.entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * Create at 27/10/2020 - 2:32 PM
 * Project Name oauth
 *
 * @author yor
 */
@Data
public class AuthenticationToken {
    private Object principal;
    private Object credentials;
    private Collection<GrantedAuthority> grantedAuthorities;
    private Object details;

    @Override
    public String toString() {
        ObjectMapper mapper = new ObjectMapper();

        String jsonString = "";
        try {
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            jsonString = mapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonString;
    }
}
