
package com.ticketpro.parking.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name="EnforcementZone",strict = false)
public class EnforcementZone {

    @Element(name = "Description",required = false)
    private String description;
    @Element(name = "Name", required = false)

    private String name;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
