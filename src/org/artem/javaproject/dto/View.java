package org.artem.javaproject.dto;

import java.util.ArrayList;

public class View {
private ArrayList<String> name;
private ArrayList<String> br;



public String getName(int i) {
	return  name.get(i);
}
public void setName(ArrayList name) {
	this.name = name;
}
public String getBr(int i) {
	return br.get(i);
}
public void setBr(ArrayList br) {
	this.br = br;
}
public int size(){
	return this.name.size();
}
}
