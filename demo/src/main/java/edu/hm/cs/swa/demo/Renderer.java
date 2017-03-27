package edu.hm.cs.swa.demo;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class Renderer {
	private Object obj;
	public Renderer(Object ob){
		obj = ob;
	}
	
	public String render(){
		String res = "";
		Class<? extends Object> c = obj.getClass();
		Field[] attributes =  c.getDeclaredFields();
		
		for (int i = 0; i < attributes.length; i++){
			res += attributes[i].getName();
			res += " ";
			res += "(Type "+attributes[i].getType()+ ")";
			res += ": ";
			try {
				Object ob = attributes[i].get(obj);
				
				Annotation [] ants =  attributes[i].getDeclaredAnnotations();
				boolean render = false;
				
				for (int z = 0; z<ants.length; z++){
					Class<? extends Annotation> anno = ants[z].annotationType();
					String[] split1 = ants[z].toString().split("\\(");
					String tmp = split1[split1.length-1];
					String fin = tmp.substring(5, tmp.length()-1);
					if (fin.length() > 0) {
						System.out.println(fin);
					}
					else{
						System.out.println("nichts mehr enthalten");
					}
				}
				
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "";
	}
}
