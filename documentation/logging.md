# Logging

## What is logging?

Logging is the process of providing information about an application as it performs different tasks or events, in other words It's a means of tracking events that happen when some software runs.
Logging is used for Analysis, Debugging, troubleshooting, security, and performance monitoring.

## Where to log: console vs file? Anywhere else?

The most common locations for logging are the console (standard output) and files, but there are other options as well. Let's explore each of these options:

**Console** (Standard Output): Logging to the console involves printing log messages directly to the standard output stream. In many programming languages, this is often accomplished using functions like console.log() in JavaScript. Logging to the console is useful during development and debugging phases when developers need real-time visibility. into the application's behavior( you can see the messages immediately.) However, it's essential to avoid excessive logging in production environments as it may impact performance and security.

**File Logging**: Writing log messages to files is a common practice in production environments. Each log entry is appended to a designated log file. You can view them later and search through them in a text editor. Additionally, it keeps the logs separate from the application, which can be helpful for debugging when applications crash or encounter issues. However, managing log files over time (e.g., rotating logs to prevent them from growing too large) is crucial to avoid disk space issues.
![image](https://github.com/Frank-readresolve/itp3-dist-arch/assets/94375151/4ddc26b5-0f36-460d-9178-32ad713e8f31)

---

**Remote Logging:** In distributed systems or cloud environments, it might be beneficial to log to a centralized logging server or service. This approach, known as remote logging or centralized logging, involves sending log data from multiple sources (e.g., different servers or microservices) to a central log repository. Centralized logging simplifies log management, analysis, and correlation across the entire system. Tools like Elasticsearch, Logstash, and Kibana (ELK stack) or Splunk are commonly used for remote logging.

**Database Logging:** Some applications log directly to databases, storing log entries in dedicated log tables. This approach provides easy access to log data for reporting and querying, but it may impact database performance, especially under heavy logging.

## What to log?

Useful Information to Log

**Application Session start/stop.** We recommend including a log statement as early and as late as possible in your application’s run time. Also, if your program has complex setup or teardown logic, include additional messages at the start and end of these sections.

**User Session start/stop.** For many applications such as services and web apps, there may be many user sessions within a single application session. Log distinctive messages at the start and end of each of these logical sessions.

**Unhandled Exceptions.** Loupe will log unhandled exceptions by default. But, if you write your own exception handler, be sure to log each exception to Loupe - passing the exception object as well as what context you have.

**Handled Exceptions.** We strongly recommend that in all cases where an exception is consumed within a catch block that you log the exception with an Informational severity rather than silently swallowing the error. Bonus prize for including what your code is going to do in the face of this handled exception (in other words, how you’re handling it!)

**Process Entrance and Exit.** Each time your code gets called from another process (like an incoming web request to your web application) or you call out to another process (like a database query or remote web request) log the request, generally with significant detail. If the request fails, log that as well. These statements serve as “bookmarks” for understanding why your software worked or didn’t. Compared to the cost of calling to another process, particularly across a network, these log statements are practically free.

**Significant User Actions.** We recommend that you log each significant action taken by the user and that you use a specific category for these log messages. This makes it easy to reconstruct reproduction steps for defect reports. Some examples of this include:

1. Button actions - describe what the button means (Save, cancel, add, delete, etc.)
2. Navigating to a new context - Switching tabs in a large application, opening views, etc.
3. Any message box / modal prompt displayed.
   4 .Expensive operations like recalculating data sets, visualizations, or others.

**Display Help requests.** From a usability perspective, every time a user opens your help documentation is a hint that something could be made clearer in the user interface.

**Cancelled Actions.** When a user begins an action then abandons it without completing, it may also point to usability issues.

**Log Thread start/stop.** If your application creates background threads, consider creating a helper class to create threads that will automatically log thread start/stop.

**Asynchronous request start/stop.** We recommend logging the start and stop of most asynchronous requests – possibly excluding high frequency activities such as loading the individual elements of a web page.

## What is a log level ?

A log level or log severity is a piece of information telling how important a given log message is. It is a simple, yet very powerful way of distinguishing log events from each other.

You can think of the log levels as a way to filter the critical information about your system state and the one that is purely informative.

## What is a rolling policy ?

A RollingPolicy is responsible for performing the rolling over of the active log file. The RollingPolicy is also responsible for providing the active log file, that is the live file where logging output will be directed.

## What do we need to know/specify regarding remote environments?

Specify how monitoring and logging will be handled in the remote environment. Define which metrics will be monitored, how logs will be collected, and how alerts will be set up to notify about critical issues.

## How/where can we configure logging in a Spring boot app?

In a Spring Boot application, you can configure logging using the application.properties

By default, Spring Boot uses Logback as the logging framework.

**Logback** is one of the most widely used logging frameworks in the Java Community. It's a replacement for its predecessor, Log4j.

## Implementation 

Basically, you just need to specify the following two lines in the application.properties file to enable daily rolling files logging:

First, you have to specify the file name

 logging.file.name=${supportrequest.logs.file.location}/${supportrequest.logs.file.name}.current.log

 Here, the first property specifies the original log file name, and the second one specifies the pattern for the files which will be rolled out the next days (daily rolling). In the pattern, I append date format %d{yyyy-MM-dd} and the ordinal number of the log file (%i) to the file name (MyApp-)

 logging.logback.rollingpolicy.file-name-pattern=${supportrequest.logs.file.location}/${supportrequest.logs.file.name}.%d{yyyy-MM-dd}.%i.log.gz
Rolling policy: A rolling policy must be set based on max file size and total size cap

You can also specify a threshold for log file size using the following property

 logging.logback.rollingpolicy.max-file-size=25KB
You can control the total size of all log files under a specified number, by using the following property:

 logging.logback.rollingpolicy.total-size-cap=60KB
 
Optional :

logging.file.clean-history-on-start=true

So when our Spring Boot application starts, Logback will clean the old log files based on the values of total size and max history. This property is set to false by default.

The result that should be displayed is as follows: 

![image](https://github.com/Frank-readresolve/itp3-dist-arch/assets/94375151/60ba49e9-b703-4c3b-95bc-fcdf262acd43)


## References

https://onloupe.com/solutions/what-should-i-log-in-my-application/
https://docs.spring.io/spring-boot/docs/2.1.13.RELEASE/reference/html/boot-features-logging.html
https://sematext.com/blog/logging-levels/#:~:text=A%20log%20level%20or%20log,look%20at%20the%20severity%20first.

https://logback.qos.ch/apidocs/ch/qos/logback/core/rolling/RollingPolicy.html

https://www.baeldung.com/logback#:~:text=Logback%20is%20one%20of%20the,replacement%20for%20its%20predecessor%2C%20Log4j.
