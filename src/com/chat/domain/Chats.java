package com.chat.domain;

public class Chats {
	private UsersLocal contactos;
    private Message ultimoMsj;

    public Chats(UsersLocal contactos, Message ultimoMsj) {
        this.contactos = contactos;
        this.ultimoMsj = ultimoMsj;
    }

    public UsersLocal getContactos() {
        return contactos;
    }

    public void setContactos(UsersLocal contactos) {
        this.contactos = contactos;
    }

    public Message getUltimoMsj() {
        return ultimoMsj;
    }

    public void setUltimoMsj(Message ultimoMsj) {
        this.ultimoMsj = ultimoMsj;
    }

}
