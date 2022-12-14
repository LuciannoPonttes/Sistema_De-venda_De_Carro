package br.atos.xlo.controller.dto.base.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NONE, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonIgnoreProperties(ignoreUnknown = true)
public interface Body<T> {

}