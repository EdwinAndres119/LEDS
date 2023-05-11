package exeptions;

import lombok.Data;

@Data
public class ListDeException extends RuntimeException{
    String code;
    public ListDeException(String code, String message){
        super(message);
        this.code = code;
    }
}
