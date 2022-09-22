package com.amadousarr.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
/*We create these Command classes to not expose the objects of our domain to a web tier*/
public class CategoryCommand {
    private Long id;
    private String description;
}
