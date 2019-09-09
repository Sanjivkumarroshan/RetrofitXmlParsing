
package com.ticketpro.parking.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name="ArrayOfEnforcementZone",strict = false)
public class ArrayOfEnforcementZone {

    @ElementList (entry="EnforcementZone", inline=true)
    private List<EnforcementZone> enforcementZone;

    public List<EnforcementZone> getEnforcementZone() {
        return enforcementZone;
    }

    public ArrayOfEnforcementZone(){

    }

    public ArrayOfEnforcementZone(List<EnforcementZone> enforcementZone) {
        this.enforcementZone = enforcementZone;
    }

    public void setEnforcementZone(List<EnforcementZone> enforcementZone) {
        this.enforcementZone = enforcementZone;
    }

}
