This is the client project for generating and sending logs to the logstash.
This project is gradle based which includes filebeat(https://www.elastic.co/products/beats/filebeat) and SIGAR API("https://support.hyperic.com/display/SIGAR/Home").

System Requirements-
1)JDK 1.7 >=

Build Requirements-
1)Latest STS
2)Install "Buildship" from eclipse marketplace(for more information refer, http://gradle.org/eclipse/)

================================================================================================================================================================

FOR DISTRIBUTION BUILD(tar creation)

Build Instruction-
1)pull project
2)Uncomment defaultLogstashConfigPath constant(LogCollectorConstants.java) for "for distribution as tar"
AND Comment defaultLogstashConfigPath constant(LogCollectorConstants.java) for "for run as>java application"
3)Uncomment startLogStash constant(UbuntuCommands.java) for "for distribution as tar"
AND Comment startLogStash constant(UbuntuCommands.java) for "for run as>java application" 
4)open "Gradle Tasks" and "Gradle Executions" views
5)"Gradle Tasks" view shows tasks lists, from tasks lists, run task "clean", "build" and "assembleDist"(in same order)(double click on task to run that task)
6)tar file gets generated at /workspace/LogCollectorClient/build/distributions/
5)run elasticsearch on your local box
7)untar it, and run "./LogCollectorClient/bin/LogCollectorClient" from command line
8)To monitor logs, use kibana


=================================================================================================================================================================


FOR RUN AS JAVA APPLICATION

STEPS-->
1)Uncomment defaultFileBeatConfigPath constant(LogCollectorConstants.java) for "for run as>java application"
AND Comment defaultFileBeatConfigPath constant(LogCollectorConstants.java) for "for distribution as tar"
2)Uncomment startFileBeat constant(UbuntuCommands.java) for "for run as>java application"
AND Comment startFileBeat constant(UbuntuCommands.java) for "for distribution as tar"
3)From "Gradle Tasks" view, run "clean", "build" (in same order)
4)Select LogCollectorTimer.java(main class) and run as java application