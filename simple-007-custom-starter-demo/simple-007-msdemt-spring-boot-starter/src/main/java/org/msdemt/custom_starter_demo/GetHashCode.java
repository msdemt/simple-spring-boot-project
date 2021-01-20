package org.msdemt.custom_starter_demo;

public class GetHashCode {

    private String target;

    public GetHashCode(String target){
        this.target = target;
    }

    public String getHashCode(){
        return String.valueOf(this.target.hashCode());
    }
}
