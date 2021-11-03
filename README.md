# FrontBack

# Instructions
In order to get the api running you need to install docker https://docs.docker.com/get-docker/ 

create and acount https://hub.docker.com/ 

When oppening the project you need to run in the project path terminal 

``` docker build -t frontback . ```

Then, in a terminal on project path /src/main/resources run

``` docker compose up mysql ``` --> to run database image 

and after that:

``` docker compose up frontback ``` --> to run app image
<br>

API is running
