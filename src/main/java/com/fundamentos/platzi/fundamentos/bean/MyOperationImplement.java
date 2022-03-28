package com.fundamentos.platzi.fundamentos.bean;

import org.springframework.stereotype.Component;


public class MyOperationImplement implements MyOperation{

    @Override
    public int sum(int number) {
        return number+1;
    }
}
