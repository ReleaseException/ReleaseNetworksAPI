# ReleaseClientAuth

For the authentication for the player who uses our client we have our own backend thats based on JavaScript. You can use the following snippets to get access to certain data of our ReleaseClient.


## BaseContent
At the beginning we're offering an pretty simple method to get the content of the given page.

```java
    public static String getSiteContent(String url) throws Exception {
        StringBuilder result = new StringBuilder();
        HttpURLConnection urlConnection = (HttpURLConnection) new URL(url).openConnection();
        urlConnection.setRequestMethod("GET");
        BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
        String content;
        while ((content = reader.readLine()) != null) {
            result.append(content);
        }
        reader.close();
        return result.toString();
    }
```

## Client versions
At the moment there are three different verions of the ReleaseClient: legacy, latest, canary. You get the version of an type by using the method below, you can use to get information about the client that the player is using.

```java
    public static String getVersionByType(String type) {
        String result = "";
        try {
            String content = getHTML("http://releaseteam.de/api/client");
            JsonObject json = new JsonParser().parse(content).getAsJsonObject();
            result = json.get("type").getAsString();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return result;
    }
```
