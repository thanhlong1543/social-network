package tp.kits3.ambi.route;

import java.util.HashMap;
/**
 * @author Vu Thanh Long
 */
public class Route {
	
	private static HashMap<String, String> routes;

    public static final String host = "/ambi";
    public static final String admin = "/admin";
    public static final String home = "/";
    public static final String friend = "/friend";
    public static final String login = "/login";
    public static final String logout = "/logout";
    public static final String profile = "/profile";
    public static final String profileFriend = "/profile/friend";
    public static final String profileTimeLine = "/profile/timeline";
    public static final String profilePhoto = "/profile/photos";
    public static final String profileEdit = "/profile/edit";
    public static final String timeLine = "/timeline";
    public static final String message = "/message";
    
    public static final String verify = "/registrationVerify";

    private static void setRoutes()
    {       
        if(routes == null)
        {
            routes = new HashMap<String, String>();

            routes.put("host", host);
            routes.put("home", host + home);
            routes.put("friend",host + friend);
            routes.put("login", host + login);
            routes.put("logout", host + logout);
            routes.put("profile", host + profile);
            routes.put("profileFriend", host + profileFriend);
            
            routes.put("profileTimeLine", host + profileTimeLine);
            
            routes.put("profilePhoto", host + profilePhoto);
            
            routes.put("profileEdit", host + profileEdit);
            routes.put("message", host + message);
        }
    }   

    public static HashMap<String, String> getRoutes()
    {
        setRoutes();
        
        return routes;
    }

    public static String getRoute(String uri)
    {
    	
        setRoutes();

        return routes.get(uri);
    }

}
