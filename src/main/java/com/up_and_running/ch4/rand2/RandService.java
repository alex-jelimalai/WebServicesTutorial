package com.up_and_running.ch4.rand2;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * @author Alexandr Jelimalai
 */
@WebService
public interface RandService {

    @WebMethod
    public int next1();


    @WebMethod
    public int[] nextN(final int n);
}
