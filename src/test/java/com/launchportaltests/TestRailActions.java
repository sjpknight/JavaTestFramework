package com.launchportaltests;

import com.launchportaltests.gurock.testrail.APIClient;
import org.json.simple.JSONObject;

public class TestRailActions {

    public static void main(String[] args) throws Exception
    {
        APIClient client = new APIClient("https://sjpknight.testrail.com");
        client.setUser("sjpknight-automation@gmail.com");
        client.setPassword("P@55w0rd");

        JSONObject c = (JSONObject) client.sendGet("get_case/1");
        System.out.println(c.get("title"));


    }
}
