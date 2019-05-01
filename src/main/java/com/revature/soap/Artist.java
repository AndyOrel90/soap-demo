package com.revature.soap;

public class Artist {
	private int id;
	private String name;

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

	public Artist(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Artist() {
		super();
		// TODO Auto-generated constructor stub
	}
}
