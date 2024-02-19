/*
 * @(#)JWTUtilsTest.java
 *
 * Copyright (c) (Chile). All rights reserved.
 *
 * All rights to this product are owned by and may only
 * be used under the terms of its associated license document. You may NOT
 * copy, modify, sublicense, or distribute this source file or portions of
 * it unless previously authorized in writing.
 * In any event, this notice and the above copyright must always be included
 * verbatim with this file.
 */
package com.nisum.ms.utils;

import com.nisum.ms.constants.DesafioConstants;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * JWTUtilsTest.
 *
 * @author Jose.
 * @version 1.0.0
 */
public class JWTUtilsTest { // -------------------------------------------------------------------
    // -- Tests ----------------------------------------------------------
    // -------------------------------------------------------------------

    /**
     * Test.
     *
     * @throws Exception {@link Exception}
     */
    @Test
    void testConstructor() throws Exception {
        final Constructor<JWTUtils> constructor = JWTUtils.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        Assertions.assertThrows(InvocationTargetException.class, constructor::newInstance);
    }

    /**
     * Test.
     */
    @Test
    void testcreateJWT() {
        Assertions.assertNull(JWTUtils.createJWT(DesafioConstants.SUBJECT));
    }

}
