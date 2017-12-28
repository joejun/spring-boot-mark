package com.joe.chapter031.controller;

import com.joe.chapter031.domain.Task;
import com.joe.chapter031.domain.User;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: Joe
 * description:
 * @date: 2017-12-28
 */
@Api(value = "/swagger-restful/api/v1", description = "用户相关操作") //修饰整个类，描述Controller的作用
@RestController
@RequestMapping(value = "/swagger-restful/api/v1")
public class UserController {

    // 创建一个线程安全的map，模拟数据库，存放用户信息
    static Map<Long, User> users = new HashMap<>();

    /**
     * 新增用户
     * @param user
     * @return
     */
    @ApiOperation(value = "创建用户", notes = "根据User对象创建用户") //描述一个类的一个方法，或者说一个接口
    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public String addUser(@RequestBody User user) {
        users.put(user.getId(), user);
        return "success";
    }

    /**
     * 获取用户信息--by @ApiImplicitParam
     * @param userId 用户主键id
     * @return
     */
    @ApiOperation(value = "获取用户详细信息", notes = "根据url的id来获取用户详细信息--by @ApiImplicitParam")
    @ApiImplicitParam(name = "user_id", value = "用户ID", required = true, dataType = "Long", paramType = "path",
            defaultValue = "124")
    @RequestMapping(value = "/users/{user_id}", method = RequestMethod.GET)
    public User getUser(@PathVariable(name = "user_id") Long userId) {
        return users.get(userId);
    }

    /**
     * 获取用户信息--by @ApiParam
     * @param userId 用户主键id
     * @return
     */
    @ApiOperation(value = "获取用户详细信息", notes = "根据url的id来获取用户详细信息--by @ApiParam")
    @RequestMapping(value = "/users2 /{user_id}", method = RequestMethod.GET)
    public User getUser2(
            @ApiParam(name = "user_id", value = "用户ID", defaultValue = "123", required = true)
            @PathVariable(name = "user_id") Long userId) {
        return users.get(userId);
    }

    /**
     * 更新用户
     * @param userId
     * @param user
     * @return
     */
    @ApiOperation(value = "更新用户详细信息", notes = "根据url的id来指定更新对象，并根据传过来的user信息来更新用户详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user_id", value = "用户ID", required = true, dataType = "Long", paramType = "path")
//            @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
        // @ApiImplicitParam 传递 requestbody时，无法在swagger提供具体属性信息
    })
    @RequestMapping(value = "/users/{user_id}", method = RequestMethod.PUT)
    public String updateUser(@PathVariable(name = "user_id") Long userId, @RequestBody User user) {
        User oldUser = users.get(userId);
        oldUser.setAge(user.getAge());
        oldUser.setName(user.getName());
        users.put(userId, oldUser);
        return "success";
    }

    /**
     * 删除用户
     * @param userId
     * @return
     */
    @ApiOperation(value = "删除用户", notes = "根据url的userId来指定删除对象")
    @ApiImplicitParam(name = "user_id", value = "用户ID", required = true, dataType = "Long", paramType = "path")
    @RequestMapping(value = "/users/{user_id}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable(name = "user_id") Long userId) {
        users.remove(userId);
        return "success";
    }

    /**
     * 新增用户的task
     * @param task
     * @return
             */
    @ApiOperation(value = "创建用户下面的task", notes = "根据Task对象创建用户task") //描述一个类的一个方法，或者说一个接口
    @RequestMapping(value = "/users/{user_id}/tasks", method = RequestMethod.POST)
    public String addUser(@PathVariable(name = "user_id") Long userId, @RequestBody Task task) {

        User u = users.get(userId);
        List<Task> tasks = u.getTasks();
        tasks.add(task);
        u.setTasks(tasks);

        return "success";
    }

    /**
     * 获取用户任务列表
     * @param userId 用户主键id
     * @return
     */
    @ApiOperation(value = "获取用户任务列表", notes = "根据url的id来获取用户任务列表")
    @ApiImplicitParam(name = "user_id", value = "用户ID", required = true, dataType = "Long", paramType = "path",
            defaultValue = "124")
    @RequestMapping(value = "/users/{user_id}/tasks", method = RequestMethod.GET)
    public List<Task> getUserTasks(@PathVariable(name = "user_id") Long userId) {
        return users.get(userId).getTasks();
    }

    /**
     * 获取用户任务详情
     * @param userId 用户主键id
     * @param taskId 任务id
     * @return
     */
    @ApiOperation(value = "获取用户任务详情", notes = "根据url的id来获取用户任务详情")
    @ApiImplicitParams(
            {@ApiImplicitParam(name = "user_id", value = "用户ID", required = true, dataType = "long", paramType = "path",
            defaultValue = "124"),
            @ApiImplicitParam(name = "task_id", value = "用户ID", required = true, dataType = "string", paramType =
                    "path",
                    defaultValue = "124")}
    )
    @RequestMapping(value = "/users/{user_id}/tasks/{task_id}", method = RequestMethod.GET)
    public Task getUserTasks(
            @PathVariable(name = "user_id") Long userId,
            @PathVariable(name = "task_id") String taskId
    ) {
        List<Task> tasks = users.get(userId).getTasks();
        if(null != tasks){
            for(Task task: tasks){
                if(null != task && task.getTaskId().equals(taskId)){
                    return task;
                }
            }
        }
        return null;
    }


    @ApiOperation(value = "获取用户任务详情", notes = "根据url的id来获取用户任务详情--by query params 查询")
    @ApiImplicitParam(name = "user_id", value = "用户ID", required = true, dataType = "long", paramType = "path",
                    defaultValue = "124")
    @RequestMapping(value = "/users/{user_id}/tasks-info", method = RequestMethod.GET)
    public Task getUserTasksByObj(
            @PathVariable(name = "user_id") Long userId, Task task) {
        List<Task> tasks = users.get(userId).getTasks();
        if(null != tasks){
            for(Task t: tasks){
                if(null != task && task.getTaskId().equals(task.getTaskId())){
                    return task;
                }
            }
        }
        return null;
    }
}
