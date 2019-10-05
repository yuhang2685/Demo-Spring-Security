## Demo-Spring-Security
Author: Dr. YUHANG ZHAO

### Overview:
<img src="https://github.com/yuhang2685/Demo-Spring-Security/blob/master/Demo-Spring-Security/BigPicture.png">

### STEP1: Adding Spring security to a Spring Boot project.
By adding security dependency, the URLs are protected by Spring security.

To login, the default username is "user" and password is shown in console.
<img src="https://github.com/yuhang2685/Demo-Spring-Security/blob/master/Demo-Spring-Security/Login.png" width="400" height="300">

### STEP2: Configure authentication and authorization.
Use a class which extends `WebSecurityConfigurerAdapter`
where we override `UserDetailsService` and make it a Bean.

Therefore, we have an "in-memory-user-details".


### STEP3. Authentication and authorization using JPA and MySQL.
We do authentication and authorization using user credentials stored in DB.

We can also encrypt password by hashing such as "Bcrypt".
![Login](https://github.com/yuhang2685/Demo-Spring-Security/blob/master/Demo-Spring-Security/Authen-JPA-MySQL.png)

### Reference:
- "Spring Security Tutorial", by Telusko, https://www.youtube.com/watch?v=fjkelzWNSuA
- "Spring Security Basics", by Java Brains, https://www.youtube.com/watch?v=sm-8qfMWEV8&list=PLqq-6Pq4lTTYTEooakHchTGglSvkZAjnE&index=1

