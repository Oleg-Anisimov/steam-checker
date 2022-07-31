package me.anisimov.steamchecker.Controller;


import me.anisimov.steamchecker.model.Info;
import me.anisimov.steamchecker.model.SteamApiResponse;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/check")
public class CheckController {

    private static String CHECK_URL = "http://api.steampowered.com/ISteamUser/GetPlayerSummaries/v0002/";

    @GetMapping
    public ResponseEntity<Info> checkOnline(@RequestParam String steamId) {
        RestTemplate sender = new RestTemplate();
        //steamId="76561198129855535";
        String key = "54076FFC07F4E74FEB6215B533140F4E";
        String fullUrl = CHECK_URL + "?key=" + key + "&" + "steamids=" + steamId;
        SteamApiResponse steamApiResponse = sender.exchange(fullUrl, HttpMethod.GET, null, SteamApiResponse.class).getBody();
        Info info = steamApiResponse.getResponse().getPlayers().get(0);
        return ResponseEntity.ok(info);
    }
}
