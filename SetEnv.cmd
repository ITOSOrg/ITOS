SET PROJECT_HOME=C:\Projects
SET TOOLS_HOME=%PROJECT_HOME%\Tools

SET ANT_HOME=%TOOLS_HOME%\apache-ant-1.8.4
SET ANT_OPTS=-Xmx512m

SET J2EE_JAR=%TOOLS_HOME%\jar\j2ee.jar
SET JAVA_HOME=%TOOLS_HOME%\jdk1.6.0_43
SET JAVAMAIL_HOME=%TOOLS_HOME%\Sun\AppServer\lib

REM SET M2_HOME=%TOOLS_HOME%\apache-maven-3.2.3
REM SET M2=%M2_HOME%\bin
SET MAVEN_OPTS=-Xms256m -Xmx512m

SET ORACLE_HOME=C:\Projects\Tools\Oracle\product\11.2.0\dbhome_1

SET PATH=%ANT_HOME%\bin;%JAVA_HOME%\bin;%ORACLE_HOME%\bin;
REM SET PATH=%ANT_HOME%\bin;%JAVA_HOME%\bin;%M2%;%ORACLE_HOME%\bin;
REM SET CLASSPATH=%CLASSPATH%;

SET SERVER_DIR=%PROJECT_HOME%\ITOS

