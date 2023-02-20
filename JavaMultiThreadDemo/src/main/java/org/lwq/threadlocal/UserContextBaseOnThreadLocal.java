package org.lwq.threadlocal;

/**
 * @author liwenqi
 */
public class UserContextBaseOnThreadLocal<T> implements AutoCloseable {

    private static final ThreadLocal<UserContextBaseOnThreadLocal<?>> USER_CONTEXT = new ThreadLocal<>();
    private T info;


    private UserContextBaseOnThreadLocal(){

    }

    public static <T> UserContextBaseOnThreadLocal<T> init(){
        UserContextBaseOnThreadLocal<T> context = new UserContextBaseOnThreadLocal<>();
        USER_CONTEXT.set(context);
        return context;
    }


    public static <T> UserContextBaseOnThreadLocal<T> get(){
        return (UserContextBaseOnThreadLocal<T>) USER_CONTEXT.get();
    }

    public static void fill(User userInfo){
        UserContextBaseOnThreadLocal<User> context = UserContextBaseOnThreadLocal.get();
        context.info = userInfo;
    }

    public static UserContextBaseOnThreadLocal<?> set(UserContextBaseOnThreadLocal<?> context){
        UserContextBaseOnThreadLocal<?> backup = get();
        USER_CONTEXT.set(context);
        return backup;
    }

    @Override
    public void close() {
        USER_CONTEXT.remove();
    }
}
