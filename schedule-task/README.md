# schedule-task
Show the way to stop/restart schedule tasks, and how java thread is used for spring task.

##TaskController
The rest controller to receive the request for stop/restart task
##CustomTaskScheduler
Maintain a future map to stop/restart the task
##ScheduleTask
Hold the running task and Trigger property, it's possible to stop the task, read new trigger configure and restart task.

