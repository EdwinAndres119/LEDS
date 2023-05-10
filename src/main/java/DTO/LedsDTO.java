package DTO;

import lombok.Data;

import java.time.LocalTime;
@Data
public class LedsDTO {
    private int id;
    private boolean state;
    private LocalTime dateOn;
    private LocalTime dateOff;
}
