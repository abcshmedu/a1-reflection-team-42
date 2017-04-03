package edu.hm.cs.swa.demo;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

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
			RenderMe an =  attributes[i].getAnnotation(RenderMe.class);
			
			
			
			if (an != null){
				res += attributes[i].getName();
				res += " ";
				res += "(Type "+attributes[i].getType().getSimpleName()+ ")";
				res += ": ";
				try {
					attributes[i].setAccessible(true);
					Object ob = attributes[i].get(obj);
					
					String renderClassString = an.with();
					
					if (!renderClassString.equals("")){
						try {
							Class<?> renderClass =  Class.forName(renderClassString);
							Method rendMet =  renderClass.getMethod("render", ob.getClass());
							Object rendObj =renderClass.getConstructor().newInstance();
							res += (String) rendMet.invoke(rendObj, ob);
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (InstantiationException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (NoSuchMethodException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (SecurityException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (InvocationTargetException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}	
					else {
						res+= ob.toString();
					}
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				res += "\n";
			}
			
			
			
		}
		
		System.out.println(res);
		
		return res;
}
}
