package edu.hm.cs.swa.demo;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 
 * @author Markus Krahl
 *
 */
public class Renderer {
    private Object obj;

    /**
     * 
     * @param ob 
     */
    public Renderer(Object ob) {
        obj = ob;
    }

    /**
     * 
     * @return String 
     */
    public String render() {
        String res = "";
        Class< ? extends Object> c = obj.getClass();
        res += "Instance of " + c.getName() + ":\n";
        Field[] attributes =  c.getDeclaredFields();

        for (int i = 0; i < attributes.length; i++) {
            RenderMe an =  attributes[i].getAnnotation(RenderMe.class);

            if (an != null) {
                res += attributes[i].getName();
                res += " ";
                res += "(Type " + attributes[i].getType().getTypeName() + ")";
                res += ": ";
                try {
                    attributes[i].setAccessible(true);
                    Object ob = attributes[i].get(obj);

                    String renderClassString = an.with();

                    if (!renderClassString.equals("")) {
                        try {
                            Class< ? > renderClass =  Class.forName(renderClassString);
                            Method rendMet =  renderClass.getMethod("render", ob.getClass());
                            Object rendObj = renderClass.getConstructor().newInstance();
                            res += (String) rendMet.invoke(rendObj, ob);
                        } catch (ClassNotFoundException e1) {
                            e1.printStackTrace();
                        } catch (InstantiationException e) {
                            e.printStackTrace();
                        } catch (NoSuchMethodException e) {
                            e.printStackTrace();
                        } catch (SecurityException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        }
                    }
                    else {
                        res += ob.toString();
                    }
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                res += "\n";
            }

        }

        System.out.println(res);

        return res;
    }
}
