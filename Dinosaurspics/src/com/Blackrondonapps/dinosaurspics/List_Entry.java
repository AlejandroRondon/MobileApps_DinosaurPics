package com.Blackrondonapps.dinosaurspics;

public class List_Entry {
	private int idPicture; 
	private String title; 
	private String description; 

	public List_Entry (int idPicture, String title, String description) { 
	    this.idPicture = idPicture; 
	    this.title = title; 
	    this.description = description; 
	}

	public String get_title() { 
	    return title; 
	}

	public String get_description() { 
	    return description; 
	}

	public int get_idPicture() {
	    return idPicture; 
	} 
}
