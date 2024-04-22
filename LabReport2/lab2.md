**Part1**
Code for `ChatServer.java`

import java.io.IOException;
import java.net.URI;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;



class Handler implements URLHandler {
    StringBuilder chatLog = new StringBuilder();

    public String handleRequest(URI url) {
        if (url.getPath().equals("/")) {
            return "Welcome to the ChatServer! Use /add-message?s=<message>&user=<user> to post messages.";
        } else if (url.getPath().equals("/add-message")) {
            String query = url.getQuery();
            Map<String, String> params = parseQuery(query);
            if (params.containsKey("user") && params.containsKey("s")) {
                String user = params.get("user");
                String message = params.get("s");
                chatLog.append(user).append(": ").append(message).append("\n");
                return chatLog.toString();
            }
            return "Invalid request. Please make sure both 'user' and 's' parameters are included.";
        }
        return "404 Not Found!";
    }

    private Map<String, String> parseQuery(String query) {
        Map<String, String> result = new HashMap<>();
        if (query != null) {
            for (String param : query.split("&")) {
                String[] entry = param.split("=");
                if (entry.length > 1) {
                    try {
                        result.put(entry[0], URLDecoder.decode(entry[1], "UTF-8"));
                    } catch (IOException e) {
                        System.err.println("Error decoding parameter: " + param);
                    }
                } else {
                    result.put(entry[0], "");
                }
            }
        }
        return result;
    }
}

class ChatServer {
    public static void main(String[] args) throws IOException {
        if(args.length == 0){
            System.out.println("Missing port number! Try any number between 1024 to 49151");
            return;
        }

        int port = Integer.parseInt(args[0]);

        Server.start(port, new Handler());
    }
}

screenshot1: ![Image](interaction1.PNG)

The two `methods` called are `handleRequest(URI url)` and `parseQuery(String query)`.

`Arguments`:

`URI url` with a value of new `URI("/add-message?s=Hi!&user=Kevin")`and `String query` with a `value` of `"s=Hi!&user=Kevin"`

`Field Values`:

`StringBuilder chatLog` initially `empty`

`Field` Changes:

`chatLog` changes from an `empty` state to `"Kevin: Hi!\n"` after appending the formatted message.

screenshot2: ![Image](interaction2.PNG)

1.The two `methods` called are `handleRequest(URI url)` and `parseQuery(String query)`.

`Arguments`:

`URI url` with a `value` of new `URI("/add-message?s=Hey How are you?&user=John")` and `String query` with a `value` of `"s=Hey How are you?&user=John"`

`Field Values:`

`StringBuilder chatLog` currently holding `"Kevin: Hi!\n"`

`Field` Changes:
`chatLog` changes from `"Kevin: Hi!\n"` to `"Kevin: Hi!\nJohn: Hey How are you?\n"` after appending the second formatted message.
