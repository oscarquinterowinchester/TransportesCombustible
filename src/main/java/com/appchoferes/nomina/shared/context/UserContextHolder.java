package com.appchoferes.nomina.shared.context;

public class UserContextHolder {
    
    private static ThreadLocal<UserContext> userContext = new ThreadLocal<>();

    public static void setUserContext(UserContext context){
        userContext.set(context);
    }

    public static UserContext getUserContext() {
        return userContext.get();
    }

    public static UserContext clear(){
        return userContext.get();
    }

    public static String getDatabaseName (){
        UserContext ctx = userContext.get();
        return (ctx != null) ? ctx.getDatabaseName() : null;
    }

    public static String getUsername() {
        UserContext ctx = userContext.get();
        return (ctx != null) ? ctx.getUsername() : null;
    }

    public static String getPassword() {
        UserContext ctx = userContext.get();
        return (ctx != null) ? ctx.getPassword() : null;
    }
}
