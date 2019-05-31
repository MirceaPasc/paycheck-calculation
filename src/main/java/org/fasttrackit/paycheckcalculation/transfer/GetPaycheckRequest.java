package org.fasttrackit.paycheckcalculation.transfer;

import javax.validation.constraints.NotNull;

public class GetPaycheckRequest {

    @NotNull
   private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "GetPaycheckRequest{" +
                "name='" + name + '\'' +
                '}';
    }
}

