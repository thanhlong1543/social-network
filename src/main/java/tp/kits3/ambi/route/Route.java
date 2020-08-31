package tp.kits3.ambi.route;

import java.util.HashMap;

public class Route {
	
	private static HashMap<String, String> routes;

    public static final String host = "/ambi";
    public static final String admin = "/admin";
    public static final String home = "/";
    public static final String friend = "/friend";
    public static final String login = "/login";
    public static final String logout = "/logout";
    
    private static void setRoutes()
    {       
        if(routes == null)
        {
            routes = new HashMap<String, String>();

            routes.put("host", host);
            routes.put("home", host + home);
            routes.put("friend", host + friend);
            routes.put("login", host + login);
            routes.put("logout", host + logout);
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
