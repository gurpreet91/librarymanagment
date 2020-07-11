package com.app.librarymanagment.model;

public class BookDetails {


private String name;
private String author;
private String yearOfthePublish;

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getAuthor() {
	return author;
}

public void setAuthor(String author) {
	this.author = author;
}

public String getYearOfthePublish() {
	return yearOfthePublish;
}

public void setYearOfthePublish(String yearOfthePublish) {
	this.yearOfthePublish = yearOfthePublish;
}


public BookDetails(String name, String author, String yearOfthePublish) {
	this.name = name;
	this.author = author;
	this.yearOfthePublish = yearOfthePublish;
}
}
