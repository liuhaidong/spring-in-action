package com.arkdex.springinaction.schedule.controller;

import com.arkdex.springinaction.schedule.schedule.CustomTaskScheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {

    @Autowired
    private CustomTaskScheduler customTaskScheduler;

    @GetMapping("/future")
    String findFuture(){
        return customTaskScheduler.getFutureNames();

    }

    @GetMapping("/stop")
    String stop(@RequestParam("id") int id) {
        try{
            customTaskScheduler.stopTask(id);
            return "true";
        }catch (Exception e){
            return "false";
        }
    }

    @GetMapping("/start")
    String start(@RequestParam("task") String task) {
        try{
            customTaskScheduler.startTask(task);
            return "true";
        }catch (Exception e){
            return "false";
        }
    }
}
