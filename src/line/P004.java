package line;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;



public class P004 {

    public static void main(String[] args) throws IOException {
        HashMap<String, String> users = new HashMap<>();
        try (final BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            final int n = Integer.parseInt(br.readLine());
            for (int i = 0; i < n; i++) {
                final StringTokenizer tokenizer = new StringTokenizer(br.readLine());
                String method = tokenizer.nextToken();
                String url = tokenizer.nextToken();
                String body = null;
                if (tokenizer.hasMoreTokens()) {
                    body = tokenizer.nextToken();
                }

                if("POST".equals(method)){
                    if(url.startsWith("/users/")){
                        String [] op = url.split("/");
                        String user = op[2];
                        if(op.length == 3){
                            if(users.keySet().contains(user)){
                                System.out.println("403 FORBIDDEN");
                            }else{
                                users.put(user, null);
                                System.out.println("201 CREATED");
                            }
                        }else if(op.length == 4){

                            if(users.keySet().contains(user)){
                                if(url.endsWith("/data")){
                                    if(body == null){
                                        System.out.println("405 METHOD_NOT_ALLOWED");
                                    }else {
                                        String value = body.substring(6);
                                        users.put(user, value);
                                        System.out.println("200 OK");
                                    }
                                }else{
                                    System.out.println("404 NOT_FOUND");
                                }
                            }else{
                                System.out.println("403 FORBIDDEN");
                            }

                        }else{
                            System.out.println("404 NOT_FOUND");
                        }

                    }else{
                        System.out.println("404 NOT_FOUND");
                    }
                }else if("GET".equals(method)){
                    if(url.startsWith("/users/")){
                        String [] op = url.split("/");
                        String user = op[2];
//                        System.out.println("User : " + user);
                        if(op.length == 3){
                            System.out.println("405 METHOD_NOT_ALLOWED");
                        }else if(op.length == 4){
                            if(users.keySet().contains(user)){
                                if(url.endsWith("/data")){
                                    if(users.get(user) == null){
                                        System.out.println("404 NOT_FOUND");
                                    }else{
                                        System.out.println("200 OK " + users.get(user));
                                    }
                                }else{
                                    System.out.println("404 NOT_FOUND");
                                }
                            }else{
                                System.out.println("403 FORBIDDEN");
                            }
                        }else{
                            System.out.println("404 NOT_FOUND");
                        }

                    }else{
                        System.out.println("404 NOT_FOUND");
                    }
                }else{

                }

//                System.out.println(method + ", " + url + ", " + body);
            }
        }
    }

}
