package com.vasileirimia.coinchange.domain;

/**
 * OnlyOnceDenominationRequiredException
 */
public class InputContraintException extends RuntimeException {


    private static final long serialVersionUID = -1257881542820755851L;

    public InputContraintException(String message) {
        super(message);
    }
}
