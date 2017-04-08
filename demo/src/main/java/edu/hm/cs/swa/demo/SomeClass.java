package edu.hm.cs.swa.demo;

import java.util.Date;

/**
 * SomeClass is an example for demonstrating the functions of Renderer.
 * @author Markus Krahl, Thomas Murschall
 *
 */
public class SomeClass {
    /**
     * Attributes for demonstrating the work of the render-method in Renderer class.
     */
    @RenderMe private int foo;
    @RenderMe(with = "edu.hm.renderer.ArrayRenderer") private final int[] array = {1, 2, 3};
    private final int time = 123456789;
    @RenderMe private Date date = new Date(time);
    
    /**
     * Constructor of some class.
     * @param foo 
     */
    public SomeClass(int foo) {
        this.foo = foo;
    }
    
    /**
     * Performs some magic calculations in order to demonstrate that render-method can render this method.
     * @return the answer
     */
    @RenderMe
    public int magic() {
        final int answer = 42;
        return answer;
    }
    
    /**
     * Special method for demonstrating that render-method can render methods with a specified Renderer, too.
     * @return int []
     */
    @RenderMe(with = "edu.hm.renderer.ArrayRenderer") 
    public int[] whatever() {
        final int [] array = {1, 2, 3};
        return array;
    }
}
