package com.intern.task.model.jdl.type;

import java.util.Arrays;
import java.util.List;

public interface TypeList {
    public final List<Type> TYPES = Arrays.asList(
        new Type("Byte", "SMALLINT", "integer", null),
        new Type("Short", "SMALLINT", "integer", null),
        new Type("Integer", "INTEGER", "integer", null),
        new Type("Long", "BIGINT", "integer", null),
        new Type("Double", "NUMERIC", "number", null),
        new Type("Float", "NUMERIC", "number", null),
        new Type("Character", "CHAR", "string", null),
        new Type("Boolean", "BOOLEAN", "boolean", null),
        new Type("String", "TEXT", "string", null),
        new Type("BigDecimal", "NUMERIC", "integer", "java.math.BigDecimal"),
        
        new Type("Instant", "TIMESTAMP WITH TIME ZONE", "string", "java.time.Instant"),
        new Type("Date", "DATE", "string", "java.util.Date"),
        new Type("LocalDate", "DATE", "string", "java.time.LocalDate"),
        new Type("ZonedDateTime", "TIMESTAMP WITH TIME ZONE", "string", "java.time.ZonedDateTime"),
        new Type("OffsetDateTime", "TIMESTAMP WITH TIME ZONE", "string", "java.time.OffsetDateTime"),
        new Type("Duration", null, "string", "java.time.Duration"),
        
        new Type("UUID", "UUID", "string", "java.util.UUID"),
        new Type("Blob", "BLOB", "string", "java.sql.Blob")
    );
}
