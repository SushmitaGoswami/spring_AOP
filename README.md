# Spring AOP

Spring AOP is used to increase modularity by cross-cutting concerns. A cross-cutting concern/logic is a concern that can affect the whole application and should be centralized in one location in code as possible, such as transaction management, authentication, logging, security etc.

## Use case
Suppose, you have to implement an audit mechanism for every method in your application. So, if you introduce the audit code in all the files, it will be a repetition. Moreover, when there will be a need to change the logic, you have to update the code in all the files. Hence, AOP provides a solution to this problem which will introduce this cross-cutting concern as an infrastructure so that it can be deployed in every layer of your application.

1. Common use cases - Logging, Security
2. Auditing
3. API Management - Analysing how many calls are being made to that API.
4. Exception Handling 

## AOP helps to solve two main problems
- Code Tangling
- Code scattering
- Improve the code reusability
- Apply the aspect based on configuration.

## Disadvantages of AOP
- Makes the code hard to trace when many aspects are being added.
- Sometimes performance gets lowered when an runtime weaving is applied.


## AOP Terminology
- **Join point** is any point in a program such as method execution, exception handling, field access etc. Spring supports only method execution join point.
- **Aspect** is the module of the code which solves the cross-cutting concerns.
- **Advice** represents an action taken by an aspect at a particular join point. There are different types of advices:
    - **Before Advice**: it executes before a join point.
    - **After Returning Advice**: it executes after a joint point completes normally.
    - **After Throwing Advice**: it executes if method exits by throwing an exception.
    - **After (finally) Advice**: it executes after a join point regardless of join point exit whether normally or exceptional return.
    - **Around Advice**: It executes before and after a join point.
- **Point-cut** expression specify where to apply the aspect.
- **Weaving** is the process of linking aspect with the target object to create an advised object. Weaving can be done at compile time, load time or runtime. Spring AOP performs weaving at runtime.
- **Target Object** is the object i.e. being advised by one or more aspects. It is also known as proxied object in spring because Spring AOP is implemented using runtime proxies.


## AOP Implementations
AOP implementations are provided by:
- AspectJ
- Spring AOP - It is a lightweight version of AspectJ. It only supports method based Joint point execution, applicable only to the spring beans and only the runtime weaving is allowed. 
- JBoss AOP

## Point-cut expression
- execution point cut - applied to method execution
  pattern - execution(<method modifier> (optional) <return type> <package name.class name> (optional) <method_name(param_name)> <throw exception> (optional) 

 It is possible to reuse a advice using a pointcut declaration. Also, it is possible to combine multiple point cuts and the operators are as follows.
    - AND (&&)
    - OR (||)
    - NOT (!)
    
### Ordering of the Advice
    It is possible to order the advice which will gurantee the ordering of those aspect when applied to a target object.
    
## JoinPoints
   It is possible to retrieve the method signature and arguments using a JointPoint.
    
