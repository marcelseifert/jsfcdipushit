/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.marcel.web.asynch;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.concurrent.ExecutorService;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marcel
 */
@FutureSupport
@Interceptor
public class FutureInterceptor implements Serializable
{
    private static final long serialVersionUID = 7938266823530974338L;

     private ExecutorService         pool           = Executors.newCachedThreadPool();
    @AroundInvoke
    public Object executeAsynchronous(final InvocationContext invocationContext) throws Exception
    {
        System.out.println("executeAsynchronous start "+this.hashCode());
          
        try
        {
             Runnable worker = new Runnable() {

                 @Override
                 public void run() {
                     try { 
                         System.out.println("worker proceed context");
                         
                         Method m =  invocationContext.getMethod();
                         Object target = invocationContext.getTarget();
                          Object[] params = invocationContext.getParameters();
                         m.invoke(target, params);
                     } catch (Exception ex) {
                         ex.printStackTrace();
                         Logger.getLogger(FutureInterceptor.class.getName()).log(Level.SEVERE, null, ex);
                     }
                 }
             };
             pool.execute(worker);
             
        } catch (Exception ex) {
            ex.printStackTrace();
        } 
        return null; 
    }
}
