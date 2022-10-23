package pl.wsb.restexample.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class WonderOfTheWorldDto {

    private Long id;
    private String name;
    private String date;
    private String location;
    private String type;
    private String description;

}
