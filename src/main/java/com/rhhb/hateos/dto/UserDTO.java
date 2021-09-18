package com.rhhb.hateos.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

@Setter
@Getter
public class UserDTO extends RepresentationModel<UserDTO> {

    private Long id;
    private String name;
}