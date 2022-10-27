package dev.bigstack.springboot.object;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GlobalExceptionObject extends RuntimeException {

    private static final long serialVersionUID = 1L;
    
	private String code;
    private String message;

    public GlobalExceptionObject(String message) {
        super(message);
    }
}
