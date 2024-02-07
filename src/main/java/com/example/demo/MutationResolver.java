package com.example.demo;

import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
public class MutationResolver {
    @MutationMapping
    public boolean throwUnsupported() {
        throw new UnsupportedOperationException("This is not supported");
    }

    @MutationMapping
    public boolean throwCast() {
        throw new ClassCastException("I will not cast it");
    }
}
