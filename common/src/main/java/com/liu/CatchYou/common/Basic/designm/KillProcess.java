package com.liu.CatchYou.common.Basic.designm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dmrj on 2017-06-23.
 */
public class KillProcess {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
       // try {
            //runtime.exec("taskkill /F /IM QQ.exe");
            KillProcess.isRunning("qq");
      //  } catch (IOException e) {
      //      e.printStackTrace();
      //  }
    }

    /**
     * 查找当前系统中的QQ进程并且KILL掉。
     * @param exeName
     * @return
     */
    public static boolean isRunning(String exeName) {
        Process proc;
        try {
            proc = Runtime.getRuntime().exec("tasklist");
            BufferedReader br = new BufferedReader(new InputStreamReader(proc
                    .getInputStream()));
            String info = br.readLine();
            while (info != null) {
                System.out.println(info);
               /* if (info.indexOf(exeName) >= 0) {
                    return true;
                }*/
               if (info.contains("QQ.exe")) {
                   Runtime.getRuntime().exec("taskkill /F /IM QQ.exe");
                   return true;
               }
                info = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(false);
        return false;
    }
}
