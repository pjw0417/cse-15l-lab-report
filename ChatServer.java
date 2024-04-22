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

