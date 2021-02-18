package org.msdemt.simple;

import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(fluent = true)
@Data
public class Person {
    private String name;
}
