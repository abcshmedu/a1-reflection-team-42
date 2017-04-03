package edu.hm.cs.swa.demo;

import java.util.Date;

public class SomeClass 
{
	@RenderMe private int foo;
	@RenderMe(with="edu.hm.renderer.ArrayRenderer") int[] array = {1, 2, 3, };
	@RenderMe private Date date = new Date(123456789);
	
	public SomeClass(int foo) {
		this.foo = foo;
	}
	
	public static void main (String... strings){
		SomeClass sc = new SomeClass(5);
		Renderer rend = new Renderer(sc);
		rend.render();
	} 
}
