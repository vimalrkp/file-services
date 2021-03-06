################################## prerequisite  ###############################
1. Java 1.8 or above
2. Spring boot 2.4.3

################################### Run command  ###############################
java -jar file-services-1.0.jar --server.port=8090 --fs.docs.repo.root=/docs-repo

################################### Project setup ##############################
1. Clone the file-services repo from Git or Download the Git hub project to the local.
2. Have installed JDK 1.8 or above.
3. Import the spring boot project as simple Maven project to the IDE.
4. Do the Maven update and make sure no project errors.
5. Do Maven clean install -DskipTests to build the runnable jar.
6. Run the application either through IDE as spring boot app or with the jar command as mentioned above in #Run command section.
7. In the both the ways make sure to give the program arguments --server.port=8090 --fs.docs.repo.root=/docs-repo
8. server.port can be any port which is available.
9. fs.docs.repo.root is the root directory for the document repository. e.g. /docs-repo.
10. Create the document directories as you need based on the configurations which you will do E.g.\docs-repo\phone\ios\iphone-x.xlsx
11. Launch the aplication url http://localhost:8090/fs/, it will show you the home page with three default drop downs 1. Category, 2. Sub Category1, Sub Category2.
12. If I select the following values PHONE, IOS, IPHONE-X for Category, Sub Category1, and Sub Category2 respectively then the application will download the file from the server folder \docs-repo\phone\ios\iphone-x.xlsx, if the file doesn't exist then application will show you the error page.