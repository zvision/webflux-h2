# webflux-h2

Simple Spring Boot project implementing reactive programming, using WebClient to make API call and functional endpoints to present the data.</br>
At start up access the <em><u>https://jsonplaceholder.typicode.com/posts</u></em> to fetch 100 posts and save them into h2 in-memory DB.   

<u>Using:</u>

- Spring  3.3.5
- Java 17
- Maven 3.9.5
<br></br> 

<strong><u>How to</u></strong>


- Build: mvn clean package 
- Run:  mvn spring-boot:run    (java -jar target\webflux_access_h2-0.0.1-SNAPSHOT.jar)




<strong><u>What to invoke</u></strong>

GET: 
- curl http://localhost:9011/router/posts     		<strong><i>Get all posts from h2 </i></strong>
- curl http://localhost:9011/router/post/{id}		<strong><i>Get specific number of posts from h2</i></strong>
- curl http://localhost:9011/router/posts/stream/{max} 		<strong><i>Get max number of posts as steram from h2</i></strong> 

<br></br> 
