package edu.hm.cs.swa.demo;

import java.util.Date;

/**
 * 
 * @author Markus Krahl, Thomas Murschall
 *
 */
public class SomeClass {
    @RenderMe private int foo;
    
    @RenderMe(with = "edu.hm.renderer.ArrayRenderer") private final int[] array = {1, 2, 3, };
    private final int time = 123456789;
    @RenderMe private Date date = new Date(time);
    
    /**
     * 
     * @param foo 
     */
    public SomeClass(int foo) {
        this.foo = foo;
    }
   
}
