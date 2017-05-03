package shoppingcart;

import java.lang.Exception;

public class ShoppingCartException extends Exception
{
    public ShoppingCartException()
    {
        
    }

    public ShoppingCartException(String message)
    {
        super(message);
    }
}
