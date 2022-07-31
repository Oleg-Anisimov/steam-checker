package me.anisimov.steamchecker.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SteamApiResponse {
    private InfoList response;
}
