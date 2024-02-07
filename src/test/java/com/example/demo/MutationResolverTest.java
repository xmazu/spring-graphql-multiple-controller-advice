package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.tester.AutoConfigureGraphQlTester;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.graphql.test.tester.GraphQlTester;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureGraphQlTester
class MutationResolverTest {
    @Autowired
    private GraphQlTester graphQlTester;

    @Test
    void throwUnsupported() {
        graphQlTester
                .document("mutation { throwUnsupported }")
                .execute()
                .errors()
                .expect(
                        error ->
                                error
                                        .getMessage()
                                        .equals(
                                                "handle: This is not supported"));
    }

    @Test
    void throwCast() {
        graphQlTester
                .document("mutation { throwCast }")
                .execute()
                .errors()
                .expect(
                        error ->
                                error
                                        .getMessage()
                                        .equals(
                                                "handle: I will not cast it"));
    }
}