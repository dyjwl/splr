package com.mm.splr.controller;


import com.mm.splr.version.ApiVersion;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@ApiVersion(value = 2)
@RestController
@RequestMapping("api/{version}/data")
public class DataController {

    @RequestMapping("/getDataById/{id}")
    public String getDataById(@PathVariable("id") Long id) {
        return "getDataById:" + id;
    }

    @RequestMapping("/getJson/*.json")
    public String getJson() {
        return "get json data";
    }

    @RequestMapping("/getJson2/abc?.json")
    public String getJson2() {
        return "getJson2 data";
    }

    @RequestMapping("/getJson3/{id:\\d{6}}")
    public String getJson3(@PathVariable Long id) {
        return "getJson3 data";
    }

    @RequestMapping(value = "/getData", method = RequestMethod.GET)
    public String getData() {
        return "RequestMethod GET";
    }

    @RequestMapping(value = "/getData", method = RequestMethod.POST)
    public String PostData() {
        return "RequestMethod POST";
    }

    //处理request Content-Type为“application/json”类型的请求。
    @RequestMapping(value = "/Content", method = RequestMethod.POST, consumes = "application/json")
    public String Consumes(@RequestBody Map param) {
        return "Consumes POST  Content-Type=application/json";
    }
    //处理request请求中Accept头中包含了”application/json”的请求，同时返回的内容类型为application/json;
    @RequestMapping(value = "/Content/{id}", method = RequestMethod.GET, produces = "application/json")
    public String produces(@PathVariable Long id) {
        return "produces get id: " + id;
    }

    @RequestMapping(value="paramsTest",params="action=save")
    public String paramsTest(@RequestBody Map param){
        return "params test";
    }

    @RequestMapping(value="headerTest",headers={"Host=localhost:8080"})
    public String headerTest()
    {
        return "header test";
    }


}
