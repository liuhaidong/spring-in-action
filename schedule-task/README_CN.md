# schedule-task
展示了更灵活的应用任务机制，比如停止某个任务，重启或是修改定时不重启应用的情况下更新执行周期。
以及透过这些功能的实现了解java线程是如何能实现定时任务的。 
##TaskController
用于接受请求并停止和重启某个定时任务的rest controller。
##CustomTaskScheduler
负责执行定时任务，维护了相关map对象，并重启或停止某个任务。
##ScheduleTask
记录一个运行的定时任务相关属性，包括 runnable，trigger等，进一步扩展相关方法，即可实现从数据库读取周期定义，动态更新。

