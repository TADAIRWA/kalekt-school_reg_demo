package com.kalekt.school_reg_demo.utilities.exceptions;

import java.text.MessageFormat;

public class RecordNotFoundException extends RuntimeException {
    private String value;
    private Long id;

    public RecordNotFoundException(String s) {
        super(s);
    }

    public RecordNotFoundException(String message, String value) {
        super(MessageFormat.format(message, value));
        this.value = value;
    }

    public RecordNotFoundException(String message, Long id) {
        super(MessageFormat.format(message, id));
        this.id = id;
    }
}
