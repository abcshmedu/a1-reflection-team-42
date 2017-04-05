package edu.hm.cs.swa.demo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author Thomas Murschall
 *
 */
public class RendererTest {
   
    private SomeClass toRender;
    private Renderer renderer;
    
    /**
     * Setup for the tests.
     * 
     * Initialization of renderer and SomeClass instance.
     */
    @Before
    public void setUp() {
        final int foo = 5;
        toRender = new SomeClass(foo);
        renderer = new Renderer(toRender);
    }

    /**
     * Testcase with SomeClass.
     * @throws Exception 
     */
    @Test
    public void testRendering() throws Exception {
        assertEquals("Instance of edu.hm.cs.swa.demo.SomeClass:\n"
                + "foo (Type int): 5\narray (Type int[]): [1, 2, 3]\ndate (Type java.util.Date): Fri Jan 02 11:17:36 CET 1970\n", renderer.render());
    }
}