package me.anisimov.steamchecker.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Info {
   private String steamid;
   private Integer communityvisibilitystate;
   private Integer profilestate;
   private String personaname;
   private Integer lastlogoff;
   private Integer commentpermission;
   private String  profileurl;
   private String  avatar;
   private String  avatarmedium;
   private String  avatarfull;
   private Integer personastate;
   private String primaryclanid;
   private Integer timecreated;
   private Integer personastateflags;
   private String gameextrainfo;
   private Integer gameid;
   private String loccountrycode;
   private String locstatecode;
   private Integer loccityid;
}
