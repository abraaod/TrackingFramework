package br.ufrn.trackingframework.helper;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.stream.Stream;

@Component
public class DataEntityValidator {

    public static boolean isValid(Object value){
        if(Stream.of("number", "string", "object", "list").anyMatch(x -> value.equals(x))){
            return true;
        }
        return false;
    }
}
