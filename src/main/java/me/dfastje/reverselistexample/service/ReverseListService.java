package me.dfastje.reverselistexample.service;

import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ReverseListService {

    /**
     * Reverse a list using Guava's Lists class. This outputs a reversed view of the input list
     * @param inputList
     * @return
     */
    public List<String> reverseListWithGuava(List<String> inputList){
        List<String> outputList  = Lists.reverse(inputList);
        return outputList;
    }

    /**
     * Reverse a list using Java util's collections. This reverses the input list
     * @param inputList
     * @return
     */
    public List<String> reverseListWithCollections(List<String> inputList){
        Collections.reverse(inputList);
        return inputList;
    }

    /**
     * Don't do it this way. It's hard to read
     * @param inputList
     * @return
     */
    public List<String> reverseListTheHardWay(List<String> inputList){
        List<String> outputList = new ArrayList<>();

        //Verify the List.add(int i, Object object) method shifts the List rather than override an element:
        // https://docs.oracle.com/javase/8/docs/api/java/util/List.html#add-int-E-
        //Verify that forEach iterates in expected order:
        //  https://docs.oracle.com/javase/8/docs/api/java/lang/Iterable.html
        //  https://docs.oracle.com/javase/8/docs/api/java/lang/Iterable.html#forEach-java.util.function.Consumer-
        inputList.forEach( listElement -> outputList.add(0,listElement) );
        return outputList;
    }
}
