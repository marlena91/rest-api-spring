package pl.wsb.restexample.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WonderOfTheWorld {

    private Long id;
    private String name;
    private String date;
    private String location;
    private String type;
    private String description;

    public WonderOfTheWorld(Long id, WonderOfTheWorldDto wonderOfTheWorldDto){
        this.id = id;
        this.name = wonderOfTheWorldDto.getName();
        this.date = wonderOfTheWorldDto.getDate();
        this.location = wonderOfTheWorldDto.getLocation();
        this.type = wonderOfTheWorldDto.getType();
        this.description = wonderOfTheWorldDto.getDescription();
    }
}
