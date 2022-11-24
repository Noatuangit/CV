package com.example.demo.utils;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.stream.Stream;

@Component
public class MyGenerator implements IdentifierGenerator {
    private final String prefix = "HK-";

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        String query = String.format("select %s from %s",
                session.getEntityPersister(object.getClass().getName(), object)
                        .getIdentifierPropertyName(),
                object.getClass().getSimpleName());

        Stream<String> ids = session.createQuery(query, String.class).stream();

        long max = ids.map(o -> o.replace(prefix, "")).mapToLong(Long::parseLong).max().orElse(0L);

        return prefix + (String.format("%03d", max + 1));
    }
}
