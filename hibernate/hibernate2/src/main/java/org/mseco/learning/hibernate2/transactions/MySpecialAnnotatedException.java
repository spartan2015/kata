package org.mseco.learning.hibernate2.transactions;

import javax.ejb.ApplicationException;

@ApplicationException(rollback=true)
public class MySpecialAnnotatedException extends Exception{

}
