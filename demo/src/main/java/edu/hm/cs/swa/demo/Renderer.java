package edu.hm.cs.swa.demo;

public class Renderer {
	private Object obj;
	public Renderer(Object ob){
		obj = ob;
	}
	
	public String render(){
		Class<? extends Object> c = obj.getClass();
		c.getAnnotations();
		return "";
	}
}
