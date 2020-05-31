package com.ct.utils.DWR;

import com.ct.pojo.User;
import org.directwebremoting.Container;
import org.directwebremoting.ServerContextFactory;
import org.directwebremoting.WebContextFactory;
import org.directwebremoting.event.ScriptSessionEvent;
import org.directwebremoting.event.ScriptSessionListener;
import org.directwebremoting.extend.ScriptSessionManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

public class DwrScriptSessionManagerUtil extends dwrMessage{


    public void init() throws ServletException {
        Container container= ServerContextFactory.get().getContainer();
        ScriptSessionManager manager=container.getBean(ScriptSessionManager.class);
        ScriptSessionListener listener=new ScriptSessionListener(){
            @Override
            public void sessionCreated(ScriptSessionEvent scriptSessionEvent) {
                HttpSession session= new WebContextFactory().get().getSession();
                Integer uId=((User)session.getAttribute("USER_ID")).getuId();
                System.out.println("session 已创建");
                scriptSessionEvent.getSession().setAttribute("USER_ID",uId);
            }

            @Override
            public void sessionDestroyed(ScriptSessionEvent scriptSessionEvent) {
                System.out.println("session 被销毁");
            }
        };
        manager.addScriptSessionListener(listener);
    }
}
