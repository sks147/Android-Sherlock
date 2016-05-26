package com.mind.awesome.sherlock;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sumit on 5/26/16.
 */
public class BeerExpert {

    List<String> getBrands(String color) {
        List<String> brands = new ArrayList<String>();
        if(color.equals("amber")){
            brands.add("Jack Amber");
            brands.add("Red Moose");
        }else{
            brands.add("Jail Pale Ale");
            brands.add("Gout Scout");
        }
        return brands;
    }


}
