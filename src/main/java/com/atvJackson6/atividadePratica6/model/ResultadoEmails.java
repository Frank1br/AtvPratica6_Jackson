package com.atvJackson6.atividadePratica6.model;

import java.util.List;

public class ResultadoEmails {
    private int totalComentarios;
    private int emailsValidos;
    private int emailsInvalidos;
    private List<String> listaEmailsValidos;
    private List<String> listaEmailsInvalidos;

    public ResultadoEmails(int totalComentarios, int emailsValidos, int emailsInvalidos, List<String> listaEmailsValidos, List<String> listaEmailsInvalidos) {
        this.totalComentarios = totalComentarios;
        this.emailsValidos = emailsValidos;
        this.emailsInvalidos = emailsInvalidos;
        this.listaEmailsValidos = listaEmailsValidos;
        this.listaEmailsInvalidos = listaEmailsInvalidos;
    }

    public int getTotalComentarios() {
        return totalComentarios;
    }

    public void setTotalComentarios(int totalComentarios) {
        this.totalComentarios = totalComentarios;
    }

    public int getEmailsValidos() {
        return emailsValidos;
    }

    public void setEmailsValidos(int emailsValidos) {
        this.emailsValidos = emailsValidos;
    }

    public int getEmailsInvalidos() {
        return emailsInvalidos;
    }

    public void setEmailsInvalidos(int emailsInvalidos) {
        this.emailsInvalidos = emailsInvalidos;
    }

    public List<String> getListaEmailsValidos() {
        return listaEmailsValidos;
    }

    public void setListaEmailsValidos(List<String> listaEmailsValidos) {
        this.listaEmailsValidos = listaEmailsValidos;
    }

    public List<String> getListaEmailsInvalidos() {
        return listaEmailsInvalidos;
    }

    public void setListaEmailsInvalidos(List<String> listaEmailsInvalidos) {
        this.listaEmailsInvalidos = listaEmailsInvalidos;
    }
}
