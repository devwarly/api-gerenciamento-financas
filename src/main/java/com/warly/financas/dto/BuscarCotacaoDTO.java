package com.warly.financas.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BuscarCotacaoDTO {

    private String code;
    private String codein;
    private String bid;

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public String getCodein() { return codein; }
    public void setCodein(String codein) { this.codein = codein; }

    public String getBid() { return bid; }
    public void setBid(String bid) { this.bid = bid; }
}