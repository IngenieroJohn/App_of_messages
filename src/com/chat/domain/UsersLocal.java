package com.chat.domain;



public class UsersLocal {
	private int id;
	private String name;
	private String lastName;
	private String username;
	private String email;
	private String image;
	private String password;
	private String estado;
	
	public UsersLocal(int id){
		this.id = id;
		
	}
	public UsersLocal(int id, String userName) {
        this.id = id;
        this.username = userName;
    }
	
	
	public UsersLocal(int id, String username, String password, String image, String estado) {
		
		this.id = id;
		this.username = username;
		this.password=password;
		this.image = image;
		this.estado=estado;
	}
	
	public UsersLocal(int id, String name, String lastName, String username, String email, String password, String image) {
		super();
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.username = username;
		this.email = email;
		this.password = password;
		this.image = image;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "{\"id\":" + id + ", \"userName\": \"" + username + "\"}";
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
