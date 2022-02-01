package com.example;

import io.micronaut.context.BeanContext;
import io.micronaut.data.annotation.Query;
import io.micronaut.runtime.EmbeddedApplication;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import jakarta.inject.Inject;

@MicronautTest
class DataDemoTest {

    @Inject
    EmbeddedApplication<?> application;

    @Inject
    BeanContext beanContext;

    @Test
    void testItWorks() {
        Assertions.assertTrue(application.isRunning());
    }

    @Test
    void testAnnotationGeneratesDeleteFilter() {
        String query1 = beanContext.getBeanDefinition(MyRepository1.class).getRequiredMethod("findById", Long.class).getAnnotationMetadata().stringValue(Query.class).orElse(null);
        String query2 = beanContext.getBeanDefinition(MyRepository2.class).getRequiredMethod("findById", Long.class).getAnnotationMetadata().stringValue(Query.class).orElse(null);

        Assertions.assertEquals("SELECT m1_ FROM com.example.MyEntity1 AS m1_ LEFT JOIN FETCH m1_.myJoinedEntity1 j1_ WHERE (m1_.id = :p1 AND (m1_.deleted = false))", query1);
        Assertions.assertEquals("SELECT m2_ FROM com.example.MyEntity2 AS m2_ LEFT JOIN FETCH m2_.myJoinedEntity2 j2_ WHERE (m2_.id = :p1 AND (m2_.deleted = false))", query2);
    }

}
