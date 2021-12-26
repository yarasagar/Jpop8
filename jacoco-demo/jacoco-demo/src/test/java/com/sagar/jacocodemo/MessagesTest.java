package com.sagar.jacocodemo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MessagesTest {

    @Test
    public void testValidName(){
        Messages messages = new Messages();
        Assertions.assertEquals("sagar", messages.getMessage("sagar"));
    }

    @Test
    public void testNullName(){
        Messages messages = new Messages();
        Assertions.assertEquals("empty", messages.getMessage(null));
    }

    @Test
    public void testEmptyName(){
        Messages messages = new Messages();
        Assertions.assertEquals("empty", messages.getMessage(""));
    }

}
