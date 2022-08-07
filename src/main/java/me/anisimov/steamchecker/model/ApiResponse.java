package me.anisimov.steamchecker.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse {
    private String  name;
    private String avatar;
    private Integer gameId;
    private String gameExtraInfo;
    private String gameLogo;

}
