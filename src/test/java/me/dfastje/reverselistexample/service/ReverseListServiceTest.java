package me.dfastje.reverselistexample.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class ReverseListServiceTest {

    //Test Data
    private List<String> emptyList;
    private List<String> singleElementList;
    private List<String> threeElementList;
    private List<String> reverseThreeElementList;
    private List<String> nullElementList;

    @TestConfiguration
    static class ReverseListServiceConfiguration {

        @Bean
        public ReverseListService reverseListServiceBean() {
            return new ReverseListService();
        }
    }

    //Usually use instructor based injection, but don't care for a test class
    @Autowired
    private ReverseListService reverseListService;

    @BeforeEach
    void setupLists(){
        emptyList = new ArrayList<>();

        singleElementList = new ArrayList<>();
        singleElementList.add("onlyElement");

        String firstElement = "firstElement";
        String secondElement = "secondElement";
        String thirdElement = "thirdElement";

        threeElementList = new ArrayList<>();
        threeElementList.add(firstElement);
        threeElementList.add(secondElement);
        threeElementList.add(thirdElement);

        reverseThreeElementList = new ArrayList<>();
        reverseThreeElementList.add(thirdElement);
        reverseThreeElementList.add(secondElement);
        reverseThreeElementList.add(firstElement);

        nullElementList = new ArrayList<>();
        nullElementList.add(null);
        nullElementList.add("NotNull");
    }

    /**
     * Normally, I wouldn't unit test a method maintained by a 3rd party
     */
    @Test
    void reverseListWithGuava() {
        Assertions.assertLinesMatch( reverseListService.reverseListWithGuava(emptyList), emptyList,
                "Empty list should be equal to itself");
        Assertions.assertLinesMatch( reverseListService.reverseListWithGuava(singleElementList), singleElementList,
                "Single element list should be equal to itself");
        Assertions.assertLinesMatch( reverseListService.reverseListWithGuava(threeElementList), reverseThreeElementList,
                "Multi element list should be equal to its reverse");
        List<String> reversedNullElementList = reverseListService.reverseListWithGuava( nullElementList );
        Assertions.assertNull( reversedNullElementList.get( reversedNullElementList.size()-1 ) );
    }

    @Test
    void reverseListWithCollections() {
        Assertions.assertLinesMatch( reverseListService.reverseListWithCollections(emptyList), emptyList,
                "Empty list should be equal to itself");
        Assertions.assertLinesMatch( reverseListService.reverseListWithCollections(singleElementList), singleElementList,
                "Single element list should be equal to itself");
        Assertions.assertLinesMatch( reverseListService.reverseListWithCollections(threeElementList), reverseThreeElementList,
                "Multi element list should be equal to its reverse");
        List<String> reversedNullElementList = reverseListService.reverseListWithCollections( nullElementList );
        Assertions.assertNull( reversedNullElementList.get( reversedNullElementList.size()-1 ) );
    }

    @Test
    void reverseListTheHardWay() {
        Assertions.assertLinesMatch( reverseListService.reverseListTheHardWay(emptyList), emptyList,
                "Empty list should be equal to itself");
        Assertions.assertLinesMatch( reverseListService.reverseListTheHardWay(singleElementList), singleElementList,
                "Single element list should be equal to itself");
        Assertions.assertLinesMatch( reverseListService.reverseListTheHardWay(threeElementList), reverseThreeElementList,
                "Multi element list should be equal to its reverse");
        List<String> reversedNullElementList = reverseListService.reverseListTheHardWay( nullElementList );
        Assertions.assertNull( reversedNullElementList.get( reversedNullElementList.size()-1 ) );
    }
}