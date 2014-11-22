package com.up_and_running.ch4.client;

import java.util.List;

/**
 * @author Alexandr Jelimalai
 */
public class RandClient {

    public static void main(String[] args) {
        // set-up
        RandImplService service = new RandImplService();
        RandService port = service.getRandImplPort();
        // sample calls
        System.out.println(port.next1());
        System.out.println();
        List<Integer> nums = port.nextN(4);
        for (Integer num : nums)
            System.out.println(num);
    }
}
