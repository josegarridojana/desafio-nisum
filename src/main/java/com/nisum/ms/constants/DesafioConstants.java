/*
 * @(#)DesafioConstants.java
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
/**
 *
 */
package com.nisum.ms.constants;

/**
 * DesafioConstants.
 *
 * @author Jose.
 * @version 1.0.0
 */
public final class DesafioConstants {

    // -------------------------------------------------------------------
    // --EXPRESIONES REGULARES --------------------------------------------------------
    // -------------------------------------------------------------------
    /** REGEXP_VALIDATE_PASSWORD. */
    public static final String REGEXP_VALIDATE_PASSWORD =
        "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$";
    /** REGEXP_VALIDATE_EMAIL. */
    public static final String REGEXP_VALIDATE_EMAIL =
        "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";

    // -------------------------------------------------------------------
    // -- Constructor ----------------------------------------------------
    // -------------------------------------------------------------------
    /**
     * Constructor.
     */
    private DesafioConstants() {
        throw new UnsupportedOperationException("Prohibido Instanciar esta clase");
    }

}
