package me.anisimov.steamchecker.service;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import me.anisimov.steamchecker.model.BasicInfo;
import me.anisimov.steamchecker.model.Info;
import me.anisimov.steamchecker.model.SteamApiResponse;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


@Slf4j
@Service
public class SteamCheckService {
//    https://steamcommunity.com/id/katiatka?xml=1
    private static String CHECK_URL = "http://api.steampowered.com/ISteamUser/GetPlayerSummaries/v0002/";
    private static String API_KEY = "54076FFC07F4E74FEB6215B533140F4E";

    private static String PROFILE_URL = "https://steamcommunity.com/id/";

    @Autowired
    private RestTemplate steamSender;

    @SneakyThrows
    public String checkSteamId(String nick){

        String fullUrl = PROFILE_URL + nick + "?xml=1";
        String Response = steamSender.getForObject(fullUrl, String.class);
        XmlMapper xmlMapper = new XmlMapper();
        BasicInfo info = xmlMapper.readValue(Response,BasicInfo.class);
        return info.getSteamId();
    }

    public List<Info> massCheck(@NotNull String steamIds) {
        List<Info> infos = new ArrayList<>();

        String[] ids = steamIds.split(",");
        for (int i = 0; i < ids.length; i++) {
            Info info = this.checkSingleClient(ids[i]);
            infos.add(info);
        }

        return infos;
    }

    public Info checkSingleClient(String steamId) {
        String fullUrl = CHECK_URL + "?key=" + API_KEY + "&" + "steamids=" + steamId;
        SteamApiResponse steamApiResponse = steamSender.exchange(fullUrl, HttpMethod.GET, null, SteamApiResponse.class).getBody();

        return steamApiResponse.getResponse().getPlayers().get(0);
    }
}
