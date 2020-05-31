package com.ct.utils.DWR;


import org.directwebremoting.*;

import javax.servlet.ServletException;
import java.util.Collection;

public class dwrMessage {

    public void onPageLoad(String userid){
        ScriptSession scriptSession= WebContextFactory.get().getScriptSession();
        scriptSession.setAttribute(userid,userid);
        DwrScriptSessionManagerUtil scriptSessionManagerUtil=new DwrScriptSessionManagerUtil();
        try {
           scriptSessionManagerUtil.init();
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }


    /**
     * 发送消息
     */
    public void sendMessage(String userid, String message, String jsFuc){
        final String userId = userid;

        final String msg = message;

        final String jsFunc = jsFuc;
        Browser.withAllSessionsFiltered(new ScriptSessionFilter(){
            public boolean match(ScriptSession scriptSession) {
                if (scriptSession.getAttribute("USER_ID")==null){
                    return false;
                }else
                return scriptSession.getAttribute("USER_ID").equals(userId);
            }
        }, new Runnable(){
            private ScriptBuffer script = new ScriptBuffer();
            public void run() {// 推送消息
                script.appendCall(jsFunc,msg);
                Collection<ScriptSession> sessions = Browser.getTargetSessions();
                for (ScriptSession scriptSession : sessions) {
                    scriptSession.addScript(script);
                }
            }
        });
    }
}
