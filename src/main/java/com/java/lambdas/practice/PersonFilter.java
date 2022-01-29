package com.java.lambdas.practice;

public class PersonFilter {
    private final Integer maxAge;
    private final Integer minAge;
    private final String partialName;

    public PersonFilter(Integer minAge, Integer maxAge, String partialName) {
        super();
        this.maxAge = maxAge;
        this.minAge = minAge;
        this.partialName = partialName;
    }

     boolean test(Person p) {
        if(minAge != null && maxAge != null) {
            if(p.getAge()< minAge || p.getAge() > maxAge)
                return false;
        }
        if (minAge != null)
            if (p.getAge() < minAge)
                return false;
        if (maxAge != null)
            if (p.getAge() > maxAge)
                return false;
        if (partialName != null)
            if (!p.getName().contains(partialName))
                return false;

        return true;
    }
}
