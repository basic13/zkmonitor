/*
 * Author: wuya
 * Create Date: 2015年11月26日 下午1:45:26
 */

package com.github.stuxuhai.zkmonitor.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.List;

import com.google.common.collect.Lists;

public class SocketUtils {

    public static List<String> sendCommand(String ip, int port, String cmd) throws IOException {
        try (Socket socket = new Socket(ip, port);
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))) {

            writer.write(cmd);
            writer.flush();

            List<String> list = Lists.newArrayList();
            String line = null;
            while ((line = reader.readLine()) != null) {
                list.add(line);
            }
            return list;
        } catch (IOException e) {
            throw new IOException(e);
        }
    }
}
