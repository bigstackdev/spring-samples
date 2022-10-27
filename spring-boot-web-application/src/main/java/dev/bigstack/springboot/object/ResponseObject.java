package dev.bigstack.springboot.object;

import lombok.Getter;
import lombok.Builder;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ResponseObject {
	
    private String code;
    private String message;
    
    private Object data;
    
}