package me.anisimov.steamchecker.Controller;

import me.anisimov.steamchecker.model.ApiResponse;
import me.anisimov.steamchecker.model.Info;

import me.anisimov.steamchecker.service.SteamCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.Endpoint;
import java.util.List;

@RestController
@RequestMapping("/check")
public class CheckController {

    @Autowired
    private SteamCheckService steamCheckService;

    @GetMapping
    public ResponseEntity<Info> checkOnline(@RequestParam String steamId) {
        Info info = steamCheckService.checkSingleClient(steamId);
        return ResponseEntity.ok(info);
    }


    @GetMapping("/mass")
    public ResponseEntity<List<Info>> checkMass(@RequestParam String steamIds) {
        List<Info> infos = steamCheckService.massCheck(steamIds);
        return ResponseEntity.ok(infos);
    }

    @GetMapping(value="/find",produces = "Application/Json")
    public ResponseEntity<Info> checkSteamId(@RequestParam String nick) {
        String steamId = steamCheckService.checkSteamId(nick);
        Info info = steamCheckService.checkSingleClient(steamId);
        return ResponseEntity.ok(info);
    }
    @GetMapping(value = "/important",produces = "Application/Json")
    public ResponseEntity<ApiResponse> checkImportant(@RequestParam String nick) {
        String steamId = steamCheckService.checkSteamId(nick);
        ApiResponse apiResponse =  steamCheckService.checkImportantClient(steamId);

        return ResponseEntity.ok(apiResponse);
    }


}
