package Controller;

import DTO.LedsDTO;
import DTO.ResponseDTO;
import Model.Leds;
import Service.ListDeService;
import exeptions.ListDeException;
import exeptions.RequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

public class ListDeController {
    @RestController
    @RequestMapping(path = "/list_de")
    public class ListDEController {
        private ListDeService listDEService;

        public ResponseEntity<ResponseDTO> addLed(@RequestBody LedsDTO ledDTO) {
            try {
                listDEService.addLedToEnd(new Leds(ledDTO.getId(), ledDTO.isState(), ledDTO.getDateOn(), ledDTO.getDateOff()));
                return new ResponseEntity<>(new ResponseDTO(200, "el led se añadio a la lista", null), HttpStatus.OK);
            } catch (ListDeException e) {
                throw new RequestException(e.getCode(), e.getMessage(), HttpStatus.BAD_REQUEST);
            }

        }

        @PostMapping(path = "/add_led_beginning")
        public ResponseEntity<ResponseDTO> addLedToStart(@RequestBody LedsDTO ledDTO) {
            listDEService.addLedToStart(new Leds(ledDTO.getId(), ledDTO.isState(), ledDTO.getDateOn(), ledDTO.getDateOff()));
            return new ResponseEntity<>(new ResponseDTO(200, "el led se agrego a la lista", null), HttpStatus.OK);
        }

    }
    @PostMapping(path = "/restart_list")
    public ResponseEntity<ResponseDTO> restartLeds() {
        try {
            ListDeService.restartLeds();
            return new ResponseEntity<>(new ResponseDTO(200, "leds reiniciadas y apagadas", null
            ), HttpStatus.OK);
        } catch (ListDeException e) {
            throw new RequestException(e.getCode(), e.getMessage(), HttpStatus.BAD_REQUEST);
        }
}
    }