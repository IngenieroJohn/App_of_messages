package com.chat.repositorio;

import java.util.ArrayList;
import java.util.List;

import com.chat.domain.Chats;
import com.chat.domain.Message;
import com.chat.domain.UsersLocal;

public class ChatRepository {
	private RepositoryMessages msjRepositorio;
    private UserRepository userRepositorio;
 
    public ChatRepository() {
        msjRepositorio = new RepositoryMessages();
        userRepositorio = new UserRepository();
    }

    public RepositoryMessages getMsjRepositorio() {
        return msjRepositorio;
    }



    public void setMsjRepositorio(RepositoryMessages msjRepositorio) {
        this.msjRepositorio = msjRepositorio;
    }



    public UserRepository getUserRepositorio() {
        return userRepositorio;
    }



    public void setUserRepositorio(UserRepository userRepositorio) {
        this.userRepositorio = userRepositorio;
    }



    public List<Chats> getContactos(int userId){
        List<Chats> chats = new ArrayList<Chats>();
        
        
        List<UsersLocal> userContact =  userRepositorio.getUsuarios();
        

        for(int i = 0; i < userContact.size(); i++) {
            if(userContact.get(i).getId() == userId) 
                continue;

            Message ultimoMsj = msjRepositorio.getlastsms(userId, userContact.get(i).getId());

            if(ultimoMsj == null)
                continue;

            UsersLocal contacto = userRepositorio.Getuserlocal(userContact.get(i).getId());
            chats.add(new Chats(contacto, ultimoMsj));
        }
        return chats;
    }

	
}


