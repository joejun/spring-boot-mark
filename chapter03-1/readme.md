# Swaggr集成 + Restful规范整理

## Swagger是当前最好用的Restful API文档生成的开源项目  
测试spring restful风格的接口功能。
官方网站为：http://swagger.io/  
### ApiImplicitParam 与 ApiParam 的区别  
* 对Servlets或者非 JAX-RS的环境，只能使用 ApiImplicitParam。
* 在使用上，ApiImplicitParam比ApiParam具有更少的代码侵入性，只要写在方法上就可以了，
    但是需要提供具体的属性才能配合swagger ui解析使用。
* ApiParam只需要较少的属性，与swagger ui配合更好。    

## Restful规范整理：  
### 请求方法  
GET（SELECT）：从服务器取出资源（一项或多项,一项时一般在路径中包含唯一ID，多项时资源用复数）。
POST（CREATE）：在服务器新建一个资源。
PUT（UPDATE）：在服务器更新资源（客户端提供改变后的完整资源）。
PATCH（UPDATE）：在服务器更新资源（客户端提供改变的属性）。
DELETE（DELETE）：从服务器删除资源。

GET /tickets   					- Retrieves a list of tickets  
GET /tickets/12 			    - Retrieves a specific ticket  
POST /tickets 				    - Creates a new ticket  
PUT /tickets/12 			    - Updates ticket #12  
PATCH /tickets/12 		        - Partially updates ticket #12  
DELETE /tickets/12 		        - Deletes ticket #12  

GET /tickets/12/messages 			- Retrieves list of messages for ticket #12  
GET /tickets/12/messages/5 			- Retrieves message #5 for ticket #12  
POST /tickets/12/messages 			- Creates a new message in ticket #12  
PUT /tickets/12/messages/5 			- Updates message #5 for ticket #12  
PATCH /tickets/12/messages/5 		- Partially updates message #5 for ticket #12  
DELETE /tickets/12/messages/5 		- Deletes message #5 for ticket #12  
