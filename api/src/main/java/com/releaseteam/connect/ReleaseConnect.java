package com.releaseteam.connect;

public enum ReleaseConnect {

    BASE("https://api.releaseteam.de/","base", -1),
    USERNAME(BASE.getURL() + "users/username?uuid=", "username",-1),
    UUID(BASE.getURL() + "users/uuid?username=", "uuid",-1),
    @Deprecated(since = "API version 4.7")
    CONNECT(BASE.getURL() + "api/connect/", "connect",-1),
    PROFILE(BASE.getURL() + "session/profile?uuid=", "profile",-1),
    VERSION(BASE.getURL() + "api/client?type=", "clientversion",-1),
    CAPE(BASE.getURL()  + "cosmetics/capes?cape=", "cape",-1),
    AUTO_UPDATER(BASE.getURL() + "updater", "clientautoupdater",-1),
    FEATURED_SERVER(BASE.getURL() + "api/featuredserver?id=", "featuredServerALL",-1),
    SCREENSHOT(BASE.getURL() + "cloud/share/","share",-1),
    LATEST_NEWS(BASE.getURL() + "news", "news",-1),
    AUTH(BASE.getURL() + "api/auth","auth",-1),
    VOICE("https://voice.releaseteam.de", "voiceServer",-1),
    CHAT("https://chat.releaseteam.de", "chat",-1),
    FRIENDS(BASE.getURL() + "session/friends","friends", -1),
    CHANNEL(BASE.getURL() + "session/channel", "channel", 0);

    private final String url;
    private final String name;
    private final int port;

    ReleaseConnect(String url, String name, int port) {
        this.url = url;
        this.name = name;
        this.port = port;
    }
    public String getURL() {
        return url;
    }

    public String getName() {
        return name;
    }

    public int getPort() {
        return port;
    }
}
