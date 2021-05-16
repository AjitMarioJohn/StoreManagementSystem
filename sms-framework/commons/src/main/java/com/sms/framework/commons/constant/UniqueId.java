package com.sms.framework.commons.constant;

import lombok.*;

import java.util.UUID;

import com.sms.framework.commons.exception.InvalidUniqueId;

public final class UniqueId {
    @NonNull
    private final UUID id;

    // not including -
    private static int maxSize = 32;
    private static int minSize = 32;

    public UniqueId (@NonNull UUID id) {
        this.id = id;
    }

    public static UniqueId of(@NonNull final String id) throws InvalidUniqueId{
    	String replacedId = id.replaceAll("-", "");
    	if( replacedId.length() < minSize || replacedId.length() > maxSize)
    		throw new InvalidUniqueId("Length of unique id should not be more than "+maxSize+" or less than "+minSize);
    	
        return new UniqueId(UUID.fromString(id));
    }

    public static UniqueId of(@NonNull final UUID id){
        return new UniqueId(id);
    }
    
    public static UniqueId create() throws InvalidUniqueId{
        return UniqueId.of(UUID.randomUUID().toString());
    }

    public UUID getValue(){
        return this.id;
    }
}
