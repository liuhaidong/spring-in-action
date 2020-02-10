# spring-in-action
记录关于spring boot的技术实践,包括 tasks, feign, eureka, hystrix, zuul, sleuth, and stream calculations等.
这些范例不仅仅记录了如何使用spring框架的某个组件或特性，也同时包含了关于如何运用这些技术到企业应用的思考。


##schedule-task
通过 @Scheduled 标签可以快速创建一个定时执行的任务，如果要更灵活的应用，比如停止某个任务，重启或是修改定时不重启应用的情况下更新执行周期。
以及透过这些功能的实现了解java线程是如何能实现定时任务的。  